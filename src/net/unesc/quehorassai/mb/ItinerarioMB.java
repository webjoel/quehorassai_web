package net.unesc.quehorassai.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import net.unesc.quehorassai.modelo.Itinerario;
import net.unesc.quehorassai.modelo.Linha;
import net.unesc.quehorassai.modelo.Logradouro;

@ManagedBean(name="itinerario")
@ViewScoped
public class ItinerarioMB extends AbstractEntityMB<Itinerario> {
	
	private List<SelectItem> linhas;
	private List<SelectItem> logradouros;
	
	public ItinerarioMB() {
		novo();
	}
	
	@Override
	public void novo() {
		setBean(new Itinerario());
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
}