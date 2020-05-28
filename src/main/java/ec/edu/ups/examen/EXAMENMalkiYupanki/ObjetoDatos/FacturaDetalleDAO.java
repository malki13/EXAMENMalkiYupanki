package ec.edu.ups.examen.EXAMENMalkiYupanki.ObjetoDatos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.examen.EXAMENMalkiYupanki.Entidades.FacturaCabecera;
import ec.edu.ups.examen.EXAMENMalkiYupanki.Entidades.FacturaDetalle;

@Stateless
public class FacturaDetalleDAO {
	
	
	@PersistenceContext(name = "EXAMENMalkiYupankiPersistenceUnit") 
	private EntityManager con;
	
	public boolean insertarFactura(FacturaDetalle factura) {
		con.persist(factura);
		return true;
	}
	
	
	public FacturaDetalle obtenerfactura(int id) {
		 return con.find(FacturaDetalle.class, id);
	}
	
	
	
	public boolean editar_factura(FacturaDetalle factura) {
		con.merge(factura);
		return true;
	}
	
	public List<FacturaDetalle> obtener() {
		String jpl = "select p from FacturaDetalle p";
		Query q = con.createQuery(jpl, FacturaCabecera.class);
		//Query q = con.createNativeQuery(jpl, Persona.class) ;
		return q.getResultList();
	
	}
	
	
	public void eliminarpersona(FacturaDetalle per) {
		FacturaDetalle p = obtenerfactura(per.getIdDetalle());
		con.remove(p);

    }
	

}
