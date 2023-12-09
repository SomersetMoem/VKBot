package helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static String removeBracketsAndContents(String input) {
        String regex = "\\[.*?\\]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll("");
    }

    public static String removeParenthesesAndContents(String input) {
        String regex = "\\(.*?\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll("");
    }

    public static String removeBracesAndContents(String input) {
        String regex = "\\{.*?\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll("");
    }
}
