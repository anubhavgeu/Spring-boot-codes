package regex;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDynamicExample {
    public static void checkStringAgainstRegEx(String regEx, String str) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        boolean matches = matcher.matches();
        System.out.println(matches);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter regEx: ");
        String regEx = sc.nextLine();
        System.out.print("Enter input string: ");
        String str = sc.nextLine();
        checkStringAgainstRegEx(regEx,str);
    }
}
