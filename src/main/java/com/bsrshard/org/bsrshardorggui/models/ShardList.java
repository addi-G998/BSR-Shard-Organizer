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

    }

    private static void genSets(int start, int n, int k, int depth,int[] buffer){

        if(depth == k){
            System.out.println(Arrays.toString(buffer));
            return;
        }

        for(int i = start; i < n - (k + depth) + 1; i++){
            buffer[depth] = i;
            genSets(i + 1, n,k,depth + 1,buffer);
        }
    }

}
