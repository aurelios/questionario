package br.com.questionario.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ForeignKey;
import java.util.List;
import javax.validation.Valid;
import javax.persistence.CascadeType;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;

@MappedSuperclass
public class Questionario  implements Serializable {

	
	@OneToMany (targetEntity = br.com.questionario.entity.PerguntaEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="questionario")
	@ForeignKey(name="FK_PERGUNTA2_QUESTIONARIO")
	@PlcValDuplicity(property="dsPergunta")
	@PlcValMultiplicity(referenceProperty="dsPergunta",  message="{jcompany.aplicacao.mestredetalhe.multiplicidade.PerguntaEntity}")
	@Valid
	@OrderBy(value="nrSequencial")
	private List<Pergunta> pergunta;


	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "SE_QUESTIONARIO")
	@Column(name="ID_QUESTIONARIO")	
	private Long id;
	
	@Version
	@NotNull
	@Digits(integer=5, fraction=0)
	@Column(name="VERSAO")	
	private Integer versao = new Integer(0);
	
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
	private String dsQuestionario;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getDsQuestionario() {
		return dsQuestionario;
	}

	public void setDsQuestionario(String dsQuestionario) {
		this.dsQuestionario=dsQuestionario;
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

	public List<Pergunta> getPergunta() {
		return pergunta;
	}

	public void setPergunta(List<Pergunta> pergunta) {
		this.pergunta = pergunta;
	}
	public Integer getPerguntaSize(){
		if(getPergunta() != null)
			return getPergunta().size();
		else
			return 0;
	}
}
