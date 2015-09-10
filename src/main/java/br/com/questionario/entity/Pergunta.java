package br.com.questionario.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;

import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;

import br.com.questionario.enumerate.SimNao;
import java.util.List;
import javax.validation.Valid;
import javax.persistence.CascadeType;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;


@MappedSuperclass
public class Pergunta  implements Serializable {

	private transient String estadoSubDetalhePlc="E"; // E-expandido, R-retraido
	
	@OneToMany (targetEntity = br.com.questionario.entity.ItemPerguntaEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="pergunta")
	@ForeignKey(name="FK_ITEMPERGUNTA_PERGUNTA")
	@PlcValDuplicity(property="nmItem")
	@PlcValMultiplicity(referenceProperty="nmItem",  message="{jcompany.aplicacao.mestredetalhe.multiplicidade.ItemPerguntaEntity}")
	@Valid
	@OrderBy(value="nrSequencial")
	private List<ItemPergunta> itemPergunta;

	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "SE_PERGUNTA")
	@Column(name="ID_PERGUNTA")	
	private Long id;
	
	@Version
	@NotNull
	@Digits(integer=5, fraction=0)
	@Column(name="VERSAO")	
	private Integer versao = new Integer(0);
	
	@NotNull
	@Column(name="NR_SEQUENCIAL")
	private Integer nrSequencial;
	
	@NotNull
	@Column(name="DATA_ULT_ALTERACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltAlteracao = new Date();
	
	@NotNull
	@Size(max = 150)
	@Column(name = "USUARIO_ULT_ALTERACAO") 
	private String usuarioUltAlteracao = "";
	
	@NotNull
	@Size(max = 150)
	private String dsPergunta;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@PlcValRequiredIf(dependentfield="idQuestaoAberta",targetField="dsPergunta")
	@Column(length=1)
	private SimNao idQuestaoAberta;
	
	@ManyToOne (targetEntity = QuestionarioEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_PERGUNTA_QUESTIONARIO")
	@NotNull
	@PlcValRequiredIf(dependentfield="questionario",targetField="dsPergunta")
	@JoinColumn(name="ID_QUESTIONARIO")
	private Questionario questionario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getDsPergunta() {
		return dsPergunta;
	}

	public void setDsPergunta(String dsPergunta) {
		this.dsPergunta=dsPergunta;
	}

	public SimNao getIdQuestaoAberta() {
		return idQuestaoAberta;
	}

	public void setIdQuestaoAberta(SimNao idQuestaoAberta) {
		this.idQuestaoAberta=idQuestaoAberta;
	}

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario=questionario;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao=versao;
	}

	public Date getDataUltAlteracao() {
		return dataUltAlteracao;
	}

	public void setDataUltAlteracao(Date dataUltAlteracao) {
		this.dataUltAlteracao=dataUltAlteracao;
	}

	public String getUsuarioUltAlteracao() {
		return usuarioUltAlteracao;
	}

	public void setUsuarioUltAlteracao(String usuarioUltAlteracao) {
		this.usuarioUltAlteracao=usuarioUltAlteracao;
	}
	
	@Transient
	private String indExcPlc = "N";	

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

	public List<ItemPergunta> getItemPergunta() {
		return itemPergunta;
	}

	public void setItemPergunta(List<ItemPergunta> itemPergunta) {
		this.itemPergunta=itemPergunta;
	}

	public String getEstadoSubDetalhePlc() {
		return estadoSubDetalhePlc;
	}

	public void setEstadoSubDetalhePlc(String estadoSubDetalhePlc) {
		this.estadoSubDetalhePlc=estadoSubDetalhePlc;
	}

	public Integer getNrSequencial() {
		return nrSequencial;
	}

	public void setNrSequencial(Integer nrSequencial) {
		this.nrSequencial = nrSequencial;
	}
}
