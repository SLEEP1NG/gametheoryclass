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
		if (duplicateOnMax)
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
