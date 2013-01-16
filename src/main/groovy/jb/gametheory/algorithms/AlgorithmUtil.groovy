package jb.gametheory.algorithms

class AlgorithmUtil {
	/**
	 * Returns the element with the UNIQUE highest value.  If multiple elements share that highest value, return null;
	 * Assumes non empty array.
	 * @param row
	 * @param elementIndex
	 * @return
	 */
	static def indexForStrictMaxInElementX(Object[] row, int elementIndex) {
		helper_indexForMaxInElementX(row, elementIndex, false)
	}
	
	/**
	 * Returns the element with the highest value.  If multiple elements share that highest value, return it;
	 * Assumes non empty array.
	 * @param row
	 * @param elementIndex
	 * @return
	 */
	static def indexForMaxInElementX(Object[] row, int elementIndex) {
		helper_indexForMaxInElementX(row, elementIndex, true)
	}
	
	private static def helper_indexForMaxInElementX(Object[] row, int elementIndex, boolean allowDuplicatesOnMax) {
		int maxIndex = 0
		boolean duplicateOnMax = false
		for (i in 1..row.length - 1) {
			if (row[i][elementIndex] == row[maxIndex][elementIndex]) {
				duplicateOnMax = true
			} else if (row[i][elementIndex] > row[maxIndex][elementIndex]) {
				maxIndex = i
				duplicateOnMax = false
			}
		}
		if (! allowDuplicatesOnMax && duplicateOnMax)
			null
		else
			maxIndex
	}

	// -----------------------------------------------------------

	/**
	 *
	 * Transforms a column to be a row
	 * @param matrix
	 * @param column
	 * @return
	 */
	static def transformColumnCellsToArray(Object[][] matrix, int column) {
		def result = []
		matrix.each() { result << it[column] };
		result
	}


}
