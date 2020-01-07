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
	 * Valid from and valid to TCRM date format
	 */
	private final static String _DATE_RESPONSE_FORMAT = "EEE, d MMM yyyy HH:mm:ss Z";
	
	/**
	 * TCRM query date format
	 */
	private final static String _DATE_QUERY_FORMAT = "yyyy-MM-dd";
	
	/**
	 * TCRM query value format
	 */
	private final static String _VALUE_QUERY_FORMAT = "#0.00";

	/**
	 * TCRM date to query
	 */
	private final static String _DATE_TO_QUERY = "2014-08-13";
	
	/**
	 * Web Service end point
	 */
	private final static String _WEB_SERVICE_URL = "https://www.superfinanciera.gov.co/SuperfinancieraWebServiceTRM/TCRMServicesWebService/TCRMServicesWebService?WSDL";
	
	
	public String obtenerTrm()  throws RemoteException, ParseException{
		// Simple date format declaration
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(_DATE_RESPONSE_FORMAT);
		
		// Decimal value format declaration
		DecimalFormat decimalFormat = new DecimalFormat(_VALUE_QUERY_FORMAT);
		
		TCRMServicesInterfaceProxy proxy = new TCRMServicesInterfaceProxy(_WEB_SERVICE_URL);
				
		// Gets the TCRM value for the current date
		TcrmResponse tcrmResponse = proxy.queryTCRM(null);
		return decimalFormat.format(tcrmResponse.getValue());
	}

}
