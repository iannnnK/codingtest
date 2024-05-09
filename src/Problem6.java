import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static void main(String[] args) {
        String input = "20200309_최종_확정2.png";

        String[] fileName = input.split(".");
        fileRename(fileName);
    }

    public static void fileRename(String[] input) {

        // 파일 저장
        // 같은 이름의 파일이 있으면 해당 키의 밸류 개수 이상으로 번호를 매긴 뒤, 출력
        HashMap<String, List<Integer>> map = new HashMap<>();
//        if(map.containsKey(input[0])) {
//            int number = map.get(input[0]).size() + 1;
//            map.put()
//        }

        // 확장자가 다를 경우 같은 이름이 아니므로 해당 부분 고려는 추후에 해보기
    }
}
