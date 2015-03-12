package bpv.neurosky.data.entity.medicao;

import bpv.neurosky.data.type.TipoDadoEnum;

public class MedicaoSinal extends Medicao<Integer> {
	
	public MedicaoSinal() {
		this.setTipo(TipoDadoEnum.SINAL);
	}

	public MedicaoSinal(Integer v){
		this();
		this.setValor(v);
	}
}
