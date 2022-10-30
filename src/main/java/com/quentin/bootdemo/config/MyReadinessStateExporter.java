package com.quentin.bootdemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author quentin
 * @create 2022-10-23 19:52
 */
@Component
public class MyReadinessStateExporter {
    public static final Logger LOG = LoggerFactory.getLogger(MyReadinessStateExporter.class);
    @EventListener
    public void onStateChange(AvailabilityChangeEvent<ReadinessState> event) {
        switch (event.getState()) {
            case ACCEPTING_TRAFFIC:
                LOG.info("ACCEPTING_TRAFFIC");
                // create file /tmp/healthy
                break;
            case REFUSING_TRAFFIC:
                LOG.info("REFUSING_TRAFFIC");
                // remove file /tmp/healthy
                break;
        }
    }
}
