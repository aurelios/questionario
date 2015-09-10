package br.com.questionario.entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.ForeignKey;
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

import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;
import javax.persistence.Transient;
import java.util.List;
import javax.validation.Valid;
import javax.persistence.CascadeType;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;
import javax.persistence.OneToMany;
import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;

@MappedSuperclass
public class RespostaPergunta  implements Serializable {

	
	@OneToMany (targetEntity = br.com.questionario.entity.RespostaItemPerguntaEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="respostaPergunta")
	@ForeignKey(name="FK_RESPOSTAITEMPERGUNTA_RESPOSTAPERGUNTA")
	@Valid
	private List<RespostaItemPergunta> respostaItemPergunta;
	
	@Id 
	@Column(name="ID_RESPOSTA_PERGUNTA")	
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "SE_RESPOSTA_PERGUNTA")
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
	
	@ManyToOne (targetEntity = RespostaQuestionarioEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_RESPOSTAPERGUNTA_RESPOSTAQUESTIONARIO")	
	@NotNull
	@JoinColumn(name="ID_RESPOSTA_QUESTIONARIO")
	private RespostaQuestionario respostaQuestionario;
	
	@ManyToOne (targetEntity = PerguntaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_RESPOSTAPERGUNTA_PERGUNTA")
	@NotNull	
	@JoinColumn(name="ID_PERGUNTA")
	private Pergunta pergunta;	
	
	@Size(max = 255)	
	private String dsResposta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public RespostaQuestionario getRespostaQuestionario() {
		return respostaQuestionario;
	}

	public void setRespostaQuestionario(RespostaQuestionario respostaQuestionario) {
		this.respostaQuestionario=respostaQuestionario;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta=pergunta;
	}

	public String getDsResposta() {
		return dsResposta;
	}

	public void setDsResposta(String dsResposta) {
		this.dsResposta=dsResposta;
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

	public List<RespostaItemPergunta> getRespostaItemPergunta() {
		return respostaItemPergunta;
	}

	public void setRespostaItemPergunta(List<RespostaItemPergunta> respostaItemPergunta) {
		this.respostaItemPergunta=respostaItemPergunta;
	}

}
