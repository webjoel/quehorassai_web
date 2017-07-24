package net.unesc.quehorassai.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.unesc.quehorassai.modelo.Cidade;

@ManagedBean(name="cidade")
@ViewScoped
public class CidadeMB extends AbstractEntityMB<Cidade> {

	public CidadeMB() {
		novo();
	}
	
	@Override
	public void novo() {
		setBean(new Cidade());
	}
}