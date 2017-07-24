package net.unesc.quehorassai.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="horario")
public class Horario {

	@Id
	@SequenceGenerator(name="SEQ_HORARIO",sequenceName="SEQ_HORARIO")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_HORARIO")
	@Column(name="codigo_horario")
	private Integer codigoHorario;
	private String horario;
	@Column(name="tipo_saida")
	private String tipoSaida;
	@Column(name="tipo_dia")
	private String tipoDia;
	@Column(name="codigo_linha")
	private Integer codigoLinha;
	
	public Horario() {
		
	}

	public Integer getCodigoHorario() {
		return codigoHorario;
	}

	public void setCodigoHorario(Integer codigoHorario) {
		this.codigoHorario = codigoHorario;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getTipoSaida() {
		return tipoSaida;
	}

	public void setTipoSaida(String tipoSaida) {
		this.tipoSaida = tipoSaida;
	}

	public String getTipoDia() {
		return tipoDia;
	}

	public void setTipoDia(String tipoDia) {
		this.tipoDia = tipoDia;
	}

	public Integer getCodigoLinha() {
		return codigoLinha;
	}

	public void setCodigoLinha(Integer codigoLinha) {
		this.codigoLinha = codigoLinha;
	}
}