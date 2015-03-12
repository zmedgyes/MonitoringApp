package bpv.neurosky.data.type;

import java.util.ArrayList;
import java.util.List;

public class SubjectTestException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8145483042610855763L;

	private List<String> mensagens; 
	
	public SubjectTestException() {
		this.mensagens = new ArrayList<String>();
	}
	
	public void addMensagem(String msg){
		this.mensagens.add(msg);
	}

	public boolean isEmpty(){
		return this.mensagens.size()==0;
	}
	
	public List<String> getMensagens(){
		return mensagens;
	}
}
