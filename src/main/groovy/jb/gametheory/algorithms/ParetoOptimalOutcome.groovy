package jb.gametheory.algorithms

/**
 * Return all cells where neither player could do better without making one player worse off.  
 * Note: this algorithm is not efficient at all.  If running it on large matrices, need to fix it.
 * @author jeanne
 *
 */
class ParetoOptimalOutcome {


	def findParetoCoordinates(Object[][] matrix) {
		def result = []
		matrix.eachWithIndex() { outer, row ->
			outer.eachWithIndex() { inner, column ->
				if (! isParetoDominant(matrix, inner)) {
					result << row + "" + column
				}
			}
		}

		result
	}

	private boolean isParetoDominant(Object[][] matrix, cell) {
		def found = false
		matrix.eachWithIndex() { outer, row ->
			outer.eachWithIndex() { inner, column ->
				if(isOneBetterWithoutHurtingOther(inner, cell, 0, 1)) {
					found = true;
				}
				if(isOneBetterWithoutHurtingOther(inner, cell, 1, 0)) {
					found = true;
				}
			}
		}
		return found
	}
	
	private boolean isOneBetterWithoutHurtingOther(inner, cell, index1, index2) {
		inner[index1] > cell[index1] && inner[index2] >= cell[index2]
	}
}
