package net.unesc.quehorassai.mb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Query;

import net.unesc.quehorassai.modelo.Horario;
import net.unesc.quehorassai.modelo.Usuario;

@ManagedBean(name="principal")
@ViewScoped
public class PrincipalMB extends GenericMB {

	private String loginUsuarioAcesso;
	private String senhaUsuarioAcesso;
	
	public String getLoginUsuarioAcesso() {
		return loginUsuarioAcesso;
	}

	public void setLoginUsuarioAcesso(String loginUsuarioAcesso) {
		this.loginUsuarioAcesso = loginUsuarioAcesso;
	}

	public String getSenhaUsuarioAcesso() {
		return senhaUsuarioAcesso;
	}

	public void setSenhaUsuarioAcesso(String senhaUsuarioAcesso) {
		this.senhaUsuarioAcesso = senhaUsuarioAcesso;
	}
	
	public String acessar() {
		
		if (getLoginUsuarioAcesso() != null && getSenhaUsuarioAcesso() != null) {
			
			Query query = getEM().createQuery("select u from Usuario u where u.loginUsuario = :login and u.senhaUsuario = :senha", Usuario.class);
			query.setParameter("login", getLoginUsuarioAcesso());
			query.setParameter("senha", getSenhaUsuarioAcesso());
			
			setUsuarioConectado((Usuario) query.getSingleResult());
		}
		
		return "index";
	}
	
	public void setHoraAtual(String hora) {
		getSession().setAttribute("horaAtual", hora);
	}
	
	private String getTipoDia() {
		
		Calendar calendar = new GregorianCalendar();
		Integer diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
		
		String tipoDia = "S";
		
		if (diaSemana == 1) {
			return "D";
		} else if (diaSemana == 7) {
			return "A";
		}
		
		// TODO F (FERIADO)
		
		return tipoDia;
	}
	
	private String getTipoSaida() {
		
		// TODO L (LOCALIDADE). 
		return "T";
	}
	
	private String formatDate(String format, Object date) {
		return new SimpleDateFormat(format, new Locale("pt","br")).format(date);
	}
	
	private String getHoraAtual() {
		
		String hora = (String) getSession().getAttribute("horaAtual");
		
		if (hora == null) {
		
			return formatDate("HH:mm:ss", System.currentTimeMillis());
		}
		
		return hora + ":00";
	}
	
	public String sair() {
		
		getSession().invalidate();
		
		return "index";
	}
	
	@SuppressWarnings("unchecked")
	public Collection<String> getProximosHorarios() {
	
		Collection<String> proximos = new ArrayList<String>();
		
		Usuario usuario = getUsuarioConectado();
		
		if (usuario != null) {
			
			Query query = getEM().createNativeQuery("select * from horario where CODIGO_LINHA in " +
						"(select i.CODIGO_LINHA from itinerario i where i.CODIGO_LOGRADOURO = ?) "+
						"and cast(HORARIO as time) > cast(? as time) and cast(HORARIO as time) <= '23:59' " +
						"and TIPO_SAIDA = ? and TIPO_DIA = ? " +
						"order by cast(HORARIO as time)", Horario.class);
			query.setParameter(1, usuario.getCodigoLogradouro());
			query.setParameter(2, getHoraAtual());
			query.setParameter(3, getTipoSaida());
			query.setParameter(4, getTipoDia());
			
			for (Horario horario : (List<Horario>) query.getResultList()) {
				proximos.add(horario.getHorario());
			}
		}
		
		return proximos;
	}
	
	public String getProximoHorario() {
		
		for (String proximo : getProximosHorarios()) {
			return proximo;
		}
		
		return "00:00";
	}
	
	public void proximoHorario() {
		setHoraAtual(getProximoHorario());
	}
}