package code.wars.unique_string_characters;

class Solution {

    public static String solve(String a, String b) {

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : a.toCharArray()) {
            if (!b.contains(String.valueOf(c))) {
                stringBuilder.append(c);
            }
        }

        for (char c : b.toCharArray()) {
            if (!a.contains(String.valueOf(c))) {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}
