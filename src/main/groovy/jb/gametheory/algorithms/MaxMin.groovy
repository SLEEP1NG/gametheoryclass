package jb.gametheory.algorithms

/**
 * Two player game.  Player 1 wants to minimize payoff given constraint that player 2 wants to maximize player 1's payoff.  And vice versa.
 * (What's the best I can do given the worst case scenario chosen by my opponent.)
 * @author nyjeanne
 *
 */
class MaxMin {

	int maxIndex(Object[] row, int playerNum) {
		int result = 0
		for (i in 1..row.length-1) {
			if (row[result][playerNum] < row[i][playerNum]) {
				result = i
			}
		}
		result
	}

	int firstPlayerToChoose(Object[][] matrix, int playerNumber) {
		int minRowOrColumn = 0;
		Object[] row = rowOrColumn(matrix, 0)
		int minValue = row[maxIndex(row, playerNumber)][playerNumber]
		for (i in 1..matrix.length-1) {
			row = rowOrColumn(matrix, i)
			int tempIndex = maxIndex(row, playerNumber)
			if (row[tempIndex][playerNumber] < minValue) {
				minValue = row[tempIndex][playerNumber]
				minRowOrColumn = i
			}
		}
		minRowOrColumn
	}

	def rowOrColumn;

	// --------------------------------------------

	int bestForPlayer1(Object[][] matrix) {
		rowOrColumn = {m, i -> AlgorithmUtil.transformColumnCellsToArray(m, i)}
		int player2 = firstPlayerToChoose(matrix, 0)
		Object[] column = AlgorithmUtil.transformColumnCellsToArray(matrix, player2)
		maxIndex(column, 0)
	}

	int bestForPlayer2(Object[][] matrix) {
		rowOrColumn = {m, i -> m[i]}
		int player1 = firstPlayerToChoose(matrix, 1)
		maxIndex(matrix[player1], 1)
	}



}

