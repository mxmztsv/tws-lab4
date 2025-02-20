
package ru.mxmztsv.app.soap;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.3
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ClientServiceException", targetNamespace = "http://soap.app.mxmztsv.ru/")
public class ClientServiceException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ClientServiceException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ClientServiceException_Exception(String message, ClientServiceException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ClientServiceException_Exception(String message, ClientServiceException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ru.mxmztsv.app.soap.ClientServiceException
     */
    public ClientServiceException getFaultInfo() {
        return faultInfo;
    }

}
