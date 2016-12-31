/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;


import Elements.Element;
import Elements.Field;
import javafx.scene.control.Control;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author g.ioffe
 */
class WorkPane {

   
    private final Pane root;
    private Map<String, Element> elements = new HashMap<>();

    WorkPane(){
        this.root = new Pane();
    }
    
    void addElement(Element element){
        this.addElement(element.getElement());
    }
    
    Pane getPane(){
        return this.root;
    }
    
    private void addElement(Control element){
        this.root.getChildren().add(element);
    }
    
    void addElement(List<Element> elems){
        elems.forEach((elem) -> {
            this.root.getChildren().add(elem.getElement());
            elements.put(elem.getElementText(), elem);
        });
    }
    
    void setOnClickAction(Field element){
        this.getPane().setOnKeyPressed((KeyEvent kev) -> {
            Element elem = elements.get(kev.getText());
            if (elem != null){
                elem.run();
            }
        });
    }
}
