package database.tests;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import database.FlagUtil;
import database.exceptions.NoFlagsExistException;
import foodServer.Flag;
import foodServer.exceptions.DatabaseConnectionException;

/**
 * @author Christian Gläser
 * Tests concerning flag persistence
 */
public class FlagPersistenceTests {
	
	@Test
	public void getAllFlags() throws DatabaseConnectionException, NoFlagsExistException{
		List<Flag> flags = FlagUtil.getAllFlags();
		for(Flag f:flags){
			System.out.println(f);
		}
	}
	
	@Test
	public void getFirstFlag() throws DatabaseConnectionException, NoFlagsExistException{
		Flag flag = FlagUtil.getFlag(1);
		assertTrue(flag !=null);
		System.out.println(flag);
		
	}

}
