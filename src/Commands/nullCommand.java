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
public class nullCommand implements Command {

    @Override
    public BigDecimal execute(BigDecimal... args) {
        return null;
    }
    
}
