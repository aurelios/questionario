package br.com.questionario.entity;


import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.AccessType;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import javax.persistence.Access;
/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name="RESPOSTA_PERGUNTA")
@SequenceGenerator(name="SE_RESPOSTA_PERGUNTA", sequenceName="SE_RESPOSTA_PERGUNTA")
@Access(AccessType.FIELD)


@NamedQueries({
	@NamedQuery(name="RespostaPerguntaEntity.querySelLookup", query="select id as id, dsResposta as dsResposta from RespostaPerguntaEntity where id = ? order by id asc")
})
public class RespostaPerguntaEntity extends RespostaPergunta {

	private transient String estadoSubDetalhePlc="E"; // E-expandido, R-retraido


	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public RespostaPerguntaEntity() {
    }
	@Override
	public String toString() {
		return getDsResposta();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RespostaPergunta other = (RespostaPergunta) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	public String getEstadoSubDetalhePlc() {
		return estadoSubDetalhePlc;
	}

	public void setEstadoSubDetalhePlc(String estadoSubDetalhePlc) {
		this.estadoSubDetalhePlc=estadoSubDetalhePlc;
	}

}
