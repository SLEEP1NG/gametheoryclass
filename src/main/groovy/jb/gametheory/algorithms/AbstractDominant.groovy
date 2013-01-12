package jb.gametheory.algorithms

abstract class AbstractDominant {

	/**
	 * For each possible column player 2 chooses, returns the index of the rows with the highest overall value
	 * @param matrix
	 * @return
	 */
	def findForPlayer1(Object[][] matrix) {
		def result = [] as Set
		for (i in 0..matrix[0].length-1) {
			Object[] temp = AlgorithmUtil.transformColumnCellsToArray(matrix, i)
			result << AlgorithmUtil.indexForStrictMaxInElementX(temp, 0)
		}
		onlyAllowOneDominantStrategy(result)
	}


	/**
	 * For each possible row player 1 chooses, returns the index of the cells with the highest overall value
	 * @param matrix
	 * @return
	 */
	def findForPlayer2(Object[][] matrix) {
		def result = [] as Set
		matrix.each() { result << AlgorithmUtil.indexForStrictMaxInElementX(it, 1) }
		onlyAllowOneDominantStrategy(result)
	}
}
