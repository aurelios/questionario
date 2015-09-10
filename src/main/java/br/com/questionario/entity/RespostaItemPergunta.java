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
import com.powerlogic.jcompany.domain.validation.PlcValRequiredIf;

import br.com.questionario.enumerate.SimNao;

@MappedSuperclass
public class RespostaItemPergunta  implements Serializable {

	
	@Id 
 	@GeneratedValue(strategy=GenerationType.AUTO, generator = "SE_RESPOSTA_ITEM_PERGUNTA")
	@Column(name="ID_RESPOSTA_ITEM_PERGUNTA")
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
		
	@Column(name = "ID_CHECKED") 
	private String check = "N";	
	
	@ManyToOne (targetEntity = RespostaPerguntaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_RESPOSTAITEMPERGUNTA_RESPOSTAPERGUNTA")	
	@NotNull(groups=PlcValGroupEntityList.class)
	@JoinColumn(name="ID_RESPOSTA_PERGUNTA")
	private RespostaPergunta respostaPergunta;
	
	@ManyToOne (targetEntity = ItemPerguntaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name="FK_RESPOSTAITEMPERGUNTA_ITEMPERGUNTA")
	@NotNull(groups=PlcValGroupEntityList.class)
	@JoinColumn(name="ID_ITEM_PERGUNTA")
	private ItemPergunta itemPergunta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id=id;
	}

	public RespostaPergunta getRespostaPergunta() {
		return respostaPergunta;
	}

	public void setRespostaPergunta(RespostaPergunta respostaPergunta) {
		this.respostaPergunta=respostaPergunta;
	}

	public ItemPergunta getItemPergunta() {
		return itemPergunta;
	}

	public void setItemPergunta(ItemPergunta itemPergunta) {
		this.itemPergunta=itemPergunta;
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

	public String isCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getCheck() {
		return check;
	}
}
