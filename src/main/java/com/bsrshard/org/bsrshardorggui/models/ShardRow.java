package com.bsrshard.org.bsrshardorggui.models;

public class ShardRow {

    private final int id;
    private final Shard shard;

    public ShardRow(int id, Shard shard) {
        this.id = id;
        this.shard = shard;
    }

    public int getId() {
        return id;
    }

    public Shard getShard() {
        return shard;
    }
}

