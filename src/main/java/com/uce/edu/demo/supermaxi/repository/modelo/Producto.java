package com.uce.edu.demo.supermaxi.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@Column(name = "prod_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_id_seq")
	@SequenceGenerator(name = "prod_id_seq", sequenceName = "prod_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "prod_codigo_barras")
	private String codigoBarras;
	
	@Column(name = "prod_nombre")
	private String nombre;
	
	@Column(name = "prod_precio")
	private BigDecimal precio;
	
	@Column(name = "prod_stock")
	private Integer stock;
	
	@OneToMany(mappedBy = "producto")
	private List<DetalleFactura2> detalles;
	
	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<DetalleFactura2> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura2> detalles) {
		this.detalles = detalles;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}