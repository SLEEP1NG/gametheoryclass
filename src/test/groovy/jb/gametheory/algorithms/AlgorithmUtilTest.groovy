package jb.gametheory.algorithms;

import static org.junit.Assert.*;

class AlgorithmUtilTest extends GroovyTestCase {

	void testIndexForStrictMaxInElementX() {
		def input = [[-1, -1], [-4, 0]] as Object[]
		assert 0 == AlgorithmUtil.indexForStrictMaxInElementX(input, 0) : "first coordinate"
		assert 1 == AlgorithmUtil.indexForStrictMaxInElementX(input, 1) : "second coordinate"
	}

	void testIndexForStrictMaxInElementX_forStrictMax() {
		def input = [[-1, -1], [-1, 0]] as Object[]
		assert null == AlgorithmUtil.indexForStrictMaxInElementX(input, 0) : "first coordinate"
		assert 1 == AlgorithmUtil.indexForStrictMaxInElementX(input, 1) : "second coordinate"
	}
	//----------------------------------------------------------------
	void testTransformColumnCellsToArray() {
		Object[][] matrix =
				[[0, 1], [2, 3],]
		assertIntArrayEquals([0, 2], AlgorithmUtil.transformColumnCellsToArray(matrix, 0))
		assertIntArrayEquals([1, 3], AlgorithmUtil.transformColumnCellsToArray(matrix, 1))
	}
	def assertIntArrayEquals(expected, actual) {
		assertArrayEquals(expected as int[], actual as int[])
	}
}