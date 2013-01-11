package jb.gametheory.algorithms;

import static org.junit.Assert.*;

class WeaklyDominantTest extends GroovyTestCase {

	private strategy

	// ----------------------------------------------------------------
	void setUp() {
		strategy = new WeaklyDominant()
	}
	// ----------------------------------------------------------------

	void testWeaklyDominant() {
		Object[][] matrix =
				[
					[[2, 0], [1, 1]],
					[[1, 3], [1, 3]]
				]
		assertIntArrayEquals([0], strategy.findForPlayer1(matrix))
		assertIntArrayEquals([1], strategy.findForPlayer2(matrix))
	}

	// ----------------------------------------------------------------

	void testNoDominantStrategy() {
		Object[][] matrix =
				[
					[[1, 1], [1, 1]],
					[[1, 1], [1, 1]]
				]
		assertIntArrayEquals([], strategy.findForPlayer1(matrix))
		assertIntArrayEquals([], strategy.findForPlayer2(matrix))
	}

	//----------------------------------------------------------------

	def assertIntArrayEquals(expected, actual) {
		assertArrayEquals(expected as int[], actual as int[])
	}



}