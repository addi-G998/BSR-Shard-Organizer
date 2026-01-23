package com.bsrshard.org.bsrshardorggui.models;

import java.util.ArrayList;
import java.util.List;

public class ShardSetList {

    private static List<ShardSet> setList = new ArrayList<>();

    public static void addSet(ShardSet set){
        setList.add(set);
    }

    public static List<ShardSet> getSetList() {
        return setList;
    }

    public static void setSetList(List<ShardSet> setList) {
        ShardSetList.setList = setList;
    }
}
