/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Commands.Command;
import Commands.NeutralCommand;
import Elements.Element;
import Elements.Field;
import java.math.BigDecimal;

/**
 *
 * @author zikas
 */
public class ClearAction implements Action{

    @Override
    public void execute(Element element, Command command) {
        try{
            Field field = element.getField();
            if (field.getBinaryCommand().getClass().equals(NeutralCommand.class)){
                throw new RuntimeException();
            }
            field.getFieldContent(true);
            field.setDotSettedStatus(false);
            field.setFieldContent(new BigDecimal("0"));
        }
        catch(Exception ex){
            ClearAllAction caa = new ClearAllAction();
            caa.execute(element, command);
        }
        
    }
    
}
