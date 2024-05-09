import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Problem4 {
    private static String number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        calcSunday(input);
    }

    private static int getFirstDayOfWeek(LocalDate localDate) {
        return localDate.withDayOfMonth(1).getDayOfWeek().getValue();
    }

    private static int calcMonthInfo(LocalDate localDate) {
        boolean leapYear = localDate.isLeapYear();
        return localDate.getMonth().length(leapYear);
    }

    private static void calcSunday(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate inputDate = LocalDate.parse(input, formatter);

        int startDayOfWeek = getFirstDayOfWeek(inputDate);
        int countOfDay = calcMonthInfo(inputDate);

        int count = 0;
        for (int i = startDayOfWeek; i < startDayOfWeek + countOfDay; i++) {
            if (i % 7 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
