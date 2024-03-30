package com.georgen.gpt4allrest.controllers;

import com.georgen.gpt4allrest.model.constants.Message;
import com.georgen.gpt4allrest.model.settings.Settings;
import com.georgen.gpt4allrest.network.Responder;
import com.georgen.gpt4allrest.services.SettingsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/settings")
public class SettingsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SettingsController.class);

    private SettingsService service;

    public SettingsController(SettingsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getSettings(){
        try {
            Settings settings = service.getSettings();
            return settings != null ? Responder.sendOk(settings) : Responder.sendError(Message.SETTINGS_GET_ERROR);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return Responder.sendError(e);
        }
    }

    @PostMapping
    public ResponseEntity saveSettings(@RequestBody Settings settings){
        try {
            service.saveSettings(settings);
            return Responder.sendOk(Message.SETTINGS_SAVE_SUCCESS);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return Responder.sendError(e);
        }
    }
}
