package jb.gametheory.algorithms;

import static org.junit.Assert.*

class MaxMinTest extends GroovyTestCase {

	private strategy

	// ----------------------------------------------------------------
	void setUp() {
		strategy = new MaxMin()
	}
	// ----------------------------------------------------------------

	void testSample() {
		Object[][] matrix =
				[
					[[3, 0], [1, 2]],
					[[2, 1], [0, 3]]
				]
		assertEquals(0, strategy.bestForPlayer1(matrix))
		assertEquals(1, strategy.bestForPlayer2(matrix))
	}

}
