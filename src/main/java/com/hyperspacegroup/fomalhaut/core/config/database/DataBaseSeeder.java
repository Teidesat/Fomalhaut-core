package com.hyperspacegroup.fomalhaut.core.config.database;

import com.hyperspacegroup.fomalhaut.core.model.Log;
import com.hyperspacegroup.fomalhaut.core.model.dao.LogRepository;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Profile("dev")
@Service
public class DataBaseSeeder {
    private final LogRepository logRepository;
    public DataBaseSeeder(LogRepository logRepository) {
        this.logRepository = logRepository;

        this.deleteAllAndSeedDataBase();
    }

    private void deleteAllAndSeedDataBase() {
        this.deleteAll();
        this.seedDataBase();
    }

    private void deleteAll() {
        this.logRepository.deleteAll();
        LogManager.getLogger(this.getClass()).warn("------- Delete All -----------");
    }

    private void seedDataBase() {
        LogManager.getLogger(this.getClass()).warn("------- Initial Load from JAVA -----------");
        Log[] logs = {
                Log.builder().title("Launch Successful").body("The satellite has successfully reached orbit.").dateTime(LocalDateTime.now().minusHours(12)).build(),
                Log.builder().title("Systems Check").body("All onboard systems are functioning within normal parameters.").dateTime(LocalDateTime.now().minusHours(10)).build(),
                Log.builder().title("Solar Panels Deployed").body("The satellite's solar panels have been successfully deployed and are generating power.").dateTime(LocalDateTime.now().minusHours(8)).build(),
                Log.builder().title("Communication Established").body("Ground station has established stable communication with the satellite.").dateTime(LocalDateTime.now().minusHours(6)).build(),
                Log.builder().title("Orbit Adjustment").body("The satellite has successfully adjusted its orbit to the designated altitude.").dateTime(LocalDateTime.now().minusHours(4)).build(),
                Log.builder().title("Anomaly Detected").body("Minor deviation in thermal control system detected, monitoring closely.").dateTime(LocalDateTime.now().minusHours(2)).build(),
                Log.builder().title("Mission Status: Operational").body("The satellite is fully operational and carrying out its mission objectives.").dateTime(LocalDateTime.now()).build()
        };
        this.logRepository.saveAll(List.of(logs));
        LogManager.getLogger(this.getClass()).warn("        ------- logs");
    }
}

