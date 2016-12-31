/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;


import Elements.Element;
import Elements.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author g.ioffe
 */
public class WorkPane {

   
    private final Pane root;
    private Map<String, Element> elements = new HashMap<>();

    public WorkPane(){
        this.root = new Pane();
    }
    
    public void addElement(Element element){
        this.addElement(element.getElement());
    }
    
    public Pane getPane(){
        return this.root;
    }
    
    private void addElement(Control element){
        this.root.getChildren().add(element);
    }
    
    public void addElement(List<Element> elems){
        elems.stream().forEach((elem) ->{
                this.root.getChildren().add(elem.getElement());
                elements.put(elem.getElementText(), elem);
        });
    }
    
    public void setOnClickAction(Field element){
        this.getPane().setOnKeyPressed((KeyEvent kev) -> {
            if (kev.getCode().isDigitKey()){
                BigDecimal curr = element.getFieldContent(true);
                BigDecimal n = new BigDecimal(new BigInteger(kev.getText()), curr.scale()+1);
                curr = curr.add(n);
                curr = element.getDotStatus() ? curr : curr.movePointRight(1);
                element.setFieldContent(curr);
                return;
            }
            Element elem = elements.get(kev.getText());
            if (elem != null){
                elem.run();
            }

        });
    }
}
