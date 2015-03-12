package bpv.neurosky.data.type;

public enum TipoDadoEnum {
	ATENCAO("Atenção"),
	MEDITACAO("Meditação"),
	PISCADA("Piscada"),
	ONDA("Onda"),
	RAW("Dados Raw"), 
	SINAL("Sinal");
	
	private String descricao;

	private TipoDadoEnum(String desc) {
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
