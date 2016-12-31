/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.math.BigDecimal;

/**
 *
 * @author zikas
 */
public class MultiplyCommand implements Command{

    @Override
    public BigDecimal execute(BigDecimal... args) {
        if (args.length != 2) throw new RuntimeException("Wrong number of arguments");
        return args[0].multiply(args[1]);
    }
    
}
