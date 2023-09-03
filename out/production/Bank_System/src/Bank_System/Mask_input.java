package Bank_System;

import java.io.Console;
import java.util.Scanner;

public class Mask_input {

    public static void main(String[] argv) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String password;
        System.out.println("input your password");
        password = scanner.nextLine();


        System.out.println(asterisk(password));
    }/*from ww  w  . j av a  2s . com*/

    public static String asterisk(String password) {
        if (password == null) {
            return null;
        }

        char[] chs = new char[password.length()];
        for (int i = 1; i < chs.length; i++) {
            chs[i] = '*';
        }
        chs[0] = password.charAt(0);
        chs[chs.length - 1] = password.charAt(password.length() - 1);
        return new String(chs);
    }
}


