/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import java.math.BigDecimal;

/**
 *
 * @author g.ioffe
 */
public class BigDecimalOperations {
    public static BigDecimal scaleByTen(BigDecimal operand){
        String num = operand.toPlainString();
        int currScale = num.indexOf(".");
        return operand.scaleByPowerOfTen(-currScale + 1);
    }
}
