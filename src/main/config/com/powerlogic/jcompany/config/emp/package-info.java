/* ******************* REDEFINIÇÃES DE META-DADOS GLOBAIS DA EMPRESA **********************
 ********************** Configurações default para toda a empresa *************************
 *******************************************************************************************/
			
@PlcConfigCompany(name = "Aurelios SA", domain = "", acronym = "", 
			logo = "/recursos/midia/login-logo-empresa.png", address = "Uberlândia/MG",
			supportEmail = "dicios@gmail.com.br",supportPhone = "55 34 9671-9987")
			
@PlcConfigLookAndFeel(skin = "itunes", layout = "sistema")

@PlcConfigSuffixClass (entity="Entity",repository="Repository")

@PlcConfigPackage (entity=".entity.", application="br.com.questionario")
			    	 
package com.powerlogic.jcompany.config.emp;

import com.powerlogic.jcompany.config.application.PlcConfigLookAndFeel;
import com.powerlogic.jcompany.config.application.PlcConfigCompany;
import com.powerlogic.jcompany.config.application.PlcConfigPackage;
import com.powerlogic.jcompany.config.application.PlcConfigSuffixClass;

