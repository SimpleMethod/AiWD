package com.simplemethod.aiwd.webController;

import com.simplemethod.aiwd.Services.pngMaker;
import com.simplemethod.aiwd.model.*;
import com.simplemethod.aiwd.reader.FileReader;
import com.simplemethod.aiwd.repository.DataModelRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RESTService {

    @Autowired
    FileReader fileReader;
    @Autowired
    DataModelRepository dataModelRepository;

    @Autowired
    EntityManager entityManager;

    @Autowired
    pngMaker  pngMaker;

    @GetMapping(value = "/loaddata/{attribute}", produces = "application/json")
    @ResponseBody
    public ResponseEntity LoaData(@Valid @PathVariable String filepath) throws IOException {
        File f = new File(filepath);
        if (f.exists() && !f.isDirectory()) {
            fileReader.ParseData(filepath);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/loaddatamodel", produces = "application/json",  consumes = "application/json", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity LoaDataSQL( @Valid @RequestBody EditDataJson editDataJson) throws IOException {

        DataModel dataModel1 = new DataModel(0, 0, 0, editDataJson.getMaps(), editDataJson.getBomb_planted(), 0,
                0, 0, 0, 0, 0, 0,
                0,0, editDataJson.getCt_players_alive(), editDataJson.getT_players_alive(), 0,
               0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0,0, 0, 0,
               0, 0, 0,0, 0,
                0, 0,0, 0, 0,
               0,0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0,0, 0, 0, editDataJson.getCt_grenade_flashbang(),
                editDataJson.getT_grenade_flashbang(), editDataJson.getCt_grenade_smokegrenade(), editDataJson.getT_grenade_smokegrenade(), 0,
                0, 0, 0, 0,
                0, editDataJson.getRound_winner());
        dataModelRepository.save(dataModel1);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/loaddatamodel/{id}", produces = "application/json",  consumes = "application/json", headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity EditData(@Valid @RequestBody EditDataJson editDataJson, @Valid @PathVariable String id) throws IOException {

      DataModel dataModel =  dataModelRepository.findById(Long.parseLong(id));
        dataModel.setMap(editDataJson.getMaps());
        dataModel.setBomb_planted(editDataJson.getBomb_planted());
        dataModel.setCt_players_alive(editDataJson.getCt_players_alive());
        dataModel.setT_players_alive(editDataJson.getT_players_alive());
        dataModel.setCt_grenade_flashbang(editDataJson.getCt_grenade_flashbang());
        dataModel.setCt_grenade_smokegrenade(editDataJson.getCt_grenade_smokegrenade());
        dataModel.setT_grenade_flashbang(editDataJson.getT_grenade_flashbang());
        dataModel.setT_grenade_smokegrenade(editDataJson.getT_grenade_smokegrenade());
        dataModel.setRound_winner(editDataJson.getRound_winner());
        dataModelRepository.save(dataModel);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/pngmarker/{maps}", produces = "image/png")
    @ResponseBody
    public ResponseEntity<byte[]> pngMarker(@Valid @PathVariable String maps) throws IOException {



        int ctAlive=0;

        int tAlive=0;

        int winRound=0;

        float flashValue=0;

        float smokeValue=0;

        Query ctAliveQuery = entityManager.createQuery("SELECT avg (ct_players_alive) FROM DataModel WHERE map="+maps);
        double ctAliveValue = Double.parseDouble(ctAliveQuery.getResultList().get(0).toString());

        if(ctAliveValue<=1)
        {
            ctAlive=0;
        }
        else if(ctAliveValue>=1 && ctAliveValue<=1.5)
        {
            ctAlive=1;
        }
        else if(ctAliveValue>=1.5 && ctAliveValue<=2.5)
        {
            ctAlive=2;
        }
        else if(ctAliveValue>=2.5 && ctAliveValue<=3.5)
        {
            ctAlive=3;
        }
        else if(ctAliveValue>=3.5 && ctAliveValue<=4.5)
        {
            ctAlive=4;
        }
        else if(ctAliveValue>=4.5 && ctAliveValue<=5.0)
        {
            ctAlive=5;
        }



        Query tAliveQuery = entityManager.createQuery("SELECT avg(t_players_alive) FROM DataModel WHERE map="+maps);
        double tAliveValue = Double.parseDouble(tAliveQuery.getResultList().get(0).toString());

        if(tAliveValue<=1)
        {
            tAlive=0;
        }
        else if(tAliveValue>=1 && tAliveValue<=1.5)
        {
            tAlive=1;
        }
        else if(tAliveValue>=1.5 && tAliveValue<=2.5)
        {
            tAlive=2;
        }
        else if(tAliveValue>=2.5 && tAliveValue<=3.5)
        {
            tAlive=3;
        }
        else if(tAliveValue>=3.5 && tAliveValue<=4.5)
        {
            tAlive=4;
        }
        else if(tAliveValue>=4.5 && tAliveValue<=5.0)
        {
            tAlive=5;
        }



        Query ctFlashQuery = entityManager.createQuery("SELECT avg(ct_grenade_flashbang) FROM DataModel WHERE map="+maps);
        double ctFlashValue = Double.parseDouble(ctFlashQuery.getResultList().get(0).toString());
        Query tFlashQuery = entityManager.createQuery("SELECT avg(t_grenade_flashbang) FROM DataModel WHERE map="+maps);
        double tFlashValue = Double.parseDouble(tFlashQuery.getResultList().get(0).toString());

        double flashSum=ctFlashValue+tFlashValue;

        if(flashSum<=1)
        {
            flashValue=0;
        }
        else if(flashSum>=1 && flashSum<=1.5)
        {
            flashValue=1;
        }
        else if(flashSum>=1.5 && flashSum<=2.5)
        {
            flashValue=2;
        }
        else if(flashSum>=2.5 && flashSum<=3.5)
        {
            flashValue=3;
        }
        else if(flashSum>=3.5 && flashSum<=4.5)
        {
            flashValue=4;
        }
        else if(flashSum>=4.5 && flashSum<=5.5)
        {
            flashValue=5;
        }
        else if(flashSum>=5.5 && flashSum<=6.5)
        {
            flashValue=6;
        }
        else if(flashSum>=6.5 && flashSum<=7.5)
        {
            flashValue=7;
        }
        else if(flashSum>=7.5 && flashSum<=8.5)
        {
            flashValue=8;
        }
        else if(flashSum>=8.5 && flashSum<=9.5)
        {
            flashValue=9;
        }
        else if(flashSum>=9.5)
        {
            flashValue=10;
        }




        Query ctSmokeQuery = entityManager.createQuery("SELECT avg(ct_grenade_smokegrenade) FROM DataModel WHERE map="+maps);
        double ctSmokeValue = Double.parseDouble(ctSmokeQuery.getResultList().get(0).toString());
        Query tSmokeQuery = entityManager.createQuery("SELECT avg(t_grenade_smokegrenade) FROM DataModel WHERE map="+maps);
        double tSmokeValue = Double.parseDouble(tSmokeQuery.getResultList().get(0).toString());


        double smokeSumValue=ctSmokeValue+tSmokeValue;

        if(smokeSumValue<=1)
        {
            smokeValue=0;
        }
        else if(smokeSumValue>=1 && smokeSumValue<=1.5)
        {
            smokeValue=1;
        }
        else if(smokeSumValue>=1.5 && smokeSumValue<=2.5)
        {
            smokeValue=2;
        }
        else if(smokeSumValue>=2.5 && smokeSumValue<=3.5)
        {
            smokeValue=3;
        }
        else if(smokeSumValue>=3.5 && smokeSumValue<=4.5)
        {
            smokeValue=4;
        }
        else if(smokeSumValue>=4.5 && smokeSumValue<=5.5)
        {
            smokeValue=5;
        }
        else if(smokeSumValue>=5.5 && smokeSumValue<=6.5)
        {
            smokeValue=6;
        }
        else if(smokeSumValue>=6.5 && smokeSumValue<=7.5)
        {
            smokeValue=7;
        }
        else if(smokeSumValue>=7.5 && smokeSumValue<=8.5)
        {
            smokeValue=8;
        }
        else if(smokeSumValue>=8.5 && smokeSumValue<=9.5)
        {
            smokeValue=9;
        }
        else if(smokeSumValue>=9.5)
        {
            smokeValue=10;
        }




        Query tWinQuery = entityManager.createQuery("SELECT COUNT(round_winner) FROM DataModel WHERE round_winner=1 AND map="+maps);
        double tWinValue = Double.parseDouble(tWinQuery.getResultList().get(0).toString());

        Query ctWinQuery = entityManager.createQuery("SELECT COUNT(round_winner) FROM DataModel WHERE round_winner=0 AND map="+maps);
        double ctWinValue = Double.parseDouble(ctWinQuery.getResultList().get(0).toString());

        if(ctWinValue>tWinValue)
        {
            winRound=0;
        }
        else
        {
            winRound=1;
        }
        System.out.println("CT Alive:"+ctAliveValue);
        System.out.println("CT Alive ARG:"+ctAlive);
        System.out.println("T Alive:"+tAliveValue);
        System.out.println("T Alive ARG:"+tAlive);
        System.out.println("Flash CT:"+ctFlashValue);
        System.out.println("Flash T:"+tFlashValue);
        System.out.println("Flash SUM AVG:"+flashSum);
        System.out.println("Flash ARG:"+flashValue);
        System.out.println("Smoke CT:"+ctSmokeValue);
        System.out.println("Smoke T:"+tSmokeValue);
        System.out.println("Smoke SUM AVG:"+smokeSumValue);
        System.out.println("Smoke ARG:"+smokeValue);
        System.out.println("CT WIN:"+ctWinValue);
        System.out.println("T WIN:"+tWinValue);
        System.out.println("Arg WIN:"+winRound);

        byte[] bytes =  pngMaker.makePng(ctAlive,tAlive,winRound,flashValue,smokeValue,Integer.parseInt(maps));

        return new ResponseEntity<>(bytes, HttpStatus.OK);
    }

    @GetMapping(value = "/data/{attribute}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<ResponseModel> getRecord(@Valid @PathVariable String attribute) {
        Query minValueQuery = entityManager.createQuery("SELECT min(" + attribute + ") FROM DataModel");
        Query maxValueQuery = entityManager.createQuery("SELECT max(" + attribute + ") FROM DataModel");
        Query avgValueQuery = entityManager.createQuery("SELECT avg (" + attribute + ") FROM DataModel");
        Query percentileQ1ValueQuery = entityManager.createNativeQuery("SELECT " + attribute + " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY " + attribute + ") temp WHERE temp.row_num=ROUND (0.25* @row_num)");
        Query percentileQ2ValueQuery = entityManager.createNativeQuery("SELECT " + attribute + " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY " + attribute + ") temp WHERE temp.row_num=ROUND (0.50* @row_num)");
        Query percentileQ3ValueQuery = entityManager.createNativeQuery("SELECT " + attribute + " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY " + attribute + ") temp WHERE temp.row_num=ROUND (0.75* @row_num)");
        Query percentile1ValueQuery = entityManager.createNativeQuery("SELECT " + attribute + " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY " + attribute + ") temp WHERE temp.row_num=ROUND (0.1* @row_num)");
        Query percentile9ValueQuery = entityManager.createNativeQuery("SELECT " + attribute + " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY " + attribute + ") temp WHERE temp.row_num=ROUND (0.9* @row_num)");
        double minValue = Double.parseDouble(minValueQuery.getResultList().get(0).toString());
        double maxValue = Double.parseDouble(maxValueQuery.getResultList().get(0).toString());
        double avgValue = roundAvoid(Double.parseDouble(avgValueQuery.getResultList().get(0).toString()), 2);
        double percentileQ1Value = Double.parseDouble(percentileQ1ValueQuery.getResultList().get(0).toString());
        double percentileQ2Value = Double.parseDouble(percentileQ2ValueQuery.getResultList().get(0).toString());
        double percentileQ3Value = Double.parseDouble(percentileQ3ValueQuery.getResultList().get(0).toString());
        double percentile1Value = Double.parseDouble(percentile1ValueQuery.getResultList().get(0).toString());
        double percentile9Value = Double.parseDouble(percentile9ValueQuery.getResultList().get(0).toString());
        double percentileIRQ = percentileQ3Value - percentileQ1Value;
        double belowPoint = percentileQ1Value - 1.5; //* percentileIRQ;
        double abovePoint = percentileQ3Value + 1.5; //* percentileIRQ;
        ResponseModel responseModel = new ResponseModel(minValue, maxValue, avgValue, percentileQ1Value, percentileQ2Value, percentileQ3Value, percentileIRQ, belowPoint, abovePoint, attribute, percentile1Value, percentile9Value);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping(value = "/dataonmape/{attribute}/{maps}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<ResponseModel> getRecordMape(@Valid @PathVariable String attribute, @PathVariable String maps) {
        Query minValueQuery = entityManager.createQuery("SELECT min(" + attribute + ") FROM DataModel where map="+ maps);
        Query maxValueQuery = entityManager.createQuery("SELECT max(" + attribute + ") FROM DataModel where map="+ maps);
        Query avgValueQuery = entityManager.createQuery("SELECT avg (" + attribute + ") FROM DataModel where map="+ maps);
        Query percentileQ1ValueQuery = entityManager.createNativeQuery("SELECT " + attribute + " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY " + attribute + ") temp WHERE temp.row_num=ROUND (0.25* @row_num) AND map="+ maps);
        Query percentileQ2ValueQuery = entityManager.createNativeQuery("SELECT " + attribute + " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY " + attribute + ") temp WHERE temp.row_num=ROUND (0.50* @row_num) AND map="+ maps);
        Query percentileQ3ValueQuery = entityManager.createNativeQuery("SELECT " + attribute + " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY " + attribute + ") temp WHERE temp.row_num=ROUND (0.75* @row_num) AND map="+ maps);
        Query percentile1ValueQuery = entityManager.createNativeQuery("SELECT " + attribute + " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY " + attribute + ") temp WHERE temp.row_num=ROUND (0.1* @row_num) AND map="+ maps);
        Query percentile9ValueQuery = entityManager.createNativeQuery("SELECT " + attribute + " FROM (SELECT t.*,@row_num \\:=@row_num+1 AS row_num FROM DataModel t,(SELECT @row_num \\:=0)counter ORDER BY " + attribute + ") temp WHERE temp.row_num=ROUND (0.9* @row_num) AND map="+ maps);
        double minValue = Double.parseDouble(minValueQuery.getResultList().get(0).toString());
        double maxValue = Double.parseDouble(maxValueQuery.getResultList().get(0).toString());
        double avgValue = roundAvoid(Double.parseDouble(avgValueQuery.getResultList().get(0).toString()), 2);
        double percentileQ1Value = Double.parseDouble(percentileQ1ValueQuery.getResultList().get(0).toString());
        double percentileQ2Value = Double.parseDouble(percentileQ2ValueQuery.getResultList().get(0).toString());
        double percentileQ3Value = Double.parseDouble(percentileQ3ValueQuery.getResultList().get(0).toString());
        double percentile1Value = Double.parseDouble(percentile1ValueQuery.getResultList().get(0).toString());
        double percentile9Value = Double.parseDouble(percentile9ValueQuery.getResultList().get(0).toString());
        double percentileIRQ = percentileQ3Value - percentileQ1Value;
        double belowPoint = percentileQ1Value - 1.5; //* percentileIRQ;
        double abovePoint = percentileQ3Value + 1.5; //* percentileIRQ;
        ResponseModel responseModel = new ResponseModel(minValue, maxValue, avgValue, percentileQ1Value, percentileQ2Value, percentileQ3Value, percentileIRQ, belowPoint, abovePoint, attribute, percentile1Value, percentile9Value);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping(value = "/data/pcc/{attribute}/{attribute2}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<PearsonModel> getPearson(@Valid @PathVariable String attribute, @Valid @PathVariable String attribute2) {
        Query sumXQuery = entityManager.createQuery("SELECT sum(" + attribute + ") FROM DataModel");
        Query powerXQuery = entityManager.createNativeQuery("SELECT sum(power(" + attribute + ",2)) FROM DataModel");
        Query sumYQuery = entityManager.createQuery("SELECT sum(" + attribute2 + ") FROM DataModel");
        Query powerYQuery = entityManager.createNativeQuery("SELECT sum(power(" + attribute2 + ",2)) FROM DataModel");
        Query sumXYQuery = entityManager.createQuery("SELECT sum(" + attribute + "*" + attribute2 + ") FROM DataModel");
        Query countRecords = entityManager.createQuery("SELECT count(id) FROM DataModel");

        double sumXValue = Double.parseDouble(sumXQuery.getResultList().get(0).toString());
        double powerXValue = Double.parseDouble(powerXQuery.getResultList().get(0).toString());
        double sumYValue = Double.parseDouble(sumYQuery.getResultList().get(0).toString());
        double powerYValue = Double.parseDouble(powerYQuery.getResultList().get(0).toString());
        double sumXYValue = Double.parseDouble(sumXYQuery.getResultList().get(0).toString());
        double countRecordsValue = Double.parseDouble(countRecords.getResultList().get(0).toString());
        double numeratorValue = (countRecordsValue * sumXYValue) - (sumXValue * sumYValue);
        double denominatorValue = Math.sqrt(((countRecordsValue * powerXValue) - Math.pow(sumXValue, 2)) * ((countRecordsValue * powerYValue) - Math.pow(sumYValue, 2)));
        double pearsonValue = roundAvoid(numeratorValue / denominatorValue, 2);
        PearsonModel pearsonModel = new PearsonModel(attribute, attribute2, pearsonValue, sumXValue, powerXValue, sumYValue, powerYValue, sumXYValue, countRecordsValue);
        return new ResponseEntity<>(pearsonModel, HttpStatus.OK);
    }


    @GetMapping(value = "/data/linearregression/{attribute}/{attribute2}/{attribute3}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<LinearRegressionModel> getLinearRegression(@Valid @PathVariable String attribute, @Valid @PathVariable String attribute2, @Valid @PathVariable double attribute3) {

        Query sumXQuery = entityManager.createQuery("SELECT sum(" + attribute + ") FROM DataModel");
        Query powerXQuery = entityManager.createNativeQuery("SELECT sum(power(" + attribute + ",2)) FROM DataModel");
        Query sumYQuery = entityManager.createQuery("SELECT sum(" + attribute2 + ") FROM DataModel");
        Query sumXYQuery = entityManager.createQuery("SELECT sum(" + attribute + "*" + attribute2 + ") FROM DataModel");
        Query countRecords = entityManager.createQuery("SELECT count(id) FROM DataModel");

        Query avgXQuery = entityManager.createQuery("SELECT avg(" + attribute + ") FROM DataModel");
        Query avgYXQuery = entityManager.createQuery("SELECT avg(" + attribute2 + ") FROM DataModel");
        double sumXValue = Double.parseDouble(sumXQuery.getResultList().get(0).toString());
        double powerXValue = Double.parseDouble(powerXQuery.getResultList().get(0).toString());
        double sumYValue = Double.parseDouble(sumYQuery.getResultList().get(0).toString());
        double sumXYValue = Double.parseDouble(sumXYQuery.getResultList().get(0).toString());
        double countRecordsValue = Double.parseDouble(countRecords.getResultList().get(0).toString());

        double avgXValue = Double.parseDouble(avgXQuery.getResultList().get(0).toString());
        double avgYValue = Double.parseDouble(avgYXQuery.getResultList().get(0).toString());

        double numeratorValue = countRecordsValue * sumXYValue - sumXValue * sumYValue;
        double denominatorValue = countRecordsValue * powerXValue - Math.pow(sumXValue, 2);
        double linearRegressionBArgs = numeratorValue / denominatorValue;
        //   double linearRegressionAArgs=(sumYValue/countRecordsValue)-linearRegressionBArgs*(sumXValue/countRecordsValue);
        double linearRegressionAArgs = (avgYValue) - linearRegressionBArgs * (avgXValue);
        double linearRegressionYArgs = roundAvoid(linearRegressionAArgs + linearRegressionBArgs * attribute3, 3);

        LinearRegressionModel linearRegressionModel = new LinearRegressionModel(attribute, attribute2, attribute3, linearRegressionYArgs, linearRegressionAArgs, linearRegressionBArgs);
        return new ResponseEntity<>(linearRegressionModel, HttpStatus.OK);
    }

    @GetMapping(value = "/data/weapons/{attribute}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<JSONObject> getWeaponsUsage(@Valid @PathVariable String attribute) {
        Query grenade_decoygrenade = entityManager.createQuery("SELECT sum(" + attribute + "_grenade_decoygrenade) FROM DataModel");
        double grenade_decoygrenadeValue = Double.parseDouble(grenade_decoygrenade.getResultList().get(0).toString());
        Query grenade_flashbang = entityManager.createQuery("SELECT sum(" + attribute + "_grenade_flashbang) FROM DataModel");
        double grenade_flashbangValue = Double.parseDouble(grenade_flashbang.getResultList().get(0).toString());
        Query grenade_hegrenade = entityManager.createQuery("SELECT sum(" + attribute + "_grenade_hegrenade) FROM DataModel");
        double grenade_hegrenadeValue = Double.parseDouble(grenade_hegrenade.getResultList().get(0).toString());
        Query grenade_incendiarygrenade = entityManager.createQuery("SELECT sum(" + attribute + "_grenade_incendiarygrenade) FROM DataModel");
        double grenade_incendiarygrenadeValue = Double.parseDouble(grenade_incendiarygrenade.getResultList().get(0).toString());
        Query grenade_molotovgrenade = entityManager.createQuery("SELECT sum(" + attribute + "_grenade_molotovgrenade) FROM DataModel");
        double grenade_molotovgrenadeValue = Double.parseDouble(grenade_molotovgrenade.getResultList().get(0).toString());
        Query grenade_smokegrenade = entityManager.createQuery("SELECT sum(" + attribute + "_grenade_smokegrenade) FROM DataModel");
        double grenade_smokegrenadeValue = Double.parseDouble(grenade_smokegrenade.getResultList().get(0).toString());
        Query weapon_ak47 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_ak47) FROM DataModel");
        double weapon_ak47Value = Double.parseDouble(weapon_ak47.getResultList().get(0).toString());
        Query weapon_aug = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_aug) FROM DataModel");
        double weapon_augValue = Double.parseDouble(weapon_aug.getResultList().get(0).toString());
        Query weapon_awp = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_awp) FROM DataModel");
        double weapon_awpValue = Double.parseDouble(weapon_awp.getResultList().get(0).toString());
        Query weapon_bizon = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_bizon) FROM DataModel");
        double weapon_bizonValue = Double.parseDouble(weapon_bizon.getResultList().get(0).toString());
        Query weapon_cz75auto = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_cz75auto) FROM DataModel");
        double weapon_cz75autoValue = Double.parseDouble(weapon_cz75auto.getResultList().get(0).toString());
        Query weapon_deagle = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_deagle) FROM DataModel");
        double weapon_deagleValue = Double.parseDouble(weapon_deagle.getResultList().get(0).toString());
        Query weapon_elite = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_elite) FROM DataModel");
        double weapon_eliteValue = Double.parseDouble(weapon_elite.getResultList().get(0).toString());
        Query weapon_famas = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_famas) FROM DataModel");
        double weapon_famasValue = Double.parseDouble(weapon_famas.getResultList().get(0).toString());
        Query weapon_fiveseven = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_fiveseven) FROM DataModel");
        double weapon_fivesevenValue = Double.parseDouble(weapon_fiveseven.getResultList().get(0).toString());
        Query weapon_g3sg1 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_g3sg1) FROM DataModel");
        double weapon_g3sg1Value = Double.parseDouble(weapon_g3sg1.getResultList().get(0).toString());
        Query weapon_galilar = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_galilar) FROM DataModel");
        double weapon_galilarValue = Double.parseDouble(weapon_galilar.getResultList().get(0).toString());
        Query weapon_glock = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_glock) FROM DataModel");
        double weapon_glockValue = Double.parseDouble(weapon_glock.getResultList().get(0).toString());
        Query weapon_m249 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_m249) FROM DataModel");
        double weapon_m249Value = Double.parseDouble(weapon_m249.getResultList().get(0).toString());
        Query weapon_m4a1s = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_m4a1s) FROM DataModel");
        double weapon_m4a1sValue = Double.parseDouble(weapon_m4a1s.getResultList().get(0).toString());
        Query weapon_m4a4 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_m4a4) FROM DataModel");
        double weapon_m4a4Value = Double.parseDouble(weapon_m4a4.getResultList().get(0).toString());
        Query weapon_mac10 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_mac10) FROM DataModel");
        double weapon_mac10Value = Double.parseDouble(weapon_mac10.getResultList().get(0).toString());
        Query weapon_mag7 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_mag7) FROM DataModel");
        double weapon_mag7Value = Double.parseDouble(weapon_mag7.getResultList().get(0).toString());
        Query weapon_mp5sd = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_mp5sd) FROM DataModel");
        double weapon_mp5sdValue = Double.parseDouble(weapon_mp5sd.getResultList().get(0).toString());
        Query weapon_mp7 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_mp7) FROM DataModel");
        double weapon_mp7Value = Double.parseDouble(weapon_mp7.getResultList().get(0).toString());
        Query weapon_mp9 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_mp9) FROM DataModel");
        double weapon_mp9Value = Double.parseDouble(weapon_mp9.getResultList().get(0).toString());
        Query weapon_negev = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_negev) FROM DataModel");
        double weapon_negevValue = Double.parseDouble(weapon_negev.getResultList().get(0).toString());
        Query weapon_nova = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_nova) FROM DataModel");
        double weapon_novaValue = Double.parseDouble(weapon_nova.getResultList().get(0).toString());
        Query weapon_p2000 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_p2000) FROM DataModel");
        double weapon_p2000Value = Double.parseDouble(weapon_p2000.getResultList().get(0).toString());
        Query weapon_p250 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_p250) FROM DataModel");
        double weapon_p250Value = Double.parseDouble(weapon_p250.getResultList().get(0).toString());
        Query weapon_p90 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_p90) FROM DataModel");
        double weapon_p90Value = Double.parseDouble(weapon_p90.getResultList().get(0).toString());
        Query weapon_r8revolver = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_r8revolver) FROM DataModel");
        double weapon_r8revolverValue = Double.parseDouble(weapon_r8revolver.getResultList().get(0).toString());
        Query weapon_sawedoff = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_sawedoff) FROM DataModel");
        double weapon_sawedoffValue = Double.parseDouble(weapon_sawedoff.getResultList().get(0).toString());
        Query weapon_scar20 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_scar20) FROM DataModel");
        double weapon_scar20Value = Double.parseDouble(weapon_scar20.getResultList().get(0).toString());
        Query weapon_sg553 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_sg553) FROM DataModel");
        double weapon_sg553Value = Double.parseDouble(weapon_sg553.getResultList().get(0).toString());
        Query weapon_ssg08 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_ssg08) FROM DataModel");
        double weapon_ssg08Value = Double.parseDouble(weapon_ssg08.getResultList().get(0).toString());
        Query weapon_tec9 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_tec9) FROM DataModel");
        double weapon_tec9Value = Double.parseDouble(weapon_tec9.getResultList().get(0).toString());
        Query weapon_ump45 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_ump45) FROM DataModel");
        double weapon_ump45Value = Double.parseDouble(weapon_ump45.getResultList().get(0).toString());
        Query weapon_usps = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_usps) FROM DataModel");
        double weapon_uspsValue = Double.parseDouble(weapon_usps.getResultList().get(0).toString());
        Query weapon_xm1014 = entityManager.createQuery("SELECT sum(" + attribute + "_weapon_xm1014) FROM DataModel");
        double weapon_xm1014Value = Double.parseDouble(weapon_xm1014.getResultList().get(0).toString());
        //WeaponsModel weaponsModel = new WeaponsModel(grenade_decoygrenadeValue,grenade_flashbangValue,grenade_hegrenadeValue,grenade_incendiarygrenadeValue,grenade_molotovgrenadeValue,grenade_smokegrenadeValue,weapon_ak47Value,
        //         weapon_augValue,weapon_awpValue,weapon_bizonValue,weapon_cz75autoValue,weapon_deagleValue,weapon_eliteValue,weapon_famasValue,weapon_fivesevenValue,weapon_g3sg1Value,weapon_galilarValue,
        //        weapon_glockValue,weapon_m249Value,weapon_m4a1sValue, weapon_m4a4Value,weapon_mac10Value,weapon_mag7Value,weapon_mp5sdValue,weapon_mp7Value,weapon_mp9Value,weapon_negevValue,weapon_novaValue,
        //       weapon_p2000Value,weapon_p250Value,weapon_p90Value,weapon_r8revolverValue,weapon_sawedoffValue, weapon_scar20Value,weapon_sg553Value,weapon_ssg08Value,weapon_tec9Value,weapon_ump45Value,weapon_uspsValue,weapon_xm1014Value);

        JSONObject object = new JSONObject();
        List<WeaponsSimpleModel> weaponsSimpleModels = new ArrayList<>();

        weaponsSimpleModels.add(new WeaponsSimpleModel("decoygrenade", grenade_decoygrenadeValue, "decoygrenade"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("flashbang", grenade_flashbangValue, "flashbang"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("hegrenade", grenade_hegrenadeValue, "hegrenade"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("incendiarygrenade", grenade_incendiarygrenadeValue, "incendiarygrenade"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("molotovgrenade", grenade_molotovgrenadeValue, "molotovgrenade"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("smokegrenade", grenade_smokegrenadeValue, "smokegrenade"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("ak47", weapon_ak47Value, "ak47"));

        weaponsSimpleModels.add(new WeaponsSimpleModel("aug", weapon_augValue, "aug"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("awp", weapon_awpValue, "awp"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("bizon", weapon_bizonValue, "bizon"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("cz75auto", weapon_cz75autoValue, "cz75auto"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("deagle", weapon_deagleValue, "deagle"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("elite", weapon_eliteValue, "elite"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("famas", weapon_famasValue, "famas"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("fiveseven", weapon_fivesevenValue, "fiveseven"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("g3sg1", weapon_g3sg1Value, "g3sg1"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("galilar", weapon_galilarValue, "galilar"));

        weaponsSimpleModels.add(new WeaponsSimpleModel("glock", weapon_glockValue, "glock"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("m249", weapon_m249Value, "m249"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("m4a1s", weapon_m4a1sValue, "m4a1s"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("m4a4", weapon_m4a4Value, "m4a4"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("mac10", weapon_mac10Value, "mac10"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("mag7", weapon_mag7Value, "mag7"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("mp5sd", weapon_mp5sdValue, "mp5sd"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("mp7", weapon_mp7Value, "mp7"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("mp9", weapon_mp9Value, "mp9"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("negev", weapon_negevValue, "negev"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("nova", weapon_novaValue, "nova"));

        weaponsSimpleModels.add(new WeaponsSimpleModel("p2000", weapon_p2000Value, "p2000"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("p250", weapon_p250Value, "p250"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("p90", weapon_p90Value, "p90"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("r8revolver", weapon_r8revolverValue, "r8revolver"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("sawedoff", weapon_sawedoffValue, "sawedoff"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("scar20", weapon_scar20Value, "scar20"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("sg553", weapon_sg553Value, "sg553"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("ssg08", weapon_ssg08Value, "ssg08"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("tec9", weapon_tec9Value, "tec9"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("ump45", weapon_ump45Value, "ump45"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("usps", weapon_uspsValue, "usps"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("xm1014", weapon_xm1014Value, "xm1014"));

        object.appendField("jsonarray", weaponsSimpleModels);
        return new ResponseEntity<>(object, HttpStatus.OK);


    }

    @GetMapping(value = "/data/roundwinner", produces = "application/json")
    @ResponseBody
    public ResponseEntity<JSONObject> getRoundWinner() {
        JSONObject object = new JSONObject();
        Query countRecords = entityManager.createQuery("SELECT count(id) FROM DataModel");
        double countRecordsValue = Double.parseDouble(countRecords.getResultList().get(0).toString());
        Query ctWinnerRoundQuery = entityManager.createQuery("SELECT count(round_winner) FROM DataModel where  round_winner=0");
        double ctWinnerRoundValue = Double.parseDouble(ctWinnerRoundQuery.getResultList().get(0).toString());
        Query tWinnerRoundQuery = entityManager.createQuery("SELECT count(round_winner) FROM DataModel where  round_winner=1");
        double tWinnerRoundValue = Double.parseDouble(tWinnerRoundQuery.getResultList().get(0).toString());
        //   RoundWinnerModel roundWinnerModel = new RoundWinnerModel("CT","T",countRecordsValue,ctWinnerRoundValue,tWinnerRoundValue);

        List<WeaponsSimpleModel> weaponsSimpleModels = new ArrayList<>();
        weaponsSimpleModels.add(new WeaponsSimpleModel("CT", ctWinnerRoundValue, "CT"));
        weaponsSimpleModels.add(new WeaponsSimpleModel("T", tWinnerRoundValue, "T"));
        object.appendField("jsonarray", weaponsSimpleModels);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @GetMapping(value = "/data/linearregression/{attribute}/{attribute2}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<BigDecimal>> getLinearRegressionAtribute(@Valid @PathVariable String attribute, @Valid @PathVariable String attribute2) {
        Query countRecords = entityManager.createQuery("SELECT count(id) FROM DataModel");
        double countRecordsValue = Double.parseDouble(countRecords.getResultList().get(0).toString());
        List<BigDecimal> getCT_armor = dataModelRepository.getAllByct_armor();
        List<BigDecimal> getCT_playerAlive = dataModelRepository.getAllByct_players_alive();
        ArrayList<SimpleValueModel> simpleValueModels = new ArrayList<>();
        for (int i = 0; i < countRecordsValue; i++) {
            simpleValueModels.add(new SimpleValueModel(getCT_armor.get(i), getCT_playerAlive.get(i)));
        }
        return new ResponseEntity<>(getCT_armor, HttpStatus.OK);
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}