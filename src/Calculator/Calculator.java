/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import Elements.Field;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author g.ioffe
 */
public class Calculator extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WorkPane workpane = new WorkPane();
        Field field = new Field();
        field.setCoordinates(50, 50);
        field.createMemory();
        workpane.addElement(field);
        workpane.setOnClickAction();
        ButtonAdder ba = new ButtonAdder(field);
        workpane.addElement(ba.addBtns(50, 125));
        Scene scene = new Scene(workpane.getPane(), 300, 250);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
}
