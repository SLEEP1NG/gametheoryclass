package jb.gametheory.algorithms;

import org.junit.*;

class NashEquilibriumTest extends GroovyTestCase {

	private strategy

	// ----------------------------------------------------------------
	void setUp() {
		strategy = new NashEquilibrium()
	}
	// ----------------------------------------------------------------

	void testPrisonersDilema() {
		Object[][] matrix =
				[
					[[-1, -1], [-4, 0]],
					[[0, -4], [-3, 3]]
				]
		Object[] expected = ["11"]
		Object[] actual = strategy.findNashEquilibrium(matrix)
		assertArrayEquals(expected, actual)
	}
}
