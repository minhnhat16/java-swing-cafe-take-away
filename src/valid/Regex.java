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
public class Regex {

    public static final String W = "\\w+"; //[0-9][a-z][A-Z]_
    public static final String SDT = "0[0-9]{9}";
    public static final String TAI_KHOAN = "[\\w\\S]*";
    public static final String NUMBER = "[0-9]*";
    public static final String SLCAN = "\\d*\\.\\d*";

//    public static void main(String[] args) {
//        System.out.println("Diachi nha".matches(TAI_KHOAN));
//        System.out.println("123.3.".matches(SLCAN));
//        System.out.println("0123123123".matches(SDT));
//    }
}
