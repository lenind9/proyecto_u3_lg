package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura1 {
	
	@Id
	@Column(name = "fact_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fact_id_seq")
	@SequenceGenerator(name = "fact_id_seq", sequenceName = "fact_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "fact_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "fact_numero")
	private String numero;
	
	//@OneToMany(mappedBy = "factura", cascade  = CascadeType.ALL, fetch = FetchType.EAGER)
	@OneToMany(mappedBy = "factura", cascade  = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DetalleFactura1> detalles;
	
	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<DetalleFactura1> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura1> detalles) {
		this.detalles = detalles;
	}
	
}