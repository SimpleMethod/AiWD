package com.simplemethod.aiwd.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "firstVariableName",
        "secondVariableName",
        "pearsonValue",
        "sumXValue",
        "powerXValue",
        "sumYValue",
        "powerYValue",
        "sumXYValue",
        "countRecordsValue"
})
public class PearsonModel {
    @JsonProperty("firstVariableName")
    private String firstVariableName;
    @JsonProperty("secondVariableName")
    private String secondVariableName;
    @JsonProperty("pearsonValue")
    private double pearsonValue;
    @JsonProperty("sumXValue")
    private double sumXValue;
    @JsonProperty("powerXValue")
    private double powerXValue;
    @JsonProperty("sumYValue")
    private double sumYValue;
    @JsonProperty("powerYValue")
    private double powerYValue;
    @JsonProperty("sumXYValue")
    private double sumXYValue;
    @JsonProperty("countRecordsValue")
    private double countRecordsValue;
}
