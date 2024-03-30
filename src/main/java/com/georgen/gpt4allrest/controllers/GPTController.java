package com.georgen.gpt4allrest.controllers;

import com.georgen.gpt4allrest.model.constants.Message;
import com.georgen.gpt4allrest.model.gpt.GPTResponse;
import com.georgen.gpt4allrest.network.Responder;
import com.georgen.gpt4allrest.services.GPTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/gpt")
public class GPTController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GPTController.class);
    private GPTService service;

    public GPTController(GPTService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getResponse(@RequestParam String prompt){
        try {
            GPTResponse response = service.getCompletion(prompt);
            return response != null ? Responder.sendOk(response) : Responder.sendError(Message.COMPLETION_ERROR);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return Responder.sendError(e);
        }
    }
}
