package epn.edu.ec.ocjp.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Especifica la clase boletos
 * @author jpatrick
 *
 */
public class Boleto {

	private static Pasajero pasajero;
	private double valorPasaje;
	private static DatosBoleto datosBoleto;

	public static void main(String [] args) {
		System.out.println("============================================================");
		System.out.println("                  TERMINAL AUTOBUS EPN                      ");
		System.out.println("============================================================");
		String entradaTeclado = "";
		datosBoleto = new DatosBoleto();
		pasajero = new Pasajero();
		int count = 0;
		if(count==0) {
			System.out.println("INGRESE LA INFORMACION DE AUTOBUS, RUTA Y HORARIO");
		}
		do{
			count+=1;
			System.out.println("1. Ingresar autobus");
			System.out.println("2. Ingresar ruta");
			System.out.println("3. Ingresar horario");

			Scanner entradaEscaner = new Scanner (System.in);
			entradaTeclado = entradaEscaner.nextLine(); 

			switch (entradaTeclado) {

			case "1":
				datosBoleto.ingresarAutoBus();
				break;
			case "2":
				datosBoleto.ingresarRuta();
				break;
			case "3":
				datosBoleto.ingresarHorario();
				break;
			default:
				System.out.println("...");
				break;

			}
		} while (datosBoleto.getAutobus() == null || 
				datosBoleto.getHorario() == null || 
				datosBoleto.getRuta() == null ||
				datosBoleto.getHorario()==null);
		count=0;

		if(count==0){
			System.out.println("INGRESE INFORMACION DEL PASAJERO");			
		}

		Boleto boleto = new Boleto();
		do{
			count+=1;
			Scanner dataCar = new Scanner (System.in);
			System.out.println("Nombre del pasajero: ");
			String nombre = dataCar.nextLine();
			System.out.println("Cédula: ");
			String cedula = dataCar.nextLine();
			pasajero.setNombre(nombre);
			pasajero.setCedula(cedula);
			boleto.setPasajero(pasajero);
		}while(boleto.getPasajero()==null);
		count=0;

		if(count==0){
			System.out.println("INGRESE EL VALOR DEL PASAJE");
		}

		do{
			Scanner dataCar = new Scanner (System.in);
			String valorPasaje = dataCar.nextLine();
			boleto.setValorPasaje(Double.parseDouble(valorPasaje));
		}while(boleto.getValorPasaje()==0);

		boleto.imprimirPasaje(datosBoleto, pasajero, boleto.getValorPasaje());

		//Se inicializan los objetos para repetir el ciclo
		datosBoleto = null;
		pasajero = null;
		boleto.setValorPasaje(0);
		main(null);
	}

	/**
	 * Permite la impresión del pasaje
	 */
	public void imprimirPasaje(DatosBoleto datosBoleto, Pasajero pasajero, double valorPasaje){
		try {
			File archivo = new File("pasaje.txt");
			FileWriter fw = new FileWriter(archivo, true);
			fw.write("\n===================================================================\n");
			fw.write("          COOPERATIVA: "+datosBoleto.getAutobus().getCooperativa()+"           \n");
			fw.write("===================================================================\n");
			fw.write("RUTA: " + datosBoleto.getRuta().getRuta());
			fw.write("        HORA DE SALIDA: " + datosBoleto.getHorario().getHoraSalida()+"\n");
			fw.write("Valor del pasaje: "+ valorPasaje+"\n");
			fw.write("Nombre pasajero: "+ pasajero.getNombre());
			fw.write("        CEDULA: " + pasajero.getCedula());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/*
	 * Getters and setters
	 */

	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	public double getValorPasaje() {
		return valorPasaje;
	}

	public void setValorPasaje(double valorPasaje) {
		this.valorPasaje = valorPasaje;
	}
	public DatosBoleto getDatosBoleto() {
		return datosBoleto;
	}

	public void setDatosBoleto(DatosBoleto datosBoleto) {
		this.datosBoleto = datosBoleto;
	}
}
