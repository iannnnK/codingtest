public class Problem1 {
    public static void main(String[] args) {
        String input = "HELLO";
        String answer = reverseStr(input);
        System.out.println(answer);
    }

    private static String reverseStr(String input) {
        char[] arr = input.toCharArray();
        String answer = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            answer += arr[i];
        }
        return answer;
    }
}
