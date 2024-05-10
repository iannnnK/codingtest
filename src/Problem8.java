import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Problem8 {
    private static final String pattern = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,}+$";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean check = validCheckPassword(br.readLine());
        System.out.println(check);
    }

    private static boolean validCheckPassword(String input) {
        return Pattern.matches(pattern, input);
    }
}