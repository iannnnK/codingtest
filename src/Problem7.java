import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// TODO
//  수열이 잘못됨
//  재귀 함수 다시 공부
public class Problem7 {
    private static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        arr = new String[Integer.parseInt(num)];
        createAnt(Integer.parseInt(num));

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void createAnt(int num) {
        if (num == 1) {
            arr[0] = "1";
            return;
        }

        StringBuilder sb = new StringBuilder();
        createAnt(num - 1);
        String pre = arr[num - 2];

        int count = 1;

        for (int i = 0; i < pre.length(); i++) {
            if (i + 1 < pre.length() && pre.charAt(i) == pre.charAt(i + 1)) {
                count++;
                continue;
            }
            sb.append(pre.charAt(i)).append(count);
            count = 1;
        }
        arr[num - 1] = sb.toString();
    }
}
