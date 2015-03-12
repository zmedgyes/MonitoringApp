package bpv.neurosky.data.type;

public enum SexoEnum {
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private String descricao;

	private SexoEnum(String desc) {
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
