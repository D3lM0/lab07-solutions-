package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {
    private enum Month {
        JANUARY("January", 31), FEBRUARY("February", 28), MARCH("March", 31), APRIL("April", 30),
        MAY("May", 31),
        JUNE("June", 30),
        JULY("July", 31), AUGUST("August", 31), SEPTEMBER("September", 30), OCTOBER("October", 31),
        NOVEMBER("November", 30),
        DECEMBER("December", 31);

        private final String monthName;
        private final int monthDays;

        private Month(final String monthName, final int monthDays) {
            this.monthName = monthName;
            this.monthDays = monthDays;
        }

        public String getName() {
            return this.monthName;
        }

        public int getMonthDays() {
            return this.monthDays;
        }

        public static Month fromString(final String name) {
            Objects.requireNonNull(name, "Month name cannot be null");
            final String normalizedName = name.toLowerCase(Locale.ROOT);

            Month match = null;
            for (final Month m : Month.values()) {
                final String monthName = m.getName().toLowerCase(Locale.ROOT);
                if (monthName.startsWith(normalizedName)) {
                    if (match != null) {
                        throw new IllegalArgumentException("Ambiguous month name: " + name);
                    }
                    match = m;
                }
            }
            if (match == null) {
                throw new IllegalArgumentException("Unknown Month name: " + name);
            }
            return match;
        }
    }

    private class SortByMonthOrder implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(Month.fromString(o1).ordinal(), Month.fromString(o2).ordinal());
        }

    }

    private class SortByDate implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(Month.fromString(o1).getMonthDays(),
                    Month.fromString(o2).getMonthDays());
        }

    }

    @Override
    public Comparator<String> sortByDays() {
        return new SortByDate();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new SortByMonthOrder();
    }
}
