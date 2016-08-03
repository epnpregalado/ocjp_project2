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
public enum Estado {
    ALQUILADO (1), 
    EN_REPARACION(2),
    LIBRE(3);  
    
    private final int estado; 

    private Estado(int estado) {
        this.estado = estado;
    }

	public int getEstado() {
		return estado;
	}
    
}
