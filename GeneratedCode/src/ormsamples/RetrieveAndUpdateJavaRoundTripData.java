/**
 * Licensee: Hamburg University of Applied Sciences
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateJavaRoundTripData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = foodserver.JavaRoundTripPersistentManager.instance().getSession().beginTransaction();
		try {
			foodserver.Article lfoodServerArticle = foodserver.Article.loadArticleByQuery(null, null);
			// Update the properties of the persistent object
			lfoodServerArticle.save();
			foodserver.Flag lfoodServerFlag = foodserver.Flag.loadFlagByQuery(null, null);
			// Update the properties of the persistent object
			lfoodServerFlag.save();
			foodserver.Ingredient lfoodServerIngredient = foodserver.Ingredient.loadIngredientByQuery(null, null);
			// Update the properties of the persistent object
			lfoodServerIngredient.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Article by ArticleCriteria");
		foodserver.ArticleCriteria lfoodServerArticleCriteria = new foodserver.ArticleCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lfoodServerArticleCriteria._id.eq();
		System.out.println(lfoodServerArticleCriteria.uniqueArticle());
		
		System.out.println("Retrieving Flag by FlagCriteria");
		foodserver.FlagCriteria lfoodServerFlagCriteria = new foodserver.FlagCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lfoodServerFlagCriteria._id.eq();
		System.out.println(lfoodServerFlagCriteria.uniqueFlag());
		
		System.out.println("Retrieving Ingredient by IngredientCriteria");
		foodserver.IngredientCriteria lfoodServerIngredientCriteria = new foodserver.IngredientCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lfoodServerIngredientCriteria._id.eq();
		System.out.println(lfoodServerIngredientCriteria.uniqueIngredient());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateJavaRoundTripData retrieveAndUpdateJavaRoundTripData = new RetrieveAndUpdateJavaRoundTripData();
			try {
				retrieveAndUpdateJavaRoundTripData.retrieveAndUpdateTestData();
				//retrieveAndUpdateJavaRoundTripData.retrieveByCriteria();
			}
			finally {
				foodserver.JavaRoundTripPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
