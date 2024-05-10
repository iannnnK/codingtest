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

    /*
    테스트 케이스
    ian.png -> ian.png
    ian.png -> ian(1).png
    ian(1).png -> ian(2).png
    ian(1).png.png -> ian(1).png.png
    ian.png.png -> ian.png.png
    ian(1).png(1).png -> ian(1).png(1).png
    */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<FileName> fileNameList = new ArrayList<>();

        while (true) {
            String input = br.readLine();
            if ("stop".equals(input)) {
                break;
            }

            createFile(input, fileNameList);
            System.out.println(fileNameList);
        }

    }

    private static void createFile(String input, List<FileName> fileNameList) {
        FileName file = new FileName(input);

        if (fileNameList.indexOf(file) == -1) {
            System.out.println("new");
            fileNameList.add(file);
        } else {
            System.out.println("duplicated");
            FileName dupFileName = fileNameList.get(fileNameList.indexOf(file));
            dupFileName.createNewFile(file);
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
        this.ext = input.substring(dotIdx + 1);
    }

    // 적절한 위치에 괄호와 숫자가 존재하는지 판별
    private void extractNumberIdx(String name) {
        this.name = name;
        int open = name.lastIndexOf('(');
        int close = name.lastIndexOf(')');

        if (close == -1 || close != name.length() - 1 || open == -1) {
            return;
        }

        String number = name.substring(open + 1, close);
        for (char num : number.toCharArray()) {
            if (!Character.isDigit(num)) {
                return;
            }
        }

        this.num = Integer.parseInt(number);
        this.name = name.substring(0, open);
        return;
    }

    public void createNewFile(FileName o) {
        if(this.next == null) {
            o.setNum(this.num + 1);
            this.next = o;
            System.out.println("새로운 파일 : " + o);
            return;
        }
        this.next.createNewFile(o);
    }

    public void setNum(int num) {
        this.num = num;
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
        if (num == 0) {
            return name + "." + ext;
        }
        return name + "(" + num + ")." + ext;
    }
}
