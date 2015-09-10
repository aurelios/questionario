package br.com.questionario.controller.jsf.respostaquestionario;

import java.util.ArrayList;
import java.util.List;

import com.powerlogic.jcompany.commons.PlcBaseContextVO;
import com.powerlogic.jcompany.commons.PlcConstants;
import com.powerlogic.jcompany.commons.config.qualifiers.QPlcSpecific;
import com.powerlogic.jcompany.commons.facade.IPlcFacade;
import com.powerlogic.jcompany.controller.jsf.PlcBaseEditMB;

import br.com.questionario.entity.ItemPergunta;
import br.com.questionario.entity.Pergunta;
import br.com.questionario.entity.QuestionarioEntity;
import br.com.questionario.entity.RespostaItemPergunta;
import br.com.questionario.entity.RespostaItemPerguntaEntity;
import br.com.questionario.entity.RespostaPergunta;
import br.com.questionario.entity.RespostaPerguntaEntity;
import br.com.questionario.entity.RespostaQuestionarioEntity;

@QPlcSpecific(name = "respostaquestionario")
public class RespostaQuestionarioEditMB extends PlcBaseEditMB {
	
	@Override
	public Object[] editFind() {		
		PlcBaseContextVO context = (PlcBaseContextVO)contextUtil.getRequest().getAttribute(PlcConstants.CONTEXT);
		String url = urlUtil.resolveCollaborationNameFromUrl(contextUtil.getRequest());
		IPlcFacade facade = iocControleFacadeUtil.getFacade(url);
		
		PlcBaseContextVO contextoQuest = contextMontaUtil.createContextParamMinimum();
		contextoQuest.setEntityClassPlc(QuestionarioEntity.class);
		ArrayList<String> detalhe = new ArrayList<String>();
		detalhe.add("br.com.questionario.entity.PerguntaEntity");
		
		ArrayList<String> nomedetalhe = new ArrayList<String>();
		nomedetalhe.add("pergunta");
		
		contextoQuest.setDetailNames(detalhe);
		contextoQuest.setDetailNamesProps(nomedetalhe);
		contextoQuest.setSubDetailClass("br.com.questionario.entity.ItemPerguntaEntity");
		contextoQuest.setSubDetailParent("br.com.questionario.entity.PerguntaEntity");
		contextoQuest.setSubDetailPropNameCollection("itemPergunta");
		Object[] retQuestionario = facade.edit(contextoQuest, QuestionarioEntity.class, new Long(this.id));
		QuestionarioEntity questionario = (QuestionarioEntity) retQuestionario[0];		
		
		RespostaQuestionarioEntity respostaQuestionario = new RespostaQuestionarioEntity();
		respostaQuestionario.setQuestionario(questionario);
		
		List<RespostaPergunta> listaRP = new ArrayList<RespostaPergunta>();
		if(questionario.getPergunta() != null)
			for(Pergunta pergunta : questionario.getPergunta()){
				RespostaPerguntaEntity respostaPergunta = new RespostaPerguntaEntity();
				respostaPergunta.setPergunta(pergunta);
				//respostaPergunta.setRespostaQuestionario(respostaQuestionario);
				
				List<RespostaItemPergunta> listaIP = new ArrayList<RespostaItemPergunta>();
				if(pergunta.getItemPergunta() != null)
					for(ItemPergunta itemPergunta : pergunta.getItemPergunta()){
						RespostaItemPerguntaEntity respostaIP = new RespostaItemPerguntaEntity();
						respostaIP.setItemPergunta(itemPergunta);
						//respostaIP.setRespostaPergunta(respostaPergunta);
						
						listaIP.add(respostaIP);
					}
				respostaPergunta.setRespostaItemPergunta(listaIP);
				listaRP.add(respostaPergunta);
			}
		respostaQuestionario.setRespostaPergunta(listaRP);
		
		
		Object[] ret = new Object[3];
		ret[0] = respostaQuestionario;
		
		
		
		
		return ret;
	}

}
