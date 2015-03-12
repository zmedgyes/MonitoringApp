package bpv.neurosky.data.entity;
/**
 * Classe responsavel por armazenar dados de um teste.
 * 
 * @author velloso
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import bpv.neurosky.data.entity.medicao.MedicaoAtencao;
import bpv.neurosky.data.entity.medicao.MedicaoMeditacao;
import bpv.neurosky.data.entity.medicao.MedicaoOnda;
import bpv.neurosky.data.entity.medicao.MedicaoPiscada;
import bpv.neurosky.data.entity.medicao.MedicaoRaw;
import bpv.neurosky.data.entity.medicao.MedicaoSinal;
import bpv.neurosky.data.type.SerieEnum;
import bpv.neurosky.data.type.SexoEnum;

@XmlRootElement
public class SubjectTest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8016412692456610544L;
	
	//Dados do sujeito
	private String nome;
	private SexoEnum sexo;
	private SerieEnum serie;
	private Date dataNascimento;
	private Float conceitoEscolar;
	
	//Dados do teste
	private Date inicio;
	private Date fim;
	private Integer tentativa=1;
	private HyperMedia hipermidia;
	private String observacoes;
	
	//Dados Obtidos
	private List<MedicaoAtencao> dadosAtencao;
	private List<MedicaoMeditacao> dadosMeditacao;
	private List<MedicaoPiscada> dadosPiscada;
	private List<MedicaoOnda> dadosDelta;
	private List<MedicaoOnda> dadosTheta;
	private List<MedicaoOnda> dadosLowAlpha;
	private List<MedicaoOnda> dadosHighAlpha;
	private List<MedicaoOnda> dadosLowBeta;
	private List<MedicaoOnda> dadosHighBeta;
	private List<MedicaoOnda> dadosLowGama;
	private List<MedicaoOnda> dadosHighGama;
	private List<MedicaoSinal> dadosSinal;
	private List<MedicaoRaw> dadosRaw;
	
	/**
	 * Cria objeto e inicializa listas de dados.
	 */
	public SubjectTest() {
		this.dadosAtencao = new ArrayList<MedicaoAtencao>();
		this.dadosMeditacao = new ArrayList<MedicaoMeditacao>();
		this.dadosPiscada = new ArrayList<MedicaoPiscada>();
		this.dadosDelta = new ArrayList<MedicaoOnda>();
		this.dadosTheta = new ArrayList<MedicaoOnda>();
		this.dadosLowAlpha = new ArrayList<MedicaoOnda>();
		this.dadosHighAlpha = new ArrayList<MedicaoOnda>();
		this.dadosLowBeta = new ArrayList<MedicaoOnda>();
		this.dadosHighBeta = new ArrayList<MedicaoOnda>();
		this.dadosLowGama = new ArrayList<MedicaoOnda>();
		this.dadosHighGama = new ArrayList<MedicaoOnda>();
		this.dadosSinal = new ArrayList<MedicaoSinal>();
		this.dadosRaw = new ArrayList<MedicaoRaw>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public SexoEnum getSexo() {
		return sexo;
	}
	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}
	public SerieEnum getSerie() {
		return serie;
	}
	public void setSerie(SerieEnum serie) {
		this.serie = serie;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Float getConceitoEscolar() {
		return conceitoEscolar;
	}
	public void setConceitoEscolar(Float conceitoEscolar) {
		this.conceitoEscolar = conceitoEscolar;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	public Integer getTentativa() {
		return tentativa;
	}
	public void setTentativa(Integer tentativa) {
		this.tentativa = tentativa;
	}
	public HyperMedia getHipermidia() {
		return hipermidia;
	}
	public void setHipermidia(HyperMedia hipermidia) {
		this.hipermidia = hipermidia;
	}
	public List<MedicaoAtencao> getDadosAtencao() {
		return dadosAtencao;
	}
	public void setDadosAtencao(List<MedicaoAtencao> dadosAtencao) {
		this.dadosAtencao = dadosAtencao;
	}
	public List<MedicaoMeditacao> getDadosMeditacao() {
		return dadosMeditacao;
	}
	public void setDadosMeditacao(List<MedicaoMeditacao> dadosMeditacao) {
		this.dadosMeditacao = dadosMeditacao;
	}

	public List<MedicaoPiscada> getDadosPiscada() {
		return dadosPiscada;
	}

	public void setDadosPiscada(List<MedicaoPiscada> dadosPiscada) {
		this.dadosPiscada = dadosPiscada;
	}

	public List<MedicaoOnda> getDadosDelta() {
		return dadosDelta;
	}

	public void setDadosDelta(List<MedicaoOnda> dadosDelta) {
		this.dadosDelta = dadosDelta;
	}

	public List<MedicaoOnda> getDadosTheta() {
		return dadosTheta;
	}

	public void setDadosTheta(List<MedicaoOnda> dadosTheta) {
		this.dadosTheta = dadosTheta;
	}

	public List<MedicaoOnda> getDadosLowAlpha() {
		return dadosLowAlpha;
	}

	public void setDadosLowAlpha(List<MedicaoOnda> dadosLowAlpha) {
		this.dadosLowAlpha = dadosLowAlpha;
	}

	public List<MedicaoOnda> getDadosHighAlpha() {
		return dadosHighAlpha;
	}

	public void setDadosHighAlpha(List<MedicaoOnda> dadosHighAlpha) {
		this.dadosHighAlpha = dadosHighAlpha;
	}

	public List<MedicaoOnda> getDadosLowBeta() {
		return dadosLowBeta;
	}

	public void setDadosLowBeta(List<MedicaoOnda> dadosLowBeta) {
		this.dadosLowBeta = dadosLowBeta;
	}

	public List<MedicaoOnda> getDadosHighBeta() {
		return dadosHighBeta;
	}

	public void setDadosHighBeta(List<MedicaoOnda> dadosHighBeta) {
		this.dadosHighBeta = dadosHighBeta;
	}

	public List<MedicaoOnda> getDadosLowGama() {
		return dadosLowGama;
	}

	public void setDadosLowGama(List<MedicaoOnda> dadosLowGama) {
		this.dadosLowGama = dadosLowGama;
	}

	public List<MedicaoOnda> getDadosHighGama() {
		return dadosHighGama;
	}

	public void setDadosHighGama(List<MedicaoOnda> dadosHighGama) {
		this.dadosHighGama = dadosHighGama;
	}

	public List<MedicaoSinal> getDadosSinal() {
		return dadosSinal;
	}

	public void setDadosSinal(List<MedicaoSinal> dadosSinal) {
		this.dadosSinal = dadosSinal;
	}

	public List<MedicaoRaw> getDadosRaw() {
		return dadosRaw;
	}

	public void setDadosRaw(List<MedicaoRaw> dadosRaw) {
		this.dadosRaw = dadosRaw;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}











