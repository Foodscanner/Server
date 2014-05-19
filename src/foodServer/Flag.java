package foodServer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//TODO Felipe Oehrwald
/**
 * Allergy flags for {@link Article}
 * 
 * @author Christian Gläser
 * @author Felipe Oehrwald
 * 
 */
@Entity
public class Flag implements IFlag {

	private int id;
	private String name;
	private String description;
	private boolean limitToProduct;

	@Id
	@Column(name = "Flag_ID", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int aId) {
		this.id = aId;
	}

	@Column(name = "Flag_Name")
	public String getName() {
		return this.name;
	}

	public void setName(String aName) {
		this.name = aName;
	}

	@Column(name = "Flag_Description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String aDescription) {
		this.description = aDescription;
	}

	@Column(name = "LimitToProduct")
	public boolean getLimitToProduct() {
		return this.limitToProduct;
	}

	public void setLimitToProduct(boolean aLimitToProduct) {
		this.limitToProduct = aLimitToProduct;
	}

	public Flag copy() {
		// TODO Auto-generated method stub
		return null;
	}

	public void persist() {
		// TODO Auto-generated method stub
	}
}