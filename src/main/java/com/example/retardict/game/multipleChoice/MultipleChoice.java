package com.example.retardict.game.multipleChoice;

import com.example.retardict.game.Game;

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

        do {
            randomInt = (int) Math.floor(Math.random() * (max - min + 1) + min);
            this.questions.get(randomInt).setChosen(true);
        } while (!this.questions.get(randomInt).isChosen());
        this.questions.get(randomInt).setChosen(true);
        return this.questions.get(randomInt);
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

    private static MultipleChoice getMultipleChoice() {
        MultipleChoice multipleChoice = new MultipleChoice();
        Question a = new Question("a", "is", "are", "was", "were", "A");
        Question b = new Question("b", "is", "are", "was", "were", "B");
        Question c = new Question("c", "is", "are", "was", "were", "B");
        Question d = new Question("d", "is", "are", "was", "were", "B");
        Question e = new Question("e", "is", "are", "was", "were", "B");
        Question f = new Question("f", "is", "are", "was", "were", "B");

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

        System.out.println(multipleChoice.returnRandomQuestion().toString());
        System.out.println(multipleChoice.returnRandomQuestion().toString());
        System.out.println(multipleChoice.returnRandomQuestion().toString());
        System.out.println(multipleChoice.returnRandomQuestion().toString());
        System.out.println(multipleChoice.returnRandomQuestion().toString());
        System.out.println(multipleChoice.returnRandomQuestion().toString());
    }
}
