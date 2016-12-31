/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import Actions.*;
import Commands.Command;
import Commands.DivisionCommand;
import Commands.MultiplyCommand;
import Commands.minusCommand;
import Commands.NeutralCommand;
import Commands.PercentCommand;
import Commands.nullCommand;
import Commands.plusCommand;
import Commands.sqrtCommand;
import Elements.Btn;
import Elements.Field;
import Elements.Element;
import Elements.NumberKeys;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zikas
 */
public class ButtonAdder {

    private final Field field;

    public ButtonAdder(Field field){
        this.field = field;
    }
    
    /**
     *
     * @param xcoord x coordinate of top left corner
     * @param ycoord y coordinate of top left corner
     * @return 
     */
    public List<Element> addBtns (double xcoord, double ycoord){
        List<Element> elems = new ArrayList<>();
        
        elems.add(getBtn(plusCommand.class, MemorySetAction.class, xcoord, ycoord, "M+" ));
        elems.add(getBtn(minusCommand.class, MemorySetAction.class, xcoord + 25, ycoord, "M-" ));
        elems.add(getBtn(nullCommand.class, MemoryClearAction.class, xcoord + 50, ycoord, "MC" ));
        elems.add(getBtn(NeutralCommand.class, MemoryGetAction.class, xcoord + 75, ycoord, "MR" ));
        elems.addAll(getNumKeys(xcoord, ycoord+25));
        elems.add(getBtn(nullCommand.class, DotAction.class, xcoord + 25, ycoord + 100, "."));
        elems.add(getBtn(plusCommand.class, BinaryAction.class, xcoord + 75, ycoord + 75, "+"));
        elems.add(getBtn(NeutralCommand.class, BinaryAction.class, xcoord + 50, ycoord + 100, "="));
        elems.add(getBtn(sqrtCommand.class, UnaryAction.class, xcoord + 75, ycoord + 25, "\u221A"));
        elems.add(getBtn(minusCommand.class, BinaryAction.class, xcoord + 75, ycoord + 50, "-"));
        elems.add(getBtn(PercentCommand.class, PercentAction.class, xcoord + 100, ycoord + 50, "\u0025"));
        elems.add(getBtn(nullCommand.class, ClearAllAction.class, xcoord + 100, ycoord + 25, "C"));
        elems.add(getBtn(MultiplyCommand.class, BinaryAction.class, xcoord + 100, ycoord + 75, "*"));
        elems.add(getBtn(nullCommand.class, ClearAction.class, xcoord + 125, ycoord + 25, "CE"));
        elems.add(getBtn(DivisionCommand.class, BinaryAction.class, xcoord + 125, ycoord + 50, "/"));
        return elems;
    }
    
    private List<Btn> getNumKeys(double x, double y){
        NumberKeys nmkeys = new NumberKeys(field);
        nmkeys.setCoordinates(x, y);
        return nmkeys.getBtns();
    }
        
    private Btn getBtn(Class command, Class action, double x, double y, String text){
        try {
            Object comm = command.newInstance();
            Object act = action.newInstance();
            Btn btn = new Btn(field, (Command) comm, text);
            btn.setCoordinates(x, y);
            btn.setElementAction((Action) act, btn);
            return btn;
        } catch (InstantiationException | IllegalAccessException ex) {
        }
        return null;
    }
}
