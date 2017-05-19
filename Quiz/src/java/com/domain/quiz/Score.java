/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.quiz;

import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class Score {
    private Double score;
    private Player player;
    public static ArrayList<Score> ranking = new ArrayList<Score>();

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public static ArrayList<Score> getRanking() {
        return ranking;
    }

    public static void setRanking(Score score) {
        ranking.add(score);
    }
    
    
}
