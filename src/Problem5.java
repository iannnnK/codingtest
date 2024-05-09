public class Problem5 {
    public static void main(String[] args) {
        // x^2 + y^2 = r^2
        int r = 20;
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
