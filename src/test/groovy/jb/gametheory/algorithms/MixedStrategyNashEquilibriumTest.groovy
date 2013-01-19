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
		Object[] bothPlayersStrategy = [0.5, 0.5]
		Object[] expected = [bothPlayersStrategy, bothPlayersStrategy]
		Object[] actual = strategy.find2x2MixedStrategyNashEquilibrium(matrix)
		assertArrayEquals(expected, actual)
		assertTrue strategy.checkMixedStrategyNashEquilibrium(matrix, bothPlayersStrategy, bothPlayersStrategy)
	}

	// ----------------------------------------------------------------

	void testMatching() {
		Object[][] matrix =
				[
					[[1, 1], [0, 0]],
					[[0, 0], [1, 1]]
				]
		Object[] bothPlayersStrategy = [0.5, 0.5]
		Object[] expected = [bothPlayersStrategy, bothPlayersStrategy]
		Object[] actual = strategy.find2x2MixedStrategyNashEquilibrium(matrix)
		assertArrayEquals(expected, actual)
		assertTrue strategy.checkMixedStrategyNashEquilibrium(matrix, bothPlayersStrategy, bothPlayersStrategy)
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
		Object[] player1Strategy = [1/3, 2/3]
		Object[] player2Strategy = [2/3, 1/3]
		Object[] expected = [player1Strategy, player2Strategy]
		Object[] actual = strategy.find2x2MixedStrategyNashEquilibrium(matrix)
		assertArrayEquals(expected, actual)
		assertTrue strategy.checkMixedStrategyNashEquilibrium(matrix, player1Strategy, player2Strategy)
		assertFalse strategy.checkMixedStrategyNashEquilibrium(matrix, player2Strategy, player1Strategy)
	}

	// ----------------------------------------------------------------

	void testSoccer() {
		Object[][] matrix =
				[
					[[0, 1], [1, 0]],
					[[1, 0], [0, 1]]
				]
		Object[] bothPlayersStrategy = [0.5, 0.5]
		Object[] expected = [bothPlayersStrategy, bothPlayersStrategy]
		Object[] actual = strategy.find2x2MixedStrategyNashEquilibrium(matrix)
		assertArrayEquals(expected, actual)
		assertTrue strategy.checkMixedStrategyNashEquilibrium(matrix, bothPlayersStrategy, bothPlayersStrategy)
	}

	void testSoccer_weighted() {
		Object[][] matrix =
				[
					[[0, 1], [1, 0]],
					[[0.75, 0.25], [0, 1]]
				]
		Object[] player1Strategy = [0.5714285714, 0.4285714286]
		Object[] player2Strategy = [0.4285714286, 0.5714285714]
		Object[] expected = [player1Strategy, player2Strategy]
		Object[] actual = strategy.find2x2MixedStrategyNashEquilibrium(matrix)
		assertArrayEquals(expected, actual)
		assertTrue strategy.checkMixedStrategyNashEquilibrium(matrix, player1Strategy, player2Strategy)
		assertFalse strategy.checkMixedStrategyNashEquilibrium(matrix, player2Strategy, player1Strategy)
	}
	
	void testCheckerForWrongSums() {
		Object[] good = [0.5, 0.5]
		Object[] bad = [0.3, 0.5]
		assertFalse "player1", strategy.checkMixedStrategyNashEquilibrium(null, bad, good)
		assertFalse "player 2", strategy.checkMixedStrategyNashEquilibrium(null, good, bad)
	}
	
	void testCheckerForWrongSolution() {
		Object[][] matrix =
				[
					[[0, 1], [1, 0]],
					[[1, 0], [0, 1]]
				]
		Object[] bothPlayersStrategy = [0.7, 0.3]
		assertFalse strategy.checkMixedStrategyNashEquilibrium(matrix, bothPlayersStrategy, bothPlayersStrategy)
	}
	
	void test_rockPaperSissors() {
		Object[][] matrix =
		[	/* xy yz xz */
	/*x*/		[[0, 0], [-1,1], [1, -1]],
	/*y*/		[[1, -1], [0, 0], [-1, 1]],
	/*z*/		[[-1, 1], [1, -1], [0, 0]]
		]
		Object[] player1Strategy = [1/3, 1/3, 1/3]
		Object[] player2Strategy = [1/3, 1/3, 1/3]
		assertTrue strategy.checkMixedStrategyNashEquilibrium(matrix, player1Strategy, player2Strategy)
	}

}
