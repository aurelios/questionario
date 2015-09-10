package br.com.questionario.controller.jsf.respostaquestionario;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcConstants;
import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcSpecific;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.action.util.PlcConversationControl;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

import br.com.questionario.controller.jsf.AppMB;
import br.com.questionario.entity.ItemPergunta;
import br.com.questionario.entity.ItemPerguntaEntity;
import br.com.questionario.entity.PerguntaEntity;
import br.com.questionario.entity.QuestionarioEntity;
import br.com.questionario.entity.RespostaItemPergunta;
import br.com.questionario.entity.RespostaItemPerguntaEntity;
import br.com.questionario.entity.RespostaPergunta;
import br.com.questionario.entity.RespostaPerguntaEntity;
import br.com.questionario.entity.RespostaQuestionarioEntity;

@PlcConfigAggregation(
		entity = br.com.questionario.entity.RespostaQuestionarioEntity.class

		,details = { 		@com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(clazz = br.com.questionario.entity.RespostaPerguntaEntity.class,
								collectionName = "respostaPergunta", numNew = 1,onDemand = false,
								subDetail = @com.powerlogic.jcompany.config.aggregation.PlcConfigSubDetail(clazz = br.com.questionario.entity.RespostaItemPerguntaEntity.class,
																collectionName = "respostaItemPergunta", numNew = 1)
)
			

		}
	)



@PlcConfigForm (
	
	formPattern=FormPattern.Mds,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls/respostaquestionario")
	
	
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("respostaquestionario")
@PlcHandleException
public class RespostaQuestionarioMB extends AppMB  {

	@Inject @Named(PlcConstants.PlcJsfConstantes.PLC_CONTROLE_CONVERSACAO)
	protected PlcConversationControl plcControleConversacao;	
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void handleButtonsAccordingFormPattern() {
		super.handleButtonsAccordingFormPattern();
		HttpServletRequest request = contextUtil.getRequest();
		request.setAttribute(PlcConstants.ACAO.EXIBE_BT_INCLUIR, PlcConstants.NAO);
		request.setAttribute(PlcConstants.ACAO.EXIBE_BT_EXCLUIR, PlcConstants.NAO);
		request.setAttribute(PlcConstants.ACAO.EXIBE_BT_ABRIR, PlcConstants.NAO);
		request.setAttribute(PlcConstants.ACAO.EXIBE_BT_CLONAR, PlcConstants.NAO);
		request.setAttribute(PlcConstants.ACAO.EXIBE_BT_VISUALIZA_DOCUMENTO, PlcConstants.NAO);
		request.setAttribute("exibe_jcompany_evt_incluir_subdetalhe", PlcConstants.NAO);
		request.setAttribute("exibe_jcompany_evt_incluir_detalhe", PlcConstants.NAO);
	}
	
	@Override
	public String save() {		
		RespostaQuestionarioEntity rq = (RespostaQuestionarioEntity) entityPlc;
		
		if(rq.getRespostaPergunta() != null)
			for(RespostaPergunta p : rq.getRespostaPergunta()){
				p.setRespostaQuestionario(rq);
				if(p.getRespostaItemPergunta() != null)
					for(RespostaItemPergunta rip : p.getRespostaItemPergunta()){
						rip.setRespostaPergunta(p);
					}
			}		
		
		plcControleConversacao.setModoPlc(PlcConstants.MODOS.MODO_INCLUSAO);
		return super.save();
	}
	
    		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("respostaquestionario")
	public RespostaQuestionarioEntity createEntityPlc() {
         if (this.entityPlc==null) {
              this.entityPlc = new RespostaQuestionarioEntity();              
              this.newEntity();
         }         
        return (RespostaQuestionarioEntity) this.entityPlc;   
        
	}
}
