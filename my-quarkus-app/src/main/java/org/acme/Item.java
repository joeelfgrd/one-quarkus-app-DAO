package org.acme;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="t_items")
public class Item {

    @Id
	@Column(name="item_nom")
	private String nombre = "";
	
	@Column(name="item_prop")
	private int quality = 0;;

	@Column(name = "item_tipo", insertable = false, updatable = false)
	private String tipo;
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getQuality() {
		return this.quality;
	}
	

	public String getTipo() {
		return this.tipo;
	}    
}