package com.bsrshard.org.bsrshardorggui.models;

public class CalculatedStats {

    public BleachCharacter statDummy(ShardSet set){
        BleachCharacter dummy = BleachCharacter.getUnit();
        Shard totalShardStat = totalShardStat(set);
        return new BleachCharacter(
                dummy.getName(), // Keep the original name
                // Basic Stats (Calculated via your formula)
                calcFinalStat(totalShardStat.getHpPercent(), totalShardStat.getFlatHP(), dummy.getHp()),
                calcFinalStat(totalShardStat.getAttackPercent(), totalShardStat.getFlatAttack(), dummy.getAtk()),
                calcFinalStat(totalShardStat.getDefPercent(), totalShardStat.getFlatDef(), dummy.getDef()),

                // Advanced Stats (Direct addition of percentages)
                dummy.getCritRate() + totalShardStat.getCritRate(),
                dummy.getCritDmg() + totalShardStat.getCritDmg(),

                // These don't seem to be in the Shard model, keeping base values
                dummy.getHealingEffect(),
                dummy.getHealedEffect(),
                dummy.getCooldownRed(),
                dummy.getDissipationDmg(),

                // Ultimate & Combat Bonuses
                dummy.getUltimateCharge() + totalShardStat.getUltimateCRate(),
                dummy.getBasicAtkDmg(),
                dummy.getTechniqueDmg(),
                dummy.getUltimateDmg(),
                dummy.getSpecialAtkDmg(),
                dummy.getBattlefieldDmg(),

                // Elemental/Type Damage Bonuses
                dummy.getSlashDmg() + totalShardStat.getSlashDmg(),
                dummy.getStrikeDmg() + totalShardStat.getStrikeDmg(),
                dummy.getThrustDmg() + totalShardStat.getThrustDmg(),
                dummy.getSpritDmg() + totalShardStat.getSpritDmg(),
                dummy.getAilmentDmg() + totalShardStat.getAilmentDmg()
        );
    }

    private int calcFinalStat(double gearStat, int flatStat, int baseStat){
        return (int) ((baseStat * (gearStat/100)) + baseStat + flatStat);
    }

    private Shard totalShardStat(ShardSet set){
        int finalFlatAtk = set.getShardI().getFlatAttack() + set.getShardII().getFlatAttack() + set.getShardIII().getFlatAttack();
        double finalAtk = set.getShardI().getAttackPercent() + set.getShardII().getAttackPercent() + set.getShardIII().getAttackPercent();


        int finalFlatHP = set.getShardI().getFlatHP() + set.getShardII().getFlatHP() + set.getShardIII().getFlatHP();
        double finalHPPercent = set.getShardI().getHpPercent() + set.getShardII().getHpPercent() + set.getShardIII().getHpPercent();


        int finalFlatDef = set.getShardI().getFlatDef() + set.getShardII().getFlatDef() + set.getShardIII().getFlatDef();
        double finalDefPercent = set.getShardI().getDefPercent() + set.getShardII().getDefPercent() + set.getShardIII().getDefPercent();


        double finalCritRate = set.getShardI().getCritRate() + set.getShardII().getCritRate() + set.getShardIII().getCritRate();
        double finalCritDmg = set.getShardI().getCritDmg() + set.getShardII().getCritDmg() + set.getShardIII().getCritDmg();
        double finalUltCharge = set.getShardI().getUltimateCRate() + set.getShardII().getUltimateCRate() + set.getShardIII().getUltimateCRate();


        double finalAilmentDmg = set.getShardI().getAilmentDmg() + set.getShardII().getAilmentDmg() + set.getShardIII().getAilmentDmg();
        double finalSlashDmg = set.getShardI().getSlashDmg() + set.getShardII().getSlashDmg() + set.getShardIII().getSlashDmg();
        double finalStrikeDmg = set.getShardI().getStrikeDmg() + set.getShardII().getStrikeDmg() + set.getShardIII().getStrikeDmg();
        double finalThrustDmg = set.getShardI().getThrustDmg() + set.getShardII().getThrustDmg() + set.getShardIII().getThrustDmg();
        double finalSpiritDmg = set.getShardI().getSpritDmg() + set.getShardII().getSpritDmg() + set.getShardIII().getSpritDmg();

        return new Shard(
                set.getShardI().getGearSet(),
                finalFlatHP, finalHPPercent,
                finalFlatDef,
                finalDefPercent,
                finalFlatAtk,
                finalAtk,
                finalCritRate,
                finalCritDmg,
                finalAilmentDmg,
                finalSlashDmg,
                finalStrikeDmg,
                finalThrustDmg,
                finalSpiritDmg,
                finalUltCharge);
    }
}
