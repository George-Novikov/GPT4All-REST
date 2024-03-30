package com.georgen.gpt4allrest.services;

import com.georgen.gpt4allrest.model.settings.Settings;
import com.georgen.hawthorne.api.Repository;
import com.georgen.hawthorne.model.exceptions.HawthorneException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SettingsService {
    @Value("${gpt4all.model-name}")
    private String modelName;
    @Value("${gpt4all.base-url}")
    private String baseUrl;
    @Value("${gpt4all.port}")
    private int port;

    public Settings getSettings() throws Exception {
        Settings settings = Repository.get(Settings.class);

        if (settings == null){
            settings = new Settings(modelName, baseUrl, port);
            saveSettings(settings);
        }

        return settings;
    }

    public void saveSettings(Settings settings) throws HawthorneException {
        Settings settings1 = Repository.save(settings);
    }
}
