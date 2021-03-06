package com.ceiba.framework.servicio.trm.action;

public class TCRMServicesWebServiceLocator extends org.apache.axis.client.Service implements TCRMServicesWebService
{

	private static final long serialVersionUID = 1L;
	private static final String SERVICE_PORT = "TCRMServicesWebServicePort";

	public TCRMServicesWebServiceLocator()
	{
	}

	public TCRMServicesWebServiceLocator(org.apache.axis.EngineConfiguration config)
	{
		super(config);
	}

	public TCRMServicesWebServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException
	{
		super(wsdlLoc, sName);
	}

	private java.lang.String webServiceAddress = "http://AlexChacon:8080/SuperfinancieraWebServiceTRM/TCRMServicesWebService/TCRMServicesWebService";

	public java.lang.String getTCRMServicesWebServicePortAddress()
	{
		return webServiceAddress;
	}

	private java.lang.String wsdServiceName = SERVICE_PORT;

	public java.lang.String getTCRMServicesWebServicePortWSDDServiceName()
	{
		return wsdServiceName;
	}

	public void setTCRMServicesWebServicePortWSDDServiceName(java.lang.String name)
	{
		wsdServiceName = name;
	}

	public TCRMServicesInterface getTCRMServicesWebServicePort()throws javax.xml.rpc.ServiceException
	{
		java.net.URL endpoint;
		try
		{
			endpoint = new java.net.URL(webServiceAddress);
		}
		catch (java.net.MalformedURLException e)
		{
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getTCRMServicesWebServicePort(endpoint);
	}

	public TCRMServicesInterface getTCRMServicesWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException
	{
		try
		{
			TCRMServicesWebServiceSoapBindingStub stub = new TCRMServicesWebServiceSoapBindingStub(portAddress, this);
			stub.setPortName(getTCRMServicesWebServicePortWSDDServiceName());
			return stub;
		}
		catch (org.apache.axis.AxisFault e)
		{
			return null;
		}
	}

	public void setTCRMServicesWebServicePortEndpointAddress(java.lang.String address)
	{
		webServiceAddress = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException
	{
		try
		{
			if (TCRMServicesInterface.class.isAssignableFrom(serviceEndpointInterface))
			{
				TCRMServicesWebServiceSoapBindingStub stub = new TCRMServicesWebServiceSoapBindingStub(new java.net.URL(webServiceAddress),this);
				stub.setPortName(getTCRMServicesWebServicePortWSDDServiceName());
				return stub;
			}
		}
		catch (java.lang.Throwable t)
		{
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException( "There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException
	{
		if (portName == null)
		{
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("TCRMServicesWebServicePort".equals(inputPortName))
		{
			return getTCRMServicesWebServicePort();
		}
		else
		{
			java.rmi.Remote stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) stub).setPortName(portName);
			return stub;
		}
	}

	public javax.xml.namespace.QName getServiceName()
	{
		return new javax.xml.namespace.QName( "http://action.trm.services.generic.action.superfinanciera.nexura.sc.com.co/", SERVICE_PORT);
	}

	private java.util.HashSet<javax.xml.namespace.QName> ports = null;

	public java.util.Iterator<javax.xml.namespace.QName> getPorts()
	{
		if (ports == null)
		{
			ports = new java.util.HashSet<>();
			ports.add(new javax.xml.namespace.QName( "http://action.trm.services.generic.action.superfinanciera.nexura.sc.com.co/", SERVICE_PORT));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,java.lang.String address) throws javax.xml.rpc.ServiceException
	{

		if (SERVICE_PORT.equals(portName))
		{
			setTCRMServicesWebServicePortEndpointAddress(address);
		}
		else
		{ // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName,java.lang.String address) throws javax.xml.rpc.ServiceException
	{
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
