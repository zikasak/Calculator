/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Commands.Command;
import Elements.Element;
import Elements.Field;

/**
 *
 * @author zikas
 */
public class MemoryGetAction implements Action{

    @Override
    public void execute(Element element, Command command) {
        Field field = element.getField();
        Field memory = field.getMemory();
        field.setFieldContent(memory.getFieldContent(true));
    }
    
}
