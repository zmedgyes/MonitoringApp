/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bpv.neurosky.data.entity.config;

import bpv.neurosky.xml.ConfiguracaoXMLReader;
import bpv.neurosky.xml.ConfiguracaoXMLWriter;

/**
 * Singleton que encapsula as configurações do sistema
 *
 * @author velloso
 */
public class ConfigHandler {
	
	private static final String CAMINHO = "configuracaoLocal.xml.gz";
	private Configuracao configuracao;
	private static ConfigHandler instancia;
	
	private ConfigHandler(){
		ConfiguracaoXMLReader xmlReader = new ConfiguracaoXMLReader();
		this.configuracao = xmlReader.carregarXml(ConfigHandler.CAMINHO);
	}

	public static ConfigHandler getInstancia() {
		if(instancia==null){
			instancia = new ConfigHandler();
		}
		return instancia;
	}
	
	public Configuracao getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}

	public void saveConfig(){
		ConfiguracaoXMLWriter xmlWriter =  new ConfiguracaoXMLWriter(configuracao);
		xmlWriter.gerarArquivoXML(ConfigHandler.CAMINHO);
	}
    
}