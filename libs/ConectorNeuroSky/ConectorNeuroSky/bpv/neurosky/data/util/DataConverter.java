package bpv.neurosky.data.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import bpv.neurosky.data.entity.SubjectTest;
import bpv.neurosky.data.entity.medicao.Medicao;
import bpv.neurosky.data.entity.medicao.MedicaoAtencao;

public class DataConverter {

	private static final String CABECALHO_CSV = "atencao, meditacao, sinal, tempo";

	public static String subjectToCsv(SubjectTest subjectTest) {
		String csv = DataConverter.CABECALHO_CSV +", '"+ subjectTest.getNome()+"', '"+subjectTest.getHipermidia().getTitulo()+"'\n";
		int i=0;
		for(MedicaoAtencao atencao:subjectTest.getDadosAtencao()){
			String linha = ""+atencao.getValor()+", ";
			linha += DataConverter.getValorMedicao(subjectTest.getDadosMeditacao(), i);
			linha += DataConverter.getValorMedicao(subjectTest.getDadosSinal(), i);
			//linha += "'"+subjectTest.getNome()+"' , ";
			//linha += "'"+subjectTest.getHipermidia().getTitulo()+"' , ";
			linha += i+"\n";
			i+=1;
			csv+=linha;
		}
		return csv;
	}
	
	@SuppressWarnings("rawtypes")
	private static String getValorMedicao(List lista, Integer pos){
		try{
			Integer valor = (Integer) ((Medicao)(lista.get(pos))).getValor();
			return  valor + ", ";
		}catch (Exception e) {
			return  "0, ";
		}
	}
	
}
