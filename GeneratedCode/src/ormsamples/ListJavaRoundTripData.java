/**
 * Licensee: Hamburg University of Applied Sciences
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListJavaRoundTripData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Article...");
		foodserver.Article[] foodServerArticles = foodserver.Article.listArticleByQuery(null, null);
		int length = Math.min(foodServerArticles.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(foodServerArticles[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Flag...");
		foodserver.Flag[] foodServerFlags = foodserver.Flag.listFlagByQuery(null, null);
		length = Math.min(foodServerFlags.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(foodServerFlags[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Ingredient...");
		foodserver.Ingredient[] foodServerIngredients = foodserver.Ingredient.listIngredientByQuery(null, null);
		length = Math.min(foodServerIngredients.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(foodServerIngredients[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Article by Criteria...");
		foodserver.ArticleCriteria lfoodServerArticleCriteria = new foodserver.ArticleCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lfoodServerArticleCriteria._id.eq();
		lfoodServerArticleCriteria.setMaxResults(ROW_COUNT);
		foodserver.Article[] foodServerArticles = lfoodServerArticleCriteria.listArticle();
		int length =foodServerArticles== null ? 0 : Math.min(foodServerArticles.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(foodServerArticles[i]);
		}
		System.out.println(length + " Article record(s) retrieved."); 
		
		System.out.println("Listing Flag by Criteria...");
		foodserver.FlagCriteria lfoodServerFlagCriteria = new foodserver.FlagCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lfoodServerFlagCriteria._id.eq();
		lfoodServerFlagCriteria.setMaxResults(ROW_COUNT);
		foodserver.Flag[] foodServerFlags = lfoodServerFlagCriteria.listFlag();
		length =foodServerFlags== null ? 0 : Math.min(foodServerFlags.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(foodServerFlags[i]);
		}
		System.out.println(length + " Flag record(s) retrieved."); 
		
		System.out.println("Listing Ingredient by Criteria...");
		foodserver.IngredientCriteria lfoodServerIngredientCriteria = new foodserver.IngredientCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lfoodServerIngredientCriteria._id.eq();
		lfoodServerIngredientCriteria.setMaxResults(ROW_COUNT);
		foodserver.Ingredient[] foodServerIngredients = lfoodServerIngredientCriteria.listIngredient();
		length =foodServerIngredients== null ? 0 : Math.min(foodServerIngredients.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(foodServerIngredients[i]);
		}
		System.out.println(length + " Ingredient record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListJavaRoundTripData listJavaRoundTripData = new ListJavaRoundTripData();
			try {
				listJavaRoundTripData.listTestData();
				//listJavaRoundTripData.listByCriteria();
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
