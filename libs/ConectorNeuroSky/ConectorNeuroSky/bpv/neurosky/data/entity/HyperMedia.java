package bpv.neurosky.data.entity;

import java.net.URI;

/**
 * Classe que representa uma hipermidia.
 * 
 * TODO: Carregar isso com base em XML ou arquivo com dados mais completos, 
 * marcar tudo menos o nome/id como transiente para a geraçao do XML de SubjectTest
 * 
 * @author velloso
 *
 */
public class HyperMedia {
	
	private String titulo;
	private URI uri;
	
	public HyperMedia() {
		// TODO Auto-generated constructor stub
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String nome) {
		this.titulo = nome;
	}

	public URI getURI() {
		return uri;
	}

	public void setURI(URI uri) {
		this.uri = uri;
	}
	
	public String toString(){
		return (titulo==null?"Sem Titulo":titulo)+" : "+(uri==null?"Sem URI":uri.toString());
	}
	
}
