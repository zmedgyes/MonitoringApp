package bpv.neurosky.data.entity.medicao;

import bpv.neurosky.data.type.TipoDadoEnum;

public class MedicaoAtencao extends Medicao<Integer> {
	
	public MedicaoAtencao() {
		super();
		this.setTipo(TipoDadoEnum.ATENCAO);
	}
	
	public MedicaoAtencao(Integer v){
		this();
		this.setValor(v);
	}

}
