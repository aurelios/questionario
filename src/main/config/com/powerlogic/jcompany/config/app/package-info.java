/* ************************* META-DADOS GLOBAIS DA APLICAÇÃO ******************************
  ********************** Configurações padrão para toda a aplicação *************************
  ************ Obs: configurações corporativas devem estar no nível anterior,****************
  ************              preferencialmente na camada Bridge               ****************
  *******************************************************************************************/


@PlcConfigApplication(
	definition=@PlcConfigApplicationDefinition(name="questionario", acronym="questionario", version=1, release=0),
	classesDiscreteDomain={br.com.questionario.enumerate.SimNao.class},
	classesLookup={br.com.questionario.entity.QuestionarioEntity.class,br.com.questionario.entity.PerguntaEntity.class,br.com.questionario.entity.ItemPerguntaEntity.class}
)


package com.powerlogic.jcompany.config.app;
import com.powerlogic.jcompany.config.application.PlcConfigApplication;
import com.powerlogic.jcompany.config.application.PlcConfigApplicationDefinition;
