package com.simplemethod.aiwd.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


@AllArgsConstructor
@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "variableName",
        "minValue",
        "maxValue",
        "avgValue",
        "percentileQ1Value",
        "percentileQ2Value",
        "percentileQ3Value",
        "percentile1Value",
        "percentile9Value",
        "percentileIRQ",
        "belowPoint",
        "abovePoint"
})
public class ResponseModel {
    @JsonProperty("minValue")
    private double minValue;
    @JsonProperty("maxValue")
    private double maxValue;
    @JsonProperty("avgValue")
    private double avgValue;
    @JsonProperty("percentileQ1Value")
    private double percentileQ1Value;
    @JsonProperty("percentileQ2Value")
    private double percentileQ2Value;
    @JsonProperty("percentileQ3Value")
    private double percentileQ3Value;
    @JsonProperty("percentileIRQ")
    private double percentileIRQ;
    @JsonProperty("belowPoint")
    private double belowPoint;
    @JsonProperty("abovePoint")
    private double abovePoint;
    @JsonProperty("variableName")
    private String variableName;
    @JsonProperty("percentile1Value")
    private double percentile1Value;
    @JsonProperty("percentile9Value")
    private double percentile9Value;
}
