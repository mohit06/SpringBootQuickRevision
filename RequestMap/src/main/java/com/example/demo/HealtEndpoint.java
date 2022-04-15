package com.example.demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("Mohit")
public class HealtEndpoint implements HealthIndicator {

	public boolean checkHealth() {
		return true;
	}
	
	@Override
	public Health health() {
		// TODO Auto-generated method stub
		if(this.checkHealth()) {
			return Health.up().withDetail("act", "uator").build();
		}
		return Health.down().withDetail("act1", "uator1").build();
	}

}
