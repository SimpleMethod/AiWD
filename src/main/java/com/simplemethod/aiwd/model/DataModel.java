package com.simplemethod.aiwd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "datamodel")
public class DataModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float time_left;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_score;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_score;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private Integer map;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private Integer bomb_planted;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_health;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_health;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private double ct_armor;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_armor;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_money;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_money;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_helmets;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_helmets;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_defuse_kits;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_players_alive;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_players_alive;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_ak47;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_ak47;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_aug;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_aug;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_awp;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_awp;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_bizon;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_bizon;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_cz75auto;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_cz75auto;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_elite;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_elite;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_famas;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_famas;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_g3sg1;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_g3sg1;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_galilar;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_galilar;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_glock;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_glock;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_m249;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_m249;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_m4a1s;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_m4a1s;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_m4a4;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_m4a4;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_mac10;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_mac10;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_mag7;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_mag7;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_mp5sd;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_mp5sd;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_mp7;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_mp7;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_mp9;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_mp9;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_negev;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_negev;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_nova;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_nova;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_p90;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_p90;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_r8revolver;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_r8revolver;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_sawedoff;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_sawedoff;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_scar20;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_scar20;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_sg553;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_sg553;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_ssg08;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_ssg08;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_ump45;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_ump45;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_xm1014;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_xm1014;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_deagle;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_deagle;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_fiveseven;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_fiveseven;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_usps;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_usps;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_p250;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_p250;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_p2000;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_p2000;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_weapon_tec9;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_weapon_tec9;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_grenade_hegrenade;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_grenade_hegrenade;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_grenade_flashbang;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_grenade_flashbang;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_grenade_smokegrenade;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_grenade_smokegrenade;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_grenade_incendiarygrenade;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_grenade_incendiarygrenade;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_grenade_molotovgrenade;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_grenade_molotovgrenade;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float ct_grenade_decoygrenade;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private float t_grenade_decoygrenade;
    @Column(columnDefinition="FLOAT(20)", unique = false, nullable = false)
    private Integer round_winner;

    public DataModel(){
        super();
    }

    public DataModel(Long id, float time_left, float ct_score, float t_score, Integer map, Integer bomb_planted, float ct_health, float t_health, double ct_armor, float t_armor, float ct_money, float t_money, float ct_helmets, float t_helmets, float ct_defuse_kits, float ct_players_alive, float t_players_alive, float ct_weapon_ak47, float t_weapon_ak47, float ct_weapon_aug, float t_weapon_aug, float ct_weapon_awp, float t_weapon_awp, float ct_weapon_bizon, float t_weapon_bizon, float ct_weapon_cz75auto, float t_weapon_cz75auto, float ct_weapon_elite, float t_weapon_elite, float ct_weapon_famas, float t_weapon_famas, float ct_weapon_g3sg1, float t_weapon_g3sg1, float ct_weapon_galilar, float t_weapon_galilar, float ct_weapon_glock, float t_weapon_glock, float ct_weapon_m249, float t_weapon_m249, float ct_weapon_m4a1s, float t_weapon_m4a1s, float ct_weapon_m4a4, float t_weapon_m4a4, float ct_weapon_mac10, float t_weapon_mac10, float ct_weapon_mag7, float t_weapon_mag7, float ct_weapon_mp5sd, float t_weapon_mp5sd, float ct_weapon_mp7, float t_weapon_mp7, float ct_weapon_mp9, float t_weapon_mp9, float ct_weapon_negev, float t_weapon_negev, float ct_weapon_nova, float t_weapon_nova, float ct_weapon_p90, float t_weapon_p90, float ct_weapon_r8revolver, float t_weapon_r8revolver, float ct_weapon_sawedoff, float t_weapon_sawedoff, float ct_weapon_scar20, float t_weapon_scar20, float ct_weapon_sg553, float t_weapon_sg553, float ct_weapon_ssg08, float t_weapon_ssg08, float ct_weapon_ump45, float t_weapon_ump45, float ct_weapon_xm1014, float t_weapon_xm1014, float ct_weapon_deagle, float t_weapon_deagle, float ct_weapon_fiveseven, float t_weapon_fiveseven, float ct_weapon_usps, float t_weapon_usps, float ct_weapon_p250, float t_weapon_p250, float ct_weapon_p2000, float t_weapon_p2000, float ct_weapon_tec9, float t_weapon_tec9, float ct_grenade_hegrenade, float t_grenade_hegrenade, float ct_grenade_flashbang, float t_grenade_flashbang, float ct_grenade_smokegrenade, float t_grenade_smokegrenade, float ct_grenade_incendiarygrenade, float t_grenade_incendiarygrenade, float ct_grenade_molotovgrenade, float t_grenade_molotovgrenade, float ct_grenade_decoygrenade, float t_grenade_decoygrenade, Integer round_winner) {
        this.id = id;
        this.time_left = time_left;
        this.ct_score = ct_score;
        this.t_score = t_score;
        this.map = map;
        this.bomb_planted = bomb_planted;
        this.ct_health = ct_health;
        this.t_health = t_health;
        this.ct_armor = ct_armor;
        this.t_armor = t_armor;
        this.ct_money = ct_money;
        this.t_money = t_money;
        this.ct_helmets = ct_helmets;
        this.t_helmets = t_helmets;
        this.ct_defuse_kits = ct_defuse_kits;
        this.ct_players_alive = ct_players_alive;
        this.t_players_alive = t_players_alive;
        this.ct_weapon_ak47 = ct_weapon_ak47;
        this.t_weapon_ak47 = t_weapon_ak47;
        this.ct_weapon_aug = ct_weapon_aug;
        this.t_weapon_aug = t_weapon_aug;
        this.ct_weapon_awp = ct_weapon_awp;
        this.t_weapon_awp = t_weapon_awp;
        this.ct_weapon_bizon = ct_weapon_bizon;
        this.t_weapon_bizon = t_weapon_bizon;
        this.ct_weapon_cz75auto = ct_weapon_cz75auto;
        this.t_weapon_cz75auto = t_weapon_cz75auto;
        this.ct_weapon_elite = ct_weapon_elite;
        this.t_weapon_elite = t_weapon_elite;
        this.ct_weapon_famas = ct_weapon_famas;
        this.t_weapon_famas = t_weapon_famas;
        this.ct_weapon_g3sg1 = ct_weapon_g3sg1;
        this.t_weapon_g3sg1 = t_weapon_g3sg1;
        this.ct_weapon_galilar = ct_weapon_galilar;
        this.t_weapon_galilar = t_weapon_galilar;
        this.ct_weapon_glock = ct_weapon_glock;
        this.t_weapon_glock = t_weapon_glock;
        this.ct_weapon_m249 = ct_weapon_m249;
        this.t_weapon_m249 = t_weapon_m249;
        this.ct_weapon_m4a1s = ct_weapon_m4a1s;
        this.t_weapon_m4a1s = t_weapon_m4a1s;
        this.ct_weapon_m4a4 = ct_weapon_m4a4;
        this.t_weapon_m4a4 = t_weapon_m4a4;
        this.ct_weapon_mac10 = ct_weapon_mac10;
        this.t_weapon_mac10 = t_weapon_mac10;
        this.ct_weapon_mag7 = ct_weapon_mag7;
        this.t_weapon_mag7 = t_weapon_mag7;
        this.ct_weapon_mp5sd = ct_weapon_mp5sd;
        this.t_weapon_mp5sd = t_weapon_mp5sd;
        this.ct_weapon_mp7 = ct_weapon_mp7;
        this.t_weapon_mp7 = t_weapon_mp7;
        this.ct_weapon_mp9 = ct_weapon_mp9;
        this.t_weapon_mp9 = t_weapon_mp9;
        this.ct_weapon_negev = ct_weapon_negev;
        this.t_weapon_negev = t_weapon_negev;
        this.ct_weapon_nova = ct_weapon_nova;
        this.t_weapon_nova = t_weapon_nova;
        this.ct_weapon_p90 = ct_weapon_p90;
        this.t_weapon_p90 = t_weapon_p90;
        this.ct_weapon_r8revolver = ct_weapon_r8revolver;
        this.t_weapon_r8revolver = t_weapon_r8revolver;
        this.ct_weapon_sawedoff = ct_weapon_sawedoff;
        this.t_weapon_sawedoff = t_weapon_sawedoff;
        this.ct_weapon_scar20 = ct_weapon_scar20;
        this.t_weapon_scar20 = t_weapon_scar20;
        this.ct_weapon_sg553 = ct_weapon_sg553;
        this.t_weapon_sg553 = t_weapon_sg553;
        this.ct_weapon_ssg08 = ct_weapon_ssg08;
        this.t_weapon_ssg08 = t_weapon_ssg08;
        this.ct_weapon_ump45 = ct_weapon_ump45;
        this.t_weapon_ump45 = t_weapon_ump45;
        this.ct_weapon_xm1014 = ct_weapon_xm1014;
        this.t_weapon_xm1014 = t_weapon_xm1014;
        this.ct_weapon_deagle = ct_weapon_deagle;
        this.t_weapon_deagle = t_weapon_deagle;
        this.ct_weapon_fiveseven = ct_weapon_fiveseven;
        this.t_weapon_fiveseven = t_weapon_fiveseven;
        this.ct_weapon_usps = ct_weapon_usps;
        this.t_weapon_usps = t_weapon_usps;
        this.ct_weapon_p250 = ct_weapon_p250;
        this.t_weapon_p250 = t_weapon_p250;
        this.ct_weapon_p2000 = ct_weapon_p2000;
        this.t_weapon_p2000 = t_weapon_p2000;
        this.ct_weapon_tec9 = ct_weapon_tec9;
        this.t_weapon_tec9 = t_weapon_tec9;
        this.ct_grenade_hegrenade = ct_grenade_hegrenade;
        this.t_grenade_hegrenade = t_grenade_hegrenade;
        this.ct_grenade_flashbang = ct_grenade_flashbang;
        this.t_grenade_flashbang = t_grenade_flashbang;
        this.ct_grenade_smokegrenade = ct_grenade_smokegrenade;
        this.t_grenade_smokegrenade = t_grenade_smokegrenade;
        this.ct_grenade_incendiarygrenade = ct_grenade_incendiarygrenade;
        this.t_grenade_incendiarygrenade = t_grenade_incendiarygrenade;
        this.ct_grenade_molotovgrenade = ct_grenade_molotovgrenade;
        this.t_grenade_molotovgrenade = t_grenade_molotovgrenade;
        this.ct_grenade_decoygrenade = ct_grenade_decoygrenade;
        this.t_grenade_decoygrenade = t_grenade_decoygrenade;
        this.round_winner = round_winner;
    }

    public DataModel(float time_left, float ct_score, float t_score, Integer map, Integer bomb_planted, float ct_health, float t_health, float ct_armor, float t_armor, float ct_money, float t_money, float ct_helmets, float t_helmets, float ct_defuse_kits, float ct_players_alive, float t_players_alive, float ct_weapon_ak47, float t_weapon_ak47, float ct_weapon_aug, float t_weapon_aug, float ct_weapon_awp, float t_weapon_awp, float ct_weapon_bizon, float t_weapon_bizon, float ct_weapon_cz75auto, float t_weapon_cz75auto, float ct_weapon_elite, float t_weapon_elite, float ct_weapon_famas, float t_weapon_famas, float ct_weapon_g3sg1, float t_weapon_g3sg1, float ct_weapon_galilar, float t_weapon_galilar, float ct_weapon_glock, float t_weapon_glock, float ct_weapon_m249, float t_weapon_m249, float ct_weapon_m4a1s, float t_weapon_m4a1s, float ct_weapon_m4a4, float t_weapon_m4a4, float ct_weapon_mac10, float t_weapon_mac10, float ct_weapon_mag7, float t_weapon_mag7, float ct_weapon_mp5sd, float t_weapon_mp5sd, float ct_weapon_mp7, float t_weapon_mp7, float ct_weapon_mp9, float t_weapon_mp9, float ct_weapon_negev, float t_weapon_negev, float ct_weapon_nova, float t_weapon_nova, float ct_weapon_p90, float t_weapon_p90, float ct_weapon_r8revolver, float t_weapon_r8revolver, float ct_weapon_sawedoff, float t_weapon_sawedoff, float ct_weapon_scar20, float t_weapon_scar20, float ct_weapon_sg553, float t_weapon_sg553, float ct_weapon_ssg08, float t_weapon_ssg08, float ct_weapon_ump45, float t_weapon_ump45, float ct_weapon_xm1014, float t_weapon_xm1014, float ct_weapon_deagle, float t_weapon_deagle, float ct_weapon_fiveseven, float t_weapon_fiveseven, float ct_weapon_usps, float t_weapon_usps, float ct_weapon_p250, float t_weapon_p250, float ct_weapon_p2000, float t_weapon_p2000, float ct_weapon_tec9, float t_weapon_tec9, float ct_grenade_hegrenade, float t_grenade_hegrenade, float ct_grenade_flashbang, float t_grenade_flashbang, float ct_grenade_smokegrenade, float t_grenade_smokegrenade, float ct_grenade_incendiarygrenade, float t_grenade_incendiarygrenade, float ct_grenade_molotovgrenade, float t_grenade_molotovgrenade, float ct_grenade_decoygrenade, float t_grenade_decoygrenade, Integer round_winner) {
        this.time_left = time_left;
        this.ct_score = ct_score;
        this.t_score = t_score;
        this.map = map;
        this.bomb_planted = bomb_planted;
        this.ct_health = ct_health;
        this.t_health = t_health;
        this.ct_armor = ct_armor;
        this.t_armor = t_armor;
        this.ct_money = ct_money;
        this.t_money = t_money;
        this.ct_helmets = ct_helmets;
        this.t_helmets = t_helmets;
        this.ct_defuse_kits = ct_defuse_kits;
        this.ct_players_alive = ct_players_alive;
        this.t_players_alive = t_players_alive;
        this.ct_weapon_ak47 = ct_weapon_ak47;
        this.t_weapon_ak47 = t_weapon_ak47;
        this.ct_weapon_aug = ct_weapon_aug;
        this.t_weapon_aug = t_weapon_aug;
        this.ct_weapon_awp = ct_weapon_awp;
        this.t_weapon_awp = t_weapon_awp;
        this.ct_weapon_bizon = ct_weapon_bizon;
        this.t_weapon_bizon = t_weapon_bizon;
        this.ct_weapon_cz75auto = ct_weapon_cz75auto;
        this.t_weapon_cz75auto = t_weapon_cz75auto;
        this.ct_weapon_elite = ct_weapon_elite;
        this.t_weapon_elite = t_weapon_elite;
        this.ct_weapon_famas = ct_weapon_famas;
        this.t_weapon_famas = t_weapon_famas;
        this.ct_weapon_g3sg1 = ct_weapon_g3sg1;
        this.t_weapon_g3sg1 = t_weapon_g3sg1;
        this.ct_weapon_galilar = ct_weapon_galilar;
        this.t_weapon_galilar = t_weapon_galilar;
        this.ct_weapon_glock = ct_weapon_glock;
        this.t_weapon_glock = t_weapon_glock;
        this.ct_weapon_m249 = ct_weapon_m249;
        this.t_weapon_m249 = t_weapon_m249;
        this.ct_weapon_m4a1s = ct_weapon_m4a1s;
        this.t_weapon_m4a1s = t_weapon_m4a1s;
        this.ct_weapon_m4a4 = ct_weapon_m4a4;
        this.t_weapon_m4a4 = t_weapon_m4a4;
        this.ct_weapon_mac10 = ct_weapon_mac10;
        this.t_weapon_mac10 = t_weapon_mac10;
        this.ct_weapon_mag7 = ct_weapon_mag7;
        this.t_weapon_mag7 = t_weapon_mag7;
        this.ct_weapon_mp5sd = ct_weapon_mp5sd;
        this.t_weapon_mp5sd = t_weapon_mp5sd;
        this.ct_weapon_mp7 = ct_weapon_mp7;
        this.t_weapon_mp7 = t_weapon_mp7;
        this.ct_weapon_mp9 = ct_weapon_mp9;
        this.t_weapon_mp9 = t_weapon_mp9;
        this.ct_weapon_negev = ct_weapon_negev;
        this.t_weapon_negev = t_weapon_negev;
        this.ct_weapon_nova = ct_weapon_nova;
        this.t_weapon_nova = t_weapon_nova;
        this.ct_weapon_p90 = ct_weapon_p90;
        this.t_weapon_p90 = t_weapon_p90;
        this.ct_weapon_r8revolver = ct_weapon_r8revolver;
        this.t_weapon_r8revolver = t_weapon_r8revolver;
        this.ct_weapon_sawedoff = ct_weapon_sawedoff;
        this.t_weapon_sawedoff = t_weapon_sawedoff;
        this.ct_weapon_scar20 = ct_weapon_scar20;
        this.t_weapon_scar20 = t_weapon_scar20;
        this.ct_weapon_sg553 = ct_weapon_sg553;
        this.t_weapon_sg553 = t_weapon_sg553;
        this.ct_weapon_ssg08 = ct_weapon_ssg08;
        this.t_weapon_ssg08 = t_weapon_ssg08;
        this.ct_weapon_ump45 = ct_weapon_ump45;
        this.t_weapon_ump45 = t_weapon_ump45;
        this.ct_weapon_xm1014 = ct_weapon_xm1014;
        this.t_weapon_xm1014 = t_weapon_xm1014;
        this.ct_weapon_deagle = ct_weapon_deagle;
        this.t_weapon_deagle = t_weapon_deagle;
        this.ct_weapon_fiveseven = ct_weapon_fiveseven;
        this.t_weapon_fiveseven = t_weapon_fiveseven;
        this.ct_weapon_usps = ct_weapon_usps;
        this.t_weapon_usps = t_weapon_usps;
        this.ct_weapon_p250 = ct_weapon_p250;
        this.t_weapon_p250 = t_weapon_p250;
        this.ct_weapon_p2000 = ct_weapon_p2000;
        this.t_weapon_p2000 = t_weapon_p2000;
        this.ct_weapon_tec9 = ct_weapon_tec9;
        this.t_weapon_tec9 = t_weapon_tec9;
        this.ct_grenade_hegrenade = ct_grenade_hegrenade;
        this.t_grenade_hegrenade = t_grenade_hegrenade;
        this.ct_grenade_flashbang = ct_grenade_flashbang;
        this.t_grenade_flashbang = t_grenade_flashbang;
        this.ct_grenade_smokegrenade = ct_grenade_smokegrenade;
        this.t_grenade_smokegrenade = t_grenade_smokegrenade;
        this.ct_grenade_incendiarygrenade = ct_grenade_incendiarygrenade;
        this.t_grenade_incendiarygrenade = t_grenade_incendiarygrenade;
        this.ct_grenade_molotovgrenade = ct_grenade_molotovgrenade;
        this.t_grenade_molotovgrenade = t_grenade_molotovgrenade;
        this.ct_grenade_decoygrenade = ct_grenade_decoygrenade;
        this.t_grenade_decoygrenade = t_grenade_decoygrenade;
        this.round_winner = round_winner;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "id=" + id +
                ", time_left=" + time_left +
                ", ct_score=" + ct_score +
                ", t_score=" + t_score +
                ", map=" + map +
                ", bomb_planted=" + bomb_planted +
                ", ct_health=" + ct_health +
                ", t_health=" + t_health +
                ", ct_armor=" + ct_armor +
                ", t_armor=" + t_armor +
                ", ct_money=" + ct_money +
                ", t_money=" + t_money +
                ", ct_helmets=" + ct_helmets +
                ", t_helmets=" + t_helmets +
                ", ct_defuse_kits=" + ct_defuse_kits +
                ", ct_players_alive=" + ct_players_alive +
                ", t_players_alive=" + t_players_alive +
                ", ct_weapon_ak47=" + ct_weapon_ak47 +
                ", t_weapon_ak47=" + t_weapon_ak47 +
                ", ct_weapon_aug=" + ct_weapon_aug +
                ", t_weapon_aug=" + t_weapon_aug +
                ", ct_weapon_awp=" + ct_weapon_awp +
                ", t_weapon_awp=" + t_weapon_awp +
                ", ct_weapon_bizon=" + ct_weapon_bizon +
                ", t_weapon_bizon=" + t_weapon_bizon +
                ", ct_weapon_cz75auto=" + ct_weapon_cz75auto +
                ", t_weapon_cz75auto=" + t_weapon_cz75auto +
                ", ct_weapon_elite=" + ct_weapon_elite +
                ", t_weapon_elite=" + t_weapon_elite +
                ", ct_weapon_famas=" + ct_weapon_famas +
                ", t_weapon_famas=" + t_weapon_famas +
                ", ct_weapon_g3sg1=" + ct_weapon_g3sg1 +
                ", t_weapon_g3sg1=" + t_weapon_g3sg1 +
                ", ct_weapon_galilar=" + ct_weapon_galilar +
                ", t_weapon_galilar=" + t_weapon_galilar +
                ", ct_weapon_glock=" + ct_weapon_glock +
                ", t_weapon_glock=" + t_weapon_glock +
                ", ct_weapon_m249=" + ct_weapon_m249 +
                ", t_weapon_m249=" + t_weapon_m249 +
                ", ct_weapon_m4a1s=" + ct_weapon_m4a1s +
                ", t_weapon_m4a1s=" + t_weapon_m4a1s +
                ", ct_weapon_m4a4=" + ct_weapon_m4a4 +
                ", t_weapon_m4a4=" + t_weapon_m4a4 +
                ", ct_weapon_mac10=" + ct_weapon_mac10 +
                ", t_weapon_mac10=" + t_weapon_mac10 +
                ", ct_weapon_mag7=" + ct_weapon_mag7 +
                ", t_weapon_mag7=" + t_weapon_mag7 +
                ", ct_weapon_mp5sd=" + ct_weapon_mp5sd +
                ", t_weapon_mp5sd=" + t_weapon_mp5sd +
                ", ct_weapon_mp7=" + ct_weapon_mp7 +
                ", t_weapon_mp7=" + t_weapon_mp7 +
                ", ct_weapon_mp9=" + ct_weapon_mp9 +
                ", t_weapon_mp9=" + t_weapon_mp9 +
                ", ct_weapon_negev=" + ct_weapon_negev +
                ", t_weapon_negev=" + t_weapon_negev +
                ", ct_weapon_nova=" + ct_weapon_nova +
                ", t_weapon_nova=" + t_weapon_nova +
                ", ct_weapon_p90=" + ct_weapon_p90 +
                ", t_weapon_p90=" + t_weapon_p90 +
                ", ct_weapon_r8revolver=" + ct_weapon_r8revolver +
                ", t_weapon_r8revolver=" + t_weapon_r8revolver +
                ", ct_weapon_sawedoff=" + ct_weapon_sawedoff +
                ", t_weapon_sawedoff=" + t_weapon_sawedoff +
                ", ct_weapon_scar20=" + ct_weapon_scar20 +
                ", t_weapon_scar20=" + t_weapon_scar20 +
                ", ct_weapon_sg553=" + ct_weapon_sg553 +
                ", t_weapon_sg553=" + t_weapon_sg553 +
                ", ct_weapon_ssg08=" + ct_weapon_ssg08 +
                ", t_weapon_ssg08=" + t_weapon_ssg08 +
                ", ct_weapon_ump45=" + ct_weapon_ump45 +
                ", t_weapon_ump45=" + t_weapon_ump45 +
                ", ct_weapon_xm1014=" + ct_weapon_xm1014 +
                ", t_weapon_xm1014=" + t_weapon_xm1014 +
                ", ct_weapon_deagle=" + ct_weapon_deagle +
                ", t_weapon_deagle=" + t_weapon_deagle +
                ", ct_weapon_fiveseven=" + ct_weapon_fiveseven +
                ", t_weapon_fiveseven=" + t_weapon_fiveseven +
                ", ct_weapon_usps=" + ct_weapon_usps +
                ", t_weapon_usps=" + t_weapon_usps +
                ", ct_weapon_p250=" + ct_weapon_p250 +
                ", t_weapon_p250=" + t_weapon_p250 +
                ", ct_weapon_p2000=" + ct_weapon_p2000 +
                ", t_weapon_p2000=" + t_weapon_p2000 +
                ", ct_weapon_tec9=" + ct_weapon_tec9 +
                ", t_weapon_tec9=" + t_weapon_tec9 +
                ", ct_grenade_hegrenade=" + ct_grenade_hegrenade +
                ", t_grenade_hegrenade=" + t_grenade_hegrenade +
                ", ct_grenade_flashbang=" + ct_grenade_flashbang +
                ", t_grenade_flashbang=" + t_grenade_flashbang +
                ", ct_grenade_smokegrenade=" + ct_grenade_smokegrenade +
                ", t_grenade_smokegrenade=" + t_grenade_smokegrenade +
                ", ct_grenade_incendiarygrenade=" + ct_grenade_incendiarygrenade +
                ", t_grenade_incendiarygrenade=" + t_grenade_incendiarygrenade +
                ", ct_grenade_molotovgrenade=" + ct_grenade_molotovgrenade +
                ", t_grenade_molotovgrenade=" + t_grenade_molotovgrenade +
                ", ct_grenade_decoygrenade=" + ct_grenade_decoygrenade +
                ", t_grenade_decoygrenade=" + t_grenade_decoygrenade +
                ", round_winner=" + round_winner +
                '}';
    }
}
