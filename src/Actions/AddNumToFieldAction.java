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
import java.math.BigInteger;

/**
 *
 * @author zikas
 */
public class AddNumToFieldAction implements Action{

    @Override
    public void execute(Element element, Command command) {
        Field field = element.getField();
        BigDecimal fc = field.getFieldContent(false);
        BigDecimal num = new BigDecimal(new BigInteger(element.getElementText()), fc.scale()+1);
        fc = fc.add(num);
        fc = field.getDotStatus() ? fc : fc.movePointRight(1);
        field.setFieldContent(fc); 
    }
    
}
