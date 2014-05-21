package foodServer;

import java.io.Serializable;

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
public class Flag implements IFlag, Serializable {

	@Override
	public String toString() {
		return "Flag [id=" + id + ", name=" + name + ", description="
				+ description + ", limitToProduct=" + limitToProduct + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + (limitToProduct ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flag other = (Flag) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (limitToProduct != other.limitToProduct)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7637310597378003342L;
	/**
	 * 
	 */
	// private static final long serialVersionUID = 1L;
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