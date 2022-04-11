package com.ujc.clouddishes.model.enums;

public enum Province {

	CABO_DELGADO(1),
	GAZA(2), 	    
	INHAMBANE(3),
	MANICA(4), 	          
	MAPUTO(5), 	    
	NAMPULA(6), 	
	NIASSA(7),      
	SOFALA(8), 	    
	TETE(9), 	    
	ZAMBEZIA(10);
	
	
	private int code;
	
	private Province(int code) {
		this.code = code;
	}
	
	
	public int getCode() {
		return this.code;
	}

	//metodo que retorna a provincia correspondente ao code passado
	public static Province valueOf (int code) {
		 
		for(Province value : Province.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("provincia invalida");
	}
	
}
