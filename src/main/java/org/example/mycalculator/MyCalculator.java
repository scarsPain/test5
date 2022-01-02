package org.example.mycalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class MyCalculator<T extends Event> extends Application implements EventHandler<T> {
    private String currOp;
    private StringBuilder nextNum;
    private int maxHBox;
    private int maxRowElem;
    private int i;
    private int flag;
    private Double res;
    private String virgo;
    private Label label;
    private VBox layout;
    private ArrayList<HBox> hBox;
    private ArrayList<String> firstRowElem;
    private ArrayList<String> secondRowElem;
    private ArrayList<String> thirdRowElem;
    private ArrayList<String> fourthRowElem;
    private ArrayList<String> fifthRowElem;
    private ArrayList<Button> firstRow;
    private ArrayList<Button> secondRow;
    private ArrayList<Button> thirdRow;
    private ArrayList<Button> fourthRow;
    private ArrayList<Button> fifthRow;
    //////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        launch(args);
    }
    //////////////////////////////////////////////////////////////
    @Override
    public void start(Stage stage) {
        maxHBox = 5;
        maxRowElem = 4;
        flag = 0;
        res = 0.0;
        virgo = "";
        hBox = new ArrayList<>();
        firstRowElem = new ArrayList<>();
        secondRowElem = new ArrayList<>();
        thirdRowElem = new ArrayList<>();
        fourthRowElem = new ArrayList<>();
        fifthRowElem = new ArrayList<>();
        firstRow = new ArrayList<>();
        secondRow = new ArrayList<>();
        thirdRow = new ArrayList<>();
        fourthRow = new ArrayList<>();
        fifthRow = new ArrayList<>();
        label = new Label();

        setHBoxes();
        setLayout();
        Scene scene = new Scene(layout, 200, 300);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }
    ///////////////////////////////////
    public void setLayout() {
        layout = new VBox();
        for(i = 0; i <= maxHBox; i++) {
            layout.getChildren().add(hBox.get(i));
        }
    }
    ///////////////////////////////////////////////////////
    public void setHBoxes() {
        for(int index = 0; index <= maxHBox; index++) {
            hBox.add(new HBox());
            hBox.get(index).setPrefWidth(50);
            hBox.get(index).setPrefHeight(50);
            switch(index) {
                case 0:
                    hBox.get(index).getChildren().add(label);
                    hBox.get(index).setAlignment(Pos.CENTER);
                    break;
                case 1:
                    firstRow();
                    setHBBoxesChildren(index, firstRow);
                    break;
                case 2:
                    secondRow();
                    setHBBoxesChildren(index, secondRow);
                    break;
                case 3:
                    thirdRow();
                    setHBBoxesChildren(index, thirdRow);
                    break;
                case 4:
                    fourthRow();
                    setHBBoxesChildren(index, fourthRow);
                    break;
                case 5:
                    fifthRow();
                    setHBBoxesChildren(index, fifthRow);
                    break;
                default:
                    break;
            }
        }
    }
    ///////////////////////////////////////////////////////
    public void populateFirstRow() {
        for(i = 0; i < maxRowElem; i++) {
            switch(i) {
                case 0:
                    firstRowElem.add(i, "C");
                    break;
                case 1:
                    firstRowElem.add(i, "<-");
                    break;
                case 2:
                    firstRowElem.add(i, "%");
                    break;
                case 3:
                    firstRowElem.add(i, "/");
                    break;
                default:
                    break;
            }
        }
    }
    ////////////////////////////////////////////////////////
    public void populateSecondRow() {
        for(i = 0; i < maxRowElem; i++) {
            switch(i) {
                case 0:
                    secondRowElem.add(i, "7");
                    break;
                case 1:
                    secondRowElem.add(i, "8");
                    break;
                case 2:
                    secondRowElem.add(i, "9");
                    break;
                case 3:
                    secondRowElem.add(i, "x");
                    break;
                default:
                    break;
            }
        }
    }
    ////////////////////////////////////////////////////////
    public void populateThirdRow() {
        for(i = 0; i < maxRowElem; i++) {
            switch(i) {
                case 0:
                    thirdRowElem.add(i, "4");
                    break;
                case 1:
                    thirdRowElem.add(i, "5");
                    break;
                case 2:
                    thirdRowElem.add(i, "6");
                    break;
                case 3:
                    thirdRowElem.add(i, "-");
                    break;
                default:
                    break;
            }
        }
    }
    ////////////////////////////////////////////////////////
    public void populateFourthRow() {
        for(i = 0; i < maxRowElem; i++) {
            switch(i) {
                case 0:
                    fourthRowElem.add(i, "1");
                    break;
                case 1:
                    fourthRowElem.add(i, "2");
                    break;
                case 2:
                    fourthRowElem.add(i, "3");
                    break;
                case 3:
                    fourthRowElem.add(i, "+");
                    break;
                default:
                    break;
            }
        }
    }
    ///////////////////////////////////////////////////////
    public void populateFifthRow() {
        for(i = 0; i < maxRowElem - 1; i++) {
            switch(i) {
                case 0:
                    fifthRowElem.add(i, "0");
                    break;
                case 1:
                    fifthRowElem.add(i, ",");
                    break;
                case 2:
                    fifthRowElem.add(i, "=");
                    break;
                default:
                    break;
            }

        }

    }
    //////////////////////////////////////
    @SuppressWarnings("unchecked")
    public void firstRow() {
        populateFirstRow();
        for(i = 0; i < maxRowElem; i++) {
            firstRow.add(new Button(firstRowElem.get(i)));
            firstRow.get(i).setOnAction((EventHandler<ActionEvent>) this);
            if(i != 0) firstRow.get(i).setDisable(true);
        }
    }
    ////////////////////////////////////
    @SuppressWarnings("unchecked")
    public void secondRow() {
        populateSecondRow();
        for(i = 0; i < maxRowElem; i++) {
            secondRow.add(new Button(secondRowElem.get(i)));
            secondRow.get(i).setOnAction((EventHandler<ActionEvent>) this);
            if(i == maxRowElem - 1) secondRow.get(i).setDisable(true);
        }
    }
    /////////////////////////////////////
    @SuppressWarnings("unchecked")
    public void thirdRow() {
        populateThirdRow();
        for(i = 0; i < maxRowElem; i++) {
            thirdRow.add(new Button(thirdRowElem.get(i)));
            thirdRow.get(i).setOnAction((EventHandler<ActionEvent>) this);
            if(i == maxRowElem - 1) thirdRow.get(i).setDisable(true);
        }
    }
    ////////////////////////////////////
    @SuppressWarnings("unchecked")
    public void fourthRow() {
        populateFourthRow();
        for(i = 0; i < maxRowElem; i++) {
            fourthRow.add(new Button(fourthRowElem.get(i)));
            fourthRow.get(i).setOnAction((EventHandler<ActionEvent>) this);
            if(i == maxRowElem - 1) fourthRow.get(i).setDisable(true);
        }
    }
    //////////////////////////////////////
    @SuppressWarnings("unchecked")
    public void fifthRow() {
        populateFifthRow();
        for(i = 0; i < maxRowElem - 1; i++) {
            fifthRow.add(new Button(fifthRowElem.get(i)));
            fifthRow.get(i).setOnAction((EventHandler<ActionEvent>) this);
            if(i == maxRowElem - 2 || i == maxRowElem - 3) fifthRow.get(i).setDisable(true);
        }
    }
    ///////////////////////////////////////////////////
    @Override
    public void handle(Event event) {
        if(res != 0.0) {
            label.setText("");
            res = 0.0;
        }
        Button button = (Button)event.getSource();
        if(firstRow.contains(button)) {
            setFirstRowEvent(event);
        }else {
            if(secondRow.contains(button)) {
                setEvent(secondRow, "x", event);
            }else if(thirdRow.contains(button)) {
                setEvent(thirdRow, "-", event);
            }else if(fourthRow.contains(button)) {
                setEvent(fourthRow, "+", event);
            }else if(fifthRow.contains(button)) {
                setLastRowEvent(event);
            }
        }
    }
    //////////////////////////////////////////
    public void enableDisabledButtons() {
        enableFirstRow();
        enableSecondRow();
        enableThirdRow();
        enableFourthRow();
        enableFifthRow();
    }
    ////////////////////////////////////////////
    public void enableFirstRow() {
        for(i = 1; i < firstRow.size(); i++) {
            firstRow.get(i).setDisable(false);
        }
    }
    public void enableSecondRow() {
        secondRow.get(secondRow.size() - 1).setDisable(false);
    }
    public void enableThirdRow() {
        thirdRow.get(thirdRow.size() - 1).setDisable(false);
    }
    public void enableFourthRow() {
        fourthRow.get(fourthRow.size() - 1).setDisable(false);
    }
    public void enableFifthRow() {
        for(i = 1; i < fifthRow.size(); i++) {
            fifthRow.get(i).setDisable(false);
        }
    }
    ////////////////////////////////////////////////
    public void disableEnabledButtons() {
        disableFirstRow();
        disableSecondRow();
        disableThirdRow();
        disableFourthRow();
        disableFifthRow();
    }
    /////////////////////////////////////////////////
    public void disableFirstRow() {
        for(i = 2; i < firstRow.size(); i++) {
            firstRow.get(i).setDisable(true);
        }
    }
    public void disableSecondRow() {
        secondRow.get(secondRow.size() - 1).setDisable(true);
    }
    public void disableThirdRow() {
        thirdRow.get(thirdRow.size() - 1).setDisable(true);
    }
    public void disableFourthRow() {
        fourthRow.get(fourthRow.size() - 1).setDisable(true);
    }
    public void disableFifthRow() {
        for(i = 1; i < fifthRow.size(); i++) {
            fifthRow.get(i).setDisable(true);
        }
    }
    /////////////////////////////////////////////////////////
    public void calcExpr() {
        StringBuilder prevNum = new StringBuilder();
        currOp = "";
        nextNum = new StringBuilder();
        for(i = 0; i < label.getText().length(); i++) {
            if(label.getText().charAt(i) == '+') {
                analyzeOp('+', i);
            }else if(label.getText().charAt(i) == '-') {
                analyzeOp('-', i);
            }else if(label.getText().charAt(i) == 'x') {
                analyzeOp('x', i);
            }else if(label.getText().charAt(i) == '/') {
                analyzeOp('/', i);
            }else {
                if(currOp.equals("")) {
                    prevNum.append(label.getText().charAt(i));
                }else {
                    if(res == 0.0) {
                        res = Double.parseDouble(prevNum.toString());
                        prevNum = new StringBuilder();
                    }
                    nextNum.append(label.getText().charAt(i));
                }
            }
        }
        lastOpStep();
        disableEnabledButtons();
    }
    ///////////////////////////////////////////////////////////
    public void verifyPercent() {
        String singleNum = "";
        double perNum;
        StringBuilder str = new StringBuilder();
        for(i = label.getText().length() - 1; i >= 0;i--) {
            if(label.getText().charAt(i) == '+' || label.getText().charAt(i) == '-' || label.getText().charAt(i) == '/' || label.getText().charAt(i) == 'x') {
                singleNum = "";
                break;
            }
            else {
                str.append(label.getText().charAt(i));
                singleNum = str.toString();
            }
        }
        if(!singleNum.equals("")) {
            perNum = Double.parseDouble(new StringBuffer(singleNum).reverse().toString());
            perNum /= 100;
            res = perNum;
            label.setText(String.valueOf(res));
            virgo = "";
            disableEnabledButtons();
        }
    }
    ////////////////////////////////////////////////////////////////
    public void removeLastNum() {
        if(label.getText().length() > 0) {
            label.setText(new StringBuffer(label.getText())
                    .deleteCharAt(label.getText().length() - 1)
                    .toString());
        }

        if(label.getText().length() > 0) {
            if(label.getText().charAt(label.getText().length() - 1) == '+' || label.getText().charAt(label.getText().length() - 1) == '-' || label.getText().charAt(label.getText().length() - 1) == '/' || label.getText().charAt(label.getText().length() - 1) == 'x' || label.getText().charAt(label.getText().length() - 1) == '.') {
                disableEnabledButtons();
            }else {
                enableDisabledButtons();
            }
        }
        if(label.getText().equals("")) {
            disableEnabledButtons();
        }
        virgo = "";
    }
    //////////////////////////////////////////////////////////////////////////
    public void setHBBoxesChildren(int index, List<Button> selectedRow) {
        int j;
        for(j = 0; j < selectedRow.size(); j++) {
            if(selectedRow == fifthRow && j == 0) {
                selectedRow.get(j).setMinWidth(2*hBox.get(index).getPrefWidth());
            }else {
                selectedRow.get(j).setMinWidth(hBox.get(index).getPrefWidth());
            }
            selectedRow.get(j).setMinHeight(hBox.get(index).getPrefHeight());
            hBox.get(index).getChildren().add(selectedRow.get(j));
        }
    }
    /////////////////////////////////////////////////////////////////////////////
    public void setEvent(List<Button> selectedRow, String op, Event event) {
        for (Button button : selectedRow) {
            if (button.equals(event.getSource())) {
                label.setText(label.getText() + button.getText());
                if (button.getText().equals(op)) {
                    virgo = "";
                    disableEnabledButtons();
                } else {
                    enableDisabledButtons();
                    if (virgo.equals(",")) fifthRow.get(fifthRow.size() - 2).setDisable(true);
                }
            }
        }
    }
    /////////////////////////////////////////////////
    public void setFirstRowEvent(Event event) {
        for (Button button : firstRow) {
            if (button.equals(event.getSource())) {
                if (button.getText().equals("C")) {
                    label.setText("");
                    virgo = "";
                    disableEnabledButtons();
                } else if (button.getText().equals("/")) {
                    label.setText(label.getText() + button.getText());
                    virgo = "";
                    disableEnabledButtons();
                } else if (button.getText().equals("%")) {
                    verifyPercent();
                } else {
                    removeLastNum();
                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////
    public void setLastRowEvent(Event event) {
        for (Button button : fifthRow) {
            if (button.equals(event.getSource())) {
                if (button.getText().equals(",") && virgo.equals("")) {
                    label.setText(label.getText() + ".");
                    virgo = ",";
                    disableEnabledButtons();
                } else {
                    if (button.getText().equals("0")) {
                        label.setText(label.getText() + button.getText());
                        enableDisabledButtons();
                    } else {
                        calcExpr();
                        verifyFlag();
                    }
                }
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////
    public void analyzeOp(char op, int i) {
        if(currOp.equals("")) {
            currOp = String.valueOf(label.getText().charAt(i));
        }else {
            switch (currOp) {
                case "+":
                    res += Double.parseDouble(String.valueOf(nextNum));
                    nextNum = new StringBuilder();
                    currOp = String.valueOf(op);
                    break;
                case "-":
                    res -= Double.parseDouble(String.valueOf(nextNum));
                    nextNum = new StringBuilder();
                    currOp = String.valueOf(op);
                    break;
                case "x":
                    res *= Double.parseDouble(String.valueOf(nextNum));
                    nextNum = new StringBuilder();
                    currOp = String.valueOf(op);
                    break;
                default:
                    res /= Double.parseDouble(String.valueOf(nextNum));
                    nextNum = new StringBuilder();
                    currOp = String.valueOf(op);
                    break;
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////
    public void lastOpStep() {
        if(currOp.equals("+")) {
            res += Double.parseDouble(String.valueOf(nextNum));
        }else {
            switch (currOp) {
                case "-":
                    res -= Double.parseDouble(String.valueOf(nextNum));
                    break;
                case "x":
                    res *= Double.parseDouble(String.valueOf(nextNum));
                    break;
                case "/":
                    res /= Double.parseDouble(String.valueOf(nextNum));
                    break;
                default:
                    flag++;
                    break;
            }
        }
    }
    /////////////////////////////////////////////////
    public void verifyFlag() {
        if(flag == 0) {
            label.setText(String.valueOf(res));
        }else {
            label.setText("");
            flag--;
        }
    }
/////////////////////////////////////////////////
}


