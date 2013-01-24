package jb.gametheory.algorithms

class MaxMin {

	int bestForPlayer1(Object[][] matrix) {
		int player2 = player2Chooses(matrix)
		bestForPlayer1(matrix, player2)
	}

	int bestForPlayer2(Object[][] matrix) {
		int player1 = player1Chooses(matrix)
		bestForPlayer2(matrix, player1)
	}

	// --------------------------------------------
	
	int player1Chooses(Object[][] matrix) {
		int minRow = 0;
		Object[] row = matrix[0]
		int minValue = row[maxIndex(row, 1)][1]
		for (i in 1..matrix.length-1) {
			row = matrix[i]
			int tempIndex = maxIndex(row, 1)
			if (row[tempIndex][1] < minValue) {
				minValue = row[tempIndex][1]
				minRow = i
			}
		}
		minRow
	}
	
	int player2Chooses(Object[][] matrix) {
		int minColumn = 0;
		Object[] column = AlgorithmUtil.transformColumnCellsToArray(matrix, 0)
		int minValue = column[maxIndex(column, 0)][0]
		for (i in 1..matrix.length-1) {
			column = AlgorithmUtil.transformColumnCellsToArray(matrix, i)
			int tempIndex = maxIndex(column, 0)
			if (column[tempIndex][0] < minValue) {
				minValue = column[tempIndex][0]
				minColumn = i
			}
		}
		minColumn
	}
	
	
	int maxIndex(Object[] row, int playerNum) {
		int result = 0
		for (i in 1..row.length-1) {
			if (row[result][playerNum] < row[i][playerNum]) {
				result = i
			}
		}
		result
	}

	int bestForPlayer1(Object[][] matrix, int player2) {
		Object[] column = AlgorithmUtil.transformColumnCellsToArray(matrix, player2)
		maxIndex(column, 0)
	}
	
	int bestForPlayer2(Object[][] matrix, int player1) {
		maxIndex(matrix[player1], 1)
	}
}

