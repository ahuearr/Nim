package com.gusycorp.nim.model;

import java.io.Serializable;

public class Fila implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String monedas;
	
	public Fila(String monedas)
	{
		this.monedas=monedas;
	}
	
	public String getMonedas()
	{
		return monedas;
	}
	
	public void setMonedas(String monedas)
	{
		this.monedas=monedas;
	}
	
	public String toString()
	{
		return monedas;
	}
	
	public static Fila[] getTodasFilas()
	{
		return new Fila[] {new Fila("3"), new Fila("4"), new Fila("5"), new Fila("6"), 
				new Fila("7"), new Fila("8"), new Fila("9"), new Fila("10")}; 
	}
}
