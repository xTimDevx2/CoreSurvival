package me.xtimdevx.coresurvival.utils;

import java.util.regex.Pattern;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;


/**
 * Created by xTimDevx on 12/11/2017.
 */
public class DateUtils {

    private static Pattern timePattern = Pattern.compile(
            "(?:([0-9]+)\\s*y[a-z]*[,\\s]*)?" +             // Captured group 1 = Years     (y)
                    "(?:([0-9]+)\\s*mo[a-z]*[,\\s]*)?" +    // Captured group 2 = Months    (mo)
                    "(?:([0-9]+)\\s*w[a-z]*[,\\s]*)?" +     // Captured group 3 = Weeks     (w)
                    "(?:([0-9]+)\\s*d[a-z]*[,\\s]*)?" +     // Captured group 4 = Days      (d)
                    "(?:([0-9]+)\\s*h[a-z]*[,\\s]*)?" +     // Captured group 5 = Hours     (h)
                    "(?:([0-9]+)\\s*m[a-z]*[,\\s]*)?" +     // Captured group 6 = Minutes   (m)
                    "(?:([0-9]+)\\s*(?:s[a-z]*)?)?",        // Captured group 2 = Seconds   (s)
            Pattern.CASE_INSENSITIVE
    );

    private static final long SECONDS_PER_HOUR = 3600;
    private static final long SECONDS_PER_MINUTE = 60;

    /**
     * Remove the first occurance of a {@link #timePattern time string pattern} in the given input.
     * @param input The input
     * @return The timestring trimmed input.
     */
    public static String removeTimePattern(String input) {
        return timePattern.matcher(input).replaceFirst("").trim();
    }

    /**
     * Converts the seconds to hours, minutes and seconds.
     *
     * @author ghowden, modified by LeonTG77
     *
     * @param ticks the number of seconds
     * @return The converted version.
     */
    public static String ticksToString(long ticks) {
        int hours = (int) Math.floor(ticks / (double) SECONDS_PER_HOUR);
        ticks -= hours * SECONDS_PER_HOUR;
        int minutes = (int) Math.floor(ticks / (double)SECONDS_PER_MINUTE);
        ticks -= minutes * SECONDS_PER_MINUTE;
        int seconds = (int) ticks;

        StringBuilder output = new StringBuilder();

        if (hours > 0) {
            output.append(hours).append('h');

            if (minutes == 0) {
                output.append(minutes).append('m');
            }
        }

        if (minutes > 0) {
            output.append(minutes).append('m');
        }

        output.append(seconds).append('s');

        return output.toString();
    }

    /**
     * Converts the seconds to advanced hours, minutes and seconds.
     *
     * @author LeonTG77
     *
     * @param ticks the number of seconds
     * @return The converted version.
     */
    public static String advancedTicksToString(long ticks) {
        int hours = (int) Math.floor(ticks / (double) SECONDS_PER_HOUR);
        ticks -= hours * SECONDS_PER_HOUR;
        int minutes = (int) Math.floor(ticks / (double) SECONDS_PER_MINUTE);
        ticks -= minutes * SECONDS_PER_MINUTE;
        int seconds = (int) ticks;

        StringBuilder output = new StringBuilder();

        if (hours > 0) {
            output.append(hours).append(" ").append(hours == 1 ? "§7hour§a" : "§7hours§a");
        }

        if (minutes > 0) {
            if (output.length() > 0) {
                output.append(" §7and§a ");
            }

            output.append(minutes).append(" ").append(minutes == 1 ? "§7minute§a" : "§7minutes§a");
        }

        if (seconds > 0) {
            if (output.length() > 0) {
                output.append("§7 andÂ§a ");
            }

            output.append(seconds).append(" ").append(seconds == 1 ? "§7second§a" : "§7seconds§a");
        }

        return output.toString();
    }

