/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author zikas
 */
public class DivisionCommand implements Command{

    @Override
    public BigDecimal execute(BigDecimal... args) {
        if (args.length != 2) throw new RuntimeException("Wrong number of arguments");
        return args[0].divide(args[1], new MathContext(15, RoundingMode.HALF_UP));
    }

    
}
