package com.example.retardict.game;

import java.util.ArrayList;

public class MultipleChoice extends Game {
    private ArrayList<Question> questions = new ArrayList<>();
    private int numberOfQuestions;

    public MultipleChoice() {
    }

    public Question returnRandomQuestion() {
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

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public int getNumberOfQuestions() {
        return this.numberOfQuestions;
    }

    public void addQuestion(Question q) {
        q.setChosen(false);
        this.questions.add(q);
        numberOfQuestions = this.questions.size();
    }

    public static MultipleChoice getMultipleChoice() {
        MultipleChoice multipleChoice = new MultipleChoice();

        Question a = new Question("Hello! My name ___ Quan.", "is", "are", "was", "were", "A");
        Question b = new Question("Here ___ the train.", "came", "come", "comes", "coming", "C");
        Question c = new Question("We're ___ dinner. Do you wanna join?", "have", "having", "has", "had", "B");
        Question d = new Question("At 8PM last night, I ___ the television.", "watched", "has watched", "had watched", "was watching", "D");
        Question e = new Question("I ___ have a big meeting tomorrow.", "will", "is going to", "is", "shall", "A");
        Question f = new Question("Fuck you bitch!", "Fuck you, too!", "WTF have you just said, bitch?", "Thank you!", "Fuck off, bitch!", "C");

        multipleChoice.addQuestion(a);
        multipleChoice.addQuestion(b);
        multipleChoice.addQuestion(c);
        multipleChoice.addQuestion(d);
        multipleChoice.addQuestion(e);
        multipleChoice.addQuestion(f);

        return multipleChoice;
    }

    public static void main(String[] args) {
        MultipleChoice multipleChoice = getMultipleChoice();

        for (int i = 0; i < multipleChoice.getNumberOfQuestions(); i++) {
            System.out.println(multipleChoice.returnRandomQuestion().toString() + "\n");
        }
    }
}
