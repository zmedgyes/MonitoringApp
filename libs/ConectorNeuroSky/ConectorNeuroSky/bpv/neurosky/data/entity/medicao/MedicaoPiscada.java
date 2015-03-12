package bpv.neurosky.data.entity.medicao;

import bpv.neurosky.data.type.TipoDadoEnum;

public class MedicaoPiscada extends Medicao<Integer> {
	
	public MedicaoPiscada() {
		this.setTipo(TipoDadoEnum.PISCADA);
	}

	public MedicaoPiscada(Integer v){
		this();
		this.setValor(v);
	}
}