    /**
     * Parse a time string of the format "1y2mo3w4d5h6m7s" into system milliseconds, relative to the current time.
     *
     * @param time The time string
     * @param future True if the parsed time should be in the future, false if it should be in the past.
     * @return {@link java.lang.System#currentTimeMillis()} compatible time.
     */
    public static long parseDateDiff(String time, boolean future) {
        Matcher matcher = timePattern.matcher(time);

        int years = 0;
        int months = 0;
        int weeks = 0;
        int days = 0;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        boolean found = false;

        // While we have matches...
        while (matcher.find()) {
            // The first group is always the entire pattern
            // If it's null or empty, skip
            if (matcher.group() == null || matcher.group().isEmpty()) {
                continue;
            }

            // Check if we even found any of our captured groups
            for (int i = 0; i < matcher.groupCount(); i++) {
                if (matcher.group(i) != null && !matcher.group(i).isEmpty()) {
                    found = true;
                    break;
                }
            }

            // Parse individual groups
            if (found) {
                years = parseGroup(matcher, 1);
                months = parseGroup(matcher, 2);
                weeks = parseGroup(matcher, 3);
                days = parseGroup(matcher, 4);
                hours = parseGroup(matcher, 5);
                minutes = parseGroup(matcher, 6);
                seconds = parseGroup(matcher, 7);
                break;
            }
        }

        // If we didn't find a match return 0
        if (!found) {
            return 0;
        }

        // Put everything together
        Calendar c = new GregorianCalendar();
        c.add(Calendar.YEAR, years * (future ? 1 : -1));
        c.add(Calendar.MONTH, months * (future ? 1 : -1));
        c.add(Calendar.WEEK_OF_YEAR, weeks * (future ? 1 : -1));
        c.add(Calendar.DAY_OF_MONTH, days * (future ? 1 : -1));
        c.add(Calendar.HOUR_OF_DAY, hours * (future ? 1 : -1));
        c.add(Calendar.MINUTE, minutes * (future ? 1 : -1));
        c.add(Calendar.SECOND, seconds * (future ? 1 : -1));

        Calendar max = new GregorianCalendar();
        max.add(Calendar.YEAR, 10);

        if (c.after(max)) {
            return max.getTimeInMillis();
        }

        return c.getTimeInMillis();
    }

    /**
     * Parse a group from a matcher into an integer.
     *
     * @param matcher The matcher
     * @param groupNumber The group number
     * @return The parsed integer, 0 if parsing fails.
     */
    static int parseGroup(Matcher matcher, int groupNumber) {
        String group = matcher.group(groupNumber);

        if (group == null || group.isEmpty()) {
            return 0;
        }

        try {
            return Integer.parseInt(group);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Get the difference of a specific calendar field for 2 calendar instances.
     *
     * @param type The calendar field type, see {@link Calendar} documentation.
     * @param fromDate The calendar to check from.
     * @param toDate The calendar to check against.
     * @return The field difference.
     */
    static int dateDiff(int type, Calendar fromDate, Calendar toDate) {
        boolean future = toDate.after(fromDate);

        int diff = 0;
        long savedDate = fromDate.getTimeInMillis();
        while ((future && !fromDate.after(toDate)) || (!future && !fromDate.before(toDate))) {
            savedDate = fromDate.getTimeInMillis();
            fromDate.add(type, future ? 1 : -1);
            diff++;
        }
        diff--;
        fromDate.setTimeInMillis(savedDate);
        return diff;
    }

    /**
     * Utility method to compare against the current time using
     * {@link #formatDateDiff(Calendar, Calendar, int)} with a default accuracy of 3 fields.
     *
     * @param date {@link System#currentTimeMillis()} compatible time
     * @return See {@link #formatDateDiff(Calendar, Calendar, int)}.
     */
    public static String formatDateDiff(long date) {
        Calendar then = new GregorianCalendar();
        then.setTimeInMillis(date);
        Calendar now = new GregorianCalendar();

        return DateUtils.formatDateDiff(now, then);
    }

    /**
     * Get the difference between 2 calendar instances with a maximum accuracy of 3 fields.
     *
     * @param fromDate The calendar to check from
     * @param toDate The calendar to check against
     * @return A {@link #timePattern} compatible string.
     */
    public static String formatDateDiff(Calendar fromDate, Calendar toDate) {
        return formatDateDiff(fromDate, toDate, 3);
    }

    /**
     * Get the difference between 2 calendar instances.
     *
     * @param fromDate The calendar to check from
     * @param toDate The calendar to check against
     * @param maxAccuracy The maximum accuracy of the returned string
     * @return A {@link #timePattern} compatible string.
     */
    public static String formatDateDiff(Calendar fromDate, Calendar toDate, int maxAccuracy) {
        if (toDate.equals(fromDate)) {
            return "now";
        }

        StringBuilder sb = new StringBuilder();

        String[] names = new String[] { "year", "years", "month", "months", "day", "days", "hour", "hours", "minute", "minutes", "second", "seconds" };
        int[] types = new int[] { Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND };

        int accuracy = 0;

        for (int i = 0; i < types.length; i++) {
            if (accuracy >= maxAccuracy) {
                break;
            }

            int diff = dateDiff(types[i], fromDate, toDate);

            if (diff > 0) {
                accuracy++;
                sb.append(" ").append(diff).append(" ").append(names[i * 2 + (diff > 1 ? 1 : 0)]);
            }
        }

        if (sb.length() == 0) {
            return "now";
        }

        return sb.toString().trim();
    }

}
