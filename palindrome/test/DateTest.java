import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {

    @Test
    public void CreateDateShouldGiveAValidDateObject() throws Exception {
        Date date = Date.CreateDate("29/05/2019");
        Date expected = new Date(29, 5, 2019);

        assertEquals("Invalid date object", date, expected);
    }

    @Test(expected = InvalidDateFormatException.class)
    public void CreateDateShouldThrowExceptionForInvalidDateFormat() throws Exception {
        Date date = Date.CreateDate("29-05-2019");
    }

    @Test
    public void reverseDate() throws Exception {
        Date date1 = Date.CreateDate("11/02/2001");
        Date expected = Date.CreateDate("10/02/2011");

        Date reversedDate = date1.ReverseDate();
        assertEquals(reversedDate, expected);
    }
}
