package net.unesc.quehorassai.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="logradouro")
public class Logradouro {

	@Id
	@SequenceGenerator(name="SEQ_LOGRADOURO",sequenceName="SEQ_LOGRADOURO")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_LOGRADOURO")
	@Column(name="codigo_logradouro")
	private Integer codigoLogradouro;
	@Column(name="nome_logradouro")
	private String nomeLogradouro;
	@Column(name="codigo_cidade")
	private Integer codigoCidade;
	
	public Logradouro() {
		
	}

	public Integer getCodigoLogradouro() {
		return codigoLogradouro;
	}

	public void setCodigoLogradouro(Integer codigoLogradouro) {
		this.codigoLogradouro = codigoLogradouro;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	public Integer getCodigoCidade() {
		return codigoCidade;
	}

	public void setCodigoCidade(Integer codigoCidade) {
		this.codigoCidade = codigoCidade;
	}
}