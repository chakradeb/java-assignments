package calendar;

import calendar.Calendar;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalendarTest {

    @Test
    public void CreateCalendarShouldGiveAValidCalendarObject() {
        Calendar calendar = Calendar.CreateCalendar(2019, "January", "Monday");
        Calendar expected = new Calendar(2019, 31, "January", "Monday");

        assertEquals("Invalid calendar object", calendar, expected);
    }

    @Test
    public void CreateCalendarForLeapYearShouldHave29DaysInFebruary() {
        Calendar calendar = Calendar.CreateCalendar(2016, "February", "Wednesday");
        Calendar expected = new Calendar(2016, 29, "February", "Wednesday");

        System.out.println(calendar.toString());

        assertEquals("Invalid calendar object", calendar, expected);
    }
}
