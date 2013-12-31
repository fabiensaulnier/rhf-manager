package rollerhockeyfrance.manager.health;

import com.yammer.metrics.core.HealthCheck;

public class DataBaseHealthCheck extends HealthCheck {
	
	protected DataBaseHealthCheck() {
		super("database");
	}

	@Override
	protected Result check() throws Exception {
		// TODO
		return Result.healthy();
	}

}