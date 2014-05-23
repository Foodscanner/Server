package foodServer;

import java.util.List;

/**
 * An interface for Ingredients
 * @author Christian Gläser
 *
 */
public interface IIngredient {
  
  public int getId();

  public String getName();
  
  public List<Flag> getFlags();
  
  void removeFlag(Flag flag);

  public void addFlag(Flag flag);

  public void setId(int aID);
  
  public void setName(String aName);
  
  public Ingredient copy();

}