package bpv.neurosky.data.entity.medicao;

import java.util.Date;

import bpv.neurosky.data.type.TipoDadoEnum;

public abstract class Medicao<E> {
	
	private E valor;
	private Date hora;
	private TipoDadoEnum tipo;
	
	public Medicao() {
		this.hora = new Date();
	}

	public E getValor() {
		return valor;
	}
	public void setValor(E valor) {
		this.valor = valor;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public TipoDadoEnum getTipo() {
		return tipo;
	}
	//Instancias de subclasses nao alteram o tipo
	protected void setTipo(TipoDadoEnum tipo) {
		this.tipo = tipo;
	}
}
