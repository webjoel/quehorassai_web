package net.unesc.quehorassai.mb;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import net.unesc.quehorassai.modelo.Usuario;
import net.unesc.quehorassai.persistencia.EntityManagerUtil;

public class GenericMB {
	
	protected EntityManager getEM() {
		return EntityManagerUtil.getEM();
	}
	
	protected void closeEM() {
		EntityManagerUtil.closeEM();
	}
	
	protected HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	}
	
	public Usuario getUsuarioConectado() {
		return (Usuario) getSession().getAttribute("usuarioConectado");
	}
	
	public void setUsuarioConectado(Usuario usuario) {
		getSession().setAttribute("usuarioConectado", usuario);
	}
}