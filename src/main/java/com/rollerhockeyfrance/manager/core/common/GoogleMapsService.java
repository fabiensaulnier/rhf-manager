package com.rollerhockeyfrance.manager.core.common;

import java.math.BigDecimal;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.rollerhockeyfrance.manager.core.db.entity.zone.ZoneVille;

@Singleton
public class GoogleMapsService {

    private final static String PAYS = "France";
    private final Geocoder geocoder;

    @Inject
    public GoogleMapsService(Geocoder geocoder) {
        this.geocoder = geocoder;
    }

    public Coordonnes getCoordonnees(ZoneVille ville) {

        GeocoderRequest request = new GeocoderRequestBuilder()
            .setAddress(ville.getLibelle() +", " + PAYS)
            .getGeocoderRequest();

        GeocodeResponse response = geocoder.geocode(request);

        if (GeocoderStatus.OK.equals(response.getStatus())) {
            GeocoderResult result = response.getResults().get(0);
            BigDecimal lat = result.getGeometry().getLocation().getLat();
            BigDecimal lng = result.getGeometry().getLocation().getLng();
            return new Coordonnes(lat.floatValue(), lng.floatValue());
        }

        return null;
    }

    public class Coordonnes {
        private Float latitude;
        private Float lontitude;

        public Coordonnes(Float latitude, Float lontitude) {
            this.latitude = latitude;
            this.lontitude = lontitude;
        }

        public Float getLatitude() {
            return latitude;
        }

        public Float getLontitude() {
            return lontitude;
        }

    }

}
