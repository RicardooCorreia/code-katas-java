package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.

There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

Implement the Solution class:

Solution() Initializes the object of the system.
String encode(String longUrl) Returns a tiny URL for the given longUrl.
String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.

Example 1:
    Input: url = "https://leetcode.com/problems/design-tinyurl"
    Output: "https://leetcode.com/problems/design-tinyurl"
Explanation:
    Solution obj = new Solution();
    string tiny = obj.encode(url); // returns the encoded tiny url.
    string ans = obj.decode(tiny); // returns the original url after decoding it.

Constraints:
    1 <= url.length <= 104
    url is guaranteed to be a valid URL.
 */
public class EncodeAndDecodeTinyURL {

    public static class Codec {

        public static final String BASE_URL = "http://tinyurl.com/";
        private final Map<Long, String> idToLong = new HashMap<>();

        public String encode(String longUrl) {

            long id = new Random().nextLong(1000000);
            idToLong.put(id, longUrl);
            return BASE_URL + id;
        }

        public String decode(String shortUrl) {

            long id = Long.parseLong(shortUrl.replace(BASE_URL, ""));
            return idToLong.get(id);
        }
    }
}
