package bpv.neurosky.data.entity.medicao;


import bpv.neurosky.data.type.TipoDadoEnum;

public class MedicaoRaw extends Medicao<Integer> {
	
	public MedicaoRaw() {
		this.setTipo(TipoDadoEnum.RAW);
	}

	
	public MedicaoRaw(Integer v){
		this();
		this.setValor(v);
	}
	
}
