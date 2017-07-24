package net.unesc.quehorassai.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="itinerario")
public class Itinerario {

	@Id
	@SequenceGenerator(name="SEQ_ITINERARIO",sequenceName="SEQ_ITINERARIO")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_ITINERARIO")
	@Column(name="codigo_itinerario")
	private Integer codigoItinerario;
	@Column(name="codigo_linha")
	private Integer codigoLinha;
	@Column(name="codigo_logradouro")
	private Integer codigoLogradouro;
	
	public Itinerario() {
		
	}

	public Integer getCodigoItinerario() {
		return codigoItinerario;
	}

	public void setCodigoItinerario(Integer codigoItinerario) {
		this.codigoItinerario = codigoItinerario;
	}

	public Integer getCodigoLinha() {
		return codigoLinha;
	}

	public void setCodigoLinha(Integer codigoLinha) {
		this.codigoLinha = codigoLinha;
	}

	public Integer getCodigoLogradouro() {
		return codigoLogradouro;
	}

	public void setCodigoLogradouro(Integer codigoLogradouro) {
		this.codigoLogradouro = codigoLogradouro;
	}
}