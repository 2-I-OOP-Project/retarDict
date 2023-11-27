package com.example.retardict;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.net.URL;
import java.util.ResourceBundle;

public class PremiumRegisterController implements Initializable {

    @FXML
    private TextField premiumCodeField;
    @FXML
    private Button closeButton;
    @FXML
    private Label premiumStatus;
    @FXML
    private Label registerMessage;
    @FXML
    public void displayText() {
        System.out.println("Hello world");
    }

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void checkPremiumCode(ActionEvent event) {
        String premiumCode = premiumCodeField.getText();
        if (premiumCode.equals(Utilities.PREMIUM_CODE)) {
            SettingSceneController.premium = true;
            premiumStatus.setText("Premium status: Activated");
            registerMessage.setText("🎉🎉Premium activated🎊🎊");
        } else {
            registerMessage.setText("Invalid premium code, stupid");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        premiumStatus.setText("Premium status: " + (SettingSceneController.premium ? "Activated" : "not Activated"));
        premiumCodeField.requestFocus();
    }
}
