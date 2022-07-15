package org.iassociation.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Hamza Amentag
 * @since 5/28/2022
 */
public class DateProcessor {
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static LocalDateTime toDate(final String date) {
        return LocalDateTime.parse(date, formatter);
    }

    public static String toString(final LocalDateTime date) {
        return date.format(formatter);
    }
}
