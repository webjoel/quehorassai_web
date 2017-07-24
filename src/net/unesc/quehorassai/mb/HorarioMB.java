package net.unesc.quehorassai.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import net.unesc.quehorassai.modelo.Horario;
import net.unesc.quehorassai.modelo.Linha;

@ManagedBean(name="horario")
@ViewScoped
public class HorarioMB extends AbstractEntityMB<Horario> {
	
	private List<SelectItem> linhas;
	
	public HorarioMB() {
		novo();
	}
	
	@Override
	public void novo() {
		setBean(new Horario());
	}
	
	public List<SelectItem> getLinhas() {
		
		if (linhas == null || linhas.size() == 0) {
			
			linhas = new ArrayList<SelectItem>();
			linhas.add(new SelectItem(0, "Selecione uma Linha..."));
			
			for (Linha linha : (List<Linha>) getEM().createQuery("select l from Linha l", Linha.class).getResultList()) {
				linhas.add(new SelectItem(linha.getCodigoLinha(), linha.getDescricaoLinha()));
			}
		}
		
		return linhas;
	}
}