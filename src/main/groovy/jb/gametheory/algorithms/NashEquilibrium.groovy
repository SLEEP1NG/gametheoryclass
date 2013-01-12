package jb.gametheory.algorithms

class NashEquilibrium {


	def findNashEquilibriumCoordinates(Object[][] matrix) {
		def player1Choices = findPlayer1Choices(matrix)
		def player2Choices = findPlayer2Choices(matrix)

		player1Choices.intersect(player2Choices)
	}

	private findPlayer1Choices(Object[][] matrix) {
		def result = [] as Set
		for (i in 0..matrix[0].length-1) {
			Object[] temp = AlgorithmUtil.transformColumnCellsToArray(matrix, i)
			result << AlgorithmUtil.indexForStrictMaxInElementX(temp, 0) + "" + i
		}
		result
	}

	private findPlayer2Choices(Object[][] matrix) {
		def result = [] as Set
		matrix.eachWithIndex() { it, i -> result << i + "" + AlgorithmUtil.indexForStrictMaxInElementX(it, 1) }
		result
	}
}
