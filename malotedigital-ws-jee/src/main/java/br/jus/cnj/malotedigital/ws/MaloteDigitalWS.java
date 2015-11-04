package br.jus.cnj.malotedigital.ws;

import javax.activation.DataHandler;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.soap.MTOM;

import org.apache.commons.io.IOUtils;

import br.jus.cnj.malotedigital.model.Arquivo;
import br.jus.cnj.malotedigital.service.InclusaoArquivo;

/**
 * JAX-WS para envio de arquivos utilizando MTOM.
 * @author leonardo.borges
 *
 */
@MTOM
@WebService(serviceName="maloteDigitalWS", portName="maloteDigitalWSPort")
public class MaloteDigitalWS  {
	
	@Inject
	private InclusaoArquivo inclusaoArquivo;

	@WebMethod
	public Resposta salvar (@WebParam(name="id") String id,
							@WebParam(name="contentType") String ct, 
							@XmlMimeType("application/octet-stream") 
							@WebParam(name="conteudo") DataHandler conteudo) {
		
		Resposta resp = new Resposta();
		try {
			Arquivo arquivo = new Arquivo();
			arquivo.setId(id);
			arquivo.setContentType(ct);
			arquivo.setConteudo(IOUtils.toByteArray(conteudo.getInputStream()));
			inclusaoArquivo.incluir(arquivo);
			resp.setSucesso(true);
			resp.setMensagem("Arquivo salvo com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMensagem("Erro ao salvar arquivo: "+e.getMessage());
		}
		
		return resp;
	}


}
