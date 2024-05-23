package org.acme;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="t_ordenes")
public class Orden {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ord_id")
    private Long id; 
    
    @OneToOne
	@JoinColumn(name="ord_user")
	private Usuaria user;
	
	@OneToOne
	@JoinColumn(name="ord_item")
	private Item item;

	public Orden() {}

	public Orden(Usuaria user, Item item) {
		this.user = user;
		this.item = item;
	}

	public Long getId() {
		return id;
	}
	
	public Item getItem() {
		return item;
	}
	
	public Usuaria getUser() {
		return this.user;
	}
	

}