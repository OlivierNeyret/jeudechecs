package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.*;

/**
 * Teste la classe Knight
 * @author jacobjul
 *
 */
public class KingTest extends TestCase
{
	/**
	 * cree un nouveau test
	 * @param name
	 */
	public KingTest(String name)
	{
		super(name);
	}
	
	/**
	 * test sur les deplacements d'un roi
	 */
	public void testDeplacement()
	{
		Board board = new Board();
		Position pInit=null;
		
		try
		{
			pInit = new Position(4,0);
		}
		catch (PositionOutOfBoardException e)
		{
			e.printStackTrace();
		}

		ArrayList<Position> test1 = board.getPieceAtPosition(pInit).deplacement(board, true);
		ArrayList<Position> result1 = new ArrayList<Position>(Arrays.asList());
		
	assertEquals(test1, result1);
	}
	
	public static Test suite() 
	{
		TestSuite suite= new TestSuite();
		suite.addTest(new KingTest("testDeplacement"));
		return suite;
	}
}