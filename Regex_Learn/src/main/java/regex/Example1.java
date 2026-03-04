package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example1 {
    public static void main(String[] args) {
        String regex = "a";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern);
        Matcher matcher = pattern.matcher("a");
        System.out.println(matcher.find());
    }
}
