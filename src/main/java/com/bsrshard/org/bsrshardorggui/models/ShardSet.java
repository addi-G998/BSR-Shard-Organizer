package com.bsrshard.org.bsrshardorggui.models;

public class ShardSet {

    private Shard shardI;
    private Shard shardII;
    private Shard shardIII;

    public ShardSet(Shard shardI, Shard shardII, Shard shardIII) {
        this.shardI = shardI;
        this.shardII = shardII;
        this.shardIII = shardIII;
    }

    public Shard getShardI() {
        return shardI;
    }

    public Shard getShardII() {
        return shardII;
    }

    public Shard getShardIII() {
        return shardIII;
    }
}
