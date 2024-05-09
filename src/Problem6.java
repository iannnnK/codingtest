import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 6.
- 재귀적 호출 이해(7번과 같이 재귀적 호출/함수 필요)
- 문제의 파일 리스트 배열에 넣어놓고, 중복된 파일명을 입력하여 파일명이 정상적으로 바뀌는 지 확인
- java.io 또는 java.nio 이용하여 실제 디렉토리의 파일을 읽어서 진행해 볼 것(옵션)

* */
public class Problem6 {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<FileName, Integer> map = new HashMap<>();
        while (true) {
            String input = br.readLine();
            if ("stop".equals(input)) {
                break;
            }
            createFile(input, map);
            System.out.println();
        }

        //

    }

    private static void createFile(String input, Map<FileName, Integer> map) {
        FileName file = new FileName(input);
        if (map.containsKey(file)) {
//            map.compute(file, (k, num) -> num + 1);
            int num = map.get(file);
            map.put(file, num + 1);
//            file.setNum(num + 1);
        } else {
            map.put(file, 0);
        }

        System.out.println(file);
    }
}

class FileName {
    private String name;
    private int num;
    private String ext;
    private FileName next;

    public FileName(String input) {
        parseFileName(input);
    }

    // file 이름만 파싱하는 기능
    private void parseFileName(String input) {
        int dotIdx = input.lastIndexOf('.');
        String name = input.substring(0, dotIdx);
        extractNumberIdx(name);
        this.ext = input.substring(dotIdx);
    }

    // 적절한 위치에 괄호와 숫자가 존재하는지 판별
    private void extractNumberIdx(String name) {
        int open = name.lastIndexOf('(');
        int close = name.lastIndexOf(')');

        if (close == -1 || close != name.length() - 1 || open == -1)
            return;

        String number = name.substring(open + 1, close);
        System.out.println("괄호 안 문자열 : " + number);
        for (char num : number.toCharArray()) {
            if (!Character.isDigit(num)) {
                return;
            }
        }

        this.num = Integer.parseInt(number);
        this.name = name.substring(0, open);
        return;
    }

    private void createNewFile(FileName o) {

        // checkDuplicateName()

    }

    private boolean checkDuplicateName() {
        // name - null, "" 체크

        // 같은지
            // 같으면 num - null, "" 체크

            // num 같은지
            // 다르면
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileName fileName = (FileName) o;
        return Objects.equals(name, fileName.name) && Objects.equals(ext, fileName.ext);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ext);
    }

    @Override
    public String toString() {
        if ("".equals(num)) {
            return name + "." + ext;
        }
        return name + "(" + num + ")." + ext;
    }
}
