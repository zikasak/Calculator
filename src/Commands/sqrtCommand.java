/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Calculator.BigDecimalOperations;
import NumAnalysys.NewtonMethod;
import java.math.BigDecimal;
import java.math.BigInteger;
/**
 *
 * @author g.ioffe
 */
public class sqrtCommand implements Command{

    @Override
    public BigDecimal execute(BigDecimal... args) {
        if (args.length != 1) throw new RuntimeException("Wrong number of arguments");
        BigDecimal operand = args[0];
        if (operand.compareTo(operand.abs()) != 0)
            throw new RuntimeException("Number below zero");
        BigDecimal localisation = findRoot(operand);
        NewtonMethod nm = new NewtonMethod(localisation, operand);
        return nm.solve(new BigDecimal("0.000000001"));
    }
    
    private BigDecimal findRoot(BigDecimal operand){
        BigDecimal square = BigDecimalOperations.scaleByTen(operand);
        int sqrtscale = (int) Math.round(Math.sqrt(square.scale()));
        BigInteger unscaled = new BigInteger("1");
        BigDecimal right = new BigDecimal(unscaled, sqrtscale + 1);
        return right;
    }

}
