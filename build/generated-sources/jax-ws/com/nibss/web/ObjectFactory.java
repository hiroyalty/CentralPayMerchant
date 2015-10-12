
package com.nibss.web;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.nibss.web package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CancelMandateResponse_QNAME = new QName("http://web.nibss.com/", "cancelMandateResponse");
    private final static QName _RequeryMandate_QNAME = new QName("http://web.nibss.com/", "requeryMandate");
    private final static QName _CancelMandate_QNAME = new QName("http://web.nibss.com/", "cancelMandate");
    private final static QName _ListActiveBanks_QNAME = new QName("http://web.nibss.com/", "listActiveBanks");
    private final static QName _RequeryMandateResponse_QNAME = new QName("http://web.nibss.com/", "requeryMandateResponse");
    private final static QName _ValidateOTPRequest_QNAME = new QName("http://web.nibss.com/", "validateOTPRequest");
    private final static QName _CreateMandateRequest_QNAME = new QName("http://web.nibss.com/", "createMandateRequest");
    private final static QName _GenerateOTPRequest_QNAME = new QName("http://web.nibss.com/", "generateOTPRequest");
    private final static QName _CreateMandateRequestResponse_QNAME = new QName("http://web.nibss.com/", "createMandateRequestResponse");
    private final static QName _GenerateOTPRequestResponse_QNAME = new QName("http://web.nibss.com/", "generateOTPRequestResponse");
    private final static QName _ListActiveBanksResponse_QNAME = new QName("http://web.nibss.com/", "listActiveBanksResponse");
    private final static QName _ValidateOTPRequestResponse_QNAME = new QName("http://web.nibss.com/", "validateOTPRequestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.nibss.web
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenerateOTPRequest }
     * 
     */
    public GenerateOTPRequest createGenerateOTPRequest() {
        return new GenerateOTPRequest();
    }

    /**
     * Create an instance of {@link CreateMandateRequest }
     * 
     */
    public CreateMandateRequest createCreateMandateRequest() {
        return new CreateMandateRequest();
    }

    /**
     * Create an instance of {@link ValidateOTPRequest }
     * 
     */
    public ValidateOTPRequest createValidateOTPRequest() {
        return new ValidateOTPRequest();
    }

    /**
     * Create an instance of {@link RequeryMandateResponse }
     * 
     */
    public RequeryMandateResponse createRequeryMandateResponse() {
        return new RequeryMandateResponse();
    }

    /**
     * Create an instance of {@link ListActiveBanks }
     * 
     */
    public ListActiveBanks createListActiveBanks() {
        return new ListActiveBanks();
    }

    /**
     * Create an instance of {@link CancelMandate }
     * 
     */
    public CancelMandate createCancelMandate() {
        return new CancelMandate();
    }

    /**
     * Create an instance of {@link RequeryMandate }
     * 
     */
    public RequeryMandate createRequeryMandate() {
        return new RequeryMandate();
    }

    /**
     * Create an instance of {@link CancelMandateResponse }
     * 
     */
    public CancelMandateResponse createCancelMandateResponse() {
        return new CancelMandateResponse();
    }

    /**
     * Create an instance of {@link ValidateOTPRequestResponse }
     * 
     */
    public ValidateOTPRequestResponse createValidateOTPRequestResponse() {
        return new ValidateOTPRequestResponse();
    }

    /**
     * Create an instance of {@link ListActiveBanksResponse }
     * 
     */
    public ListActiveBanksResponse createListActiveBanksResponse() {
        return new ListActiveBanksResponse();
    }

    /**
     * Create an instance of {@link GenerateOTPRequestResponse }
     * 
     */
    public GenerateOTPRequestResponse createGenerateOTPRequestResponse() {
        return new GenerateOTPRequestResponse();
    }

    /**
     * Create an instance of {@link CreateMandateRequestResponse }
     * 
     */
    public CreateMandateRequestResponse createCreateMandateRequestResponse() {
        return new CreateMandateRequestResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelMandateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.nibss.com/", name = "cancelMandateResponse")
    public JAXBElement<CancelMandateResponse> createCancelMandateResponse(CancelMandateResponse value) {
        return new JAXBElement<CancelMandateResponse>(_CancelMandateResponse_QNAME, CancelMandateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequeryMandate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.nibss.com/", name = "requeryMandate")
    public JAXBElement<RequeryMandate> createRequeryMandate(RequeryMandate value) {
        return new JAXBElement<RequeryMandate>(_RequeryMandate_QNAME, RequeryMandate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelMandate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.nibss.com/", name = "cancelMandate")
    public JAXBElement<CancelMandate> createCancelMandate(CancelMandate value) {
        return new JAXBElement<CancelMandate>(_CancelMandate_QNAME, CancelMandate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListActiveBanks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.nibss.com/", name = "listActiveBanks")
    public JAXBElement<ListActiveBanks> createListActiveBanks(ListActiveBanks value) {
        return new JAXBElement<ListActiveBanks>(_ListActiveBanks_QNAME, ListActiveBanks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequeryMandateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.nibss.com/", name = "requeryMandateResponse")
    public JAXBElement<RequeryMandateResponse> createRequeryMandateResponse(RequeryMandateResponse value) {
        return new JAXBElement<RequeryMandateResponse>(_RequeryMandateResponse_QNAME, RequeryMandateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateOTPRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.nibss.com/", name = "validateOTPRequest")
    public JAXBElement<ValidateOTPRequest> createValidateOTPRequest(ValidateOTPRequest value) {
        return new JAXBElement<ValidateOTPRequest>(_ValidateOTPRequest_QNAME, ValidateOTPRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateMandateRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.nibss.com/", name = "createMandateRequest")
    public JAXBElement<CreateMandateRequest> createCreateMandateRequest(CreateMandateRequest value) {
        return new JAXBElement<CreateMandateRequest>(_CreateMandateRequest_QNAME, CreateMandateRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateOTPRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.nibss.com/", name = "generateOTPRequest")
    public JAXBElement<GenerateOTPRequest> createGenerateOTPRequest(GenerateOTPRequest value) {
        return new JAXBElement<GenerateOTPRequest>(_GenerateOTPRequest_QNAME, GenerateOTPRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateMandateRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.nibss.com/", name = "createMandateRequestResponse")
    public JAXBElement<CreateMandateRequestResponse> createCreateMandateRequestResponse(CreateMandateRequestResponse value) {
        return new JAXBElement<CreateMandateRequestResponse>(_CreateMandateRequestResponse_QNAME, CreateMandateRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateOTPRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.nibss.com/", name = "generateOTPRequestResponse")
    public JAXBElement<GenerateOTPRequestResponse> createGenerateOTPRequestResponse(GenerateOTPRequestResponse value) {
        return new JAXBElement<GenerateOTPRequestResponse>(_GenerateOTPRequestResponse_QNAME, GenerateOTPRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListActiveBanksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.nibss.com/", name = "listActiveBanksResponse")
    public JAXBElement<ListActiveBanksResponse> createListActiveBanksResponse(ListActiveBanksResponse value) {
        return new JAXBElement<ListActiveBanksResponse>(_ListActiveBanksResponse_QNAME, ListActiveBanksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateOTPRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web.nibss.com/", name = "validateOTPRequestResponse")
    public JAXBElement<ValidateOTPRequestResponse> createValidateOTPRequestResponse(ValidateOTPRequestResponse value) {
        return new JAXBElement<ValidateOTPRequestResponse>(_ValidateOTPRequestResponse_QNAME, ValidateOTPRequestResponse.class, null, value);
    }

}
