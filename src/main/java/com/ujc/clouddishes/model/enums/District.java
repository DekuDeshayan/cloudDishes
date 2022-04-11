package com.ujc.clouddishes.model.enums;

public enum District {

	MUNTEPUEZ(1),
	PALMA(2),
	MUEDA(3),
	XAI_XAI(4),  
	MANJACAZE(5),
	BILENE(6),
	VILANCULOS(7),
	MASSINGA(8),
	INHARRIME(9),
	GONDOLA(10),
	SUSSUNDENGA(11),
	MANICA(12),
	MAPUTO_CITY(13),
	MATOLA(14),
	BOANE(15),
	KATEMBE(16),
	MANHICA(17),
	MARRACUENE(18),
	NAMAACHA(19),
	MOAMBA(20),
	NACALA_A_VELHA(21),
	NAMPULA(22),
	ANGOCHE(23),
	CUAMBA(24),
	LICHINGA(25),
	MECULA(26),
	BEIRA(27),
	BUZI(28),
	GORONGOSA(29),
	DONDO(30),
	NHAMATANDA(31),
	ANGONIA(32),
	MOATIZE(33),
	MUTARARA(34),
	CHANGARA(35),
	CAHORA_BASSA(36),
	ALTO_MOLOCUE(37),
	GILE(38),
	MILANGE(39),
	LUGELA(40),
	MOCUBA(41);
	
	private int code;
	
	private District(int code) {
		this.code=code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static District valueOf(int code) {
		for(District value : District.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("distrito invalido");
	}		
	
	
}
