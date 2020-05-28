package ec.edu.ups.examen.EXAMENMalkiYupanki.ObjetoDatos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.examen.EXAMENMalkiYupanki.Entidades.FacturaCabecera;


@Stateless
public class FacturaCabeseraDAO {
	
	
	@PersistenceContext(name = "EXAMENMalkiYupankiPersistenceUnit") 
	private EntityManager con;
	
	public boolean insertarFactura(FacturaCabecera factura) {
		con.persist(factura);
		return true;
	}
	
	
	public FacturaCabecera obtenerfactura(int id) {
		 return con.find(FacturaCabecera.class, id);
	}
	
	
	
	public boolean editar_factura(FacturaCabecera factura) {
		con.merge(factura);
		return true;
	}
	
	public List<FacturaCabecera> obtener() {
		String jpl = "select p from FacturaCabecera p";
		Query q = con.createQuery(jpl, FacturaCabecera.class);
		//Query q = con.createNativeQuery(jpl, Persona.class) ;
		return q.getResultList();
	
	}
	
	
	public void eliminarpersona(FacturaCabecera per) {
		FacturaCabecera p = obtenerfactura(per.getIdCabecera());
		con.remove(p);

    }
	

}
