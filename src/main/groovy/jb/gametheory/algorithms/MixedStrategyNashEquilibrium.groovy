package jb.gametheory.algorithms

class MixedStrategyNashEquilibrium {

	/**
	 * For 2x2, it's just probability.
	 * 
	 * Given table:
	 * <pre>
	 *      p     1-p
	 * q    a,e   b,f
	 * 1-q  c,g   d,h
	 * </pre>
	 * ap + b(1-p) = cp + d(1-p)
	 * ap + b - bp = cp + d -dp
	 * p = (d-b) / (a-b-c+d)
	 * 
	 * eq + g(1-q) = fq + h(1-q)
	 * eq + g - gq = fq = h - h1
	 * q = (h-g) / (e-g-f+h)
	 * 
	 * @param matrix
	 * @return
	 */
	def find2x2MixedStrategyNashEquilibrium(Object[][] matrix) {
		def a = matrix[0][0][0]
		def b = matrix[0][1][0]
		def c = matrix[1][0][0]
		def d = matrix[1][1][0]
		def e = matrix[0][0][1]
		def f = matrix[0][1][1]
		def g = matrix[1][0][1]
		def h = matrix[1][1][1]
		def pDenominator = a-b-c+d;
		def qDenominator = e-g-f+h;
		if (pDenominator == 0 || qDenominator == 0) 
			return []
	    def p = (d-b) / pDenominator
		def q = (h-g) / qDenominator
		return [[p, 1-p], [q, 1-q]]
	}
	
	/**
	 * Given table:
	 * <pre>
	 *      p     1-p
	 * q    a,e   b,f
	 * 1-q  c,g   d,h
	 * </pre>
	 * check:
	 * a(player1[0]) + b(player1[1] + ... is same for each row
	 * and totals for player 1 and 2 add up to 1 
	 * 
	 * @param matrix
	 * @param player1Strategy
	 * @param player2Strategy
	 * @return
	 */
	def checkMixedStrategyNashEquilibrium(Object[][] matrix, Object[] player1Strategy, Object[] player2Strategy) {
		return checkTotalIs100Percent(player1Strategy) && checkTotalIs100Percent(player2Strategy) && 
			checkWeightedAverageForPlayer1(matrix, player1Strategy) && checkWeightedAverageForPlayer2(matrix, player2Strategy)
	}
	
	def checkWeightedAverageForPlayer1(Object[][] matrix, Object[] strategy) {
		def weighted = weightedAverageForRow(0, matrix[0], strategy)
		for (i in 1 .. matrix.length-1) {
			def current = weightedAverageForRow(0, matrix[i], strategy)
			if (Math.abs(current - weighted) > 0.000001) {
				return false;
			}
		}
		return true
	}
	
	def checkWeightedAverageForPlayer2(Object[][] matrix, Object[] strategy) {
		Object[] temp = AlgorithmUtil.transformColumnCellsToArray(matrix, 0)
		def weighted = weightedAverageForRow(1, temp, strategy)
		for (i in 1 .. matrix.length-1) {
			temp = AlgorithmUtil.transformColumnCellsToArray(matrix, i)
			def current = weightedAverageForRow(1, temp, strategy)
			if (Math.abs(current - weighted) > 0.000001) {
				return false;
			}
		}
		return true
	}
	
	def weightedAverageForRow(int playerNum, Object[] row, Object[] strategy) {
		def sum = 0
		row.eachWithIndex{ it, i -> sum+= strategy[i] * it[playerNum]}
		return sum
	}
	
	def checkTotalIs100Percent(Object[] strategy) {
		def sum = 0
		strategy.each{  sum+= it}
		return Math.abs(1 - sum) < 0.000001
	}
	

	
	// ------------------------------------------------------
	
}
