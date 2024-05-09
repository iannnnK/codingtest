import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<FileName, Integer> map = new HashMap<>();
        while(true) {
            String input = br.readLine();
            if("stop".equals(input)) {
                break;
            }
            createFile(input, map);
            System.out.println();
        }

    }

    private static void createFile(String input, Map<FileName, Integer> map) {
        FileName file = new FileName(input);
        if (map.containsKey(file)) {
//            map.compute(file, (k, num) -> num + 1);
            int num = map.get(file);
            map.put(file, num + 1);
            file.setNum(num + 1);
        } else {
            map.put(file, 0);
        }

        System.out.println(file);
    }
}

class FileName {
    private String name;
    private String num;
    private String ext;

    public void setNum(int num) {
        this.num = String.valueOf(num);
    }
    public FileName(String input) {
        String[] file = parseFileName(input);
        this.name = file[0];
        this.num = file[1];
        this.ext = file[2];
    }

    public FileName(String name, int num, String ext) {
        this.name = name;
        this.num = String.valueOf(num);
        this.ext = ext;
        System.out.println(toString());
    }

    // file 이름만 파싱하는 기능
    private String[] parseFileName(String input) {
        String[] result = new String[3];
        String[] name = input.split("\\.");
        result[2] = name[1];

        if (name[0].contains("(") && name[1].contains(")")) {
            int numIdx = name[0].indexOf('(');
            result[0] = name[0].substring(0, numIdx);
            result[1] = name[0].substring(numIdx);
            return result;
        }
        result[0] = name[0];
        result[1] = "";
        return result;
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
