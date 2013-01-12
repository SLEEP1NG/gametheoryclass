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
					[[0, -4], [-3, -3]]
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

	// ----------------------------------------------------------------

	void testThreeByThree() {
		Object[][] matrix =
				[
					[[1, 1], [1, 1], [1, 9]],
					[[5, 1], [6, 2], [7, 6]],
					[[1, 1], [0, 2], [0, 5]]
				]
		assertIntArrayEquals([1], strategy.findForPlayer1(matrix))
		assertIntArrayEquals([2], strategy.findForPlayer2(matrix))
	}

	//----------------------------------------------------------------

	def assertIntArrayEquals(expected, actual) {
		assertArrayEquals(expected as int[], actual as int[])
	}




}