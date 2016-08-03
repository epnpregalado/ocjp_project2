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
public class Vehiculo {
	private String codigo;
	/**
	 * Especifica la marca del vehiculo
	 */
	private String marca;
	/**
	 * Especifica el anio del vehiculo
	 */
	private String anio;
	/**
	 * Especifica la placa del vehiculo
	 */
	private String placa;
	/**
	 *Especifica el tipo de costo de acuerdo al modelo
	 */
	private TipoCosto tipoCosto;
	/**
	 * Especifica el estado (ALQUILADO)
	 */
	private Estado estado;
	

	public Vehiculo(String codigo, String marca, String anio, String placa, TipoCosto tipo) {
		this.codigo = codigo;
		this.marca = marca;
		this.anio = anio;
		this.placa = placa;
		this.tipoCosto = tipo;
		this.estado=estado.LIBRE;

	}
	
	public Vehiculo() {
	
	}

	public void imprimirVehiculoLibre(){
		if (this.estado == estado.LIBRE){
			System.out.printf ("placa:"+this.placa );

		}
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoCosto getTipoCosto() {
		return tipoCosto;
	}

	public void setTipoCosto(TipoCosto tipoCosto) {
		this.tipoCosto = tipoCosto;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}   
}






