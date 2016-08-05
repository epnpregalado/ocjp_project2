package epn.edu.ec.ocjp.core;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import epn.edu.ec.ocjp.services.commons.Utilitario;

/**
 * Definie el objeto Prestamo
 * 
 * @author USRLAM
 */
public class Prestamo {

	private Vehiculo vehiculo;
	private Date fechaPrestamo;
	private Date fechaEntregaEsperada;
	private double costo;
	private Date fechaEntregaReal;
	private double costoFinal;

	// logics methods
	public void registrarPrestamo(Prestamo prestamo) {

		try {
			File archivo = new File("registro_prestamo.txt");
			StringBuilder strCodigo = new StringBuilder();
			StringBuilder fechaEntregaEsperado = new StringBuilder();
			StringBuilder fechaPrestamo = new StringBuilder();
			
			FileWriter fw;
			fw = new FileWriter(archivo, true);
			fw.write("");
			
			Date date = prestamo.getFechaEntregaEsperada();
			Date date2 = prestamo.getFechaPrestamo();
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
			String fechaEntregaEsperada = format1.format(date);
			SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd");
			String fechaPrest = format2.format(date2);

			//Paso de valores por referencia
			Utilitario.generarFormatoArchivo(prestamo.getVehiculo().getCodigo(), strCodigo, "COD");
			Utilitario.generarFormatoArchivo(fechaEntregaEsperada, fechaEntregaEsperado, "FEE");
			Utilitario.generarFormatoArchivo(fechaPrest, fechaPrestamo, "FPR");
			
			fw.write(strCodigo.toString().toUpperCase());
			fw.write(fechaPrestamo.toString().toUpperCase());
			fw.write(fechaEntregaEsperado.toString().toUpperCase());
			fw.flush();
			fw.close();
			System.out.println("Datos ingresados con exito...");
		}catch (IOException e) {

		}
	}
	
	public void obtenerCatalogoPrestamos() {
		
		try {
			char [] text = new char[1000];
			FileReader fr;
			fr = new FileReader("");
			System.out.println("tamanio de archivo :" + fr.read(text));
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	// get and set properties
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaEntregaEsperada() {
		return fechaEntregaEsperada;
	}

	public void setFechaEntregaEsperada(Date fechaEntregaEsperada) {
		this.fechaEntregaEsperada = fechaEntregaEsperada;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Date getFechaEntregaReal() {
		return fechaEntregaReal;
	}

	public void setFechaEntregaReal(Date fechaEntregaReal) {
		this.fechaEntregaReal = fechaEntregaReal;
	}

	public double getCostoFinal() {
		return costoFinal;
	}

	public void setCostoFinal(double costoFinal) {
		this.costoFinal = costoFinal;
	}

}
