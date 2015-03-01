package com.rollerhockeyfrance.manager.core.resultat;

import junit.framework.TestCase;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.rollerhockeyfrance.manager.core.resultat.ParseurUtils.Score;

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
	
	public void testGetScoreAvecDeuxChiffres() {
		String html = "<td class=\"center score\"><a href=\"/stats/match/feuille_match/17956\" title=\"Accès à la feuille de match\"><div><div>&nbsp;1 - 16</div></div></a></td>";
		Document doc = Jsoup.parse(html);
		
		Score s = ParseurUtils.getScore(doc.getAllElements().first(), 1);
		assertEquals(new Integer(1), s.equipeA);
		assertEquals(new Integer(16), s.equipeB);
	}

}