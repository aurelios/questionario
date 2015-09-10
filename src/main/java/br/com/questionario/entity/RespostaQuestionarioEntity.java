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
@Table(name="RESPOSTA_QUESTIONARIO")
@SequenceGenerator(name="SE_RESPOSTA_QUESTIONARIO", sequenceName="SE_RESPOSTA_QUESTIONARIO")
@Access(AccessType.FIELD)


@NamedQueries({
	@NamedQuery(name="RespostaQuestionarioEntity.querySel", query="select id as id from RespostaQuestionarioEntity order by id asc"),
	@NamedQuery(name="RespostaQuestionarioEntity.queryMan", query="from RespostaQuestionarioEntity"),
	@NamedQuery(name="RespostaQuestionarioEntity.querySelLookup", query="select id as id, email as email from RespostaQuestionarioEntity where id = ? order by id asc"),
	@NamedQuery(name="RespostaQuestionarioEntity.naoDeveExistirEmailDuplicado", query="select count(*) from RespostaQuestionarioEntity obj where obj.questionario = :questionario and obj.email = :email ")
})
public class RespostaQuestionarioEntity extends RespostaQuestionario {

	private static final long serialVersionUID = 1L;
 	
    /*
     * Construtor padrao
     */
    public RespostaQuestionarioEntity() {
    }
	@Override
	public String toString() {
		return getEmail();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RespostaQuestionario other = (RespostaQuestionario) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

}
