package com.simplemethod.aiwd;

import com.simplemethod.aiwd.AI.CSGO_Classification;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.DataSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    private final CSGO_Classification csgo_classification=new CSGO_Classification();

    private static DataSet dataSet;
    public Controller() {
        dataSet=csgo_classification.loadData();
    }

    @GetMapping(value = "ai/{weightInit}/{activation}/{epoch}", produces = "text/plain")
    @ResponseBody
    ResponseEntity<String> getLocations(@PathVariable @Valid @NotEmpty WeightInit weightInit, @PathVariable @Valid @NotEmpty Activation activation, @PathVariable @Valid @NotNull Integer epoch)
    {
       String output= csgo_classification.makeNNetwork(weightInit,activation,dataSet,epoch);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

}
