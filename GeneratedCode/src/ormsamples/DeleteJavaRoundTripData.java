/**
 * Licensee: Hamburg University of Applied Sciences
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteJavaRoundTripData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = foodserver.JavaRoundTripPersistentManager.instance().getSession().beginTransaction();
		try {
			foodserver.Article lfoodServerArticle = foodserver.Article.loadArticleByQuery(null, null);
			lfoodServerArticle.delete();
			foodserver.Flag lfoodServerFlag = foodserver.Flag.loadFlagByQuery(null, null);
			lfoodServerFlag.delete();
			foodserver.Ingredient lfoodServerIngredient = foodserver.Ingredient.loadIngredientByQuery(null, null);
			lfoodServerIngredient.delete();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteJavaRoundTripData deleteJavaRoundTripData = new DeleteJavaRoundTripData();
			try {
				deleteJavaRoundTripData.deleteTestData();
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
