package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.*;

/**
 * Teste la classe Pawn
 * @author neyreto
 *
 */
public class PawnTest extends TestCase
{
	public PawnTest(String name)
	{
		super(name);
	}
	
	public void testDeplacement()
	{
		Board board = new Board();
		Position pInit=null,p1=null,p2=null;
		
		try
		{
			pInit = new Position(1,6);
			p1 = new Position(1,5);
			p2 = new Position(1,4);
		}
		catch (PositionOutOfBoardException e)
		{
			e.printStackTrace();
		}

		ArrayList<Position> test1 = board.getPieceAtPosition(pInit).deplacement(board, true);
		ArrayList<Position> result1 = new ArrayList<Position>(Arrays.asList(p1, p2));
		
		assertEquals(test1, result1);
	}
	
	public static Test suite() 
	{
		TestSuite suite= new TestSuite();
		suite.addTest(new PawnTest("testDeplacement"));
		return suite;
	}
}
