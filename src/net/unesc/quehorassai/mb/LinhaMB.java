package net.unesc.quehorassai.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.unesc.quehorassai.modelo.Linha;

@ManagedBean(name="linha")
@ViewScoped
public class LinhaMB extends AbstractEntityMB<Linha> {
	
	public LinhaMB() {
		novo();
	}
	
	@Override
	public void novo() {
		setBean(new Linha());
	}
}