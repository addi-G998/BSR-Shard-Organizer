package com.bsrshard.org.bsrshardorggui.models;



import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class FileReader {

    private static final FileReader INSTANCE = new FileReader();



    public static FileReader getInstance(){
        return INSTANCE;
    }

    private Shard filterShard(final String rawInput) {
        // Step 1: Clean OCR weird symbols
        // Keep letters, numbers, spaces, %, and .
        String input = rawInput.replaceAll("[^\\w\\s%\\.]", "");

        // Step 2: Extract gear set
        String gearSet = "Unknown";
        Matcher gearMatcher = Pattern.compile("\\s*(.+?)\\s*(?:\\r?\\n|$)").matcher(input);
        if (gearMatcher.find()) {
            gearSet = gearMatcher.group(1).trim();
            gearSet = gearSet.replaceAll("\\bIll$", "III"); // für l, Il, ll, lI, lIl, llI,lII und IlI vielleicht auch

        }

        // Step 3: Initialize stats
        int flatAttack = 0;
        int def = 0;
        double defPercent = 0.0;
        int hp = 0;
        double hpPercent = 0.0;
        double attackPercent = 0.0;
        double critRate = 0.0;
        double critDmg = 0.0;
        double ailmentDmg = 0.0;
        double slashDmg = 0.0;
        double strikeDmg = 0.0;
        double thrustDmg = 0.0;
        double spritDmg = 0.0;
        double ultimateCRate = 0.0;

        // Step 4: Sum duplicates for each stat
        flatAttack += sumInts(input, "(?m)^ATK\\D*(\\d+)$");       // Flat ATK only
        attackPercent += sumDoubles(input, "(?m)^ATK\\s+(\\d+(?:\\.\\d+)?)%$"); // ATK%
        hp += sumInts(input, "(?m)^HP\\D*(\\d+)$");
        hpPercent += sumDoubles(input, "(?m)^HP\\s+(\\d+(?:\\.\\d+)?)%$");
        def += sumInts(input, "(?m)^DEF\\D*(\\d+)$");
        defPercent += sumDoubles(input, "(?m)^DEF\\s+(\\d+(?:\\.\\d+)?)%$");
        critRate += sumDoubles(input, "(?m)^Crit Rate\\D*(\\d+(?:\\.\\d+)?)%$");
        critDmg += sumDoubles(input, "(?m)^Crit DMG\\D*(\\d+(?:\\.\\d+)?)%$");
        ailmentDmg += sumDoubles(input, "(?m)^Ailment DMG Bonus\\D*(\\d+(?:\\.\\d+)?)%$");
        slashDmg += sumDoubles(input, "(?m)^Slash DMG Bonus\\D*(\\d+(?:\\.\\d+)?)%$");
        strikeDmg += sumDoubles(input, "(?m)^Strike DMG Bonus\\D*(\\d+(?:\\.\\d+)?)%$");
        thrustDmg += sumDoubles(input, "(?m)^Thrust DMG Bonus\\D*(\\d+(?:\\.\\d+)?)%$");
        spritDmg += sumDoubles(input, "(?m)^Spirit DMG Bonus\\D*(\\d+(?:\\.\\d+)?)%$");
        ultimateCRate += sumDoubles(input, "(?m)^Ultimate Charge Rate\\D*(\\d+(?:\\.\\d+)?)%$");


        // Step 5: Create Shard object
        return new Shard(
                gearSet,
                hp,
                hpPercent,
                def,
                defPercent,
                flatAttack,
                attackPercent,
                critRate,
                critDmg,
                ailmentDmg,
                slashDmg,
                strikeDmg,
                thrustDmg,
                spritDmg,
                ultimateCRate
        );
    }

    // Sum all integers for a given regex
    private int sumInts(String input, String regex) {
        Matcher m = Pattern.compile(regex).matcher(input);
        int sum = 0;
        while (m.find()) {
            sum += Integer.parseInt(m.group(1));
        }
        return sum;
    }

    // Sum all doubles for a given regex, divide by 10 for OCR decimal fix
    private double sumDoubles(String input, String regex) {
        Matcher m = Pattern.compile(regex).matcher(input);
        double sum = 0.0;

        while (m.find()) {
            String raw = m.group(1);

            double value;
            if (raw.contains(".")) {
                // already has decimal (e.g. 28.8)
                value = Double.parseDouble(raw);
            } else {
                // no decimal (e.g. 288 → 28.8)
                value = Double.parseDouble(raw) / 10.0;
            }

            sum += value;
        }
        return sum;
    }


    public void readShardData(final Stage stage){
        FileChooser fc = new FileChooser();

        List<File> files = new ArrayList<>(fc.showOpenMultipleDialog(stage));
        // Path to your image


        // Create Tesseract instance
        Tesseract tesseract = new Tesseract();

        // Set Tesseract data path (where tessdata folder is located)
        tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata"); // adjust to your path
        tesseract.setLanguage("eng"); // English language

        try {
            for(File f : files){
                String result = tesseract.doOCR(f);
                //System.out.print(result);
                Shard shard = filterShard(result.replaceAll("[^\\w\\s%.]", ""));
                //System.out.println(shard.toString());
                ShardList.addShard(shard);
            }

        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }
}

