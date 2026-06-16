package code.wars.likes_vs_dislikes;

import static code.wars.likes_vs_dislikes.Button.Nothing;

public class Solution {

    public static Button likeOrDislike(Button[] buttons) {

        Button current = Nothing;
        for (Button button : buttons) {

            if (button != Nothing) {
                current = current == button ? Nothing : button;
            }
        }
        return current;
    }
}
