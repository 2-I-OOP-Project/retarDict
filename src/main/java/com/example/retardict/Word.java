package com.example.retardict;

public class Word {
    private String word;
    private String pronunciation;
    private String description;

    public Word(String word, String pronunciation, String description) {
        this.word = word;
        this.pronunciation = pronunciation;
        this.description = description;
    }

    public String getWord() {
        return word;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public String getDescription() {
        return description;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.getWord();
    }
}
