package com.ceiba.framework.servicio.trm.action;

public interface TCRMServicesInterface extends java.rmi.Remote 
{
    public TcrmResponse queryTCRM(java.util.Calendar tcrmQueryAssociatedDate) throws java.rmi.RemoteException;
}
