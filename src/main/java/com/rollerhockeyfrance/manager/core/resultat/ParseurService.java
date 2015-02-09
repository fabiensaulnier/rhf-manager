package com.rollerhockeyfrance.manager.core.resultat;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static com.rollerhockeyfrance.manager.core.resultat.ParseurUtils.extractId;
import static com.rollerhockeyfrance.manager.core.resultat.ParseurUtils.getDocument;
import static com.rollerhockeyfrance.manager.core.resultat.ParseurUtils.getInt;
import static com.rollerhockeyfrance.manager.core.resultat.ParseurUtils.getString;
import static com.rollerhockeyfrance.manager.core.resultat.ParseurUtils.postDocument;
import static com.rollerhockeyfrance.manager.core.resultat.UrlHelper.classementURL;
import static com.rollerhockeyfrance.manager.core.resultat.UrlHelper.matchsURL;
import static com.rollerhockeyfrance.manager.core.resultat.UrlHelper.statistiquesURL;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.jsoup.Connection.KeyVal;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.inject.Singleton;
import com.rollerhockeyfrance.manager.api.proxy.Classement;
import com.rollerhockeyfrance.manager.api.proxy.Match;
import com.rollerhockeyfrance.manager.api.proxy.Statistique;

@Singleton
public class ParseurService {
	
	public List<Classement> getClassement(String id) throws IOException {
		Document doc = getDocument(classementURL(id));
		
		// Il y a 2 tableaux  dans la page,
		// le premier est celui avec le classement.
		Elements tableaux = doc.select("table.resultat");
		Elements lignes = tableaux.get(0).select("tr");
		
		return FluentIterable.from(lignes).filter(new Predicate<Element>() {
			public boolean apply(Element e) {
				return e.select("th").size() == 0;
			}
		}).transform(new Function<Element, Classement>() {
			public Classement apply(Element e) {

				Elements td = e.getElementsByTag("td");
				String lien = td.get(1).select("a[href]").attr("href");
				
				Classement c = new Classement();
				c.setEquipeId(extractId(lien));
				c.setPosition(getInt(td, 0));
				c.setNom(getString(td, 1));
				c.setPoint(getInt(td, 2));
				c.setMatch(getInt(td, 3));
				c.setVictoire(getInt(td, 4));
				c.setVictoireProlongation(getInt(td, 5));
				c.setVictoireTab(getInt(td, 6));
				c.setPerdu(getInt(td, 7));
				c.setPerduProlongation(getInt(td, 8));
				c.setPerduTab(getInt(td, 9));
				c.setForfait(getInt(td, 10));
				c.setPlus(getInt(td, 11));
				c.setMoins(getInt(td, 12));
				c.setDiff(getInt(td, 13));
				
				return c;
			}
		}).toList();
		
	}
	
	public List<Statistique> getStatistiques(String id) throws IOException {
		Document doc = getDocument(statistiquesURL(id));
		
		// Il y a 2 tableaux  dans la page,
		// le premier est celui avec les statistiques.
		Elements tableaux = doc.select("table.resultat");
		Elements lignes = tableaux.get(0).select("tr");
		
		return FluentIterable.from(lignes).filter(new Predicate<Element>() {
			public boolean apply(Element e) {
				return e.select("th").size() == 0;
			}
		}).transform(new Function<Element, Statistique>() {
			public Statistique apply(Element e) {

				Elements td = e.getElementsByTag("td");
				String joueurLien = td.get(1).select("a[href]").attr("href");
				String equipeLien = td.get(2).select("a[href]").attr("href");
				
				Statistique s = new Statistique();
				s.setJoueurId(extractId(joueurLien));
				s.setEquipeId(extractId(equipeLien));
				s.setPosition(getInt(td, 0));
				s.setNom(getString(td, 1));
				s.setEquipe(getString(td, 2));
				s.setBut(getInt(td, 3));
				
				return s;
			}
		}).toList();
		
	}
	
	public List<Match> getMatchs(String id, String numero, String equipe) throws IOException {
		Collection<KeyVal> data = newHashSet();
		data.add(org.jsoup.helper.HttpConnection.KeyVal.create("numero", "ALL"));
		data.add(org.jsoup.helper.HttpConnection.KeyVal.create("equipe", ""));
		
		Document doc = postDocument(matchsURL(id), data);
		
		// Il y a autant de tableaux que de week-end de match,
		Elements tableaux = doc.select("table.resultat");
		
		List<Match> result = newArrayList();
		for (Element e : tableaux) {
		//	Date date = 
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		String competitionId = "2195"; // Ligue Elite
		
		ParseurService p = new ParseurService();
		System.out.println(p.getClassement(competitionId));
		System.out.println(p.getStatistiques(competitionId));
		System.out.println(p.getMatchs(competitionId, "", ""));
	}
}
