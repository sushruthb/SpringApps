package com.backend.rest.services.restfulwebservices.services;

import com.backend.rest.services.restfulwebservices.model.Todo;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.IOException;

@Service
public class KafkaService {


    public void startKafka() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("./kafka-server-start.sh");
        //Sets the source and destination for subprocess standard I/O to be the same as those of the current Java process.
        processBuilder.inheritIO();
        Process process = processBuilder.start();

        int exitValue = process.waitFor();
        if (exitValue != 0) {
            // check for errors
            new BufferedInputStream(process.getErrorStream());
            throw new RuntimeException("execution of script failed!");
        }

    }

    public void stopKafka() throws IOException, InterruptedException {

        ProcessBuilder processBuilder = new ProcessBuilder("./kafka-server-stop.sh");
        //Sets the source and destination for subprocess standard I/O to be the same as those of the current Java process.
        processBuilder.inheritIO();
        Process process = processBuilder.start();

        int exitValue = process.waitFor();
        if (exitValue != 0) {
            // check for errors
            new BufferedInputStream(process.getErrorStream());
            throw new RuntimeException("execution of script failed!");
        }

    }
}
