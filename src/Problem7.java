import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result = createAnt(Integer.parseInt(br.readLine()));

        System.out.println(result);
    }

    private static String createAnt(int num) {
        if(num == 1) {
            return "1";
        }

        StringBuilder sb = new StringBuilder();
        String pre = createAnt(num - 1);
        int count = 1;

        for(int i = 0; i < pre.length(); i++) {
            if(i + 1 >= pre.length() || pre.charAt(i) != pre.charAt(i + 1)) {
                sb.append(count).append(pre.charAt(i));
                count = 1;
                continue;
            }
            count++;
        }
        return sb.toString();
    }
}
