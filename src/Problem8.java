import java.util.regex.Pattern;

// 함수화
public class Problem8 {
    public static void main(String[] args) {
        String pattern = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,}+$";

        System.out.println(Pattern.matches(pattern, "980121231$"));
    }
}
