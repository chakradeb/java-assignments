package calendar;

public enum Month {
    January(31),
    February(28),
    FebruaryLeapYear(29),
    March(31),
    April(30),
    May(31),
    June(30),
    July(31),
    August(31),
    September(30),
    October(31),
    November(30),
    December(31);

    private int dayCount;

    public int getDayCount() {
        return this.dayCount;
    }

    private Month(int dayCount) {
        this.dayCount = dayCount;
    }
}
