package br.jus.cnj.malotedigital.ws;

/**
 * Resposta devolvida após tentativa de inclusão de arquivo
 * @author leonardo.borges
 *
 */
public class Resposta {

	private boolean sucesso;
	private String mensagem;
	
	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public boolean isSucesso() {
		return sucesso;
	}
	public String getMensagem() {
		return mensagem;
	}

}
