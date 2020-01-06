package com.ceiba.dominio.modelo.entidad;

import com.ceiba.dominio.exception.ExcepcionLongitudValor;
import com.ceiba.dominio.exception.ExcepcionValorObligatorio;

public class ValidadorArgumento {
	
	private ValidadorArgumento() {
		
	}
	
	/**
     * Valida si un valor es nulo
     * 
     * @param valor valor a ser evaluado     
     * @param mensaje mensaje de error a mostrar
     */
	public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }
    
	/**
     * Valida si un string excede cierta longitud
     * 
     * @param valor valor a ser evaluado
     * @param longitud longitud maxima
     * @param mensaje mensaje de error a mostrar
     */
	
    public static void validarLongitudMaxima(String valor,int longitud,String mensaje){
        if(valor.length() > longitud){
            throw new ExcepcionLongitudValor(mensaje);
        }
    }
    
    /**
     * Valida si un valor es mayor a cero
     * 
     * @param valor valor a ser evaluado
     * @param mensaje mensaje de error a mostrar
     */
    public static void validarMayorCero(double valor,String mensaje){
        if(0 >= valor){
            throw new ExcepcionLongitudValor(mensaje);
        }
    }
}
