package com.rollerhockeyfrance.manager.health;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.rollerhockeyfrance.manager.core.db.dao.HealthCheckDAO;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.metrics.core.HealthCheck;

public class DataBaseHealthCheck extends HealthCheck {
	
	@Inject
	private DatabaseConfiguration database;
	
	@Inject
	private HealthCheckDAO healthCheckDao;

	@Inject
	public DataBaseHealthCheck() {
		super("database");
	}

	@Override
	protected Result check() throws Exception {
		Optional<Integer> ping = healthCheckDao.ping();
		if (ping.isPresent() && ping.get() == 1) {
			return Result.healthy();
		} else {
			return Result.unhealthy("Cannot connect to " + database.getUrl());
		}
	}

}