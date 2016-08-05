package epn.edu.ec.ocjp.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Entidad que define los datos generales para el boleto
 * @author jpatrick
 *
 */
public class DatosBoleto {

	private Ruta ruta;
	private Horario horario;
	private AutoBus autobus;

	/**
	 * Construtor inicializado
	 * @param ruta
	 * @param horario
	 * @param autobus
	 */
	public DatosBoleto(Ruta ruta, Horario horario, AutoBus autobus) {
		this.ruta = ruta;
		this.horario = horario;
		this.autobus = autobus;
	}

	/**
	 * Constructor por defecto
	 */
	public DatosBoleto() {

	}

	/**
	 * Permite mostrar el catalogo de items
	 */
	public void mostrarCatalogos(File archivo) {

		try {
			String linea;
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			System.out.println("LISTA DE ITEMS");
			System.out.println("-----------------------------------------");
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error: "+e);
		}
	}

	/**
	 * Permite ingresar los datos del autobus
	 * @return
	 */
	public AutoBus ingresarAutoBus() {
		
		String placas;
		String cooperativa;
		Integer numeroAsientos;
		this.autobus = new AutoBus();

		File archivo = new File("autobus.txt");
		if(archivo.exists()) {
			FileReader fileReader;
			try {
				mostrarCatalogos(archivo);
				
				System.out.println("Ingrese la placa del autobus: ");
				Scanner dataCar = new Scanner (System.in);
				String in = dataCar.nextLine();
				fileReader = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fileReader);
				String linea;
				Matcher coincidencia;
				while((linea=br.readLine())!=null) {
					Pattern patron = Pattern.compile(in.toUpperCase());
					coincidencia = patron.matcher(linea);
					while(coincidencia.find()) {
						placas = linea.substring(0, 7);
						numeroAsientos = Integer.parseInt(linea.substring(linea.length() - 2, linea.length()));
						cooperativa = linea.substring(7, linea.length()-2);
						autobus.setCooperativa(cooperativa);
						autobus.setNumeroPasajeros(numeroAsientos);
						autobus.setPlacas(placas);
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("Ha ocurrido FileNotFoundException: "+e);
			} catch (IOException e) {
				System.out.println("Ha ocurrido IOException: " + e);
			}
		}else{
			System.out.println("No existe catalogo de autos");
		}
		return getAutobus();
	}

	/**
	 * Permite ingresar la ruta de viaje
	 * @return
	 */
	public Ruta ingresarRuta() {

		try {
			String linea;
			File archivo = new File("ruta.txt");
			this.ruta = new Ruta();
			if(archivo.exists()) {
				mostrarCatalogos(archivo);

				FileReader fr2 = new FileReader(archivo);
				BufferedReader br2 = new BufferedReader(fr2);
				System.out.println("INGRESE CODIGO DE RUTA: ");
				Scanner dataCar = new Scanner (System.in);
				String in = dataCar.nextLine();

				try {
					Matcher coincidencia;
					while((linea=br2.readLine())!=null) {
						Pattern patron = Pattern.compile(in.toUpperCase());
						coincidencia = patron.matcher(linea);
						while(coincidencia.find()) {
							this.ruta.setRuta(linea);
						}
					}
				} catch (FileNotFoundException e) {
					System.out.println("Ha ocurrido FileNotFoundException: "+e);
				} catch (IOException e) {
					System.out.println("Ha ocurrido IOException: " + e);
				}
			}else {
				System.out.println("No existe archivo de rutas");
			}
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error: "+e);
		}
		return getRuta();
	}

	/**
	 * Permite ingresar el horario de salida
	 * @return
	 */
	public Horario ingresarHorario() {

		try {

			File archivo = new File("horario.txt");
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			this.horario = new Horario();
			if(archivo.exists()) {
				String linea;
				mostrarCatalogos(archivo);
				FileReader fr2 = new FileReader(archivo);
				BufferedReader br2 = new BufferedReader(fr2);
				System.out.println("INGRESE CODIGO DE HORARIO: ");
				Scanner dataCar = new Scanner (System.in);
				String in = dataCar.nextLine();

				Matcher coincidencia;
				while((linea=br2.readLine())!=null) {
					Pattern patron = Pattern.compile(in.toUpperCase());
					coincidencia = patron.matcher(linea);
					while(coincidencia.find()) {
						this.horario.setCodigoHorario(linea.substring(0, 4));
						this.horario.setHoraSalida(linea.substring(5, linea.length()));
					}
				}
			}else {
				System.err.println("No existe archivo de Horario");
			}
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error: "+e);
		}
		return getHorario();
	}

	/*
	 * Getters amd setters
	 */
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	public AutoBus getAutobus() {
		return autobus;
	}
	public void setAutobus(AutoBus autobus) {
		this.autobus = autobus;
	}


}
