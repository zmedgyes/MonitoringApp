package bpv.neurosky.data.entity.config;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import bpv.neurosky.data.entity.HyperMedia;

@XmlRootElement
public class Configuracao {

	@XmlTransient
	private static final String VERSAO = "0.1";

	
	private String versao = Configuracao.VERSAO;
	
	private List<HyperMedia> hipermidias;

	public List<HyperMedia> getHipermidias() {
		return hipermidias;
	}

	public void setHipermidias(List<HyperMedia> hipermidias) {
		this.hipermidias = hipermidias;
	}

	@XmlTransient
	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	} 
}
