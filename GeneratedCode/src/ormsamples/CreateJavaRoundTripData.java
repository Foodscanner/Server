/**
 * Licensee: Hamburg University of Applied Sciences
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateJavaRoundTripData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = foodserver.JavaRoundTripPersistentManager.instance().getSession().beginTransaction();
		try {
			foodserver.Article lfoodServerArticle = foodserver.Article.createArticle();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _unnamed_ArticleUtil_, _flags, _ingredients, _unnamed_Ingredient_, _unnamed_Flag_
			lfoodServerArticle.save();
			foodserver.Flag lfoodServerFlag = foodserver.Flag.createFlag();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _limitToProduct, _unnamed_Article_, _unnamed_Ingredient_
			lfoodServerFlag.save();
			foodserver.Ingredient lfoodServerIngredient = foodserver.Ingredient.createIngredient();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : _flags
			lfoodServerIngredient.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateJavaRoundTripData createJavaRoundTripData = new CreateJavaRoundTripData();
			try {
				createJavaRoundTripData.createTestData();
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
