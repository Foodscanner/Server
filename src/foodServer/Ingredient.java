package foodServer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


//TODO MappedByMethod for Article
/**
 * Ingredients consist of names and {@link IFlag}s
 * 
 * @author Christian Gläser
 * @author Felipe Oehrwald
 * 
 */
@Entity(name="INGREDIENT")
@NamedQueries({
	//NamedQuery zur Auflistung aller Artikel
	@NamedQuery(name = Ingredient.FIND_INGREDIENTS,
            query = "SELECT i " +
		            "FROM INGREDIENT i"),
	    @NamedQuery(name = Ingredient.FIND_INGREDIENT_BY_INGREDIENTID,
				query = "SELECT i " +
						"FROM INGREDIENT i " +
						"WHERE i.id = :" + Ingredient.PARAM_INGREDIENTID),
})
public class Ingredient implements IIngredient {
	private int id;
	private String name;
	private List<Flag> flags;
	private List<Article> articles;
	
	
	public static final String PARAM_INGREDIENTID = "ID";
	public static final String PARAM_NAME = "Name";
	
	public static final String FIND_INGREDIENTS = "findIngredients";	
	public static final String FIND_INGREDIENT_BY_INGREDIENTID = "findIngredientByIngredientID";
	
	public Ingredient() {
		name = "";
		flags = new ArrayList<Flag>();
		articles = new ArrayList<Article>();
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

	public void setName(String name) {
		this.name = name;
	}

	public void addFlag(Flag flag) {
		flags.add(flag);
	}

	public void removeFlag(Flag flag) {
		flags.remove(flag);
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="INGREDIENT_FLAGS",
	joinColumns=@JoinColumn(name="FK_IngredientID",referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="FK_FlagID",referencedColumnName="ID"))
	public List<Flag> getFlags() {
		return this.flags;
	}
	
	public void setFlags(List<Flag> flags){
		this.flags = flags;
	}

	/**
	 * Copies an ingredient with all properties except id, which is left
	 * unfilled
	 * 
	 * @see foodServer.IIngredient#copy()
	 */
	public Ingredient copy() {
		Ingredient ingredient = new Ingredient();
		ingredient.setName(this.getName());

		for (Flag flag : this.getFlags()) {
			ingredient.addFlag(flag);
		}

		return ingredient;
	}
	
	@ManyToMany(mappedBy="ingredients")
	public List<Article> getArticles() { 
		return this.articles; }
	
	public void setArticles(List<Article> articles){
		this.articles = articles;
	}
}