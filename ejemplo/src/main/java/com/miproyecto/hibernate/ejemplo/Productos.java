package com.miproyecto.hibernate.ejemplo;
// Generated 4 nov 2022 18:25:12 by Hibernate Tools 5.5.9.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Productos generated by hbm2java
 */
public class Productos implements java.io.Serializable {

	private byte id;
	private String descripcion;
	private Byte stockactual;
	private Byte stockminimo;
	private BigDecimal pvp;
	private Set ventases = new HashSet(0);

	public Productos() {
	}

	public Productos(byte id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public Productos(byte id, String descripcion, Byte stockactual, Byte stockminimo, BigDecimal pvp, Set ventases) {
		this.id = id;
		this.descripcion = descripcion;
		this.stockactual = stockactual;
		this.stockminimo = stockminimo;
		this.pvp = pvp;
		this.ventases = ventases;
	}

	public byte getId() {
		return this.id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Byte getStockactual() {
		return this.stockactual;
	}

	public void setStockactual(Byte stockactual) {
		this.stockactual = stockactual;
	}

	public Byte getStockminimo() {
		return this.stockminimo;
	}

	public void setStockminimo(Byte stockminimo) {
		this.stockminimo = stockminimo;
	}

	public BigDecimal getPvp() {
		return this.pvp;
	}

	public void setPvp(BigDecimal pvp) {
		this.pvp = pvp;
	}

	public Set getVentases() {
		return this.ventases;
	}

	public void setVentases(Set ventases) {
		this.ventases = ventases;
	}

}