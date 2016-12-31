/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import Actions.Action;
import Commands.Command;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author g.ioffe
 */
public class Btn implements Element{

    private final Field field;
    private final Command command;
    private final Button btn;
    private Action act;
    private Element workingElement;

    public Btn(Field field, Command command, String btnText){
        this.field = field;
        this.command = command;
        this.btn = new Button();
        this.btn.setText(btnText);
    }
    
    @Override
    public void setCoordinates(double x, double y){
        this.btn.setLayoutX(x);
        this.btn.setLayoutY(y);
    }
    
    @Override
    public Button getElement(){
        return this.btn;
    }
    
    @Override
    public void setElementAction(Action act, Element workingElement){
        this.act = act;
        this.workingElement = workingElement;
        this.btn.setOnAction((ActionEvent event) -> {
            run();
        });
    }

    @Override
    public Field getField() {
       return this.field;
    }

    @Override
    public String getElementText() {
       return this.btn.getText();
    }

    @Override
    public void run() {
        try{
            act.execute(workingElement, this.command);
        }
        catch(Exception ex){
            this.getField().setFieldContent(ex);
        }
    }
}
