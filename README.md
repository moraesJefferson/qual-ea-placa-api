# Qual é a placa

Projeto feito para a disciplina de sistemas multimídias. Consiste em efetuar reconhecimento visual de placas de sinalização de trânsito.


# Instalação
Necessário ter o maven instalado e configurado nas variaveis de ambiente
    
Link: https://maven.apache.org/download.cgi
    
adicionar na variável path o caminho para a pasta apache-maven-3.6.3\bin

Faça o import dessa aplicação (FrontEnd) no eclipse.


# Servidor

Realize o download do Apache Tomcat 9 e faça a configuração dele no eclipse. Feita a configuração coloque a aplicação qualeaplaca (FrontEnd) dentro do Tomcat.

Link: https://tomcat.apache.org/download-90.cgi

# API

Para o funcionamento da aplicação é necessário está executando API responsável por fazer reconhecimento do vídeo.

Realizar o import no eclipse da API que será responsável por realizar o reconhecimento

Link :https://github.com/moraesJefferson/qual-ea-placa-api

Com o clone da aplicação feito em sua máquina e o apache maven configurado nas variaveis de ambiente o serviço está pronto para ser executado.

# Script de reconhecimento
Tenha o python 3 instalado na máquina e o OpenCV 3. Não funciona com OpenCv 4. Você vai precisar também dos seguintes comandos de instalação:
```
pip install opencv-python==3.4.9.33
pip install numpy
pip install matplotlib
pip install scikit-image
pip install imutils
```

# Execução
Para executar o projeto:

Inicialize o servidor tomcat com o deploy do FrontEnd feito.

Entre na pasta onde foi feito o clone da API através do prompt de comando:

No prompt de comando: cd 'caminho onde está o diretório da API'

Inicie o serviço com o comando:
mvn spring-boot: run

Pronto! Os serviços necessários para executar a aplicação foram inicializados

# Página da web
http://localhost:8080/qual-e-a-placa/resource/html/index.jsp

Faça o download dos vídeos disponíveis no link abaixo:

Link:

Na página web selecione um dos video que foi baixado e clique em Upload File

O reconhecimento será executado. O processo pode levar alguns minutos.

Ao término do processo será exibida em tela a placa e o nome  da placa.
