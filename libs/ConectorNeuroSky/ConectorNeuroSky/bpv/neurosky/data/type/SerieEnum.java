package bpv.neurosky.data.type;

public enum SerieEnum {
	POS_DESIGN("P�s Gradua��o em Design - UFSC"),
	MEDIO_TERCEIRO("3� M�dio - Terceiro Ano"),
	MEDIO_SEGUNDO("2� M�dio - Segundo Ano"),
	MEDIO_PRIMEIRO("1� M�dio - Primeiro Ano"),
	FUNDAMENTAL_OITAVA("8� Fundamental - Oitava S�rie/Nono Ano"),
	FUNDAMENTAL_SETIMA("7� Fundamental - S�tima S�rie/Oitavo Ano"),
	FUNDAMENTAL_SEXTA("6� Fundamental - Sexta S�rie/S�timo Ano"),
	FUNDAMENTAL_QUINTA("5� Fundamental - Quinta S�rie/Sexto Ano");
	
	private String descricao;

	private SerieEnum(String desc) {
		this.setDescricao(desc);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String toString(){
		return this.getDescricao();
	}
}
