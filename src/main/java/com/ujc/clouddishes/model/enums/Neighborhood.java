package com.ujc.clouddishes.model.enums;

public enum Neighborhood {

	LIBERDADE(1),
	MALHAMPSENE(2),
	MACHAVA(3),
	MATOLA_GARE(4),
	MATOLA_SANTOS(5),
	CIDADE_MATOLA(6),
	CINEMA_700(7),
	FOMENTO(8),
	SIAL(9),
	ZUIDE(10),
	MACHAVA_TREVO(11),
	T3(12),
	ZIMPETO(13),
	MAGOANINE(14),
	GWAVA(15),
	MATEQUE(16),
	MICHAFUTENE(17),
	MAGAWANINE(18),
	NOVO_CEMITERIO(19),
	XIPAMANINE(20),
	BOQUISSO(21),
	BOBOLE(22),
	SANTA_ISABELA(23),
	TCHUMENE(24),
	INFULENE(25),
	MATLEMELE(26),
	INTAKA(27),
	MAHOTAS(28),
	XIQUELENE(29),
	COMPONE(30),
	MAFALALA(31),
	ALBAZINE(32),
	MALHAZINE(33),
	FERROVIARIO(34),
	CHOUPAL(35),
	INHAGOIA(36),
	MAXAQUENE(37),
	COSTA_DO_SOL_TRIUNFO(38),
	BAIRRO_CENTRAL(39),
	MAVALANE(40),
	NKOBE(41),
	KHONGOLOTE(42),
	BENFICA(43),
	ZONA_VERDE(44),
	MULOMBELA(45),
	MATENDENE(46);
	
private int code;
	
	private Neighborhood(int code) {
		this.code=code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Neighborhood valueOf(int code) {
		for(Neighborhood value : Neighborhood.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Bairro invalido");
	}		
	
	
	
	
}
