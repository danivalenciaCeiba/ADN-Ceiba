package com.ceiba.framework.servicio.trm.action;

public class TCRMServicesInterfaceProxy implements TCRMServicesInterface
{
	private String endpoint = null;
	private TCRMServicesInterface tCRMServicesInterface = null;
	private String ADDRESS = "javax.xml.rpc.service.endpoint.address";

	public TCRMServicesInterfaceProxy()
	{
		initTCRMServicesInterfaceProxy();
	}

	public TCRMServicesInterfaceProxy(String endpoint)
	{
		this.endpoint = endpoint;
		initTCRMServicesInterfaceProxy();
	}

	private void initTCRMServicesInterfaceProxy()
	{
		try
		{
			tCRMServicesInterface = (new TCRMServicesWebServiceLocator()) .getTCRMServicesWebServicePort();
			if (tCRMServicesInterface != null)
			{
				if (this.endpoint != null)
					((javax.xml.rpc.Stub) tCRMServicesInterface)._setProperty( this.ADDRESS,this.endpoint);
				else
					this.endpoint = (String) ((javax.xml.rpc.Stub) tCRMServicesInterface)._getProperty(this.ADDRESS);
			}

		}
		catch (javax.xml.rpc.ServiceException serviceException)
		{
			this.endpoint = null;
		}
	}

	public String getEndpoint()
	{
		return this.endpoint;
	}

	public void setEndpoint(String endpoint)
	{
		this.endpoint = endpoint;
		if (tCRMServicesInterface != null)
			((javax.xml.rpc.Stub) tCRMServicesInterface)._setProperty(this.ADDRESS, this.endpoint);

	}

	public TCRMServicesInterface getTCRMServicesInterface()
	{
		if (tCRMServicesInterface == null)
			initTCRMServicesInterfaceProxy();
		return tCRMServicesInterface;
	}

	public TcrmResponse queryTCRM( java.util.Calendar tcrmQueryAssociatedDate) throws java.rmi.RemoteException
	{
		if (tCRMServicesInterface == null)
			initTCRMServicesInterfaceProxy();
		return tCRMServicesInterface.queryTCRM(tcrmQueryAssociatedDate);
	}

}