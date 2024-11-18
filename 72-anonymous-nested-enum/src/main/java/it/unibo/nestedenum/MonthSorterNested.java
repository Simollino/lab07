package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }

    private enum Month {

        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private final int days;

        Month(final int days) {
            this.days = days;
        }

        public static Month fromString(String month) {

            String lowerMonth = month.toLowerCase(Locale.ROOT);

            if(lowerMonth.contains("jan")) {
                return Month.JANUARY;
            }
            else if(lowerMonth.contains("feb")) {
                return Month.FEBRUARY;
            }
            else if(lowerMonth.contains("mar")) {
                return Month.MARCH;
            }
            else if(lowerMonth.contains("apr")) {
                return Month.APRIL;
            }
            else if(lowerMonth.contains("may")) {
                return Month.MAY;
            }
            else if(lowerMonth.contains("jun") && !lowerMonth.contains("jan")) {
                return Month.JUNE;
            }
            else if(lowerMonth.contains("jul")) {
                return Month.JULY;
            }
            else if(lowerMonth.contains("aug")) {
                return Month.AUGUST;
            }
            else if(lowerMonth.contains("sep")) {
                return Month.SEPTEMBER;
            }
            else if(lowerMonth.contains("oct")) {
                return Month.OCTOBER;
            }
            else if(lowerMonth.contains("nov")) {
                return Month.NOVEMBER;
            }
            else if(lowerMonth.contains("dec")) {
                return Month.DECEMBER;
            }
            else {
                throw new IllegalArgumentException("Invalid sintax, can not find any match for: " + month);
            }

        }        
        
    }

    public static final class SortByMonthOrder implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return Month.fromString(o1).compareTo(Month.fromString(o2));
        }

    }

    public static final class SortByDate implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            final var m1 = Month.fromString(o1);
            final var m2 = Month.fromString(o2);
            return Integer.compare(m1.days, m2.days);
        }

    }

}
