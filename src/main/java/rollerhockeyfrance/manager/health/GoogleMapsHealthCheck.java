package rollerhockeyfrance.manager.health;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.yammer.metrics.core.HealthCheck;

public class GoogleMapsHealthCheck extends HealthCheck {

	@Inject
	private Geocoder geocoder;
	
	protected GoogleMapsHealthCheck() {
		super("Google Maps API");
	}

	@Override
	protected Result check() throws Exception {
		
		try {
		
			GeocoderRequest request = new GeocoderRequestBuilder()
											.setAddress("Paris, France")
											.getGeocoderRequest();
			
			Optional<GeocodeResponse> response = Optional.fromNullable(geocoder.geocode(request));
			
			if(response.isPresent() && GeocoderStatus.OK.equals(response.get().getStatus())) {
				return Result.healthy();
			} else {
				return (response.isPresent() ? Result.unhealthy(response.get().getStatus().name()) : Result.unhealthy("Geocoder is null"));
			}
			
		} catch (Exception e) {
			return Result.unhealthy(e.getMessage());
		}
	}

}
