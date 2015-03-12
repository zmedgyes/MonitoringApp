package bpv.neurosky.data.type;

public enum SerieEnum {
	POS_DESIGN("Pós Graduação em Design - UFSC"),
	MEDIO_TERCEIRO("3° Médio - Terceiro Ano"),
	MEDIO_SEGUNDO("2° Médio - Segundo Ano"),
	MEDIO_PRIMEIRO("1° Médio - Primeiro Ano"),
	FUNDAMENTAL_OITAVA("8° Fundamental - Oitava Série/Nono Ano"),
	FUNDAMENTAL_SETIMA("7° Fundamental - Sétima Série/Oitavo Ano"),
	FUNDAMENTAL_SEXTA("6° Fundamental - Sexta Série/Sétimo Ano"),
	FUNDAMENTAL_QUINTA("5° Fundamental - Quinta Série/Sexto Ano");
	
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
