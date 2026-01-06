package code.wars.friend_or_foe;

import java.util.List;

    public class Kata {

        public static List<String> friend(List<String> list){

            return list.stream()
                    .map(String::trim)
                    .filter(s -> s.length() == 4)
                    .toList();
        }
    }
