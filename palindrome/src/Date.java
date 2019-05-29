import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Date {
    private final String day;
    private final String month;
    private final String year;

    Date(int day, int month, int year) {
        this.day = String.format("%02d", day);
        this.month = String.format("%02d", month);
        this.year = String.format("%04d", year);
    }

    public static Date CreateDate(String dateStr) throws Exception {
        if(dateStr.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
            LocalDate date = LocalDate.parse(dateStr, formatter);
            return new Date(
                    date.getDayOfMonth(),
                    date.getMonthValue(),
                    date.getYear()
            );
        }
        throw new InvalidDateFormatException("Invalid date format given");
    }

    public Date ReverseDate() {
        int year = Integer.parseInt(reverse(this.month).concat(reverse(day)));
        int month = Integer.parseInt(reverse(this.year).substring(2));
        int day = Integer.parseInt(reverse(this.year).substring(0,2));
        return new Date(day, month, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day.equals(date.day) &&
                month.equals(date.month) &&
                year.equals(date.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
