package com.igordsanches.mrdeliveryspringboot.config.check;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

import java.net.InetAddress;

public class HealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        try{
            InetAddress address = InetAddress.getByName("localhost");
            if(address.isReachable(1000)){
                return Health.up().build();
            }
        }catch (Exception e){
            return Health.down().withDetail("Motivo", e.getMessage()).build();
        }

        return Health.down().withDetail("Motivo", "Motivo desconhecido").build();
    }
}
