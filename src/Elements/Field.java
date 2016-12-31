/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import Actions.Action;
import Commands.Command;
import Commands.plusCommand;
import java.math.BigDecimal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

/**
 *
 * @author zikas
 */
public class Field implements Element{
    
    private final TextField field;
    private boolean isDotPlaced;
    private boolean isOperationChanged;
    private String prevFieldText;
    private Field memoryField = this;
    private Command currentBinaryCommand;
    private Action act;
    private Element workingElement;

    public Field(){
        this.field = new TextField();
        this.field.setDisable(true);
        this.setDefaultState();
    }
    
    public void createMemory(){
        this.memoryField = new Field();
    };
    
    @Override
    public void setCoordinates(double x, double y){
        this.field.setLayoutX(x);
        this.field.setLayoutY(y);
    }
    
    public void setFieldContent(BigDecimal text){
        this.field.setText(text.toPlainString());
    }
    
    public void setFieldContent(Exception ex){
        this.field.setText(ex.getMessage());
    }
    
    public BigDecimal getPrevFieldContent(){
        return new BigDecimal(this.prevFieldText);
    }
    
    public void setOperationStatus(boolean b){
        this.isOperationChanged = b;
    }
    
    public boolean getOperationStatus(){
        return isOperationChanged;
    }
    
    public void setPrevFieldText(){
        this.prevFieldText = this.field.getText();
    }
    
    public BigDecimal getFieldContent(boolean isActualNeeded){
        if (isOperationChanged && !isActualNeeded){
            isDotPlaced = false;
            isOperationChanged = !isOperationChanged;
            return new BigDecimal("0");
        }
        String cont = this.field.getText().equals("") ? "0" : "";
        return new BigDecimal(this.field.getText()+cont);
    }
    
    public void setBinaryCommand(Command bc){
        this.currentBinaryCommand = bc;
    }
    
    public Command getBinaryCommand(){
        return this.currentBinaryCommand;
    }
    
    public void setDotSettedStatus(boolean st){
        this.isDotPlaced = st;
    }
    
    public boolean getDotStatus(){
        return this.isDotPlaced;
    }
    
    public final void setDefaultState(){
        this.isDotPlaced = false;
        this.field.setText("0");
        this.currentBinaryCommand = new plusCommand();
        this.prevFieldText = "0";
        this.isOperationChanged = false;
    }
    
    @Override
    public TextField getElement(){
        return this.field;
    }
    

    @Override
    public void setElementAction(Action act, Element workingElement) {
        this.act = act;
        this.workingElement = workingElement;
        this.field.setOnAction((ActionEvent event ) ->
           run());
    }

    public Field getMemory() {
        return this.memoryField;
    }
    
    @Override
    public Field getField() {
        return this;
    }

    @Override
    public String getElementText() {
        return "";
    }

    @Override
    public void run() {
        act.execute(workingElement, currentBinaryCommand);
    }
}
