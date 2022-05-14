package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;

@Table(name = "hospitales")
@Entity
public class Hospital implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer idHospital;
	  private String nombreHospital;
	  private String descripcionHospital;
	  private String distritoHospital;
	  
	  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
		@JoinTable(name="hospital_cliente",
		joinColumns = @JoinColumn(name="id_cliente", nullable = false, unique = true,foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_hospital) references products (id_cliente)")),
		inverseJoinColumns =  @JoinColumn(name="id_hospital", nullable = false, unique = true,foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references clients (id_hospital)"))
		)
		private List<Cliente> clientes = new ArrayList<>();

	public Integer getIdHospital() {
		return idHospital;
	}

	public void setIdHospital(Integer idHospital) {
		this.idHospital = idHospital;
	}

	public String getNombreHospital() {
		return nombreHospital;
	}

	public void setNombreHospital(String nombreHospital) {
		this.nombreHospital = nombreHospital;
	}

	public String getDescripcionHospital() {
		return descripcionHospital;
	}

	public void setDescripcionHospital(String descripcionHospital) {
		this.descripcionHospital = descripcionHospital;
	}

	public String getDistritoHospital() {
		return distritoHospital;
	}

	public void setDistritoHospital(String distritoHospital) {
		this.distritoHospital = distritoHospital;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	  
	  
}
