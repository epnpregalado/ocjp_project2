/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epn.edu.ec.ocjp.core;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import epn.edu.ec.ocjp.services.commons.Utilitario;

/**
 *
 * @author USRLAM
 */
public class AlquilerVehiculo {
	//ArrayList <Vehiculo> vehiculos=null;
	static ArrayList<Vehiculo> vehiculos= new ArrayList<>();

	static  ArrayList<Prestamo> prestamos= new ArrayList<>();

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		//		cargarVehiculos();

		String entradaTeclado = "";

		do{

			System.out.println("============================================================");
			System.out.println("                    Ingrese una opción");
			System.out.println("============================================================");
			System.out.println("1. Registro de vehículos");
			System.out.println("2. búsqueda de vehículos");
			System.out.println("3. Registrar préstamo");
			System.out.println("4. Registrar devolución");

			Scanner entradaEscaner = new Scanner (System.in);
			entradaTeclado = entradaEscaner.nextLine(); 

			switch (entradaTeclado) {

			case "1":
				registerCar();
				break;
			case "2":
				searchCar();
				break;
			case "3":
				rentCar();
				break;
			case "4":
				returnCar();
				break;
			default:
				System.out.println("...");
				break;

			}
		} while (!entradaTeclado.equals("E")&& !entradaTeclado.equals("e") );
	}


	/**
	 * Permite ingresar en el archivo nuevos vehiculos
	 */
	public static void registerCar() {
		System.out.println("==========================================================================================");
		System.out.println("                           Ingrese la información del vehículo                            ");
		System.out.println("==========================================================================================");
		Scanner dataCar = new Scanner (System.in);
		System.out.println("Código: ");
		String codigo = dataCar.nextLine();
		System.out.println("Marca: ");
		String marca = dataCar.nextLine();
		System.out.println("Anio: ");
		String anio = dataCar.nextLine();
		System.out.println("Placa: ");
		String placa = dataCar.nextLine();
		TipoCosto tipo = null;
		Vehiculo vehiculo = new Vehiculo(codigo, marca, anio, placa, tipo);

		generarArchivoVehiculo(vehiculo);
	}

	/**
	 * Genera el rchivo de catalogo de autos
	 * @param vehiculo
	 */
	private static void generarArchivoVehiculo(Vehiculo vehiculo) {
		try {

			StringBuilder strCodigo = new StringBuilder();
			StringBuilder strMarca = new StringBuilder();
			StringBuilder strAnio = new StringBuilder();
			StringBuilder strPlaca = new StringBuilder();
			File archivo = new File("car_catalog.txt");

			FileWriter fw;
			fw = new FileWriter(archivo, true);
			fw.write("");

			//Paso de valores por referencia
			Utilitario.generarFormatoArchivo(vehiculo.getCodigo().toString(), strCodigo, "COD");
			Utilitario.generarFormatoArchivo(vehiculo.getMarca().toString(), strMarca, "AU");
			Utilitario.generarFormatoArchivo(vehiculo.getAnio().toString(), strAnio, "Y");
			Utilitario.generarFormatoArchivo(vehiculo.getPlaca().toString(), strPlaca, "PL");

			Locale locale = new Locale("es", "EC");
			Calendar cal = Calendar.getInstance(locale);
			Date date = cal.getTime();             
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
			String fechaRegistro = format1.format(date);


			fw.write(fechaRegistro);
			fw.write(strCodigo.toString().toUpperCase());
			fw.write(strMarca.toString().toUpperCase());
			fw.write(strAnio.toString().toUpperCase());
			fw.write(strPlaca.toString().toUpperCase());
			fw.write("      LIBRE\n");
			fw.flush();
			fw.close();
			System.out.println("Datos ingresados con exito...");
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error en la carga del archivo: " + e);
		}
	}

	private static void generarFormatoCatalogoAuto(String elemento, StringBuilder propiedad, String prefijo) {
		int value = 15 - elemento.length();
		for(int i = 0; i < value; i++) {
			propiedad.append(" ");
		}
		propiedad.append(prefijo+elemento);
	}

	public static void searchCar() {
		System.out.println("==========================================================================================");
		System.out.println("                        Seleccione el criterio de búsqueda                                ");
		System.out.println("==========================================================================================");
		System.out.println("1. marca");
		System.out.println("2. anio vehiculo");
		System.out.println("3. estado");

		Scanner entradaEscaner = new Scanner (System.in);
		String entradaTeclado = entradaEscaner.nextLine(); 

		switch (entradaTeclado) {
		case "1":
			buscarPorMarca();
			break;
		case "2":
			buscarAnio();
			break;
		case "3":
			buscarPorEstado();
			break;
		default:
			System.out.println("...");
			break;

		}
	}
	
	/**
	 * 
	 * @param prefijo
	 * @param inputText
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void buscarPorItem(String prefijo, String inputText) throws FileNotFoundException, IOException {
		File carCatalog = new File("car_catalog.txt");
		if(carCatalog.exists()) {
			FileReader fileReader = new FileReader(carCatalog);
			BufferedReader br = new BufferedReader(fileReader);

			Collection<String> resultCol = Utilitario.buscarPorPatron(prefijo, inputText, br);

			for (String result : resultCol) {
				System.out.println(result);
			}
		}else{
			System.out.println("No existe catalogo de autos");
		}
	}
	
	/**
	 * Permite buscar en el catalogo por código 
	 */
	private static String buscarPorCodigo() {

		try {
			Scanner dataCar = new Scanner (System.in);
			String codigo = dataCar.nextLine();
			String prefijo = "COD";
			String inputText = codigo; 
			Prestamo prestamo = new Prestamo();
			File carCatalog = new File("car_catalog.txt");
			if(carCatalog.exists()) {
				FileReader fileReader = new FileReader(carCatalog);
				BufferedReader br = new BufferedReader(fileReader);

				Collection<String> resultCol = Utilitario.buscarPorPatron(prefijo, inputText, br);
				String linea = (String) resultCol.toArray()[0];
				if(resultCol.size() > 0) {
					Pattern patron = Pattern.compile("COD\\w\\w\\w\\w\\w\\w");
					Matcher coincidencia = patron.matcher(linea);
					while(coincidencia.find()) {
						return linea;
					}
				}
				
			}else{
				System.out.println("No existe catalogo de autos");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Ha ocurrido un error: " + e);
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error: " + e);
		}
		return null;
	}

	/**
	 * Permite buscar en el catalogo por marca del 
	 */
	private static void buscarPorMarca() {
		System.out.println("Ingrese marca  de auto: ");
		Scanner dataCar = new Scanner (System.in);
		String marca = dataCar.nextLine();
		String prefijo = "AU";
		String inputText = marca; 

		try {
			buscarPorItem(prefijo, inputText);
		} catch (FileNotFoundException e) {
			System.out.println("Ha ocurrido un error: " + e);
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error: " + e);
		}
	}

	/**
	 * Permite buscar por anio
	 */
	private static void buscarAnio() {
		Scanner dataCar = new Scanner (System.in);
		String marca = dataCar.nextLine();
		System.out.println("Anio: ");
		String prefijo = "Y";
		String inputText = marca;

		try {
			buscarPorItem(prefijo, inputText);
		} catch (FileNotFoundException e) {
			System.out.println("Ha ocurrido un error: " + e);
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error: " + e);
		}
	}

	/**
	 * Permite la busqueda por estado (LIBRE O ALQUILADO)
	 */
	private static void buscarPorEstado() {
		Scanner dataCar = new Scanner (System.in);
		System.out.println("Estado: ");
		String prefijo = "";
		String inputText = dataCar.nextLine();
		try {
			buscarPorItem(prefijo, inputText);
		} catch (FileNotFoundException e) {
			System.out.println("Ha ocurrido un error: " + e);
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error: " + e);
		}
	}

	/**
	 * Proceso que permite el registro del alquiler del vehiculo
	 */
	public static void rentCar(){
		System.out.println("==========================================================================================");
		System.out.println("                                     Autos disponibles                                    ");
		System.out.println("==========================================================================================");
		
		String nombreArchivo = "car_catalog.txt";
		String prefijo = "";
		Collection<String> resultCol = Utilitario.buscarDisponibles(Estado.LIBRE.toString(), nombreArchivo, prefijo);
		for (String result : resultCol) {
			System.out.println(result);
		}
		
		System.out.println("Ingresar código del auto: ");
		String linea = buscarPorCodigo();
			
	}
	
	public static void obtenerCodigoItemDisponible() {
		
	}

	
	/**
	 * Proceso que permite registrar la devolucion del vehiculo
	 */
	public static void returnCar(){
		System.out.println ("Escogio Devolucion Alquiler");

	}

}


