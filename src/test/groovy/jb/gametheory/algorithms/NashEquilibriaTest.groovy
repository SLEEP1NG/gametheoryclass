package jb.gametheory.algorithms;

import static org.junit.Assert.*;

class NashEquilibriaTest extends GroovyTestCase {

	void testDummy() {
		def strategy = new NashEquilibria()
		def actual = strategy.execute()
		assert 0 == actual.size
	}
}