/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.ocjp.core;

/**
 *
 * @author USRLAM
 */
public enum TipoCosto {

	AVEOFAMILI (200,20),
	HIUNDAYACCENT(300,30),
	SZ (400,40),  
	HONDACIVIC (500,50),
	TOYOTACOROLLA(350,35);


	private final double alquilerDiario; 
	private final double mora; 

	private TipoCosto(double alquilerDiario, double mora) {
		this.alquilerDiario = alquilerDiario;
		this.mora = mora;
	}

	public double getAlquilerDiario() {
		return alquilerDiario;
	}

	public double getMora() {
		return mora;
	}


}

