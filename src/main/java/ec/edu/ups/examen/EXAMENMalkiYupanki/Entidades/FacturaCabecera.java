package ec.edu.ups.examen.EXAMENMalkiYupanki.Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class FacturaCabecera implements Serializable {
	private static final long serialVersionUID = 2L;
	
	@Id
	@Column(name = "id_cabecera")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCabecera;
	
	private String Nombre;
	private String Apellido;
	private String Cedula;
	
	@OneToMany(mappedBy = "codCabecera", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FacturaDetalle> listaDetalles;

	public int getIdCabecera() {
		return idCabecera;
	}

	public void setIdCabecera(int idCabecera) {
		this.idCabecera = idCabecera;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public List<FacturaDetalle> getListaDetalles() {
		return listaDetalles;
	}

	public void setListaDetalles(List<FacturaDetalle> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}
	
	public void addDetalle(FacturaDetalle t) {
		if (listaDetalles == null)
			listaDetalles = new ArrayList<FacturaDetalle>();
		listaDetalles.add(t);
	}
	
	

}
