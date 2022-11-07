package com.miproyecto.hibernate.ejemplo;
// Generated 4 nov 2022 18:25:12 by Hibernate Tools 5.5.9.Final

import java.util.Date;

/**
 * Ventas generated by hbm2java
 */
public class Ventas implements java.io.Serializable {

	private byte idVentas;
	private Clientes clientes;
	private Productos productos;
	private Date fechaventas;
	private Byte cantidad;

	public Ventas() {
	}

	public Ventas(byte idVentas) {
		this.idVentas = idVentas;
	}

	public Ventas(byte idVentas, Clientes clientes, Productos productos, Date fechaventas, Byte cantidad) {
		this.idVentas = idVentas;
		this.clientes = clientes;
		this.productos = productos;
		this.fechaventas = fechaventas;
		this.cantidad = cantidad;
	}

	public byte getIdVentas() {
		return this.idVentas;
	}

	public void setIdVentas(byte idVentas) {
		this.idVentas = idVentas;
	}

	public Clientes getClientes() {
		return this.clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public Productos getProductos() {
		return this.productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	public Date getFechaventas() {
		return this.fechaventas;
	}

	public void setFechaventas(Date fechaventas) {
		this.fechaventas = fechaventas;
	}

	public Byte getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Byte cantidad) {
		this.cantidad = cantidad;
	}

}
