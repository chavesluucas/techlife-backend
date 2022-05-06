package br.com.techlife.pacientes.data.enums;

public enum Prioridade {

	GRAVISSIMA(1),
	GRAVE(2),
	MEDIO(3),
	LEVE(4);
	
private int code;
	
	private Prioridade(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Prioridade valueOf(int code) {
		for (Prioridade value : Prioridade.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
