package com.rollerhockeyfrance.manager.core.resultat;

import junit.framework.TestCase;

public class ParseurUtilsTest extends TestCase {
	
	
	public void testExtractId() {
		
		int actual = -1;
		int expected = 1755;
		
		actual = ParseurUtils.extractId("file:///stats/match/equipe/1755?competition=2195");
		assertEquals(expected, actual);
		
		actual = ParseurUtils.extractId("file:///stats/match/feuille_match/1755");
		assertEquals(expected, actual);
		
		actual = ParseurUtils.extractId("/match/pdf/1755.pdf");
		assertEquals(expected, actual);
		
		
	}

}
