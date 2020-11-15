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
        "countRecordsValue",
        "firstVariableValue",
        "secondVariableValue"
})
public class RoundWinnerModel {
    @JsonProperty("firstVariableName")
    private String firstVariableName;
    @JsonProperty("secondVariableName")
    private String secondVariableName;
    @JsonProperty("countRecordsValue")
    private double countRecordsValue;
    @JsonProperty("firstVariableValue")
    private double firstVariableValue;
    @JsonProperty("secondVariableValue")
    private double secondVariableValue;
}
