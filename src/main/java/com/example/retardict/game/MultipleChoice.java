package com.example.retardict.game;

import java.util.ArrayList;

public class MultipleChoice extends Game {
    private ArrayList<MultipleChoiceQuestion> questions;
    private int numberOfQuestions;

    public MultipleChoice() {
         questions = new ArrayList<>();
    }

    public MultipleChoiceQuestion returnRandomQuestion() {
        int min = 0;
        int max = this.numberOfQuestions - 1;
        int randomInt = 0;

        while (true) {
            randomInt = (int) Math.floor(Math.random() * (max - min + 1) + min);
            if (!this.questions.get(randomInt).isChosen()) {
                this.questions.get(randomInt).setChosen(true);
                return this.questions.get(randomInt);
            }
        }
    }

    public ArrayList<MultipleChoiceQuestion> getQuestions() {
        return this.questions;
    }

    public int getNumberOfQuestions() {
        return this.numberOfQuestions;
    }

    public void addQuestion(MultipleChoiceQuestion q) {
        q.setChosen(false);
        this.questions.add(q);
        numberOfQuestions = this.questions.size();
    }

    public static MultipleChoice getMultipleChoice() {
        MultipleChoice multipleChoice = new MultipleChoice();

        MultipleChoiceQuestion a = new MultipleChoiceQuestion("Hello! My name ___ Quan.", "is", "are", "was", "were", "A");
        MultipleChoiceQuestion b = new MultipleChoiceQuestion("Here ___ the train.", "came", "come", "comes", "coming", "C");
        MultipleChoiceQuestion c = new MultipleChoiceQuestion("We're ___ dinner. Do you wanna join?", "have", "having", "has", "had", "B");
        MultipleChoiceQuestion d = new MultipleChoiceQuestion("At 8PM last night, I ___ the television.", "watched", "has watched", "had watched", "was watching", "D");
        MultipleChoiceQuestion e = new MultipleChoiceQuestion("I ___ have a big meeting tomorrow.", "will", "is going to", "is", "shall", "A");
        MultipleChoiceQuestion f = new MultipleChoiceQuestion("Fuck you bitch!", "Fuck you, too!", "WTF have you just said, bitch?", "Thank you!", "Fuck off, bitch!", "C");

        multipleChoice.addQuestion(a);
        multipleChoice.addQuestion(b);
        multipleChoice.addQuestion(c);
        multipleChoice.addQuestion(d);
        multipleChoice.addQuestion(e);
        multipleChoice.addQuestion(f);

        return multipleChoice;
    }
}
