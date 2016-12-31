/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Commands.Command;
import Elements.Element;

/**
 *
 * @author zikas
 */
public class ClearAllAction implements Action{

    @Override
    public void execute(Element element, Command command) {
        element.getField().setDefaultState();
    }
    
}
