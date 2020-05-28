package ec.edu.ups.examen.EXAMENMalkiYupanki.ObjetoNegocio;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.examen.EXAMENMalkiYupanki.Entidades.FacturaCabecera;
import ec.edu.ups.examen.EXAMENMalkiYupanki.Entidades.Producto;
import ec.edu.ups.examen.EXAMENMalkiYupanki.ObjetoDatos.FacturaCabeseraDAO;
import ec.edu.ups.examen.EXAMENMalkiYupanki.ObjetoDatos.FacturaDetalleDAO;
import ec.edu.ups.examen.EXAMENMalkiYupanki.ObjetoDatos.ProductoDAO;

@Stateless
public class FacturaON {
	
	@Inject
	FacturaCabeseraDAO faccab;
	
	@Inject
	FacturaDetalleDAO facdet;
	
	@Inject
	ProductoDAO pro;
	
	public void crearFactura(FacturaCabecera factura) {
		faccab.insertarFactura(factura);
	}
	
	public Producto retornaProducto(int codigo) {
		
		return pro.obtenerfactura(codigo);
	}

}
