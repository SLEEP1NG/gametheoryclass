package jb.gametheory.algorithms;

import static org.junit.Assert.*;

class IteratedRemovalOfStrictlyDominatedTest extends GroovyTestCase {

	private strategy

	// ----------------------------------------------------------------
	void setUp() {
		strategy = new IteratedRemovalOfStrictlyDominated()
	}
	// ----------------------------------------------------------------

	void testUniqueNashEquilibrium() {
		Object[][] matrix =
				[  
					[[3, 0], [2, 1], [0, 0]],
					[[1, 1], [1, 1], [5, 0]],
					[[0, 1], [4, 2], [0, 1]]
				]
		Object[] actual = strategy.findPossibilitiesForNash(matrix)
		assertEquals("# rows", 1, actual.length)
		assertEquals("# cells", 1, actual[0].length)
		assertIntArrayEquals([4, 2], actual[0][0])
	}
	
	void testNashEquilibrium_whereCanOnlyRemoveOneColumn() {
		Object[][] matrix =
				[
					[[3, 1], [0, 1], [0, 0]],
					[[1, 1], [1, 1], [5, 0]],
					[[0, 1], [4, 1], [0, 0]]
				]
		Object[] actual = strategy.findPossibilitiesForNash(matrix)
		assertEquals("# rows", 3, actual.length)
		assertEquals("# cells", 2, actual[0].length)
	}
	
	void testUniqueNashEquilibrium2() {
		Object[][] matrix =
				[
					[[2, 1], [5, 3], [3, 1]],
					[[6, 7], [2, 10], [0, 0]],
					[[5, 0], [1, 1], [2, 4]]
				]
		Object[] actual = strategy.findPossibilitiesForNash(matrix)
		assertEquals("# rows", 1, actual.length)
		assertEquals("# cells", 1, actual[0].length)
		assertIntArrayEquals([5, 3], actual[0][0])
	}
	
	//----------------------------------------------------------------
	
		def assertIntArrayEquals(expected, actual) {
			assertArrayEquals(expected as int[], actual as int[])
		}
	

}