package jb.gametheory.algorithms

/**
 * @author jeanne
 *
 */
class StrictlyDominant extends AbstractDominant {


	/**
	 * if not exactly one dominant strategy, means there isn't one
	 * @param result
	 * @return
	 */
	private Collection onlyAllowOneDominantStrategy(Collection result) {
		if (result.size() > 1 || result.contains(null)) {
			result = []
		}
		return result
	}
}
