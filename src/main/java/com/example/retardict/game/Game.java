package com.example.retardict.game;

public abstract class Game {
    protected int highscore;
    public Game() {
        this.highscore = 0;
    }
    public int getHighscore() {
        return this.highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }
}
