package bpv.neurosky.data.entity.medicao;

import bpv.neurosky.data.type.TipoDadoEnum;

public class MedicaoMeditacao extends Medicao<Integer> {
	
	public MedicaoMeditacao() {
		this.setTipo(TipoDadoEnum.MEDITACAO);
	}

	public MedicaoMeditacao(Integer v){
		this();
		this.setValor(v);
	}
}
