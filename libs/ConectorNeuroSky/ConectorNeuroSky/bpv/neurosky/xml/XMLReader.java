package bpv.neurosky.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLReader<E> {
	
	protected E instancia;
	
	
	public XMLReader(E i) {
		this.instancia = i;
	}

	/**
	 * Método que carrega um @<E> com base em um arquivo XML.
	 * 
	 * @param arquivoStr @String como caminho para arquivo xml
	 * @return @<E> carregado com os dados do arquivo
	 */
	public E carregarXml(String arquivoStr){
		File arquivo = new File(arquivoStr);
		return (E) carregarXML(arquivo);
	}
	
	/**
	 * Método que carrega um @<E> com base em um arquivo XML.
	 * 
	 * @param arquivo @File apontando para arquivo xml
	 * @return @<E> carregado com os dados de arquivo
	 */
	public E carregarXML(File arquivo){
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(instancia.getClass());
			
			//Cria stream de descompactacap gzip
			FileInputStream fileInputStream = new FileInputStream(arquivo);
			GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
			
			//Cria unmarshal
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			@SuppressWarnings("unchecked")
			E instacia = (E) jaxbUnmarshaller.unmarshal(gzipInputStream);
					
			return instacia;
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
