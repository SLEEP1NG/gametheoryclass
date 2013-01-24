package jb.gametheory.algorithms

/**
 * Remove any columns where all values in cell 2 are smaller than all corresponding values in another column. 
 * Do the same for rows.  Repeat until one row and one column left or can't remove any more.
 * @author Jeanne
 *
 */
class IteratedRemovalOfDominated {
	
	def comparator;

	Object[] findPossibilitiesForNashForStronglyDominated(Object[][] matrix) {
		comparator = { a, b -> a >= b }
		findPossibilitiesForNashForDominated(matrix)
	}
	
	Object[] findPossibilitiesForNashForWeaklyDominated(Object[][] matrix) {
		comparator = { a, b -> a > b }
		findPossibilitiesForNashForDominated(matrix)
	}
	
	Object[] findPossibilitiesForNashForDominated(Object[][] matrix) {
		int numRowsBefore = matrix.length
		int numColumnsBefore = numColumns(matrix)
		
		Object[][] triedColumns = removeColumnIfCan(matrix)
		Object[][] triedRows = removeRowIfCan(triedColumns)
		int numRowsAfter = triedRows.length
		int numColumnsAfter = numColumns(triedRows)
		
		// if removed a row or a column, try again.  otherwise return
		if ( numRowsBefore == numRowsAfter && numColumnsBefore == numColumnsAfter) {
			return triedRows
		}
		// recurse
		return findPossibilitiesForNashForDominated(triedRows)
	}
	
	int numColumns(Object[] rows) {
		if ( rows.length == 0) {
			return 0
		}
		return rows[0].length
	}

	// ------------------------------------------------------------------------------

	Object[][] removeColumnIfCan(Object[][] matrix) {
		if (matrix[0].length == 1) {
			return matrix
		}
		
		
		def result = [] as Set
		for (i in 0..matrix[0].length-1) {
			for (j in 0..matrix[0].length-1) {
				int alwaysLower = columnIndexAlwaysLower(matrix, i, j)
				if ( alwaysLower != -1) {
					return createCopyWithoutRowOrColumn(matrix, -1, alwaysLower)
				}
			}
		}
		return matrix
	}

	int columnIndexAlwaysLower(Object[][] matrix, int index, int comparison) {
		boolean alwaysLower = true
		for (rowNum in 0..matrix.length-1) {
			if (matrix[rowNum][index][1] >= matrix[rowNum][comparison][1]) {
				alwaysLower = false
			}
		}
		if (alwaysLower) {
			return index
		}
		return -1
	}

	Object[][] createCopyWithoutRowOrColumn(Object[][] matrix, int rowToRemove, int columnToRemove) {
		def result = [] as List
		for (i in 0..matrix.length-1) {
			if ( i != rowToRemove) {
				def row = [] as List
				for (j in 0..matrix[0].length-1) {
					if ( j != columnToRemove) {
						row.add(matrix[i][j])
					}
				}
				result.add(row as Object[])
			}
		}
		result as Object[][]
	}
	// ------------------------------------------------------------------------------

	Object[] removeRowIfCan(Object[][] matrix) {
		if (matrix.length == 1) {
			return matrix
		}
		
		def result = [] as Set
		for (i in 0..matrix.length-1) {
			for (j in 0..matrix.length-1) {
				int alwaysLower = rowIndexAlwaysLower(matrix, i, j)
				if ( alwaysLower != -1) {
					return createCopyWithoutRowOrColumn(matrix, alwaysLower, -1)
				}
			}
		}
		return matrix
	}

	int rowIndexAlwaysLower(Object[][] matrix, int index, int comparison) {
		boolean alwaysLower = true
		for (columnNum in 0..matrix[0].length-1) {
			if (comparator(matrix[index][columnNum][0], matrix[comparison][columnNum][0]) == true) {
				alwaysLower = false
			}
		}
		if (alwaysLower) {
			return index
		}
		return -1
	}

}
