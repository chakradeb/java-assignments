package calendar;

import java.util.Arrays;
import java.util.Objects;

public class Calendar {
    private final int year;
    private final int numberOfDays;
    private final String month;
    private final String startDay;

    private String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    Calendar(int year, int numberOfDays, String month, String startDay) {
        this.year = year;
        this.numberOfDays = numberOfDays;
        this.month = month;
        this.startDay = startDay;
    }

    public static Calendar CreateCalendar(int year, String month, String startDay) {
        if (Calendar.isLeapYear(year)) {
            month = Month.FebruaryLeapYear.toString();
        }
        return new Calendar(year, Month.valueOf(month).getDayCount(), month, startDay);
    }

    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    private String printDate() {
        StringBuilder str = new StringBuilder();
        int i = 0;
        int j = 0;
        int date = 1;
        while (i < Arrays.asList(week).indexOf(startDay)) {
            str.append("   ");
            i++;
            j++;
        }
        while(j < 7 && date <= numberOfDays) {
            str.append(String.format("%02d", date)+ " ");
            j++;
            date++;
            if(j == 7) {
                j = 0;
                str.append("\n");
            }
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendar calendar = (Calendar) o;
        return year == calendar.year &&
                numberOfDays == calendar.numberOfDays &&
                startDay.equals(calendar.startDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, numberOfDays, startDay);
    }

    @Override
    public String toString() {
        return month + " " + year +
                "\n" + " M  T  W TH  F  S SU" +
                "\n" + printDate();
    }
}
