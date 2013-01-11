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
		Object[][] matrix =
				[
					[[-1, -1], [-4, 0]],
					[[0, -4], [-3, 3]]
				]
		assertIntArrayEquals([1], strategy.findForPlayer1(matrix))
		assertIntArrayEquals([1], strategy.findForPlayer2(matrix))
	}

	// ----------------------------------------------------------------

	void testNoDominantStrategy() {
		Object[][] matrix =
				[
					[[1, 1], [1, 1]],
					[[1, 1], [0, 2]]
				]
		assertIntArrayEquals([], strategy.findForPlayer1(matrix))
		assertIntArrayEquals([], strategy.findForPlayer2(matrix))
	}

	//----------------------------------------------------------------

	def assertIntArrayEquals(expected, actual) {
		assertArrayEquals(expected as int[], actual as int[])
	}

	//----------------------------------------------------------------
	void testIndexForStrictMaxInElementX() {
		def input = [[-1, -1], [-4, 0]] as Object[]
		assert 0 == strategy.indexForStrictMaxInElementX(input, 0) : "first coordinate"
		assert 1 == strategy.indexForStrictMaxInElementX(input, 1) : "second coordinate"
	}

	void testIndexForStrictMaxInElementX_forStrictMax() {
		def input = [[-1, -1], [-1, 0]] as Object[]
		assert null == strategy.indexForStrictMaxInElementX(input, 0) : "first coordinate"
		assert 1 == strategy.indexForStrictMaxInElementX(input, 1) : "second coordinate"
	}
	//----------------------------------------------------------------
	void testTransformColumnCellsToArray() {
		Object[][] matrix =
				[[0, 1], [2, 3],]
		assertIntArrayEquals([0, 2], strategy.transformColumnCellsToArray(matrix, 0))
		assertIntArrayEquals([1, 3], strategy.transformColumnCellsToArray(matrix, 1))
	}


}