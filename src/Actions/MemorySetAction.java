/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Commands.Command;
import Elements.Element;
import Elements.Field;
import java.math.BigDecimal;

/**
 *
 * @author zikas
 */
public class MemorySetAction implements Action {

    @Override
    public void execute(Element element, Command command) {
        Field field = element.getField();
        Field memory = field.getMemory();
        BigDecimal leftOper = field.getFieldContent(true);
        BigDecimal rightOper = memory.getFieldContent(true);
        BigDecimal res = command.execute(leftOper, rightOper);
        memory.setFieldContent(res);
    }
    
}
