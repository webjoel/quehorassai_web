package net.unesc.quehorassai.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
public class Cidade {

	@Id
	@SequenceGenerator(name="SEQ_CIDADE",sequenceName="SEQ_CIDADE")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_CIDADE")
	@Column(name="codigo_cidade")
	private Integer codigoCidade;
	@Column(name="nome_cidade")
	private String nomeCidade;
	private String uf;
	
	public Cidade() {
		
	}

	public Integer getCodigoCidade() {
		return codigoCidade;
	}

	public void setCodigoCidade(Integer codigoCidade) {
		this.codigoCidade = codigoCidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}