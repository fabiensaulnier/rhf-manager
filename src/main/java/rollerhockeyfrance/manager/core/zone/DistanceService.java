package rollerhockeyfrance.manager.core.zone;

import java.util.List;

import rollerhockeyfrance.manager.core.db.dao.zone.ZoneDistanceDAO;
import rollerhockeyfrance.manager.core.db.entity.zone.ZoneDistance;
import rollerhockeyfrance.manager.core.db.entity.zone.ZoneVille;

import com.google.inject.Inject;

public class DistanceService {
    
    private ZoneDistanceDAO distanceDAO;
    
    @Inject
    public DistanceService(ZoneDistanceDAO distanceDAO) {
        this.distanceDAO = distanceDAO;
    }
    
    
    private List<ZoneDistance> calculerDistances(ZoneVille ville) {
        
        // Liste des villes où il manque la distance
        List<ZoneVille> villes = null;
        
        for (ZoneVille ville2 : villes) {
            ZoneDistance distance = new ZoneDistance();
            distance.setVille1(ville);
            distance.setVille2(ville2);
            
            // TODO :: 
            distance.setDistance(0);
            distanceDAO.create(distance);
        }
        
        return null;
    }
    
    public Float[][] getMatrice(final List<ZoneVille> villes) {
    	Float[][] matrice = null; 
    	for (int i = 0; i < villes.size(); i++) {
			for (int j = 0; j < villes.size(); j++) {
				
			}
		}
    	return matrice;
    }

}
