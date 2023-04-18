package com.ecology.ecologyfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EcologyConroller {

    @FXML
    private TextField autoTextBusHeavy3;

    @FXML
    private TextField autoTextBusLight2;

    @FXML
    private TextField autoTextLightweight1;

    @FXML
    private TextField autoTextTruckHeavy5;

    @FXML
    private TextField autoTextTruckLight4;


    @FXML
    private Button clearButton;

    @FXML
    private Button countButton;

    @FXML
    private TextField elemBnz7;

    @FXML
    private TextField elemCH3;

    @FXML
    private TextField elemCO1;

    @FXML
    private TextField elemFrm6;

    @FXML
    private TextField elemNO2;

    @FXML
    private TextField elemSO5;

    @FXML
    private TextField elemSazha4;

    @FXML
    private TextField roadText6;


    @FXML
    private ComboBox<String> avgSpeed;

    @FXML
    public void initialize() {
        avgSpeed.getItems().addAll(avgSpeedValue);
    }

    @FXML
    ObservableList<String> avgSpeedValue = FXCollections.observableArrayList("5", "10", "15", "20", "25", "30",
            "35", "40", "45", "50", "60", "70", "80", "100", "110", "120");

    @FXML
    private void countValues() {

        double[][] elemCategories = {
                {0.8, 0.3, 0.24, 0.005, 0.006, 0.0014, 0.0000016},
                {4.2, 1.6, 0.63, 0.034, 0.013, 0.0023, 0.00000018},
                {4.8, 5.8, 1.4, 0.34, 0.024, 0.006, 0.00000054},
                {5.1, 6.8, 1.80, 0.40, 0.035, 0.007, 0.00000066},
                {3.6, 4.3, 0.4, 0.14, 0.02, 0.002, 0.00000018}
        };
        double[] MLk = {0, 0, 0, 0, 0, 0, 0};
        double[] ML = {0, 0, 0, 0, 0, 0, 0};

        if (autoTextLightweight1.getText().equals("") ||
                autoTextBusLight2.getText().equals("") ||
                autoTextBusHeavy3.getText().equals("") ||
                autoTextTruckLight4.getText().equals("") ||
                autoTextTruckHeavy5.getText().equals("") ||
                roadText6.getText().equals("")
        ) {
            elemCO1.setText("");
            elemNO2.setText("");
            elemCH3.setText("");
            elemSazha4.setText("");
            elemSO5.setText("");
            elemFrm6.setText("");
            elemBnz7.setText("");
            return;
        }
        for (int j = 0; j < ML.length; j++) {
            double Gk = 0, RV1 = 0, L = Integer.parseInt(roadText6.getText());
            for (int i = 0; i < elemCategories.length; i++) {
                MLk[j] += elemCategories[i][j];
            }
            Gk += Integer.parseInt(autoTextLightweight1.getText());
            Gk += Integer.parseInt(autoTextBusLight2.getText());
            Gk += Integer.parseInt(autoTextBusHeavy3.getText());
            Gk += Integer.parseInt(autoTextTruckLight4.getText());
            Gk += Integer.parseInt(autoTextTruckHeavy5.getText());
            RV1 += Integer.parseInt(avgSpeed.getSelectionModel().getSelectedItem());
            ML[j] = (L / 3600) * (MLk[j]) * Gk * RV1;
        }

        elemCO1.setText(String.valueOf(ML[0]));
        elemNO2.setText(String.valueOf(ML[1]));
        elemCH3.setText(String.valueOf(ML[2]));
        elemSazha4.setText(String.valueOf(ML[3]));
        elemSO5.setText(String.valueOf(ML[4]));
        elemFrm6.setText(String.valueOf(ML[5]));
        elemBnz7.setText(String.valueOf(ML[6]));
    }

    @FXML
    private void clearFields() {
        autoTextLightweight1.setText("");
        autoTextBusLight2.setText("");
        autoTextBusHeavy3.setText("");
        autoTextTruckLight4.setText("");
        autoTextTruckHeavy5.setText("");
        roadText6.setText("");
    }


}
