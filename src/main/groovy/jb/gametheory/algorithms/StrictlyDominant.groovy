package jb.gametheory.algorithms

/**
 * @author jeanne
 *
 */
class StrictlyDominant {

	/**
	 * For each possible column player 2 chooses, returns the index of the rows with the highest overall value
	 * @param matrix
	 * @return
	 */
	def findForPlayer1(Object[][] matrix) {
		def result = [] as Set
		for (i in 0..matrix.length-1) {
			Object[] temp = transformColumnCellsToArray(matrix, i)
			result << indexForMaxInElementX(temp, 0)
		}
		result
	}

	//TODO support more than 2x2 (remember max?)
	//TODO support no dominant strategy
	//TODO why doesn't closure each work?

	/**
	 * For each possible row player 1 chooses, returns the index of the cells with the highest overall value
	 * @param matrix
	 * @return
	 */
	def findForPlayer2(Object[][] matrix) {
		def result = [] as Set
		for (i in 0..matrix[0].length-1) {
			result << indexForMaxInElementX(matrix[i], 1)
		}
		result
	}

	/**
	 * Returns the element with the highest value.
	 * Assumes non empty array.
	 * @param row
	 * @param elementIndex
	 * @return
	 */
	def indexForMaxInElementX(Object[] row, int elementIndex) {
		int max = 0
		for (i in 1..row.length - 1) {
			if (row[i][elementIndex] > row[max][elementIndex]) {
				max = i
			}
		}
		max
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
		for(i in 0..matrix.length-1) {
			result << matrix[i][column]
		}
		result
	}


}
