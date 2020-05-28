package ec.edu.ups.examen.EXAMENMalkiYupanki.ObjetoDatos;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.ups.examen.EXAMENMalkiYupanki.Entidades.FacturaCabecera;
import ec.edu.ups.examen.EXAMENMalkiYupanki.Entidades.FacturaDetalle;
import ec.edu.ups.examen.EXAMENMalkiYupanki.Entidades.Producto;
import ec.edu.ups.examen.EXAMENMalkiYupanki.ObjetoNegocio.FacturaON;

@ManagedBean
@ViewScoped
public class FacturaBean {

	private FacturaON facon;

	private FacturaCabecera faccab;

//	private FacturaDetalle facdet;

//	private Producto producto;
	
	private int nume;

	private List<FacturaDetalle> listadetalles;

	@PostConstruct
	public void init() {
		
		faccab = new FacturaCabecera();
		FacturaDetalle t = new FacturaDetalle();
		t.setCodCabecera(faccab);
		faccab.addDetalle(t);
	}

	public FacturaON getFacon() {
		return facon;
	}

	public void setFacon(FacturaON facon) {
		this.facon = facon;
	}

	public FacturaCabecera getFaccab() {
		return faccab;
	}

	public void setFaccab(FacturaCabecera faccab) {
		this.faccab = faccab;
	}

/*	public FacturaDetalle getFacdet() {
		return facdet;
	}

	public void setFacdet(FacturaDetalle facdet) {
		this.facdet = facdet;
	}*/

/*	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}*/

	public List<FacturaDetalle> getListadetalles() {
		return listadetalles;
	}

	public void setListadetalles(List<FacturaDetalle> listadetalles) {
		this.listadetalles = listadetalles;
	}
	

	public int getNume() {
		return nume;
	}

	public void setNume(int nume) {
		this.nume = nume;
	}

	public String guardarDatos() {
		try {
			facon.crearFactura(faccab);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	public String addDetalle(int nume) {
		System.out.println(nume);
		FacturaDetalle t = new FacturaDetalle();
		//t.setCodCabecera(faccab);
		t.setCantidad(1);
		Producto p = facon.retornaProducto(nume);
		faccab.addDetalle(t);
		return null;
	}
	

	
	

}
