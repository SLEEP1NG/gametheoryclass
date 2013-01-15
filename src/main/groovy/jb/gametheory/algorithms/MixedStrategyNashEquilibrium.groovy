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
}
