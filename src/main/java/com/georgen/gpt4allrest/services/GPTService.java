package com.georgen.gpt4allrest.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.georgen.gpt4allrest.model.gpt.GPTRequest;
import com.georgen.gpt4allrest.model.gpt.GPTResponse;
import com.georgen.gpt4allrest.model.settings.Settings;
import com.georgen.gpt4allrest.network.HttpConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GPTService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GPTService.class);
    private static final ObjectMapper SERIALIZER = new ObjectMapper();
    private SettingsService settingsService;

    public GPTService(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    public GPTResponse getCompletion(String prompt) throws Exception {
        Settings settings = settingsService.getSettings();
        GPTRequest request = new GPTRequest(prompt, settings);

        try (HttpConnector connector = new HttpConnector(settings.getFullUrl())){
            String responseJson = connector.post("/v1/completions", SERIALIZER.writeValueAsString(request));
            return SERIALIZER.readValue(responseJson, GPTResponse.class);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }
}
