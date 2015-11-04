package br.jus.cnj.malotedigital.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.jus.cnj.malotedigital.model.Arquivo;

/**
 * Repositório de arquivos
 * @author leonardo.borges
 *
 */
@ApplicationScoped
public class ArquivoRepository {
	@Inject
    private EntityManager em;

	@SuppressWarnings("unchecked")
	public Arquivo recuperarArquivo(String id) {
		Query query = em.createQuery("SELECT a FROM Arquivo a WHERE a.id = :id");
		query.setParameter("id", id);
		List<Arquivo> result = query.getResultList();
		if ( result!=null && result.size()>0 ) {
			return result.get(0);
		} else {
			return null;
		}
	}

	public void salvar(Arquivo arquivo) {
		em.persist(arquivo);
		
	}
	
}
