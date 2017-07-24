package net.unesc.quehorassai.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import net.unesc.quehorassai.modelo.Logradouro;
import net.unesc.quehorassai.modelo.Usuario;

@ManagedBean(name="usuario")
@ViewScoped
public class UsuarioMB extends AbstractEntityMB<Usuario> {
	
	private List<SelectItem> logradouros;
	
	public UsuarioMB() {
		if (getUsuarioConectado() != null) {
			setBean(getUsuarioConectado());
		} else {
			novo();
			getBean().setUsuarioAdm("N");
			getBean().setCodigoLogradouro(3);
		}
	}
	
	@Override
	public void novo() {
		setBean(new Usuario());
	}

	public List<SelectItem> getLogradouros() {
		
		if (logradouros == null || logradouros.size() == 0) {
			
			logradouros = new ArrayList<SelectItem>();
			logradouros.add(new SelectItem(0, "Selecione um Logradouro..."));
			
			for (Logradouro logradouro : (List<Logradouro>) getEM().createQuery("select l from Logradouro l", Logradouro.class).getResultList()) {
				logradouros.add(new SelectItem(logradouro.getCodigoLogradouro(), logradouro.getNomeLogradouro()));
			}
		}
		
		return logradouros;
	}
	
	@Override
	public void salvar() {
		
		super.salvar();
		
		setUsuarioConectado(getBean());
	}
}