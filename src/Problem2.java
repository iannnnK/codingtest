import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        int[][] arr = {
                {9, 11, 16, 21, 28, 36, 5},
                {3, 9, 10, 29, 40, 45, 7},
                {2, 5, 12, 14, 24, 39, 33},
                {1, 6, 13, 37, 38, 40, 9},
                {1, 21, 25, 29, 34, 37, 36}
        };

        unionArr(arr);
    }

    private static int[] unionArr(int[][] arr) {

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(list.contains(arr[i][j])) {
                    continue;
                }
                list.add(arr[i][j]);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
