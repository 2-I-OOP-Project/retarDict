package com.example.retardict;

import java.util.ArrayList;

public class Dictionary {
    public final ArrayList<Word> words = new ArrayList<Word>();

    public void insertWord(String target, String explain) {
        if (target == null) target = "something";
        if (explain == null) explain = "something aswell";
        words.add(new Word(target, explain));
    }

    public void sortByWordTarget() {
        words.sort(((o1, o2) ->
                o1.getWord_target().compareTo(o2.getWord_target())));
    }

    public int getWordCount () {
        return words.size();
    }

    public Word getWord(int index) {
        return words.get(index);
    }
}
