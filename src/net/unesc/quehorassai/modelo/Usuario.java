package net.unesc.quehorassai.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@SequenceGenerator(name="SEQ_USUARIO",sequenceName="SEQ_USUARIO")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_USUARIO")
	@Column(name="codigo_usuario")
	private Integer codigoUsuario;
	@Column(name="nome_usuario")
	private String nomeUsuario;
	@Column(name="email_usuario")
	private String emailUsuario;
	@Column(name="login_usuario")
	private String loginUsuario;
	@Column(name="senha_usuario")
	private String senhaUsuario;
	@Column(name="usuario_adm")
	private String usuarioAdm;
	@Column(name="codigo_logradouro")
	private Integer codigoLogradouro;
	
	public Usuario() {
		
	}

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getUsuarioAdm() {
		return usuarioAdm;
	}

	public void setUsuarioAdm(String usuarioAdm) {
		this.usuarioAdm = usuarioAdm;
	}

	public Integer getCodigoLogradouro() {
		return codigoLogradouro;
	}

	public void setCodigoLogradouro(Integer codigoLogradouro) {
		this.codigoLogradouro = codigoLogradouro;
	}
}