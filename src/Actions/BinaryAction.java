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
public class BinaryAction implements Action{

    @Override
    public void execute(Element element, Command command) {
        Field field = element.getField();
        Command bc = field.getBinaryCommand();
        BigDecimal leftOper = field.getPrevFieldContent();
        BigDecimal rightOper = field.getFieldContent(false);
        BigDecimal res = bc.execute(leftOper, rightOper);
        field.setFieldContent(res);
        field.setPrevFieldText();
        field.setBinaryCommand(command);
        field.setOperationStatus(true);
    }
    
}
