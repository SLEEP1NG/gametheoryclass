package jb.gametheory.algorithms;

import static org.junit.Assert.*;

class StrictlyDominantTest extends GroovyTestCase {

	private strategy

	// ----------------------------------------------------------------
	void setUp() {
		strategy = new StrictlyDominant()
	}
	// ----------------------------------------------------------------

	void testPrisonersDilema() {
		/**
		 * 1 2
		 * 3 4 
		 */
		Object[][] matrix =
				[
					[[-1, -1], [-4, 0]],
					[[0, -4], [-3, 3]]
				]
		assertIntArrayEquals([1], strategy.findForPlayer1(matrix))
		assertIntArrayEquals([1], strategy.findForPlayer2(matrix))
	}

	def assertIntArrayEquals(expected, actual) {
		assertArrayEquals(expected as int[], actual as int[])
	}

	//----------------------------------------------------------------
	void testIndexForMaxInElementX() {
		def input = [[-1, -1], [-4, 0]] as Object[]
		assert 0 == strategy.indexForMaxInElementX(input, 0) : "first coordinate"
		assert 1 == strategy.indexForMaxInElementX(input, 1) : "second coordinate"
	}
	//----------------------------------------------------------------
	void testTransformColumnCellsToArray() {
		Object[][] matrix =
				[[0, 1], [2, 3],]
		assertIntArrayEquals([0, 2], strategy.transformColumnCellsToArray(matrix, 0))
		assertIntArrayEquals([1, 3], strategy.transformColumnCellsToArray(matrix, 1))
	}

	void testJeanne() {
		Object[][] matrix =
				[[0, 1], [2, 3]]
		matrix.each() { println " ${it}" };
		matrix.each() { println ( it) };
	}
}