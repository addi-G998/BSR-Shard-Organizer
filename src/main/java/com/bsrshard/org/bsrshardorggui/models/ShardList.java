package com.bsrshard.org.bsrshardorggui.models;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShardList {

    private static List<Shard> shardList = new ArrayList<>();

    public static List<Shard> getShardList() {
        return shardList;
    }

    public static void setShardList(List<Shard> shardList) {
        ShardList.shardList = shardList;
    }

    public static void addShard(final Shard shard){
        shardList.add(shard);
    }

    public static void genShardCombination(){
        // The buffer only needs to be the size of the set you want (k = 3)
        Shard[] buffer = new Shard[3];
        genSets(0, shardList.size(), 3, 0, buffer);
    }

    private static void genSets(int start, int n, int k, int depth, Shard[] buffer) {
        if (depth == k) {
            if (isValidSet(buffer)) {
                System.out.println(Arrays.toString(buffer));
                ShardSet set = new ShardSet(buffer[0], buffer[1], buffer[2]);
                ShardSetList.addSet(set);
                // Optional: Add to your TreeTableView list here
            }
            return;
        }

        for (int i = start; i <= n - (k - depth); i++) {
            buffer[depth] = shardList.get(i);
            genSets(i + 1, n, k, depth + 1, buffer);
        }
    }

    private static boolean isValidSet(Shard[] buffer) {
        // Regex logic:
        // " +" matches one or more spaces
        // "(I|II|III)$" matches I, II, or III specifically at the end of the string
        String regex = " +(I|II|III)$";

        String base0 = buffer[0].getGearSet().replaceAll(regex, "");
        String base1 = buffer[1].getGearSet().replaceAll(regex, "");
        String base2 = buffer[2].getGearSet().replaceAll(regex, "");

        // 1. Check Rule A: Are they the same class?
        // Now "Death Knight I" becomes "Death Knight", and they will match.
        if (!base0.equals(base1) || !base0.equals(base2)) {
            return false;
        }

        // 2. Check Rule B: Do we have exactly one of each: I, II, and III?
        // We check the original names to ensure the tiers are unique
        String n0 = buffer[0].getGearSet();
        String n1 = buffer[1].getGearSet();
        String n2 = buffer[2].getGearSet();

        return hasTier(n0, n1, n2, "I") &&
                hasTier(n0, n1, n2, "II") &&
                hasTier(n0, n1, n2, "III");
    }

    // Helper to ensure the tier exists as a standalone word at the end
    private static boolean hasTier(String s0, String s1, String s2, String tier) {
        String suffix = " " + tier;
        return s0.endsWith(suffix) || s1.endsWith(suffix) || s2.endsWith(suffix);
    }

}
