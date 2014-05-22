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
  
  public List<IFlag> getFlags();
  
  void removeFlag(IFlag flag);

  public void addFlag(IFlag flag);

  public void setId(int aID);
  
  public void setName(String aName);
  
  public IIngredient copy();

}