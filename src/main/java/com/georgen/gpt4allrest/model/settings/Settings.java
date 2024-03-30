package com.georgen.gpt4allrest.model.settings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.georgen.hawthorne.api.annotations.SingletonEntity;

import java.util.Map;

@SingletonEntity
@JsonIgnoreProperties(value = {"fullUrl"}, ignoreUnknown = true)
public class Settings {
    private static final String DEFAULT_BASE_URL = "http://localhost";
    private static final int DEFAULT_PORT = 4891;
    private static final String DEFAULT_MODEL_NAME = "Nous Hermes 2 Mistral DPO";
    private String baseUrl;
    private int port;
    private String modelName;
    private int bestOf = 1;
    private boolean isEcho;
    private int frequencyPenalty;
    private Map<Integer, Integer> logitBias;
    private int logProbs;
    private int maxTokens = 250;
    private int n = 1;
    private int presencePenalty;
    private String seed = "66245"; // It's a random value, but it's best to keep it the same for all requests
    private String stop = "\n___\n";
    private boolean isStream;
    private String suffix;
    private double temperature = 0.5;
    private int topP = 1;
    private String user = "system";

    public Settings() {}

    public Settings(String modelName, String baseUrl, int port) {
        this.modelName = isValid(modelName) ? modelName : DEFAULT_MODEL_NAME;
        this.baseUrl = isValid(baseUrl) ? baseUrl : DEFAULT_BASE_URL;
        this.port = port != 0 ? port : DEFAULT_PORT;
    }

    public String getBaseUrl() {
        if (!isValid(this.baseUrl)) return DEFAULT_BASE_URL;
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public int getPort() {
        if (this.port == 0) return DEFAULT_PORT;
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getModelName() {
        if (!isValid(this.modelName)) return DEFAULT_MODEL_NAME;
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getBestOf() {
        return bestOf;
    }

    public void setBestOf(int bestOf) {
        this.bestOf = bestOf;
    }

    public boolean isEcho() {
        return isEcho;
    }

    public void setEcho(boolean echo) {
        isEcho = echo;
    }

    public int getFrequencyPenalty() {
        return frequencyPenalty;
    }

    public void setFrequencyPenalty(int frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
    }

    public Map<Integer, Integer> getLogitBias() {
        return logitBias;
    }

    public void setLogitBias(Map<Integer, Integer> logitBias) {
        this.logitBias = logitBias;
    }

    public int getLogProbs() {
        return logProbs;
    }

    public void setLogProbs(int logProbs) {
        this.logProbs = logProbs;
    }

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

    public String getFullUrl(){
        return String.format("%s:%s", this.getBaseUrl(), this.getPort());
    }

    private boolean isValid(String value){
        return value != null && !value.isEmpty();
    }
}
