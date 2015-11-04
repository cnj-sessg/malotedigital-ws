package br.jus.cnj.malotedigital.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entidade representativa de um arquivo
 * @author leonardo.borges
 *
 */
@Entity
public class Arquivo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	@Column(length=10000000)
	private byte[] conteudo;
	private String contentType;
	
	public byte[] getConteudo() {
		return conteudo;
	}
	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	
}
