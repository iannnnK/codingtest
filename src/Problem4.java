import java.time.LocalDate;
import java.time.LocalDateTime;

public class Problem4 {
    private static String number;

    public static void main(String[] args) {

        // 날짜를 여러 값으로 전달할 수 있으면 좋을 듯
        calcSunday(getFirstDayOfWeek(), calcMonthInfo());
    }

    private static int getFirstDayOfWeek() {
        return LocalDate.now().withDayOfMonth(1).getDayOfWeek().getValue();
    }

    private static int calcMonthInfo() {
        LocalDate now = LocalDate.now();
        boolean leapYear = now.isLeapYear();
        return now.getMonth().length(leapYear);
    }

    private static void calcSunday(int startDayOfWeek, int countOfDay) {
        int count = 0;
        for (int i = startDayOfWeek; i < startDayOfWeek + countOfDay; i++) {
            if (i % 7 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
