import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        String input = "1234567890";

        // SecureRandom 사용
        System.out.println(createRandomStr(input));
        // Collections.shuffle() 사용
        System.out.println(shuffleStr(input));
    }

    private static String createRandomStr(String input) {
        SecureRandom random = new SecureRandom();

        char[] arr = input.toCharArray();
        int size = input.length();
        String result = "";
        for(int i = 0; i < size; i++) {
            int idx = random.nextInt(size);
            char t = arr[idx];
            arr[idx] = arr[i];
            arr[i] = t;
        }

        for(int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }

    // secure 하지는 않지만, Collections.shuffle을 이용한 비교적 간단한 풀이방법
    private static String shuffleStr(String input) {
        List<Character> list = new ArrayList<>();
        for (char c : input.toCharArray()) {
            list.add(c);
        }

        String answer = "";
        Collections.shuffle(list);
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }

        return answer;
    }
}
