package com.rollerhockeyfrance.manager.core.zone;

import java.util.List;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.rollerhockeyfrance.manager.core.common.GoogleMapsService;
import com.rollerhockeyfrance.manager.core.common.GoogleMapsService.Coordonnes;
import com.rollerhockeyfrance.manager.core.db.dao.zone.ZoneVilleDAO;
import com.rollerhockeyfrance.manager.core.db.entity.zone.ZoneVille;
import com.yammer.dropwizard.hibernate.UnitOfWork;

public class VilleService {

    ZoneVilleDAO villeDAO;
    GoogleMapsService googleMapsService;
    
    @Inject
    public VilleService(ZoneVilleDAO villeDAO, GoogleMapsService googleMapsService) {
        this.villeDAO = villeDAO;
        this.googleMapsService = googleMapsService;
    }
    
    @UnitOfWork
    public ZoneVille create(ZoneVille ville) {
        Optional<Coordonnes> coordonnes = Optional.fromNullable(googleMapsService.getCoordonnees(ville));
        ville.setLatitude(coordonnes.orNull().getLatitude());
        ville.setLongitude(coordonnes.orNull().getLontitude());
        return villeDAO.create(ville); 
    }
    
    @UnitOfWork
    public ZoneVille read(Long id) {
        return villeDAO.getById(id);
    }
    
    @UnitOfWork
    public List<ZoneVille> findAll() {
        return villeDAO.getList();
    }
    
    @UnitOfWork
    public ZoneVille update(ZoneVille ville) {
        return villeDAO.update(ville);
    }
    
    @UnitOfWork
    public ZoneVille delete(Long id) {
        return villeDAO.deleteById(id);
    }
    
}
