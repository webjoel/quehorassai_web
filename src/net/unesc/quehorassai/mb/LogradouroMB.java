package net.unesc.quehorassai.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import net.unesc.quehorassai.modelo.Cidade;
import net.unesc.quehorassai.modelo.Logradouro;

@ManagedBean(name="logradouro")
@ViewScoped
public class LogradouroMB extends AbstractEntityMB<Logradouro> {
	
	private List<SelectItem> cidades;
	
	public LogradouroMB() {
		novo();
	}
	
	@Override
	public void novo() {
		setBean(new Logradouro());
	}
	
	public List<SelectItem> getCidades() {
		
		if (cidades == null || cidades.size() == 0) {
			
			cidades = new ArrayList<SelectItem>();
			cidades.add(new SelectItem(0, "Selecione uma Cidade..."));
			
			for (Cidade cidade : (List<Cidade>) getEM().createQuery("select c from Cidade c", Cidade.class).getResultList()) {
				cidades.add(new SelectItem(cidade.getCodigoCidade(), cidade.getNomeCidade()));
			}
		}
		
		return cidades;
	}
}