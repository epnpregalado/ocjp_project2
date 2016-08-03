package epn.edu.ec.ocjp.services.commons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilitario {
	
	/**
	 * Permite la busqueda segun el patron enviado
	 * @param prefijo
	 * @param inputText
	 * @param br
	 * @return
	 * @throws IOException
	 */
	public static Collection<String> buscarPorPatron(
			String prefijo, 
			String inputText, 
			BufferedReader br) throws IOException {
		Collection<String> resultCol = new ArrayList<>();
		Matcher coincidencia;
		String linea;
		
		while((linea=br.readLine())!=null) {
			Pattern patron = Pattern.compile(prefijo + inputText.toUpperCase());
			coincidencia = patron.matcher(linea);
			while(coincidencia.find()) {//Este metodo muestra los indices donde encontro de manera automatica
				resultCol.add(linea);
			}
		}
		return resultCol;
	}
	
	/**
	 * Genera la cadena que se almacenará en el archivo
	 * @param elemento
	 * @param propiedad
	 * @param prefijo
	 * @return
	 */
	public static StringBuilder generarFormatoArchivo(String elemento, StringBuilder propiedad, String prefijo) {
		int value = 15 - elemento.length();
		for(int i = 0; i < value; i++) {
			propiedad.append(" ");
		}
		return propiedad.append(prefijo+elemento);
	}
	
	/**
	 * Busca registros en estado disponible dentro de los archivos dado el patrón de búsqueda
	 * @param value
	 * @return
	 */
	public static Collection<String> buscarDisponibles(String inputText, String nombreArchivo, String prefijo) {
		
		File archivo = new File(nombreArchivo);
		Collection<String> resultCol = null;
		try {
			if(archivo.exists()) {
				FileReader fileReader = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fileReader);
				resultCol = buscarPorPatron(prefijo, inputText, br);
			}else {
				System.out.println("No existe archivo");
			}
		} catch (Exception e) {
			
		}
		
		return resultCol;
	}
}
