package foodServer;

import java.util.List;

/**
 * An interface for Ingredients
 * @author Christian Gläser
 *
 */
public interface IIngredient<I,F> {
  
  public int getId();

  public String getName();
  
  public List<F> getFlags();
  
  void removeFlag(F flag);

  public void addFlag(F flag);

  public void setId(int aID);
  
  public I copy();

}