package bpv.neurosky.data.entity.medicao;

import bpv.neurosky.data.type.TipoDadoEnum;

public class MedicaoOnda extends Medicao<Integer> {
	
	public MedicaoOnda() {
		this.setTipo(TipoDadoEnum.ONDA);
	}

	public MedicaoOnda(Integer v){
		this();
		this.setValor(v);
	}
}
