package com.rollerhockeyfrance.manager.core.resultat;

import java.io.IOException;
import java.util.List;




import com.google.inject.Inject;


import com.google.inject.Singleton;
import com.rollerhockeyfrance.manager.api.proxy.Classement;
import com.rollerhockeyfrance.manager.api.resultat.Competition;


@Singleton
public class CompetitionService {

	@Inject ParseurService parseur;
	
    public List<Classement> getClassement(String id) {
        try {
			return parseur.getClassement(id);
		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}
    }
    
    public Competition getCompetition(Integer id) {
        return null;
    }

}
