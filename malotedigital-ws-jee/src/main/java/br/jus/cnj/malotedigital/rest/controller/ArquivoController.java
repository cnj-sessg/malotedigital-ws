package br.jus.cnj.malotedigital.rest.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.io.IOUtils;

import br.jus.cnj.malotedigital.data.ArquivoRepository;
import br.jus.cnj.malotedigital.model.Arquivo;

/**
 * Controladora JAX-RS para recuperar arquivos pela ID
 * @author leonardo.borges
 *
 */
@Path("/arquivos")
@ApplicationScoped
public class ArquivoController {

	
	@Inject
	private ArquivoRepository arquivoRepository;
	
    @GET
    @Path("/{id}")
    public Response getArquivo(@PathParam("id") String id) {
    	final Arquivo arquivo = arquivoRepository.recuperarArquivo(id);
    	
    	if ( arquivo!=null ) {
    	
	    	return Response.ok(new StreamingOutput() {
				public void write(OutputStream output) throws IOException, WebApplicationException {
					IOUtils.write(arquivo.getConteudo(), output);
				}
			}, arquivo.getContentType()).build();
	    	
    	} else {
    		return Response.status(Status.NOT_FOUND).build();
    	}
    }
    
    
}
