package com.georgen.gpt4allrest.model.constants;

public enum Message implements Descriptive {
    COMPLETION_ERROR("Failed to get the GPT4All completion."),
    SETTINGS_GET_ERROR("Failed to retrieve settings."),
    SETTINGS_SAVE_SUCCESS("The settings were successfully saved.");

    private String description;

    Message(String description) {
        this.description = description;
    }

    @Override
    public String describe() {
        return this.description;
    }
}
