package rollerhockeyfrance.manager.core.zone;


import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;
import java.util.List;

import rollerhockeyfrance.manager.core.db.dao.zone.ZoneRepartitionDAO;
import rollerhockeyfrance.manager.core.db.dao.zone.ZoneVilleDAO;
import rollerhockeyfrance.manager.core.db.entity.zone.ZonePoule;
import rollerhockeyfrance.manager.core.db.entity.zone.ZoneRepartition;
import rollerhockeyfrance.manager.core.db.entity.zone.ZoneVille;

import com.google.inject.Inject;

public class ZoneService {

	private ZoneRepartitionDAO repartitionDAO;
	private ZoneVilleDAO villeDAO;
	
	@Inject
	public ZoneService(ZoneRepartitionDAO repartitionDAO, ZoneVilleDAO villeDAO) {
		this.repartitionDAO = repartitionDAO;
		this.villeDAO = villeDAO;
	}
	
	/**
	 * Trouve une répartition et la sauvegarde en base
	 * 
	 * @param nbZone
	 * @param villesIds
	 * @return
	 */
	public ZoneRepartition findRepartition(int nbZones, List<Long> villesIds, String libelle, String description) {
		
		// On récupère les villes en bases
		List<ZoneVille> villes = villeDAO.getList(villesIds);
		
		// Détermine les poules
		Collection<ZonePoule> poules = this.computeZone(villes, nbZones);
		
		// Persistence
		ZoneRepartition repartition = new ZoneRepartition();
		repartition.setLibelle(libelle);
		repartition.setDescription(description);
		repartition.setPoules(poules);
		return repartitionDAO.create(repartition);
		
	}
	
	private Collection<ZonePoule> computeZone(List<ZoneVille> villes, int nbZones) {
		Collection<ZonePoule> poules = newArrayList();
		
		/*
		 * 
		 * 
		 * 
		 */
		
		for (ZoneVille ville : villes) {
			
			
		}
		// TODO
		return poules;
	}

}
