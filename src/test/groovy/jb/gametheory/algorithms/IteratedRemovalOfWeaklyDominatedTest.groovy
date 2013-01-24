package jb.gametheory.algorithms;

import static org.junit.Assert.*;

class IteratedRemovalOfWeaklyDominatedTest extends GroovyTestCase {

	private strategy

	// ----------------------------------------------------------------
	void setUp() {
		strategy = new IteratedRemovalOfDominated()
	}
	// ----------------------------------------------------------------

	void testUniqueNashEquilibrium() {
		Object[][] matrix =
				[
					[[3, 0], [2, 1], [0, 0]],
					[[1, 1], [1, 1], [5, 0]],
					[[0, 1], [4, 2], [0, 1]]
				]
		Object[] actual = strategy.findPossibilitiesForNashForWeaklyDominated(matrix)
		assertEquals("# rows", 1, actual.length)
		assertEquals("# cells", 1, actual[0].length)
		assertIntArrayEquals([4, 2], actual[0][0])
	}

	//----------------------------------------------------------------

	def assertIntArrayEquals(expected, actual) {
		assertArrayEquals(expected as int[], actual as int[])
	}


}