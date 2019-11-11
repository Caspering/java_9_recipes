package com.kousenit.recipes.http;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class JokeClientTest {
    private Logger logger = Logger.getLogger(JokeClientTest.class.getName());

    private JokeClient client = new JokeClient();
    private String heroFirstName = "Andrew";
    private String heroLastName = "Ehrig";

    @Test
    void getJokeSync() throws IOException, InterruptedException {
        String joke = client.getJokeSync(heroFirstName, heroLastName);
        logger.info(joke);
        assertTrue(joke.contains(heroFirstName) ||
                           joke.contains(heroLastName));
    }

    @Test
    void getJokeAsync() throws ExecutionException, InterruptedException {
        String joke = client.getJokeAsync(heroFirstName, heroLastName);
        logger.info(joke);
        assertTrue(joke.contains(heroFirstName) ||
                           joke.contains(heroLastName));
    }
}