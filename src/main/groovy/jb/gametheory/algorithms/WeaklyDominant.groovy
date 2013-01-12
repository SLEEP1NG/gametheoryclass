package jb.gametheory.algorithms

/**
 * @author jeanne
 *
 */
class WeaklyDominant extends AbstractDominant {

	/**
	 * if not exactly one dominant strategy, means there isn't one
	 * @param result
	 * @return
	 */
	private Collection onlyAllowOneDominantStrategy(Collection result) {
		result.remove(null)
		if (result.size() > 1) {
			result = []
		}
		return result
	}
}
