package com.georgen.gpt4allrest.model.gpt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.georgen.gpt4allrest.model.settings.Settings;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GPTRequest {
    private String model;
    private String prompt;
    private int bestOf;
    private boolean isEcho;
    private int frequencyPenalty;
    private Map<Integer, Integer> logitBias;
    private int logProbs;
    private int maxTokens;
    private int n;
    private int presencePenalty;
    private String seed;
    private String stop;
    private boolean isStream;
    private String suffix;
    private double temperature;
    private int topP;
    private String user;

    public GPTRequest() {}
    public GPTRequest(String prompt, Settings settings){
        this.model = settings.getModelName();
        this.prompt = prompt;
        this.bestOf = settings.getBestOf();
        this.isEcho = settings.isEcho();
        this.frequencyPenalty = settings.getPresencePenalty();
        this.logitBias = settings.getLogitBias();
        this.logProbs = settings.getLogProbs();
        this.maxTokens = settings.getMaxTokens();
        this.n = settings.getN();
        this.presencePenalty = settings.getPresencePenalty();
        this.seed = settings.getSeed();
        this.stop = settings.getStop();
        this.isStream = settings.isStream();
        this.suffix = settings.getSuffix();
        this.temperature = settings.getTemperature();
        this.topP = settings.getTopP();
        this.user = settings.getUser();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    @JsonProperty("best_of")
    public int getBestOf() {
        return bestOf;
    }

    public void setBestOf(int bestOf) {
        this.bestOf = bestOf;
    }

    @JsonProperty("echo")
    public boolean isEcho() {
        return isEcho;
    }

    public void setEcho(boolean echo) {
        isEcho = echo;
    }

    @JsonProperty("frequency_penalty")
    public int getFrequencyPenalty() {
        return frequencyPenalty;
    }

    public void setFrequencyPenalty(int frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
    }

    @JsonProperty("logit_bias")
    public Map<Integer, Integer> getLogitBias() {
        return logitBias;
    }

    public void setLogitBias(Map<Integer, Integer> logitBias) {
        this.logitBias = logitBias;
    }

    @JsonProperty("logprobs")
    public int getLogProbs() {
        return logProbs;
    }

    public void setLogProbs(int logProbs) {
        this.logProbs = logProbs;
    }

    @JsonProperty("max_tokens")
    public int getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @JsonProperty("presence_penalty")
    public int getPresencePenalty() {
        return presencePenalty;
    }

    public void setPresencePenalty(int presencePenalty) {
        this.presencePenalty = presencePenalty;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public boolean isStream() {
        return isStream;
    }

    public void setStream(boolean stream) {
        isStream = stream;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("top_p")
    public int getTopP() {
        return topP;
    }

    public void setTopP(int topP) {
        this.topP = topP;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
