package com.simplemethod.aiwd.AI;

import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.SplitTestAndTrain;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.NormalizerMinMaxScaler;
import org.nd4j.linalg.dataset.api.preprocessor.NormalizerStandardize;
import org.nd4j.linalg.learning.config.Nesterovs;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.springframework.core.io.ClassPathResource;

import java.util.concurrent.TimeUnit;

public class CSGO_Classification {

    private  DataSet dataNormalization(DataSet dataSet)
    {
        NormalizerMinMaxScaler normalizer = new NormalizerMinMaxScaler(-1.0,1.0);
        normalizer.fit(dataSet);
        normalizer.transform(dataSet);
        return  dataSet;
    }


    public  DataSet loadData() {
        try(RecordReader recordReader = new CSVRecordReader(0,',')) {
            recordReader.initialize(new FileSplit(
                    new ClassPathResource("csgo_full.csv").getFile()
            ));
            DataSetIterator iterator = new RecordReaderDataSetIterator(recordReader, 50, 4, 2);
            DataSet allData = iterator.next();
            allData.shuffle(20);
            return dataNormalization(allData);
           // makeNNetwork(WeightInit.DISTRIBUTION,Activation.TANH, normalizerData,50);

        } catch (Exception e) {
            Thread.dumpStack();
            new Exception("Stack trace").printStackTrace();
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return null;
    }

    public   String makeNNetwork(WeightInit weightInit, Activation activation, DataSet normalizerData, Integer epoch) {

        SplitTestAndTrain testAndTrain = normalizerData.splitTestAndTrain(0.65);
        DataSet trainingData = testAndTrain.getTrain();
        DataSet testingData = testAndTrain.getTest();

        MultiLayerConfiguration configuration = new NeuralNetConfiguration.Builder()
                .weightInit(weightInit)
                .activation(activation)
                .updater(new Nesterovs(0.9, 0.9))
                .l2(0.001)
                .list()
                .layer(0, new DenseLayer.Builder().nIn(4).nOut(7).build())
                .layer(1, new DenseLayer.Builder().activation(Activation.SOFTMAX).nIn(7).nOut(5).build())
                .layer(2, new DenseLayer.Builder().activation(Activation.SOFTMAX).nIn(5).nOut(3).build())
                .layer(3, new OutputLayer.Builder(LossFunctions.LossFunction.MSE).activation(Activation.SOFTMAX).nIn(3).nOut(2).build())
                .backprop(true).pretrain(false)
                .build();

        MultiLayerNetwork model = new MultiLayerNetwork(configuration);
        model.init();
        for (int i = 0; i < epoch; i++) {
            model.fit(trainingData);
        }
        INDArray output = model.output(testingData.getFeatureMatrix());
        Evaluation eval = new Evaluation(2);
        eval.eval(testingData.getLabels(), output);
        String s = eval.stats()+"\r\n"+eval.confusionToString()+"\r\n"+eval.getConfusionMatrix();

    return s;
    }

}
