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
@Table(name="RESPOSTA_ITEM_PERGUNTA")
@SequenceGenerator(name="SE_RESPOSTA_ITEM_PERGUNTA", sequenceName="SE_RESPOSTA_ITEM_PERGUNTA")
@Access(AccessType.FIELD)


@NamedQueries({
	@NamedQuery(name="RespostaItemPerguntaEntity.querySelLookup", query="select id as id, respostaPergunta as respostaPergunta from RespostaItemPerguntaEntity where id = ? order by id asc")
})
public class RespostaItemPerguntaEntity extends RespostaItemPergunta {

	private static final long serialVersionUID = 1L;
	
    /*
     * Construtor padrao
     */
    public RespostaItemPerguntaEntity() {
    }
	@Override
	public String toString() {
		return getRespostaPergunta().toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RespostaItemPergunta other = (RespostaItemPergunta) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}	

}
