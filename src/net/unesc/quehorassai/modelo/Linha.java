package net.unesc.quehorassai.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="linha")
public class Linha {

	@Id
	@SequenceGenerator(name="SEQ_LINHA",sequenceName="SEQ_LINHA")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_LINHA")
	@Column(name="codigo_linha")
	private Integer codigoLinha;
	@Column(name="descricao_linha")
	private String descricaoLinha;
	
	public Linha() {
		
	}

	public Integer getCodigoLinha() {
		return codigoLinha;
	}

	public void setCodigoLinha(Integer codigoLinha) {
		this.codigoLinha = codigoLinha;
	}

	public String getDescricaoLinha() {
		return descricaoLinha;
	}

	public void setDescricaoLinha(String descricaoLinha) {
		this.descricaoLinha = descricaoLinha;
	}
}