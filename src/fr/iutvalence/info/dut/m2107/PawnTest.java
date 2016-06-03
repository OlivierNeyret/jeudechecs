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
	/**
	 * cree un nouveau test
	 * @param name
	 */
	public PawnTest(String name)
	{
		super(name);
	}
	
	/**
	 * test sur les deplacements d'un pion en position de départ 
	 */
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
	
	/**
	 * test sur les deplacements d'un pion != position de depart
	 */
	public void testDeplacement2()
	{
		Board board = new Board();
		Position pInit=null,p1=null;
		try
		{
			board.move(board.getPieceAtPosition(new Position(1,6)),new Position(1,5));
		}
		catch (PositionOutOfBoardException e1)
		{
			e1.printStackTrace();
		}
		
		try
		{
			pInit = new Position(1,5);
			p1 = new Position(1,4);
		}
		catch (PositionOutOfBoardException e)
		{
			e.printStackTrace();
		}

		ArrayList<Position> test1 = board.getPieceAtPosition(pInit).deplacement(board, true);
		ArrayList<Position> result1 = new ArrayList<Position>(Arrays.asList(p1));
		
	assertEquals(test1, result1);
	}
	
	/**
	 * test sur les deplacements d'un pion != position de depart
	 */
	public void testDeplacement3()
	{
		Board board = new Board();
		Position pInit=null,p1=null, p2=null;
		try
		{
			board.move(board.getPieceAtPosition(new Position(1,6)),new Position(1,4));
			board.move(board.getPieceAtPosition(new Position(2,1)),new Position(2,3));
		}
		catch (PositionOutOfBoardException e1)
		{
			e1.printStackTrace();
		}
		
		try
		{
			pInit = new Position(1,4);
			p1 = new Position(2,3);
			p2 = new Position(1,3);
		}
		catch (PositionOutOfBoardException e)
		{
			e.printStackTrace();
		}

		ArrayList<Position> test1 = board.getPieceAtPosition(pInit).deplacement(board, true);
		ArrayList<Position> result1 = new ArrayList<Position>(Arrays.asList(p1,p2));
		
	assertEquals(test1, result1);
	}
	
	public static Test suite() 
	{
		TestSuite suite= new TestSuite();
		suite.addTest(new PawnTest("testDeplacement"));
		suite.addTest(new PawnTest("testDeplacement2"));
		suite.addTest(new PawnTest("testDeplacement3"));
		return suite;
	}
}
