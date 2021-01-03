package com.simplemethod.aiwd.services;

import org.springframework.stereotype.Service;

@Service
public class CleanerService {
    private final String[] memberFieldsToBindTo = {"time_left", "ct_score", "t_score", "map", "bomb_planted", "ct_health", "t_health", "ct_armor", "t_armor", "ct_money", "t_money", "ct_helmets", "t_helmets", "ct_defuse_kits", "ct_players_alive", "t_players_alive", "ct_weapon_ak47", "t_weapon_ak47", "ct_weapon_aug", "t_weapon_aug", "ct_weapon_awp", "t_weapon_awp", "ct_weapon_bizon", "t_weapon_bizon", "ct_weapon_cz75auto", "t_weapon_cz75auto", "ct_weapon_elite", "t_weapon_elite", "ct_weapon_famas", "t_weapon_famas", "ct_weapon_g3sg1", "t_weapon_g3sg1", "ct_weapon_galilar", "t_weapon_galilar", "ct_weapon_glock", "t_weapon_glock", "ct_weapon_m249", "t_weapon_m249", "ct_weapon_m4a1s", "t_weapon_m4a1s", "ct_weapon_m4a4", "t_weapon_m4a4", "ct_weapon_mac10", "t_weapon_mac10", "ct_weapon_mag7", "t_weapon_mag7", "ct_weapon_mp5sd", "t_weapon_mp5sd", "ct_weapon_mp7", "t_weapon_mp7", "ct_weapon_mp9", "t_weapon_mp9", "ct_weapon_negev", "t_weapon_negev", "ct_weapon_nova", "t_weapon_nova", "ct_weapon_p90", "t_weapon_p90", "ct_weapon_r8revolver", "t_weapon_r8revolver", "ct_weapon_sawedoff", "t_weapon_sawedoff", "ct_weapon_scar20", "t_weapon_scar20", "ct_weapon_sg553", "t_weapon_sg553", "ct_weapon_ssg08", "t_weapon_ssg08", "ct_weapon_ump45", "t_weapon_ump45", "ct_weapon_xm1014", "t_weapon_xm1014", "ct_weapon_deagle", "t_weapon_deagle", "ct_weapon_fiveseven", "t_weapon_fiveseven", "ct_weapon_usps", "t_weapon_usps", "ct_weapon_p250", "t_weapon_p250", "ct_weapon_p2000", "t_weapon_p2000", "ct_weapon_tec9", "t_weapon_tec9", "ct_grenade_hegrenade", "t_grenade_hegrenade", "ct_grenade_flashbang", "t_grenade_flashbang", "ct_grenade_smokegrenade", "t_grenade_smokegrenade", "ct_grenade_incendiarygrenade", "t_grenade_incendiarygrenade", "ct_grenade_molotovgrenade", "t_grenade_molotovgrenade", "ct_grenade_decoygrenade", "t_grenade_decoygrenade", "round_winner"};
    private final String[] site = {"ct", "t"};

    /**
     * Sprawdza poprawność danych
     *
     * @param args argument wyjściowy
     * @return prawda albo fałsz
     */
    public boolean checkArgs(String args) {
        for (String elements : memberFieldsToBindTo) {
            if (elements.equals(args)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sprawdza poprawność danych
     *
     * @param args argument wyjściowy
     * @return prawda albo fałsz
     */
    public boolean checkArgsSite(String args) {
        for (String elements : site) {
            if (elements.equals(args)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sprawdza czy wartość jest liczbą i jest w podanym zakresie
     *
     * @param args       argument do sprawdzenia
     * @param startRange początkowy zakres
     * @param endRange   końcowy zakres
     * @return status operacji
     */
    public boolean checkInteger(Integer args, Integer startRange, Integer endRange) {
        return args >= startRange && args <= endRange;
    }

    /**
     * Sprawdza czy wartość jest liczbą i jest w podanym zakresie
     *
     * @param args       argument do sprawdzenia
     * @param startRange początkowy zakres
     * @param endRange   końcowy zakres
     * @return status operacji
     */
    public boolean checkFloat(Float args, Float startRange, Float endRange) {
        return args >= startRange && args <= endRange;
    }
}