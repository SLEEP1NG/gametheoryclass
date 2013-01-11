package jb.gametheory.algorithms

/**
 * @author jeanne
 *
 */
class WeaklyDominant {

	/**
	 * For each possible column player 2 chooses, returns the index of the rows with the highest overall value
	 * @param matrix
	 * @return
	 */
	def findForPlayer1(Object[][] matrix) {
		def result = [] as Set
		for (i in 0..matrix[0].length-1) {
			Object[] temp = transformColumnCellsToArray(matrix, i)
			result << indexForWeakMaxInElementX(temp, 0)
		}
		onlyAllowOneDominantStrategy(result)
	}

	/**
	 * if not exactly one dominant strategy, means there isn't one
	 * @param result
	 * @return
	 */
	private Collection onlyAllowOneDominantStrategy(Collection result) {
		result.remove(null)
		if (result.size() > 1) {
			result = []
		}
		return result
	}

	/**
	 * For each possible row player 1 chooses, returns the index of the cells with the highest overall value
	 * @param matrix
	 * @return
	 */
	def findForPlayer2(Object[][] matrix) {
		def result = [] as Set
		matrix.each() { result << indexForWeakMaxInElementX(it, 1) }
		onlyAllowOneDominantStrategy(result)
	}

	/**
	 * Returns the element with the highest value.  If multiple elements share that highest value, still return it
	 * Assumes non empty array.
	 * @param row
	 * @param elementIndex
	 * @return
	 */
	def indexForWeakMaxInElementX(Object[] row, int elementIndex) {
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

	/**
	 * 
	 * Transforms a column to be a row
	 * @param matrix
	 * @param column
	 * @return
	 */
	def transformColumnCellsToArray(Object[][] matrix, int column) {
		def result = []
		matrix.each() { result << it[column] };
		result
	}
}
