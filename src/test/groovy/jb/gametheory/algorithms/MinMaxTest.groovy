package jb.gametheory.algorithms;

import static org.junit.Assert.*

class MinMaxTest extends GroovyTestCase {

	private strategy

	// ----------------------------------------------------------------
	void setUp() {
		strategy = new MinMax()
	}
	// ----------------------------------------------------------------

	void testSample() {
		Object[][] matrix =
				[
					[[3, 0], [1, 2]],
					[[2, 1], [0, 3]]
				]
		assertEquals(1, strategy.bestForPlayer1(matrix))
		assertEquals(0, strategy.bestForPlayer2(matrix))
	}

}
