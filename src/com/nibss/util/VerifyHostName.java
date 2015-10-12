/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibss.util;

/**
 *
 * @author hakintoye
 */
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;


public class VerifyHostName implements HostnameVerifier{
    public boolean verify(String string, SSLSession sslSession) {
        return true;
    }
}
