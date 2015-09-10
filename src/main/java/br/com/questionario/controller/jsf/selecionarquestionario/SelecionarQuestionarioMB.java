package br.com.questionario.controller.jsf.selecionarquestionario;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.questionario.entity.RespostaQuestionarioEntity;
import br.com.questionario.controller.jsf.AppMB;

import com.powerlogic.jcompany.commons.PlcConstants;
import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;
import com.powerlogic.jcompany.config.collaboration.FormPattern;

import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm.ExclusionMode;
import com.powerlogic.jcompany.config.collaboration.PlcConfigSelection;


import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;


@PlcConfigAggregation(
		entity = br.com.questionario.entity.QuestionarioEntity.class
	)


@PlcConfigForm (
	selection = @PlcConfigSelection(apiQuerySel = "querySel"),
	formPattern=FormPattern.Sel,
	formLayout = @PlcConfigFormLayout(dirBase="/WEB-INF/fcls")
	
	
)


/**
 * Classe de Controle gerada pelo assistente
 */
 
@SPlcMB
@PlcUriIoC("selecionarquestionario")
@PlcHandleException
public class SelecionarQuestionarioMB extends AppMB  {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void handleButtonsAccordingFormPattern() {
		super.handleButtonsAccordingFormPattern();
		HttpServletRequest request = contextUtil.getRequest();
		request.setAttribute(PlcConstants.ACAO.EXIBE_BT_INCLUIR, PlcConstants.NAO);
	}
     		
	/**
	* Entidade da ação injetado pela CDI
	*/
	@Produces  @Named("selecionarquestionario")
	public RespostaQuestionarioEntity createEntityPlc() {
        if (this.entityPlc==null) {
              this.entityPlc = new RespostaQuestionarioEntity();
              this.newEntity();
        }
        return (RespostaQuestionarioEntity)this.entityPlc;     	
	}
		
}
