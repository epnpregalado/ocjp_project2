package epn.edu.ec.ocjp.core.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import epn.edu.ec.ocjp.core.TipoCosto;
import epn.edu.ec.ocjp.core.Vehiculo;

public class AlquilerTest {

	private static final TipoCosto LIBRE = null;
	private static final TipoCosto TIPO = null;
	
	@Test
	public void searchTest() {
		System.out.println("Pruebas de buscador");
		String prefijo = "AU";
		String inputText = "mazda"; 
		int count = 0;

		try {
			File carCatalog = new File("car_catalog.txt");
			if(carCatalog.exists()) {
				FileReader fileReader = new FileReader(carCatalog);
				BufferedReader br = new BufferedReader(fileReader);
				Matcher coincidencia;
				Matcher coincidenciaMarca;
				Matcher coincidenciaAnio;
				String linea;
				
				Collection<Vehiculo> vehiculoCol = new ArrayList<>();
				while((linea=br.readLine())!=null) {
					Pattern patron = Pattern.compile(prefijo + inputText.toUpperCase());
					coincidencia = patron.matcher(linea);
					while(coincidencia.find()) {//Este metodo muestra los indices donde encontro de manera automatica
					
						Pattern patronResult = Pattern.compile("\\d\\d\\d\\d/\\d\\d/\\d\\d");
						Pattern patronResultMarca = Pattern.compile("AU\\w\\w\\w\\w\\w");
						Pattern patronAnio = Pattern.compile("Y\\d\\d\\d\\d");
						coincidencia = patronResult.matcher(linea);
						coincidenciaMarca = patronResultMarca.matcher(linea);
						coincidenciaAnio = patronAnio.matcher(linea);
						
						while(coincidencia.find()) {//Este metodo muestra los indices donde encontro de manera automatica
							System.out.println(coincidencia.group());
						}
						
						while(coincidenciaMarca.find()) {//Este metodo muestra los indices donde encontro de manera automatica
							System.out.println(coincidenciaMarca.group());
						}
						
						while(coincidenciaAnio.find()) {//Este metodo muestra los indices donde encontro de manera automatica
							System.out.println(coincidenciaAnio.group());
						}
					}
				}
			}else{
				System.out.println("No existe catalogo de autos");
			}

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}



	}
	//	 @Test
	public void test(){
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File ("car_catalog.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while((linea=br.readLine())!=null)
				System.out.println(linea);
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta 
			// una excepcion.
			try{                    
				if( null != fr ){   
					fr.close();     
				}                  
			}catch (Exception e2){ 
				e2.printStackTrace();
			}
		}
	}
}
