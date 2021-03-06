
package com.nibss.web;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CentralPayOperations", targetNamespace = "http://web.nibss.com/", wsdlLocation = "https://staging.nibss-plc.com.ng/CentralPayWebservice/CentralPayOperations?wsdl")
public class CentralPayOperations_Service
    extends Service
{

    private final static URL CENTRALPAYOPERATIONS_WSDL_LOCATION;
    private final static WebServiceException CENTRALPAYOPERATIONS_EXCEPTION;
    private final static QName CENTRALPAYOPERATIONS_QNAME = new QName("http://web.nibss.com/", "CentralPayOperations");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://staging.nibss-plc.com.ng/CentralPayWebservice/CentralPayOperations?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CENTRALPAYOPERATIONS_WSDL_LOCATION = url;
        CENTRALPAYOPERATIONS_EXCEPTION = e;
    }

    public CentralPayOperations_Service() {
        super(__getWsdlLocation(), CENTRALPAYOPERATIONS_QNAME);
    }

    public CentralPayOperations_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CENTRALPAYOPERATIONS_QNAME, features);
    }

    public CentralPayOperations_Service(URL wsdlLocation) {
        super(wsdlLocation, CENTRALPAYOPERATIONS_QNAME);
    }

    public CentralPayOperations_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CENTRALPAYOPERATIONS_QNAME, features);
    }

    public CentralPayOperations_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CentralPayOperations_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CentralPayOperations
     */
    @WebEndpoint(name = "CentralPayOperationsPort")
    public CentralPayOperations getCentralPayOperationsPort() {
        return super.getPort(new QName("http://web.nibss.com/", "CentralPayOperationsPort"), CentralPayOperations.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CentralPayOperations
     */
    @WebEndpoint(name = "CentralPayOperationsPort")
    public CentralPayOperations getCentralPayOperationsPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://web.nibss.com/", "CentralPayOperationsPort"), CentralPayOperations.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CENTRALPAYOPERATIONS_EXCEPTION!= null) {
            throw CENTRALPAYOPERATIONS_EXCEPTION;
        }
        return CENTRALPAYOPERATIONS_WSDL_LOCATION;
    }

}
