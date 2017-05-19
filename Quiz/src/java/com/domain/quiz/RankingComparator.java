/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domain.quiz;

import java.util.Comparator;

/**
 *
 * @author Leonardo
 */
public class RankingComparator implements Comparator<Score> {

    @Override
    public int compare(Score o1, Score o2) {
        return o2.getScore().compareTo(o1.getScore());
    }
}
