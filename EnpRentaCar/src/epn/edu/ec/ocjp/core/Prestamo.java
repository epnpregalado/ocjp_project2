package epn.edu.ec.ocjp.core;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

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
			if(!archivo.exists()) {
				archivo.createNewFile();
			} 
			
			FileWriter fw = new FileWriter(archivo);
			fw.write("PRESTAMOS REGISTRADOS\n");
			fw.flush();
			fw.close();
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
