package com.challenge.goldenraspberryawards.movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for {@link MovieController}
 */
@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerIT {

    private final MockMvc mockMvc;

    @Autowired
    public MovieControllerIT(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    private static ProducerResponse getProducerResponseMin() {
        ProducerResponse producerResponseMin = new ProducerResponse();
        producerResponseMin.setProducer("Joel Silver");
        producerResponseMin.setInterval(1);
        producerResponseMin.setPreviousWin(1990);
        producerResponseMin.setFollowingWin(1991);
        return producerResponseMin;
    }

    private static ProducerResponse getProducerResponseMax() {
        ProducerResponse producerResponseMax = new ProducerResponse();
        producerResponseMax.setProducer("Matthew Vaughn");
        producerResponseMax.setInterval(13);
        producerResponseMax.setPreviousWin(2002);
        producerResponseMax.setFollowingWin(2015);
        return producerResponseMax;
    }

    @Test
    void smallestAndLargestIntervalBetweenAwards() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/movies/smallest-and-largest-interval-between-awards"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        SmallestAndLargestIntervalBetweenAwards smallestAndLargestIntervalBetweenAwards = objectMapper.readValue(json,
                SmallestAndLargestIntervalBetweenAwards.class);

        ProducerResponse producerResponseMin = getProducerResponseMin();
        ProducerResponse producerResponseMax = getProducerResponseMax();

        assertEquals(smallestAndLargestIntervalBetweenAwards.getMin().getFirst(), producerResponseMin);
        assertEquals(smallestAndLargestIntervalBetweenAwards.getMax().getFirst(), producerResponseMax);
    }
}