package jb.gametheory.algorithms

/**
 * Two player game.  Player 1 wants to maximize payoff given constraint that player 2 wants to minimize player 1's payoff.  And vice versa.
 * (What's the worst I can do given the best case scenario chosen by my opponent.)
 * @author nyjeanne
 *
 */
class MinMax {

	class Player1MaxMin extends AbstractMaxMin {
		int player2Chooses(Object[][] matrix) {
			firstPlayerToChoose(matrix, 0)
		}

		int bestForPlayer1(Object[][] matrix, int player2) {
			Object[] column = AlgorithmUtil.transformColumnCellsToArray(matrix, player2)
			minIndex(column, 0)
		}
		
		Object[] getRowOrColumn(Object[][] matrix, int index) {
			AlgorithmUtil.transformColumnCellsToArray(matrix, index)
		}
	}

	// --------------------------------------------

	class Player2MaxMin extends AbstractMaxMin {
		int player1Chooses(Object[][] matrix) {
			firstPlayerToChoose(matrix, 1)
		}

		int bestForPlayer2(Object[][] matrix, int player1) {
			minIndex(matrix[player1], 1)
		}
		
		Object[] getRowOrColumn(Object[][] matrix, int index) {
			matrix[index]
		}
	}

	// --------------------------------------------

	abstract class AbstractMaxMin {
		abstract getRowOrColumn(Object[][] matrix, int index);
		
		int minIndex(Object[] row, int playerNum) {
			int result = 0
			for (i in 1..row.length-1) {
				if (row[result][playerNum] > row[i][playerNum]) {
					result = i
				}
			}
			result
		}

		int firstPlayerToChoose(Object[][] matrix, int playerNumber) {
			int maxRowOrColumn = 0;
			Object[] row = getRowOrColumn(matrix, 0)
			int maxValue = row[minIndex(row, playerNumber)][playerNumber]
			for (i in 1..matrix.length-1) {
				row = getRowOrColumn(matrix, i)
				int tempIndex = minIndex(row, playerNumber)
				if (row[tempIndex][playerNumber] > maxValue) {
					maxValue = row[tempIndex][playerNumber]
					maxRowOrColumn = i
				}
			}
			maxRowOrColumn
		}

	}

	// --------------------------------------------

	int bestForPlayer1(Object[][] matrix) {
		def helper = new Player1MaxMin()
		int player2 = helper.player2Chooses(matrix)
		helper.bestForPlayer1(matrix, player2)
	}

	int bestForPlayer2(Object[][] matrix) {
		def helper = new Player2MaxMin()
		int player1 = helper.player1Chooses(matrix)
		helper.bestForPlayer2(matrix, player1)
	}



}

