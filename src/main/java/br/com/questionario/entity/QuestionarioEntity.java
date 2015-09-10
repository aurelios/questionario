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
@Table(name="QUESTIONARIO")
@SequenceGenerator(name="SE_QUESTIONARIO", sequenceName="SE_QUESTIONARIO")
@Access(AccessType.FIELD)


@NamedQueries({
	@NamedQuery(name="QuestionarioEntity.querySel", query="select id as id, dsQuestionario as dsQuestionario from QuestionarioEntity order by dsQuestionario asc"),
	@NamedQuery(name="QuestionarioEntity.queryMan", query="from QuestionarioEntity"),	
	@NamedQuery(name="QuestionarioEntity.querySelLookup", query="select id as id, dsQuestionario as dsQuestionario from QuestionarioEntity where id = ? order by id asc")
})
public class QuestionarioEntity extends Questionario {

	private static final long serialVersionUID = 1L;
	
 	
    /*
     * Construtor padrao
     */
    public QuestionarioEntity() {
    }
	@Override
	public String toString() {
		return getDsQuestionario();
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questionario other = (Questionario) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
