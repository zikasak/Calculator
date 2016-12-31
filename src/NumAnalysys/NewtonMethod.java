/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NumAnalysys;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author g.ioffe
 */
public class NewtonMethod {

    private final BigDecimal right;
    private final BigDecimal square;

    public NewtonMethod(BigDecimal right, BigDecimal square){
        this.right = right;
        this.square = square;
    }
    
    public BigDecimal solve(BigDecimal precision){
        BigDecimal prev = right;
        BigDecimal curr = step(prev);
        while (compare(prev, curr, precision) == 1){
            prev = curr;
            curr = step(prev);
        }
        return curr;
    }
    
    private BigDecimal step(BigDecimal x){
        BigDecimal sum = x.add(square.divide(x, 30, RoundingMode.HALF_UP));
        return sum.divide(new BigDecimal("2"));
    }
    
    private int compare(BigDecimal first, BigDecimal second, BigDecimal precision){
        return first.subtract(second).abs().compareTo(precision);
    }
}
