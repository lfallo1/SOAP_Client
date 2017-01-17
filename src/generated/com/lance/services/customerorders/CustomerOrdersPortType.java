package com.lance.services.customerorders;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2017-01-16T16:38:55.061-05:00
 * Generated source version: 3.0.2
 * 
 */
@WebService(targetNamespace = "http://customerorders.services.lance.com/", name = "CustomerOrdersPortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CustomerOrdersPortType {

    @WebMethod
    @WebResult(name = "getOrdersResponse", targetNamespace = "http://customerorders.services.lance.com/", partName = "parameters")
    public GetOrdersResponse getOrders(
        @WebParam(partName = "parameters", name = "getOrdersRequest", targetNamespace = "http://customerorders.services.lance.com/")
        GetOrdersRequest parameters
    );

    @WebMethod
    @WebResult(name = "createOrdersResponse", targetNamespace = "http://customerorders.services.lance.com/", partName = "parameters")
    public CreateOrdersResponse createOrders(
        @WebParam(partName = "parameters", name = "createOrdersRequest", targetNamespace = "http://customerorders.services.lance.com/")
        CreateOrdersRequest parameters
    );

    @WebMethod
    @WebResult(name = "deleteOrdersResponse", targetNamespace = "http://customerorders.services.lance.com/", partName = "parameters")
    public DeleteOrdersResponse deleteOrders(
        @WebParam(partName = "parameters", name = "deleteOrdersRequest", targetNamespace = "http://customerorders.services.lance.com/")
        DeleteOrdersRequest parameters
    );

    @WebMethod
    @WebResult(name = "allOrdersResponse", targetNamespace = "http://customerorders.services.lance.com/", partName = "parameters")
    public AllOrdersResponse allOrders(
        @WebParam(partName = "parameters", name = "allOrdersRequest", targetNamespace = "http://customerorders.services.lance.com/")
        AllOrdersRequest parameters
    );
}
