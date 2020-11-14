package com.simplemethod.aiwd.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "attributes","grenade_decoygrenade","grenade_flashbang","grenade_hegrenade","grenade_incendiarygrenade","grenade_molotovgrenade","grenade_smokegrenade","weapon_ak47","weapon_aug","weapon_awp",
        "weapon_bizon","weapon_cz75auto","weapon_deagle","weapon_elite","weapon_famas","weapon_fiveseven","weapon_g3sg1","weapon_galilar","weapon_glock","weapon_m249","weapon_m4a1s","weapon_m4a4","weapon_mac10",
        "weapon_mag7","weapon_mp5sd","weapon_mp7","weapon_mp9","weapon_negev","weapon_nova","weapon_p2000","weapon_p250","weapon_p90","weapon_r8revolver","weapon_sawedoff","weapon_scar20","weapon_sg553","weapon_ssg08",
        "weapon_tec9","weapon_ump45","weapon_usps","weapon_xm1014"
})
public class WeaponsModel {

    @JsonProperty("attributes")
    private  final List<String> attributes = new ArrayList<>(Arrays.asList("grenade_decoygrenade","grenade_flashbang","grenade_hegrenade","grenade_incendiarygrenade","grenade_molotovgrenade","grenade_smokegrenade","weapon_ak47","weapon_aug","weapon_awp","weapon_bizon","weapon_cz75auto","weapon_deagle","weapon_elite","weapon_famas","weapon_fiveseven","weapon_g3sg1","weapon_galilar","weapon_glock","weapon_m249","weapon_m4a1s","weapon_m4a4","weapon_mac10","weapon_mag7","weapon_mp5sd","weapon_mp7","weapon_mp9","weapon_negev","weapon_nova","weapon_p2000","weapon_p250","weapon_p90","weapon_r8revolver","weapon_sawedoff","weapon_scar20","weapon_sg553","weapon_ssg08","weapon_tec9","weapon_ump45","weapon_usps","weapon_xm1014"));

    @JsonProperty("grenade_decoygrenade")
    private double grenade_decoygrenade;

    @JsonProperty("grenade_flashbang")
    private double grenade_flashbang;

    @JsonProperty("grenade_hegrenade")
    private double grenade_hegrenade;

    @JsonProperty("grenade_incendiarygrenade")
    private double grenade_incendiarygrenade;

    @JsonProperty("grenade_molotovgrenade")
    private double grenade_molotovgrenade;

    @JsonProperty("grenade_smokegrenade")
    private double grenade_smokegrenade;

    @JsonProperty("weapon_ak47")
    private double weapon_ak47;

    @JsonProperty("weapon_aug")
    private double weapon_aug;

    @JsonProperty("weapon_awp")
    private double weapon_awp;

    @JsonProperty("weapon_bizon")
    private double weapon_bizon;

    @JsonProperty("weapon_cz75auto")
    private double weapon_cz75auto;

    @JsonProperty("weapon_deagle")
    private double weapon_deagle;

    @JsonProperty("weapon_elite")
    private double weapon_elite;

    @JsonProperty("weapon_famas")
    private double weapon_famas;

    @JsonProperty("weapon_fiveseven")
    private double weapon_fiveseven;

    @JsonProperty("weapon_g3sg1")
    private double weapon_g3sg1;

    @JsonProperty("weapon_galilar")
    private double weapon_galilar;

    @JsonProperty("weapon_glock")
    private double weapon_glock;

    @JsonProperty("weapon_m249")
    private double weapon_m249;

    @JsonProperty("weapon_m4a1s")
    private double weapon_m4a1s;

    @JsonProperty("weapon_m4a4")
    private double weapon_m4a4;

    @JsonProperty("weapon_mac10")
    private double weapon_mac10;

    @JsonProperty("weapon_mag7")
    private double weapon_mag7;

    @JsonProperty("weapon_mp5sd")
    private double weapon_mp5sd;

    @JsonProperty("weapon_mp7")
    private double weapon_mp7;

    @JsonProperty("weapon_mp9")
    private double weapon_mp9;

    @JsonProperty("weapon_negev")
    private double weapon_negev;

    @JsonProperty("weapon_nova")
    private double weapon_nova;

    @JsonProperty("weapon_p2000")
    private double weapon_p2000;

    @JsonProperty("weapon_p250")
    private double weapon_p250;

    @JsonProperty("weapon_p90")
    private double weapon_p90;

    @JsonProperty("weapon_r8revolver")
    private double weapon_r8revolver;

    @JsonProperty("weapon_sawedoff")
    private double weapon_sawedoff;

    @JsonProperty("weapon_scar20")
    private double weapon_scar20;

    @JsonProperty("weapon_sg553")
    private double weapon_sg553;

    @JsonProperty("weapon_ssg08")
    private double weapon_ssg08;

    @JsonProperty("weapon_tec9")
    private double weapon_tec9;

    @JsonProperty("weapon_ump45")
    private double weapon_ump45;

    @JsonProperty("weapon_usps")
    private double weapon_usps;

    @JsonProperty("weapon_xm1014")
    private double weapon_xm1014;
}
