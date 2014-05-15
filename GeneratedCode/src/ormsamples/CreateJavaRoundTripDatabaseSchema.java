/**
 * Licensee: Hamburg University of Applied Sciences
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateJavaRoundTripDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(foodserver.JavaRoundTripPersistentManager.instance());
			foodserver.JavaRoundTripPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
