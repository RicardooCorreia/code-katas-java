package code.wars.find_a_meeting_room;

public class TheOffice {
    public static Object meeting(char[] x) {
        for (int i = 0; i < x.length; i++) {
            var c = x[i];
            if (c == 'O') {
                return i;
            }
        }
        return "None available!";
    }
}
