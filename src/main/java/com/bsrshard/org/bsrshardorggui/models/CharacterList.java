package com.bsrshard.org.bsrshardorggui.models;

import java.util.ArrayList;
import java.util.List;

public class CharacterList {

    private static List<BleachCharacter> bleachCharacterList = new ArrayList<>();

    public static List<BleachCharacter> getCharacterList() {
        return bleachCharacterList;
    }

    public static void setCharacterList(List<BleachCharacter> bleachCharacterList) {
        CharacterList.bleachCharacterList = bleachCharacterList;
    }

    public static void addCharacter(BleachCharacter bleachCharacter){
        bleachCharacterList.add(bleachCharacter);
    }
}
