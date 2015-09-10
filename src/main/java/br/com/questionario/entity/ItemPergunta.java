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

import com.powerlogic.jcompany.domain.validation.PlcValGroupEntityList;

import br.com.questionario.enumerate.Alfabeto;


@MappedSuperclass
public class ItemPergunta  implements Serializable {

	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "SE_ITEM_PERGUNTA")
	@Column(name="ID_ITEM_PERGUNTA")	
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
	
	@ManyToOne (targetEntity = PerguntaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_ITEMPERGUNTA_PERGUNTA")
	@NotNull
	@JoinColumn(name="ID_PERGUNTA")
	private Pergunta pergunta;	
	
	@NotNull(groups=PlcValGroupEntityList.class)
	@Size(max = 80)
	private String nmItem;
	
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "nrSequencial") 
	private Alfabeto nrSequencial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public String getNmItem() {
		return nmItem;
	}

	public void setNmItem(String nmItem) {
		this.nmItem=nmItem;
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

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta=pergunta;
	}

	@Transient
	private String indExcPlc = "N";	

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

	public Alfabeto getNrSequencial() {
		return nrSequencial;
	}

	public void setNrSequencial(Alfabeto nrSequencial) {
		this.nrSequencial = nrSequencial;
	}
}
