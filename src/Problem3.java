import java.security.SecureRandom;
import java.util.Random;

public class Problem3 {
    public static void main(String[] args) {
        String input = "1234567890";
        boolean[] visited = new boolean[input.length()];

        SecureRandom r = new SecureRandom();
        Random random = new Random();
        String answer = "";

        // 불필요한 반복이 있음
        while(answer.length() < input.length()) {
            int now = random.nextInt(input.length());
            if(visited[now]) {
                continue;
            }

            visited[now] = true;
            answer += input.charAt(now);
        }
        System.out.println(answer);
    }
}
