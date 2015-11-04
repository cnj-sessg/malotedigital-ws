# malotedigital-ws

Implementação de referência para o WSDL utilizado para envio de arquivos pelo Malote Digital.

O WSDL se encontra na pasta src\main\resources\maloteDigitalWS.wsdl.

Essa solução utiliza:
- CDI para fazer injeção de dependência
- EJB para controle de transação
- H2 banco de dados para armazenar os arquivos (não recomendado para uma solução definitiva)
- JAX-RS para recuperar os arquivos salvos
- JAX-WS para envio de arquivo via SOAP utilizando MTOM

Foi desenvolvido e testado utilizando JDK 1.7 e JBoss EAP 6.4

URL para envio de arquivo: http://localhost:8080/malotedigital-ws/maloteDigitalWS

URL para recuperar arquivo: http://localhost:8080/malotedigital-ws/rest/arquivos/123456
