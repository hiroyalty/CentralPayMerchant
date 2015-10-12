/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibss.util;

import com.nibss.web.CentralPayOperations;
import com.nibss.web.CentralPayOperations_Service;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


/**
 *
 * @author Famodun Gbolaga
 */
public class CentralPayMerchant {
    //final String MERCHANT_ID ="00000001";
    public Request req = new Request();
    private String MERCHANT_ID;
    private String SECRET_KEY;
    private InputStream input = null;
    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    private String logURL;
    com.nibss.web.CentralPayOperations_Service service = new com.nibss.web.CentralPayOperations_Service();
    com.nibss.web.CentralPayOperations port = service.getCentralPayOperationsPort();
    
    static {
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
        new javax.net.ssl.HostnameVerifier(){

            public boolean verify(String hostname,
                    javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("staging.nibss-plc.com.ng")) {
                    return true;
                }
                return false;
            }
        });
    }
    public CentralPayMerchant(){
        XTrustProvider fgc = new XTrustProvider();
        fgc.install();
        this.MERCHANT_ID = Constants.MERCHANT_ID;
        this.SECRET_KEY = Constants.SECRET_KEY;      
    }
    
     public void setLogURL(String url)
  {
    this.logURL = url;
  }

  public String listActiveBanks(String id)
  {
    String responseXML = this.port.listActiveBanks(id);

    return XmltoJson(responseXML);
  }

  private void logTransaction(String transactionID, String request, String response)
  {
    List nvps = new ArrayList();
    nvps.add(new BasicNameValuePair("trans_id", transactionID));
    nvps.add(new BasicNameValuePair("req", request));
    nvps.add(new BasicNameValuePair("res", response));
    try {
      this.req.post(this.logURL, nvps);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String generateOTPRequest(String mandateCode, String bankCode, String billerID, String billerName, String amt)
  {
    String tid = getTransactionID();
    String endXML = "</GenerateOTPRequest>";

    String startXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><GenerateOTPRequest><MandateCode>" + mandateCode + "</MandateCode>" + "<TransType>" + Constants.PAYMENT + "</TransType>" + "<BankCode>" + bankCode + "</BankCode>" + "<BillerID>" + billerID + "</BillerID>" + "<BillerName>" + billerName + "</BillerName>" + "<Amount>" + amt + "</Amount>" + "<BillerTransId>" + tid + "</BillerTransId>";

    String hashXML = startXML + endXML;

    String hashValue = getHashValue(hashXML);
    startXML = startXML + "<HashValue>" + hashValue + "</HashValue>" + endXML;
    String responseXML = this.port.generateOTPRequest(startXML);

    logTransaction(tid, startXML, responseXML);
    return XmltoJson(responseXML);
  }

  public String createMandateRequest(String accountNumber, String accountName, String bankCode, String billerID, String billerName)
  {
    String tid = getTransactionID();
    String endXML = "</CreateMandateRequest>";

    String startXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><CreateMandateRequest><AcctNumber>" + accountNumber + "</AcctNumber>" + "<AcctName>" + accountName + "</AcctName>" + "<TransType>" + Constants.REGISTRATION + "</TransType>" + "<BankCode>" + bankCode + "</BankCode>" + "<BillerID>" + billerID + "</BillerID>" + "<BillerName>" + billerName + "</BillerName>" + "<BillerTransId>" + tid + "</BillerTransId>";

    String hashXML = startXML + endXML;

    String hashValue = getHashValue(hashXML);
    startXML = startXML + "<HashValue>" + hashValue + "</HashValue>" + endXML;

    String responseXML = this.port.createMandateRequest(startXML);

    logTransaction(tid, startXML, responseXML);
    return XmltoJson(responseXML);
  }

  public String validateOTP(String mandateCode, String bankCode, String otp, String billerID, String billerName, String amt, String transType)
  {
    String endXML = "</ValidateOTPRequest>";
    String tid = getTransactionID();

    String startXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><ValidateOTPRequest><MandateCode>" + mandateCode + "</MandateCode>" + "<TransType>" + transType + "</TransType>" + "<OTP>" + otp + "</OTP>" + "<BankCode>" + bankCode + "</BankCode>" + "<BillerID>" + billerID + "</BillerID>" + "<BillerName>" + billerName + "</BillerName>" + "<Amount>" + amt + "</Amount>" + "<BillerTransId>" + tid + "</BillerTransId>";

    String hashXML = startXML + endXML;

    String hashValue = getHashValue(hashXML);
    startXML = startXML + "<HashValue>" + hashValue + "</HashValue>" + endXML;
    String responseXML = this.port.validateOTPRequest(startXML);
    logTransaction(tid, startXML, responseXML);
    return XmltoJson(responseXML);
  }

  public String cancelMandate(String mandateCode, String bankCode, String billerID, String billerName)
  {
    String endXML = "</CancelMandateRequest>";
    String tId = getTransactionID();
    String startXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><CancelMandateRequest><MandateCode>" + mandateCode + "</MandateCode>" + "<TransType>" + Constants.CANCELLATION_OF_MANDATE + "</TransType>" + "<BankCode>" + bankCode + "</BankCode>" + "<BillerID>" + billerID + "</BillerID>" + "<BillerName>" + billerName + "</BillerName>" + "<BillerTransId>" + tId + "</BillerTransId>";

    String hashXML = startXML + endXML;

    String hashValue = getHashValue(hashXML);
    startXML = startXML + "<HashValue>" + hashValue + "</HashValue>" + endXML;
    String responseXML = this.port.cancelMandate(startXML);

    logTransaction(tId, startXML, responseXML);
    return XmltoJson(responseXML);
  }

  public String requeryMandate(String mandateCode, String billerID)
  {
    String endXML = "</RequeryMandateRequest>";

    String startXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><RequeryMandateRequest><MandateCode>" + mandateCode + "</MandateCode>" + "<BillerID>" + billerID + "</BillerID>";

    String hashXML = startXML + endXML;

    String hashValue = getHashValue(hashXML);
    startXML = startXML + "<HashValue>" + hashValue + "</HashValue>" + endXML;
    String responseXML = this.port.requeryMandate(startXML);
    logTransaction(getTransactionID(), startXML, responseXML);
    return XmltoJson(responseXML);
  }

  private String XmltoJson(String xml) {
    try {
      JSONObject xmlJSONObj = XML.toJSONObject(xml);
      String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);

      return jsonPrettyPrintString;
    } catch (JSONException je) {
      System.out.println(je.toString());
    }
    return null;
  }

  private void createMandateRequest()
  {
    String xmlRequest = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><CreateMandateRequest><AcctNumber>1020021006</AcctNumber><AcctName>AYOWOLE R AFOLABI</AcctName><TransType>1</TransType><BankCode>057</BankCode><BillerID>NIBSS0000000033</BillerID><BillerName>VAS2NETTEST</BillerName><BillerTransId>1045621</BillerTransId><HashValue>c9e5573af83b3bb487274df43c675294aa2f0ac9e1a27c1cd2672f066b12897f</HashValue></CreateMandateRequest>";

    String responseXML = this.port.createMandateRequest(xmlRequest);
    System.out.println("Response::" + responseXML);
  }

  private String getHashValue(String stringText)
  {
    String sha256hex = DigestUtils.sha256Hex(stringText + this.SECRET_KEY);
    return sha256hex;
  }

  private String getTransactionID() {
    return Long.toString(new Date().getTime());
  }
    /**
     * @param args the command line arguments
     */
    
    /*
    
    private void listActiveBanks(){
        String responseXML = port.listActiveBanks(MERCHANT_ID);
        System.out.println("Response:: "+responseXML);
    }
    
    private void createMandateRequest(){
        String xmlRequest="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                            "<CreateMandateRequest>\n" +
                            "<AcctNumber>1020021006</ AcctNumber >\n" +
                            "<AcctName>AYOWOLE R AFOLABI</AcctName>\n" +
                            "<TransType>1</TransType>\n" +
                            "<BankCode>057</BankCode>\n" +
                            "<BillerID>00000001</BillerID >\n" +
                            "<BillerName>TESTBILER</BillerName>\n" +
                            "<BillerTransId>1045621</BillerTransId>\n" +
                            "<HashValue>your hash value</HashValue>\n" +
                            "</CreateMandateRequest>";
        String responseXML = port.createMandateRequest(xmlRequest);
        System.out.println("Response::"+responseXML);
    }
    
    public void ValidateOTPRequest()    {
        String xmlRequest="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<ValidateOTPRequest>\n" +
                "<MandateCode>0000000001</MandateCode >\n" +
                "<TransType>1</TransType>\n" +
                "<BankCode> XXX</BankCode>\n" +
                "<OTP>123321</OTP>\n" +
                "<BillerID>123</BillerID>\n" +
                "<BillerName>Konga</BillerName>\n" +
                "<Amount></Amount >\n" +
                "<BillerTransId>1045621</ BillerTransId >\n" +
                "<HashValue>XXXXXXX</HashValue>\n"+
                "</ValidateOTPRequest>";
        String responseXML = port.validateOTPRequest(xmlRequest);
        System.out.println("Response::"+responseXML);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        CentralPayMerchant cpm = new CentralPayMerchant();
        //cpm.listActiveBanks();
        //cpm.createMandateRequest();
    } */
}
