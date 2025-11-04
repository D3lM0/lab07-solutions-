package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {
    private enum Month {
        JANUARY("January", "31"), FEBRUARY("February", "28"), MARCH("March", "31"), APRIL("April", "30"),
        MAY("May", "31"),
        JUNE("June", "30"),
        JULY("July", "31"), AUGUST("August", "31"), SEPTEMBER("September", "30"), OCTOBER("October", "31"),
        NOVEMBER("November", "30"),
        DECEMBER("December", "31");

        private final String monthName;
        private final String monthDays;

        private Month(final String monthName, final String monthDays) {
            this.monthName = monthName;
            this.monthDays = monthDays;
        }

        public String getName() {
            return this.monthName;
        }

        public String getMonthDays() {
            return this.monthDays;
        }

        public static Month fromString(final String name) {
         for(final Month m : Month.values()) {
            if(m.getName().equals(name)) {
                return m;
            } 
          }
          throw new IllegalArgumentException("Unknown Month name: " + name);
        }

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
