/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valid;

import java.util.Arrays;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author nghia
 */
public class MaxLength extends PlainDocument {

    private int limit;

    public MaxLength(int limit) {
        super();
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {
        if (str == null) {
            return;
        }
//        System.out.println("getLength() " + getLength()); //độ dài chuỗi trước khi insert ký tự mới
//        System.out.println("str.length() " + str.length()); //mỗi ký tự nhập vào
        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
        /**
         * GetLength() Returns the length of the data. This is the number of
         * characters of content that represents the users data.
         *
         * @return the length &gt;= 0
         * @see Document#getLength
         */
        /**
         * @param str the string to insert; does nothing with null/empty strings
         */
    }

    private static String txt="";
    public static void limitText(JTextField textField, int n){
        if (txt.length() <= n - 1) {
            txt = textField.getText().trim().substring(0, textField.getText().trim().length());
            System.out.println(txt);
        }else{
//            textField.setText("");
            textField.setText(txt.substring(0, txt.length()));
        }
    }
    
    public static void backSpace(JTextField textField){
        txt = textField.getText().trim().substring(0, textField.getText().trim().length());
    }
    
    private static char[] pw = {};

    public static void limitText(JPasswordField passwordField, int n) {
        if (pw.length <= n - 1) {
            pw = passwordField.getPassword();
            pw = Arrays.copyOf(passwordField.getPassword(), passwordField.getPassword().length);
            System.out.println(Arrays.toString(pw));
        } else {
            passwordField.setText(new String(pw));
        }
    }
    
    public static void backSpace(JPasswordField passwordField) {
        pw = Arrays.copyOf(passwordField.getPassword(), passwordField.getPassword().length);
    }
}
