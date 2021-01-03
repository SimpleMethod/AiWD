package com.simplemethod.aiwd.reader;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.simplemethod.aiwd.model.CSVDataModel;
import com.simplemethod.aiwd.model.DataModel;
import com.simplemethod.aiwd.repository.DataModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Component
public class FileReader {

    @Autowired
    DataModelRepository dataModelRepository;


    final HashMap<String, Integer> maps = new HashMap<String, Integer>() {{
        put("de_cache", 1);
        put("de_dust2", 2);
        put("de_inferno", 3);
        put("de_mirage", 4);
        put("de_nuke", 5);
        put("de_overpass", 6);
        put("de_train", 7);
        put("de_vertigo", 8);
    }};

    final HashMap<String, Integer> side = new HashMap<String, Integer>() {{
        put("T", 1);
        put("CT", 0);
    }};

    /**
     * Parsuje dane i dodaje je do bazy danych
     *
     * @param path ścieżka do pliku csv
     * @throws IOException
     */
    public void ParseData(String path) throws IOException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(path));
        ) {
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(CSVDataModel.class);
            String[] memberFieldsToBindTo = {"time_left", "ct_score", "t_score", "map", "bomb_planted", "ct_health", "t_health", "ct_armor", "t_armor", "ct_money", "t_money", "ct_helmets", "t_helmets", "ct_defuse_kits", "ct_players_alive", "t_players_alive", "ct_weapon_ak47", "t_weapon_ak47", "ct_weapon_aug", "t_weapon_aug", "ct_weapon_awp", "t_weapon_awp", "ct_weapon_bizon", "t_weapon_bizon", "ct_weapon_cz75auto", "t_weapon_cz75auto", "ct_weapon_elite", "t_weapon_elite", "ct_weapon_famas", "t_weapon_famas", "ct_weapon_g3sg1", "t_weapon_g3sg1", "ct_weapon_galilar", "t_weapon_galilar", "ct_weapon_glock", "t_weapon_glock", "ct_weapon_m249", "t_weapon_m249", "ct_weapon_m4a1s", "t_weapon_m4a1s", "ct_weapon_m4a4", "t_weapon_m4a4", "ct_weapon_mac10", "t_weapon_mac10", "ct_weapon_mag7", "t_weapon_mag7", "ct_weapon_mp5sd", "t_weapon_mp5sd", "ct_weapon_mp7", "t_weapon_mp7", "ct_weapon_mp9", "t_weapon_mp9", "ct_weapon_negev", "t_weapon_negev", "ct_weapon_nova", "t_weapon_nova", "ct_weapon_p90", "t_weapon_p90", "ct_weapon_r8revolver", "t_weapon_r8revolver", "ct_weapon_sawedoff", "t_weapon_sawedoff", "ct_weapon_scar20", "t_weapon_scar20", "ct_weapon_sg553", "t_weapon_sg553", "ct_weapon_ssg08", "t_weapon_ssg08", "ct_weapon_ump45", "t_weapon_ump45", "ct_weapon_xm1014", "t_weapon_xm1014", "ct_weapon_deagle", "t_weapon_deagle", "ct_weapon_fiveseven", "t_weapon_fiveseven", "ct_weapon_usps", "t_weapon_usps", "ct_weapon_p250", "t_weapon_p250", "ct_weapon_p2000", "t_weapon_p2000", "ct_weapon_tec9", "t_weapon_tec9", "ct_grenade_hegrenade", "t_grenade_hegrenade", "ct_grenade_flashbang", "t_grenade_flashbang", "ct_grenade_smokegrenade", "t_grenade_smokegrenade", "ct_grenade_incendiarygrenade", "t_grenade_incendiarygrenade", "ct_grenade_molotovgrenade", "t_grenade_molotovgrenade", "ct_grenade_decoygrenade", "t_grenade_decoygrenade", "round_winner"};
            strategy.setColumnMapping(memberFieldsToBindTo);

            CsvToBean csvToBean = new CsvToBeanBuilder(reader).withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVDataModel> myUserIterator = csvToBean.iterator();
            long xd = 0;
            while (myUserIterator.hasNext()) {
                CSVDataModel dataModel = myUserIterator.next();
                Integer map = maps.get(dataModel.getMap());
                Integer round_winner = side.get(dataModel.getRound_winner());
                int bomb_planted = dataModel.isBomb_planted() ? 1 : 0;
                DataModel dataModel1 = new DataModel(dataModel.getTime_left(), dataModel.getCt_score(), dataModel.getT_score(), map, bomb_planted, dataModel.getCt_health(),
                        dataModel.getT_health(), dataModel.getCt_armor(), dataModel.getT_armor(), dataModel.getCt_money(), dataModel.getT_money(), dataModel.getCt_helmets(),
                        dataModel.getT_helmets(), dataModel.getCt_defuse_kits(), dataModel.getCt_players_alive(), dataModel.getT_players_alive(), dataModel.getCt_weapon_ak47(),
                        dataModel.getT_weapon_ak47(), dataModel.getCt_weapon_aug(), dataModel.getT_weapon_aug(), dataModel.getCt_weapon_awp(), dataModel.getT_weapon_awp(),
                        dataModel.getCt_weapon_bizon(), dataModel.getT_weapon_bizon(), dataModel.getCt_weapon_cz75auto(), dataModel.getT_weapon_cz75auto(), dataModel.getCt_weapon_elite(),
                        dataModel.getT_weapon_elite(), dataModel.getCt_weapon_famas(), dataModel.getT_weapon_famas(), dataModel.getCt_weapon_g3sg1(), dataModel.getT_weapon_g3sg1(),
                        dataModel.getCt_weapon_galilar(), dataModel.getT_weapon_galilar(), dataModel.getCt_weapon_glock(), dataModel.getT_weapon_glock(), dataModel.getCt_weapon_m249(),
                        dataModel.getT_weapon_m249(), dataModel.getCt_weapon_m4a1s(), dataModel.getT_weapon_m4a1s(), dataModel.getCt_weapon_m4a4(), dataModel.getT_weapon_m4a4(),
                        dataModel.getCt_weapon_mac10(), dataModel.getT_weapon_mac10(), dataModel.getCt_weapon_mag7(), dataModel.getT_weapon_mag7(), dataModel.getCt_weapon_mp5sd(),
                        dataModel.getT_weapon_mp5sd(), dataModel.getCt_weapon_mp7(), dataModel.getT_weapon_mp7(), dataModel.getCt_weapon_mp9(), dataModel.getT_weapon_mp9(),
                        dataModel.getCt_weapon_negev(), dataModel.getT_weapon_negev(), dataModel.getCt_weapon_nova(), dataModel.getT_weapon_nova(), dataModel.getCt_weapon_p90(),
                        dataModel.getT_weapon_p90(), dataModel.getCt_weapon_r8revolver(), dataModel.getT_weapon_r8revolver(), dataModel.getCt_weapon_sawedoff(), dataModel.getT_weapon_sawedoff(),
                        dataModel.getCt_weapon_scar20(), dataModel.getT_weapon_scar20(), dataModel.getCt_weapon_sg553(), dataModel.getT_weapon_sg553(), dataModel.getCt_weapon_ssg08(),
                        dataModel.getT_weapon_ssg08(), dataModel.getCt_weapon_ump45(), dataModel.getT_weapon_ump45(), dataModel.getCt_weapon_xm1014(), dataModel.getT_weapon_xm1014(),
                        dataModel.getCt_weapon_deagle(), dataModel.getT_weapon_deagle(), dataModel.getCt_weapon_fiveseven(), dataModel.getT_weapon_fiveseven(), dataModel.getCt_weapon_usps(),
                        dataModel.getT_weapon_usps(), dataModel.getCt_weapon_p250(), dataModel.getT_weapon_p250(), dataModel.getCt_weapon_p2000(), dataModel.getT_weapon_p2000(),
                        dataModel.getCt_weapon_tec9(), dataModel.getT_weapon_tec9(), dataModel.getCt_grenade_hegrenade(), dataModel.getT_grenade_hegrenade(), dataModel.getCt_grenade_flashbang(),
                        dataModel.getT_grenade_flashbang(), dataModel.getCt_grenade_smokegrenade(), dataModel.getT_grenade_smokegrenade(), dataModel.getCt_grenade_incendiarygrenade(),
                        dataModel.getT_grenade_incendiarygrenade(), dataModel.getCt_grenade_molotovgrenade(), dataModel.getT_grenade_molotovgrenade(), dataModel.getCt_grenade_decoygrenade(),
                        dataModel.getT_grenade_decoygrenade(), round_winner);
                System.out.println(dataModel1.toString());
                dataModelRepository.save(dataModel1);
                System.out.print(".");
            }
        }
    }
}

