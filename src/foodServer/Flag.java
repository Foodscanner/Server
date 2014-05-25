package foodServer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//TODO MappedByMethod for Article & Ingredient
/**
 * Allergy flags for {@link Article}
 * 
 * @author Christian Gläser
 * @author Felipe Oehrwald
 * 
 */
@Entity(name="FLAG")
@NamedQueries({
	//NamedQuery zur Auflistung aller Artikel
	@NamedQuery(name = Flag.FIND_FLAGS,
            query = "SELECT f " +
		            "FROM FLAG f"),
    @NamedQuery(name = Flag.FIND_FLAG_BY_FLAGID,
			query = "SELECT f " +
					"FROM FLAG f " +
					"WHERE f.id = :" + Flag.PARAM_FLAGID)})
public class Flag implements IFlag, Serializable {

	

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = -7637310597378003342L;
	private int id;
	private String name;
	private String description;
	private boolean limitToProduct;
	private List<Article> articles;
	private List<Ingredient> ingredients;
	
	//CONSTANTS
	public static final String PARAM_FLAGID = "ID";
	public static final String PARAM_NAME = "Name";
	public static final String PARAM_DESCRIPTION = "Description";
	public static final String PARAM_LIMITTOPRODUCT = "LimitToProduct";
	
	public static final String FIND_FLAGS = "findFlags";	
	public static final String FIND_FLAG_BY_FLAGID = "findFlagByFlagID";
	public static final String FIND_FULL_FLAG_BY_FLAGID = "findFullFlagByFlagID";
	

	public Flag(){
		articles = new ArrayList<Article>();
		ingredients = new ArrayList<Ingredient>();
	}
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	public int getId() {
		return this.id;
	}

	public void setId(int aId) {
		this.id = aId;
	}

	@Column(name = "Name")
	public String getName() {
		return this.name;
	}

	public void setName(String aName) {
		this.name = aName;
	}

	@Column(name = "Description")
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

	@ManyToMany(mappedBy = "flags")
	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	@ManyToMany(mappedBy = "flags")
	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
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
	
}