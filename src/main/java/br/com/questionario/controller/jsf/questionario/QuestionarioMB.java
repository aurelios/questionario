package br.com.questionario.controller.jsf.questionario;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import br.com.questionario.entity.ItemPergunta;
import br.com.questionario.entity.Pergunta;
import br.com.questionario.entity.QuestionarioEntity;
import br.com.questionario.enumerate.Alfabeto;
import br.com.questionario.controller.jsf.AppMB;

import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.config.collaboration.FormPattern;

import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm.ExclusionMode;



import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;

@PlcConfigAggregation(
		entity = br.com.questionario.entity.QuestionarioEntity.class

		,details = { 		@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(clazz = br.com.questionario.entity.PerguntaEntity.class,
								collectionName = "pergunta", numNew = 1,onDemand = false, 
								subDetail = @com.powerlogic.jcompany.config.aggregation.PlcConfigSubDetail(clazz = br.com.questionario.entity.ItemPerguntaEntity.class,
																collectionName = "itemPergunta", numNew = 1)
)
			

		}
	)



@PlcConfigForm (
	
	formPattern=FormPattern.Mds,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/questionario")
	
	
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("questionario")
@PlcHandleException
public class QuestionarioMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("questionario")
	public QuestionarioEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new QuestionarioEntity();
              this.newEntity();
        }
        this.atribuiSequenciais();
        return (QuestionarioEntity)this.entityPlc;     	
	}
	
	@Override
	public String create() {
		String retorno = super.create();
		this.atribuiSequenciais();
		return retorno;		
		
	}
	
	public void atribuiSequenciais(){
		QuestionarioEntity questionario =  (QuestionarioEntity) entityPlc;
		
		if(questionario != null && questionario.getPergunta() != null){
			int i = 0;
			for(Pergunta pergunta : questionario.getPergunta()){
				if(!pergunta.getIndExcPlc().equals("S"))
					pergunta.setNrSequencial(++i);
				if(pergunta.getItemPergunta() != null){
					int j = 0;
					for(ItemPergunta itemPergunta: pergunta.getItemPergunta()){
						if(!itemPergunta.getIndExcPlc().equals("S"))
							itemPergunta.setNrSequencial(Alfabeto.getByCodigo(j++));
					}
				}
			}
		}		
	}
	
	@Override
	public String save() {	
		this.atribuiSequenciais();
		return super.save();
	}
	
	
	
		
}
