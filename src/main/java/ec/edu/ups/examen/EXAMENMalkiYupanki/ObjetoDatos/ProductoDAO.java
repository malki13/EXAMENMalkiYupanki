package ec.edu.ups.examen.EXAMENMalkiYupanki.ObjetoDatos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.examen.EXAMENMalkiYupanki.Entidades.FacturaCabecera;
import ec.edu.ups.examen.EXAMENMalkiYupanki.Entidades.Producto;

@Stateless
public class ProductoDAO {
	
	@PersistenceContext(name = "EXAMENMalkiYupankiPersistenceUnit") 
	private EntityManager con;
	
	public boolean insertarFactura(Producto producto) {
		con.persist(producto);
		return true;
	}
	
	
	public Producto obtenerfactura(int id) {
		 return con.find(Producto.class, id);
	}
	
	
	
	public boolean editar_factura(Producto factura) {
		con.merge(factura);
		return true;
	}
	
	public List<Producto> obtener() {
		String jpl = "select p from Producto p";
		Query q = con.createQuery(jpl, Producto.class);
		//Query q = con.createNativeQuery(jpl, Persona.class) ;
		return q.getResultList();
	
	}
	
	
	public void eliminarpersona(Producto per) {
		Producto p = obtenerfactura(per.getCodigo());
		con.remove(p);

    }

}
