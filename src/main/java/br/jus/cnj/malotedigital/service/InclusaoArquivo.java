package br.jus.cnj.malotedigital.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.jus.cnj.malotedigital.data.ArquivoRepository;
import br.jus.cnj.malotedigital.model.Arquivo;

/**
 * EJB para inserir um novo arquivo
 * @author leonardo.borges
 *
 */
@Stateless
public class InclusaoArquivo {
	@Inject
	private ArquivoRepository arquivoRepository;
	
	public void incluir(Arquivo arquivo) {
		arquivoRepository.salvar(arquivo);
	}
}
