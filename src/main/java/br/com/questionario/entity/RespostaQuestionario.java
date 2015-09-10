package br.com.questionario.entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Email;

import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.FetchType;
import javax.validation.constraints.Digits;
import javax.persistence.Version;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import java.util.List;
import javax.validation.Valid;
import javax.persistence.CascadeType;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;
import javax.persistence.OneToMany;
import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;

@MappedSuperclass
public class RespostaQuestionario  implements Serializable {

	
	@OneToMany (targetEntity = br.com.questionario.entity.RespostaPerguntaEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="respostaQuestionario")
	@ForeignKey(name="FK_RESPOSTAPERGUNTA_RESPOSTAQUESTIONARIO")
	@Valid	
	private List<RespostaPergunta> respostaPergunta;
	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "SE_RESPOSTA_QUESTIONARIO")
	@Column(name="ID_RESPOSTA_QUESTIONARIO")	
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
	
	@ManyToOne (targetEntity = QuestionarioEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_RESPOSTAQUESTIONARIO_QUESTIONARIO")
	@NotNull
	@JoinColumn(name="ID_QUESTIONARIO")
	private Questionario questionario;
	
	@Email(message="Email inválido.")
	@Size(max = 100)
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario=questionario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
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

	public List<RespostaPergunta> getRespostaPergunta() {
		return respostaPergunta;
	}

	public void setRespostaPergunta(List<RespostaPergunta> respostaPergunta) {
		this.respostaPergunta=respostaPergunta;
	}

}
