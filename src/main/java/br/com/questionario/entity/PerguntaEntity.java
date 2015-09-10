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
@Table(name="PERGUNTA")
@SequenceGenerator(name="SE_PERGUNTA", sequenceName="SE_PERGUNTA")
@Access(AccessType.FIELD)


@NamedQueries({
	@NamedQuery(name="PerguntaEntity.querySelLookup", query="select id as id, dsPergunta as dsPergunta from PerguntaEntity where id = ? order by nrSequencial asc")
})
public class PerguntaEntity extends Pergunta {

	private static final long serialVersionUID = 1L;
	private transient String idPerguntaAbertaAux;	
	
 	
    public String getIdPerguntaAbertaAux() {
		return "N";
	}
	public void setIdPerguntaAbertaAux(String idPerguntaAbertaAux) {
		this.idPerguntaAbertaAux = idPerguntaAbertaAux;
	}
	/*
     * Construtor padrao
     */
    public PerguntaEntity() {
    }
	@Override
	public String toString() {
		return getDsPergunta();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
