package ec.edu.ups.examen.EXAMENMalkiYupanki.Entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class FacturaDetalle implements Serializable {
	
	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalle;
	
	private int cantidad;
	private Producto producto;
	
	@ManyToOne
    @JoinColumn(name = "id_cabecera")
    private FacturaCabecera codCabecera;

	public int getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public FacturaCabecera getCodCabecera() {
		return codCabecera;
	}

	public void setCodCabecera(FacturaCabecera faccab) {
		this.codCabecera = faccab;
	}
	
	
	
	
	
	

}
