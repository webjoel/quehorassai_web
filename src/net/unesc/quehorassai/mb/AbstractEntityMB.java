package net.unesc.quehorassai.mb;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.persistence.EntityTransaction;

public abstract class AbstractEntityMB<E> extends GenericMB {
	
	private E bean;
	private List<E> listaBean;

	public void setBean(E bean) {
		this.bean = bean;
	}
	
	public E getBean() {
		return bean;
	}

	@SuppressWarnings("unchecked")
	public List<E> getListaBean() {
		
		if (listaBean == null || listaBean.size() == 0) {
			
			listaBean = (List<E>) getEM().createQuery("select e from " + getBean().getClass().getName() + " e", getBean().getClass()).getResultList();
		}
		
		return listaBean;
	}

	public void setListaBean(List<E> listaBean) {
		this.listaBean = listaBean;
	}
	
	@SuppressWarnings("unchecked")
	public void selecionar(ActionEvent event) {
		setBean((E) event.getComponent().getAttributes().get("bean"));
	}
	
	public abstract void novo();
	
	public void salvar() {
		
		EntityTransaction et = getEM().getTransaction();
		try {			
			et.begin();
			
	        getEM().merge(getBean());
	        
	        et.commit();
	        
	        setListaBean(null);
		} catch (Exception e) {
			et.rollback();
		} finally {			
			closeEM();
		}
	}
	
	public void excluir() {
		
		EntityTransaction et = getEM().getTransaction();
		try {
			et.begin();
			
			bean = getEM().merge(getBean());
			
	        getEM().remove(bean);
	        
	        et.commit();
	        
	        setListaBean(null);
	        
	        novo();
		} catch (Exception e) {
			et.rollback();
		} finally {
			closeEM();
		}
	}
}