package com.bsrshard.org.bsrshardorggui.models;

public class BleachCharacter {
    private String name;
    private int hp;
    private int atk;
    private int def;
    private double critRate;
    private double critDmg;
    private double healingEffect;
    private double healedEffect;
    private double cooldownRed;
    private double dissipationDmg;
    private double ultimateCharge;
    private double basicAtkDmg;
    private double techniqueDmg;
    private double ultimateDmg;
    private double specialAtkDmg;
    private double battlefieldDmg;
    private double slashDmg;
    // Strike DMG Bonus
    private double strikeDmg;
    // Thrust DMG Bonus
    private double thrustDmg;
    // Spirit DMG Bonus
    private double spritDmg;
    private double ailmentDmg;


    private static BleachCharacter unit;

    public BleachCharacter(String name, int hp, int atk, int def, double critRate, double critDmg, double healingEffect, double healedEffect, double cooldownRed, double dissipationDmg, double ultimateCharge, double basicAtkDmg, double techniqueDmg, double ultimateDmg, double specialAtkDmg, double battlefieldDmg, double slashDmg, double strikeDmg, double thrustDmg, double spritDmg, double ailmentDmg) {
        this.name = name;
        // Basic Stats
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        // Advanced Stats
        this.critRate = critRate;
        this.critDmg = critDmg;
        this.healingEffect = healingEffect;
        this.healedEffect = healedEffect;
        this.cooldownRed = cooldownRed;
        this.dissipationDmg = dissipationDmg;
        this.ultimateCharge = ultimateCharge;
        this.basicAtkDmg = basicAtkDmg;
        this.techniqueDmg = techniqueDmg;
        this.ultimateDmg = ultimateDmg;
        this.specialAtkDmg = specialAtkDmg;
        this.battlefieldDmg = battlefieldDmg;
        this.slashDmg = slashDmg;
        this.strikeDmg = strikeDmg;
        this.thrustDmg = thrustDmg;
        this.spritDmg = spritDmg;
        this.ailmentDmg = ailmentDmg;
    }

    public BleachCharacter(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
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

    public double getHealingEffect() {
        return healingEffect;
    }

    public void setHealingEffect(double healingEffect) {
        this.healingEffect = healingEffect;
    }

    public double getHealedEffect() {
        return healedEffect;
    }

    public void setHealedEffect(double healedEffect) {
        this.healedEffect = healedEffect;
    }

    public double getCooldownRed() {
        return cooldownRed;
    }

    public void setCooldownRed(double cooldownRed) {
        this.cooldownRed = cooldownRed;
    }

    public double getDissipationDmg() {
        return dissipationDmg;
    }

    public void setDissipationDmg(double dissipationDmg) {
        this.dissipationDmg = dissipationDmg;
    }

    public double getUltimateCharge() {
        return ultimateCharge;
    }

    public void setUltimateCharge(double ultimateCharge) {
        this.ultimateCharge = ultimateCharge;
    }

    public double getBasicAtkDmg() {
        return basicAtkDmg;
    }

    public void setBasicAtkDmg(double basicAtkDmg) {
        this.basicAtkDmg = basicAtkDmg;
    }

    public double getTechniqueDmg() {
        return techniqueDmg;
    }

    public void setTechniqueDmg(double techniqueDmg) {
        this.techniqueDmg = techniqueDmg;
    }

    public double getUltimateDmg() {
        return ultimateDmg;
    }

    public void setUltimateDmg(double ultimateDmg) {
        this.ultimateDmg = ultimateDmg;
    }

    public double getSpecialAtkDmg() {
        return specialAtkDmg;
    }

    public void setSpecialAtkDmg(double specialAtkDmg) {
        this.specialAtkDmg = specialAtkDmg;
    }

    public double getBattlefieldDmg() {
        return battlefieldDmg;
    }

    public void setBattlefieldDmg(double battlefieldDmg) {
        this.battlefieldDmg = battlefieldDmg;
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

    public double getAilmentDmg() {
        return ailmentDmg;
    }

    public void setAilmentDmg(double ailmentDmg) {
        this.ailmentDmg = ailmentDmg;
    }

    public static BleachCharacter getUnit() {
        return unit;
    }

    public static void setUnit(BleachCharacter unit) {
        BleachCharacter.unit = unit;
    }
}
