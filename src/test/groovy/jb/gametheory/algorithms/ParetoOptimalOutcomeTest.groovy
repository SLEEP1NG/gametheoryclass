package jb.gametheory.algorithms;

import org.junit.*;

class ParetoOptimalOutcomeTest extends GroovyTestCase {

	private strategy

	// ----------------------------------------------------------------
	void setUp() {
		strategy = new ParetoOptimalOutcome()
	}
	// ----------------------------------------------------------------

	void testPrisonersDilema() {
		Object[][] matrix =
				[
					[[-1, -1], [-4, 0]],
					[[0, -4], [-3, -3]]
				]
		Object[] expected = ["00", "01", "10"]
		Object[] actual = strategy.findParetoCoordinates(matrix)
		assertArrayEquals(expected, actual)
	}

	// ----------------------------------------------------------------

	void testCoinToss() {
		Object[][] matrix =
				[
					[[1, 1], [0, 0]],
					[[0, 0], [1, 1]]
				]
		Object[] expected = ["00", "11"]
		Object[] actual = strategy.findParetoCoordinates(matrix)
		assertArrayEquals(expected, actual)
	}

	// ----------------------------------------------------------------

	void testZeroSum() {
		Object[][] matrix =
				[
					[[1, -1], [-1, 1]],
					[[-1, 1], [1, -1]]
				]
		Object[] expected = ["00", "01", "10", "11"]
		Object[] actual = strategy.findParetoCoordinates(matrix)
		assertArrayEquals(expected, actual)
	}
}
