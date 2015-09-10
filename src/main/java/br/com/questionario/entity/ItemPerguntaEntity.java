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
@Table(name="ITEM_PERGUNTA")
@SequenceGenerator(name="SE_ITEM_PERGUNTA", sequenceName="SE_ITEM_PERGUNTA")
@Access(AccessType.FIELD)


@NamedQueries({
	@NamedQuery(name="ItemPerguntaEntity.querySelLookup", query="select id as id, nmItem as nmItem from ItemPerguntaEntity where id = ? order by id asc")
})
public class ItemPerguntaEntity extends ItemPergunta {

	private static final long serialVersionUID = 1L;
	
	
 	
    /*
     * Construtor padrao
     */
    public ItemPerguntaEntity() {
    }
	@Override
	public String toString() {
		return getNmItem();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPergunta other = (ItemPergunta) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
