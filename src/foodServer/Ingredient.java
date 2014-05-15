package foodServer;

import java.util.ArrayList;
import java.util.List;

/**
 * Ingredients consist of names and {@link IFlag}s
 * @author Christian Gläser
 *
 */
public class Ingredient implements IIngredient {
	private int id;
	private String name;
	private List<IFlag> flags;
	
	
	public Ingredient(){
	flags = new ArrayList<IFlag>();  
	}
	
	
	public int getId() {
		return this.id;
	}

	public void setId(int aId) {
		this.id = aId;
	}


	public String getName() {
	    return this.name;
	}

	public void setName(String aName) {
		this.name = aName;
	}

	  public void addFlag(IFlag flag) {
	    flags.add(flag);
	  }
	  
	  public void removeFlag(IFlag flag) {
	    flags.remove(flag);
	  }

	  public List<IFlag> getFlags() {
	    //returns a new list to prevent modification of list of flags within ingredients. The flags itself should be modifiable
	    //therefore this level of deep-copying is sufficient
	    System.out.println("Copying " +  flags.size() + " flags");
	    List<IFlag> tempFlags = new ArrayList<IFlag>();
	    for(IFlag flag:this.flags){
	      tempFlags.add(flag.copy());
	    }
	    return tempFlags;
	  }
	  
	  
	  /**
	   * Copies an ingredient with all properties except id, which is left unfilled
	   * @see foodServer.IIngredient#copy()
	   */
	  public Ingredient copy() {
	    Ingredient ingredient = new Ingredient();
	    ingredient.setName(this.getName());
	    
	    for(IFlag flag: this.getFlags()){
	      ingredient.addFlag(flag);
	    }
	    
        return ingredient;
	     
	  }
	  
	  
    public void persist() {
      //if id is null = new article
      //else update
      // TODO Auto-generated method stub
    }



  


  






}