package foodServer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


//TODO MappedByMethod for Article
/**
 * Ingredients consist of names and {@link IFlag}s
 * 
 * @author Christian Gläser
 * @author Felipe Oehrwald
 * 
 */
@Entity(name="INGREDIENT")
public class Ingredient implements IIngredient {
	private int id;
	private String name;
	private List<Flag> flags;
	private List<Article> articles;

	public Ingredient() {
		flags = new ArrayList<Flag>();
	}
	


	@Id
	@Column(name = "ID", nullable = false)
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

	public void addFlag(Flag flag) {
		flags.add(flag);
	}

	public void removeFlag(Flag flag) {
		flags.remove(flag);
	}

	@ManyToMany
	@JoinTable(name="INGREDIENT_FLAGS",
	joinColumns=@JoinColumn(name="FK_IngredientID",referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="FK_FlagID",referencedColumnName="ID"))
	public List<Flag> getFlags() {
		// returns a new list to prevent modification of list of flags within
		// ingredients. The flags itself should be modifiable
		// therefore this level of deep-copying is sufficient
		System.out.println("Copying " + flags.size() + " flags");
		List<Flag> tempFlags = new ArrayList<Flag>();
		for (Flag flag : this.flags) {
			tempFlags.add(flag.copy());
		}
		return tempFlags;
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