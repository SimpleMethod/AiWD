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
        "firstVariableValue",
        "linearRegressionValue",
        "linearRegressionAVariable",
        "linearRegressionBVariable"

})
public class LinearRegressionModel {

    @JsonProperty("firstVariableName")
    private String firstVariableName;

    @JsonProperty("secondVariableName")
    private String secondVariableName;

    @JsonProperty("firstVariableValue")
    private double firstVariableValue;

    @JsonProperty("linearRegressionValue")
    private double linearRegressionValue;

    @JsonProperty("linearRegressionAVariable")
    private double linearRegressionAVariable;

    @JsonProperty("linearRegressionBVariable")
    private double linearRegressionBVariable;
}
