/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elements;

import Actions.AddNumToFieldAction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g.ioffe
 */
public class NumberKeys {

    private final Field field;
    private final AddNumToFieldAction antfa = new AddNumToFieldAction();
    private double ycoord;
    private double xcoord;
    public NumberKeys(Field field){
        this.field = field;
    }
    
    public void setCoordinates(double x, double y){
        xcoord = x;
        ycoord = y;
    }
    
    public List<Btn> getBtns(){
        List<Btn> btns = new ArrayList<>();
        double x=0,y=0;
        for(int line = 0; line < 3; line++)
        {
            y = ycoord + (25 *(2-line));
            for(int column = 2; column >= 0; column--)
            {
                x = xcoord + 25*column; 
                Btn btn = getBtn(Integer.toString(3*line + column + 1), x, y);
                btns.add(btn);
            }
        }
        Btn btn = getBtn(Integer.toString(0), x, y+75);
        btns.add(btn);
        return btns;
    }
    
    private Btn getBtn(String text, double xcoord, double ycoord){
        Btn btn = new Btn(field, null, text);
        btn.setCoordinates(xcoord, ycoord);
        btn.setElementAction(antfa);
        return btn;
    }
}
