1- Instale o servidor tomcat 7.0
2- Ascrescentar os valores  <role rolename="Administrador"/>  <user password="senha" roles="tomcat,manager,admin,Administrador" username="admin"/> em tomcat/conf/tomcat-users.xml.
3- Copiar a biblioteca do banco de dados mysql-connector-java-5.1.22.jar para a pasta tomcat/lib
4- Instale o banco de dados mysql.
5- Realize a criaçao do schema questionario com usuario root e senha 123456.
6- Execute os scripts de criação das tabelas disponível em /questionario/outros/script.txt.
7- Copie o arquivo /questionario/target/questionario.war para o servidor tomcat.
8- Inicie o servidor e acesse http://localhost:8080/questionario.

