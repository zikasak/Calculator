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
public interface Command {
    
    BigDecimal execute(BigDecimal... args);
}
