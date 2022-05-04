/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valid;

/**
 *
 * @author nghia
 */
public class Valid {
    public static boolean isTextValid(String input, String regex){
        return input.matches(regex); //true nếu khớp
    }
}
