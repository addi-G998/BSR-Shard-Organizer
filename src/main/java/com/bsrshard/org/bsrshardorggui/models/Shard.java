package com.bsrshard.org.bsrshardorggui.models;



public class Shard {

    private String gearSet;
    // HP
    private int flatHP;
    // HP %
    private double hpPercent;
    // DEF
    private int flatDef;
    // DEF %
    private double defPercent;
    // ATK
    private int flatAttack;
    // ATK %
    private double attackPercent;
    // CRIT RATE
    private double critRate;
    // CRIT DMG
    private double critDmg;
    // Ailment DMG Bonus
    private double ailmentDmg;
    // Slash DMG Bonus
    private double slashDmg;
    // Strike DMG Bonus
    private double strikeDmg;
    // Thrust DMG Bonus
    private double thrustDmg;
    // Spirit DMG Bonus
    private double spritDmg;
    // Ultimate Charge Rate
    private double ultimateCRate;

    // Default constructor
    public Shard() {
    }

    // Constructor with parameters


    public Shard(String gearSet, int flatHP, double hpPercent, int flatDef, double defPercent, int flatAttack, double attackPercent, double critRate, double critDmg, double ailmentDmg, double slashDmg, double strikeDmg, double thrustDmg, double spritDmg, double ultimateCRate) {
        this.gearSet = gearSet;
        this.flatHP = flatHP;
        this.hpPercent = hpPercent;
        this.flatDef = flatDef;
        this.defPercent = defPercent;
        this.flatAttack = flatAttack;
        this.attackPercent = attackPercent;
        this.critRate = critRate;
        this.critDmg = critDmg;
        this.ailmentDmg = ailmentDmg;
        this.slashDmg = slashDmg;
        this.strikeDmg = strikeDmg;
        this.thrustDmg = thrustDmg;
        this.spritDmg = spritDmg;
        this.ultimateCRate = ultimateCRate;
    }

    public String getGearSet() {
        return gearSet;
    }

    public void setGearSet(String gearSet) {
        this.gearSet = gearSet;
    }

    public int getFlatAttack() {
        return flatAttack;
    }

    public void setFlatAttack(int flatAttack) {
        this.flatAttack = flatAttack;
    }

    public double getAttackPercent() {
        return attackPercent;
    }

    public void setAttackPercent(double attackPercent) {
        this.attackPercent = attackPercent;
    }

    public double getCritRate() {
        return critRate;
    }

    public void setCritRate(double critRate) {
        this.critRate = critRate;
    }

    public double getCritDmg() {
        return critDmg;
    }

    public void setCritDmg(double critDmg) {
        this.critDmg = critDmg;
    }

    public double getAilmentDmg() {
        return ailmentDmg;
    }

    public void setAilmentDmg(double ailmentDmg) {
        this.ailmentDmg = ailmentDmg;
    }

    public double getSlashDmg() {
        return slashDmg;
    }

    public void setSlashDmg(double slashDmg) {
        this.slashDmg = slashDmg;
    }

    public double getStrikeDmg() {
        return strikeDmg;
    }

    public void setStrikeDmg(double strikeDmg) {
        this.strikeDmg = strikeDmg;
    }

    public double getThrustDmg() {
        return thrustDmg;
    }

    public void setThrustDmg(double thrustDmg) {
        this.thrustDmg = thrustDmg;
    }

    public double getSpritDmg() {
        return spritDmg;
    }

    public void setSpritDmg(double spritDmg) {
        this.spritDmg = spritDmg;
    }

    public int getFlatHP() {
        return flatHP;
    }

    public void setFlatHP(int flatHP) {
        this.flatHP = flatHP;
    }

    public double getHpPercent() {
        return hpPercent;
    }

    public void setHpPercent(double hpPercent) {
        this.hpPercent = hpPercent;
    }

    public int getFlatDef() {
        return flatDef;
    }

    public void setFlatDef(int flatDef) {
        this.flatDef = flatDef;
    }

    public double getDefPercent() {
        return defPercent;
    }

    public void setDefPercent(double defPercent) {
        this.defPercent = defPercent;
    }

    public double getUltimateCRate() {
        return ultimateCRate;
    }

    public void setUltimateCRate(double ultimateCRate) {
        this.ultimateCRate = ultimateCRate;
    }

    @Override
    public String toString() {
        return "Shard {" +
                "gearSet='" + gearSet + '\'' +
                ", flatAttack=" + flatAttack +
                ", attackPercent=" + String.format("%.1f", attackPercent) + "%" +
                ", critRate=" + String.format("%.1f", critRate) + "%" +
                ", critDmg=" + String.format("%.1f", critDmg) + "%" +
                ", ailmentDmg=" + String.format("%.1f", ailmentDmg) + "%" +
                ", slashDmg=" + String.format("%.1f", slashDmg) + "%" +
                ", strikeDmg=" + String.format("%.1f", strikeDmg) + "%" +
                ", thrustDmg=" + String.format("%.1f", thrustDmg) + "%" +
                ", spritDmg=" + String.format("%.1f", spritDmg) + "%" +
                '}';
    }

}

