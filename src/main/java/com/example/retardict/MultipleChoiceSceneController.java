package com.example.retardict;

import com.example.retardict.game.MultipleChoice;
import com.example.retardict.game.MultipleChoiceQuestion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MultipleChoiceSceneController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private int numberOfQuestionsUsed = 0;
    private final MultipleChoice multipleChoice = MultipleChoice.getMultipleChoice();
    private String correctAnswer;
    private String currentChosenAnswer;
    private boolean repeat = false;

    @FXML
    private Label questionBox;
    @FXML
    private Label answerABox;
    @FXML
    private Label answerBBox;
    @FXML
    private Label answerCBox;
    @FXML
    private Label answerDBox;
    @FXML
    private Label resultBox;

    @FXML
    public void setQuestion(ActionEvent event) throws IOException {
        MultipleChoiceQuestion currentQuestion = multipleChoice.returnRandomQuestion();

        questionBox.setText(currentQuestion.getQuestion());
        answerABox.setText(currentQuestion.getAnswerA());
        answerBBox.setText(currentQuestion.getAnswerB());
        answerCBox.setText(currentQuestion.getAnswerC());
        answerDBox.setText(currentQuestion.getAnswerD());
        correctAnswer = currentQuestion.getCorrectAnswer();

        resultBox.setText("Choose your answer!");
        ++numberOfQuestionsUsed;

        if (numberOfQuestionsUsed == multipleChoice.getNumberOfQuestions()) {
            for (int i = 0; i < multipleChoice.getNumberOfQuestions(); ++i) {
                multipleChoice.getQuestions().get(i).setChosen(false);
            }
            numberOfQuestionsUsed = 0;
        }
    }

    @FXML
    public void choseA() {
        currentChosenAnswer = "A";
        if (currentChosenAnswer.equals(correctAnswer)) {
            resultBox.setText("Correct!");
        } else {
            resultBox.setText("Wrong!");
        }
    }

    @FXML
    public void choseB() {
        currentChosenAnswer = "B";
        if (currentChosenAnswer.equals(correctAnswer)) {
            resultBox.setText("Correct!");
        } else {
            resultBox.setText("Wrong!");
        }
    }

    @FXML
    public void choseC() {
        currentChosenAnswer = "C";
        if (currentChosenAnswer.equals(correctAnswer)) {
            resultBox.setText("Correct!");
        } else {
            resultBox.setText("Wrong!");
        }
    }

    @FXML
    public void choseD() {
        currentChosenAnswer = "D";
        if (currentChosenAnswer.equals(correctAnswer)) {
            resultBox.setText("Correct!");
        } else {
            resultBox.setText("Wrong!");
        }
    }

    @FXML
    public void switchBackToGameScene(ActionEvent event) throws  IOException {
        FXMLLoader gameScene = new FXMLLoader(getClass().getResource("gameScene.fxml"));
        root = gameScene.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
