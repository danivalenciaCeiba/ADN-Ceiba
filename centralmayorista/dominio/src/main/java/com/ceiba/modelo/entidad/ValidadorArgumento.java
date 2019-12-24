package com.ceiba.modelo.entidad;

import com.ceiba.exception.ExcepcionLongitudValor;
import com.ceiba.exception.ExcepcionValorObligatorio;

public class ValidadorArgumento {
	
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
     * Valida si un string es mayor a cierta longitud
     * 
     * @param valor valor a ser evaluado
     * @param longitud longitud máxima
     * @param mensaje mensaje de error a mostrar
     */
	
    public static void validarLongitud(String valor,int longitud,String mensaje){
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
