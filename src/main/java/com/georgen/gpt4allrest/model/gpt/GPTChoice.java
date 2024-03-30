package com.georgen.gpt4allrest.model.gpt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GPTChoice {
    private String finishReason;
    private int index;
    private Map<Integer, Integer> logprobs;
    private List<String> references;
    private String text;

    @JsonProperty("finish_reason")
    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Map<Integer, Integer> getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(Map<Integer, Integer> logprobs) {
        this.logprobs = logprobs;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
