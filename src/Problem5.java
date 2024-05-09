import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5 {
    public static void main(String[] args) throws IOException {
        // x^2 + y^2 = r^2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int r = Integer.parseInt(input);

        drawCircle(r);
    }

    private static void drawCircle(int r) {
        for (int i = -r; i <= r; i++) {
            for (int j = -r; j <= r; j++) {

                if (i * i + j * j <= r * r) {
                    System.out.print("*");
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
