package bpv.neurosky.xml;

import bpv.neurosky.data.entity.config.Configuracao;

public class ConfiguracaoXMLReader extends XMLReader<Configuracao>{
	
	public ConfiguracaoXMLReader() {
		super( new Configuracao() );
	}
}
