package com.ceiba.framework.servicio.trm;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.ceiba.framework.servicio.trm.action.TCRMServicesInterfaceProxy;
import com.ceiba.framework.servicio.trm.action.TcrmResponse;

/**
 * TCRM Java Web Service demo client
 * 
 * @author Alex Vicente ChacOn JimEnez (alex.chacon@software-colombia.com)
 * @since JDK 1.7.0_04
 * @version 1.0
 */
public class TCRMTestClient
{
	public TCRMTestClient() {
	}		
	
	/**
	 * TCRM query value format
	 */
	private static final String VALUE_QUERY_FORMAT = "#0.00";

	
	/**
	 * Web Service end point
	 */
	private static final String WEB_SERVICE_URL = "https://www.superfinanciera.gov.co/SuperfinancieraWebServiceTRM/TCRMServicesWebService/TCRMServicesWebService?WSDL";
	
	
	public String obtenerTrm()  throws RemoteException, ParseException{		
		
		// Decimal value format declaration
		DecimalFormat decimalFormat = new DecimalFormat(VALUE_QUERY_FORMAT);
		
		TCRMServicesInterfaceProxy proxy = new TCRMServicesInterfaceProxy(WEB_SERVICE_URL);
				
		// Gets the TCRM value for the current date
		TcrmResponse tcrmResponse = proxy.queryTCRM(null);
		return decimalFormat.format(tcrmResponse.getValue());
	}

}
