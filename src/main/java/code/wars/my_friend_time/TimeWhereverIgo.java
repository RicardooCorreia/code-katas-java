package code.wars.my_friend_time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeWhereverIgo {

    public static String getFriendDateAndTime(String myTime,
                                              String myZone,
                                              String friendZone) {


        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return LocalDateTime.parse(myTime, formatter)
                .atZone(ZoneId.of(myZone))
                .withZoneSameInstant(ZoneId.of(friendZone))
                .format(formatter);
    }
}
