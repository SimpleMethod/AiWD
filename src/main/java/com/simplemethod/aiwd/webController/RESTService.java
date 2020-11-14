package com.simplemethod.aiwd.webController;

import com.simplemethod.aiwd.model.DataModel;
import com.simplemethod.aiwd.model.PearsonModel;
import com.simplemethod.aiwd.model.ResponseModel;
import com.simplemethod.aiwd.reader.FileReader;
import com.simplemethod.aiwd.repository.DataModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

@RestController
public class RESTService {

   @Autowired
   FileReader fileReader;
   @Autowired
   DataModelRepository dataModelRepository;

   @Autowired
   EntityManager entityManager;

    @PutMapping(value = "/loadData", produces = "application/json")
    @ResponseBody
    public ResponseEntity LoaData(@RequestBody String filepath) throws IOException {
        File f = new File(filepath);
        if(f.exists() && !f.isDirectory()) {
            fileReader.ParseData(filepath);
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/data/{attribute}", produces = "application/json", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<ResponseModel> getRecord(@Valid @PathVariable String attribute) {
        Query minValueQuery = entityManager.createQuery("SELECT min("+attribute+") FROM DataModel");
        Query maxValueQuery = entityManager.createQuery("SELECT max("+attribute+") FROM DataModel");
        Query avgValueQuery = entityManager.createQuery("SELECT avg ("+attribute+") FROM DataModel");
        Query percentileQ1ValueQuery = entityManager.createNativeQuery("SELECT " +attribute+ " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY "+attribute+") temp WHERE temp.row_num=ROUND (0.25* @row_num)");
        Query percentileQ2ValueQuery = entityManager.createNativeQuery("SELECT " +attribute+ " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY "+attribute+") temp WHERE temp.row_num=ROUND (0.50* @row_num)");
        Query percentileQ3ValueQuery = entityManager.createNativeQuery("SELECT " +attribute+ " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY "+attribute+") temp WHERE temp.row_num=ROUND (0.75* @row_num)");
        Query percentile1ValueQuery = entityManager.createNativeQuery("SELECT " +attribute+ " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY "+attribute+") temp WHERE temp.row_num=ROUND (0.1* @row_num)");
        Query percentile9ValueQuery = entityManager.createNativeQuery("SELECT " +attribute+ " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY "+attribute+") temp WHERE temp.row_num=ROUND (0.9* @row_num)");
         double minValue=Double.parseDouble(minValueQuery.getResultList().get(0).toString());
         double maxValue=Double.parseDouble(maxValueQuery.getResultList().get(0).toString());
         double avgValue=Double.parseDouble(avgValueQuery.getResultList().get(0).toString());
         double percentileQ1Value=Double.parseDouble(percentileQ1ValueQuery.getResultList().get(0).toString());
         double percentileQ2Value=Double.parseDouble(percentileQ2ValueQuery.getResultList().get(0).toString());
         double percentileQ3Value=Double.parseDouble(percentileQ3ValueQuery.getResultList().get(0).toString());
         double percentile1Value=Double.parseDouble(percentile1ValueQuery.getResultList().get(0).toString());
         double percentile9Value=Double.parseDouble(percentile9ValueQuery.getResultList().get(0).toString());
         double percentileIRQ=percentileQ3Value-percentileQ1Value;
         double belowPoint=percentileQ1Value-1.5*percentileIRQ;
         double abovePoint=percentileQ3Value+1.5*percentileIRQ;
         ResponseModel responseModel = new ResponseModel(minValue,maxValue,avgValue,percentileQ1Value,percentileQ2Value,percentileQ3Value,percentileIRQ,belowPoint,abovePoint,attribute,percentile1Value,percentile9Value);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);

    }


    @GetMapping(value = "/data/{attribute}/{attribute2}", produces = "application/json", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<PearsonModel> getPearson(@Valid @PathVariable String attribute, @Valid @PathVariable String attribute2) {

        //SELECT sum(bomb_planted), sum(power(bomb_planted,2)) FROM datamodel;
        Query sumXQuery  = entityManager.createQuery("SELECT sum("+attribute+") FROM DataModel");
        Query powerXQuery = entityManager.createNativeQuery("SELECT sum(power("+attribute+",2)) FROM DataModel");
        Query sumYQuery  = entityManager.createQuery("SELECT sum("+attribute2+") FROM DataModel");
        Query powerYQuery = entityManager.createNativeQuery("SELECT sum(power("+attribute2+",2)) FROM DataModel");
        Query sumXYQuery =  entityManager.createQuery("SELECT sum("+attribute+"*"+attribute2+") FROM DataModel");
        Query countRecords =  entityManager.createQuery("SELECT count(id) FROM DataModel");

        double sumXValue =Double.parseDouble(sumXQuery.getResultList().get(0).toString());
        double powerXValue =Double.parseDouble(powerXQuery.getResultList().get(0).toString());
        double sumYValue =Double.parseDouble(sumYQuery.getResultList().get(0).toString());
        double powerYValue =Double.parseDouble(powerYQuery.getResultList().get(0).toString());
        double sumXYValue =Double.parseDouble(sumXYQuery.getResultList().get(0).toString());
        double countRecordsValue =Double.parseDouble(countRecords.getResultList().get(0).toString());
        double numeratorValue=(countRecordsValue*sumXYValue)-(sumXValue*sumYValue);
        double denominatorValue=Math.sqrt(((countRecordsValue*powerXValue)-Math.pow(sumXValue,2))*((countRecordsValue*powerYValue)-Math.pow(sumYValue,2)));
        double pearsonValue=numeratorValue/denominatorValue;
        PearsonModel pearsonModel = new PearsonModel(attribute,attribute2,pearsonValue,sumXValue,powerXValue,sumYValue,powerYValue,sumXYValue,countRecordsValue);
        return new ResponseEntity<>(pearsonModel, HttpStatus.OK);
    }


    @GetMapping(value = "/data/min/{attribute1}", produces = "application/json", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> getRecord(@Valid @PathVariable Double attribute1) {
        DataModel wiadro = dataModelRepository.getPercentile(.75,"ct_health");
        return new ResponseEntity<>("XD"+dataModelRepository.max_Ct_score()+wiadro.toString() , HttpStatus.OK);
    }

}
