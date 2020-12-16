package com.simplemethod.aiwd.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Resource;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ct_players_alive",
        "t_players_alive",
        "bomb_planted",
        "ct_grenade_flashbang",
        "t_grenade_flashbang",
        "ct_grenade_smokegrenade",
        "t_grenade_smokegrenade",
        "round_winner",
        "maps"
})
@Resource
@Getter
@Setter
public class EditDataJson {

    @JsonProperty("ct_players_alive")
    private int ct_players_alive;
    @JsonProperty("t_players_alive")
    private int t_players_alive;
    @JsonProperty("bomb_planted")
    private int bomb_planted;
    @JsonProperty("ct_grenade_flashbang")
    private float ct_grenade_flashbang;
    @JsonProperty("t_grenade_flashbang")
    private float t_grenade_flashbang;
    @JsonProperty("ct_grenade_smokegrenade")
    private float ct_grenade_smokegrenade;
    @JsonProperty("t_grenade_smokegrenade")
    private float t_grenade_smokegrenade;
    @JsonProperty("round_winner")
    private int round_winner;

    @JsonProperty("maps")
    private int maps;

    public EditDataJson(int ct_players_alive, int t_players_alive, int bomb_planted, float ct_grenade_flashbang, float t_grenade_flashbang, float ct_grenade_smokegrenade, float t_grenade_smokegrenade, int round_winner, int maps) {
        this.ct_players_alive = ct_players_alive;
        this.t_players_alive = t_players_alive;
        this.bomb_planted = bomb_planted;
        this.ct_grenade_flashbang = ct_grenade_flashbang;
        this.t_grenade_flashbang = t_grenade_flashbang;
        this.ct_grenade_smokegrenade = ct_grenade_smokegrenade;
        this.t_grenade_smokegrenade = t_grenade_smokegrenade;
        this.round_winner = round_winner;
        this.maps = maps;
    }
}
