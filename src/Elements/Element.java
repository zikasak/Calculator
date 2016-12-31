/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import Actions.Action;
import javafx.scene.control.Control;

/**
 *
 * @author zikas
 */
public interface Element {
    
    void setCoordinates(double x, double y);
    Control getElement();

    void setElementAction(Action act);
    Field getField();
    String getElementText();
    void run();
    
}
