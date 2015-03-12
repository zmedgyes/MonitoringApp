package bpv.neurosky.xml;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;


public abstract class XMLWriter<E> {
	E instanciaAlvo;
	
	public XMLWriter(E s) {
		this.instanciaAlvo = s;
	}
	
	public void gerarArquivoXML(String caminho){
		File saida =  new File(caminho);
		this.gerarXML(saida);
	}
	
	public void gerarArquivoXML(File saida){
		this.gerarXML(saida);
	}
	
	public void gerarSaidaXML(){
		this.gerarXML(System.out);
	}
	/**
	 * Grava o contúdo do atributa subject em um arquivo compactado indicado em saida e fecha o arquivo.
	 * 
	 * @param saida @File indicando um arquivo
	 */
	private void gerarXML(File saida){
		try {
			Marshaller jaxbMarshaller = initJaxb();
			ByteArrayOutputStream bufferXML =  new ByteArrayOutputStream();
			
			//Cria buufer com conteúdo xml
			jaxbMarshaller.marshal(instanciaAlvo, bufferXML);
			
			//compacta e grava buffer xml no arquivo - fecha o arquivo
			GZIPOutputStream saidaGZip = (GZIPOutputStream) criaGZipOutputStrean(new FileOutputStream(saida));
			saidaGZip.write(bufferXML.toByteArray());
			saidaGZip.flush();
			saidaGZip.close();
			
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void gerarXML(OutputStream saida){
		try {
			Marshaller jaxbMarshaller = initJaxb();
	 
			jaxbMarshaller.marshal(instanciaAlvo, saida);	 
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private Marshaller initJaxb() throws JAXBException, PropertyException {
		JAXBContext jaxbContext = JAXBContext.newInstance(instanciaAlvo.getClass());
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		return jaxbMarshaller;
	}
	
	@SuppressWarnings("unused")
	private OutputStream criaGZipOutputStrean(File f) throws FileNotFoundException{
		FileOutputStream fout;
		
		fout = new FileOutputStream(f);
		return this.criaGZipOutputStrean(fout);
	}
	
	private OutputStream criaGZipOutputStrean(OutputStream s){
		GZIPOutputStream gzout;
		try {
			gzout = new GZIPOutputStream(s);
			return gzout;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
}
