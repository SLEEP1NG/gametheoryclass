package jb.gametheory.algorithms;

import org.junit.*;

class MixedStrategyNashEquilibriumTest extends GroovyTestCase {

	private strategy

	// ----------------------------------------------------------------
	void setUp() {
		strategy = new MixedStrategyNashEquilibrium()
	}

	// ----------------------------------------------------------------

	void testZeroSum() {
		Object[][] matrix =
				[
					[[1, -1], [-1, 1]],
					[[-1, 1], [1, -1]]
				]
		Object[] expected = [[0.5, 0.5], [0.5, 0.5]]
		Object[] actual = strategy.find2x2MixedStrategyNashEquilibrium(matrix)
		assertArrayEquals(expected, actual)
	}
	
	// ----------------------------------------------------------------
	
	void testMatching() {
		Object[][] matrix =
				[
					[[1, 1], [0, 0]],
					[[0, 0], [1, 1]]
				]
		Object[] expected = [[0.5, 0.5], [0.5, 0.5]]
		Object[] actual = strategy.find2x2MixedStrategyNashEquilibrium(matrix)
		assertArrayEquals(expected, actual)
	}
	
	// ----------------------------------------------------------------
	
	void testPrisonersDilema() {
		Object[][] matrix =
				[
					[[-1, -1], [-4, 0]],
					[[0, -4], [-3, -3]]
				]
		Object[] expected = []
		Object[] actual = strategy.find2x2MixedStrategyNashEquilibrium(matrix)
		assertArrayEquals(expected, actual)
	}
	
	// ----------------------------------------------------------------
	
	void testBattleSexes() {
		Object[][] matrix =
				[
					[[2, 1], [0, 0]],
					[[0, 0], [1, 2]]
				]
		Object[] expected = [[1/3, 2/3], [2/3, 1/3]]
		Object[] actual = strategy.find2x2MixedStrategyNashEquilibrium(matrix)
		assertArrayEquals(expected, actual)
	}
}
