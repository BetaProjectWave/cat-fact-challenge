package uk.co.asto.interview.cats.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FactDTO {
    @JsonProperty(value = "fact")
    private final String fact;

    public FactDTO(final String fact) {
        this.fact = fact;
    }

    public String getFact() {
        return fact;
    }
}
