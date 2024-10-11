package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/*
There is a party where n friends numbered from 0 to n - 1 are attending. There is an infinite number of chairs in this
 party that are numbered from 0 to infinity. When a friend arrives at the party, they sit on the unoccupied chair with the smallest number.

For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
When a friend leaves the party, their chair becomes unoccupied at the moment they leave.\
 If another friend arrives at that same moment, they can sit in that chair.

You are given a 0-indexed 2D integer array times where times[i] = [arrivali, leavingi], indicating the arrival and
leaving times of the ith friend respectively, and an integer targetFriend. All arrival times are distinct.

Return the chair number that the friend numbered targetFriend will sit on.

Example 1:
    Input: times = [[1,4],[2,3],[4,6]], targetFriend = 1
    Output: 1
    Explanation:
    - Friend 0 arrives at time 1 and sits on chair 0.
    - Friend 1 arrives at time 2 and sits on chair 1.
    - Friend 1 leaves at time 3 and chair 1 becomes empty.
    - Friend 0 leaves at time 4 and chair 0 becomes empty.
    - Friend 2 arrives at time 4 and sits on chair 0.
    Since friend 1 sat on chair 1, we return 1.
Example 2:
    Input: times = [[3,10],[1,5],[2,6]], targetFriend = 0
    Output: 2
    Explanation:
    - Friend 1 arrives at time 1 and sits on chair 0.
    - Friend 2 arrives at time 2 and sits on chair 1.
    - Friend 0 arrives at time 3 and sits on chair 2.
    - Friend 1 leaves at time 5 and chair 0 becomes empty.
    - Friend 2 leaves at time 6 and chair 1 becomes empty.
    - Friend 0 leaves at time 10 and chair 2 becomes empty.
    Since friend 0 sat on chair 2, we return 2.

Constraints:
    n == times.length
    2 <= n <= 104
    times[i].length == 2
    1 <= arrivali < leavingi <= 105
    0 <= targetFriend <= n - 1
    Each arrivali time is distinct.
 */
class TheNumberOfTheSmallestUnoccupiedChairTest {

    private final TheNumberOfTheSmallestUnoccupiedChair.Solution subject = new TheNumberOfTheSmallestUnoccupiedChair.Solution();

    public static Stream<Arguments> examples() {

        return Stream.of(
                Arguments.of(new int[][]{{1, 4}, {2, 3}, {4, 6}}, 1, 1),
                Arguments.of(new int[][]{{3, 10}, {1, 5}, {2, 6}}, 0, 2),
                Arguments.of(new int[][]{{4, 5}, {12, 13}, {5, 6}, {1, 2}, {8, 9}, {9, 10}, {6, 7}, {3, 4}, {7, 8}, {13, 14}, {15, 16}, {14, 15}, {10, 11}, {11, 12}, {2, 3}, {16, 17}}, 15, 0),
                Arguments.of(new int[][]{{24710, 60469}, {25295, 76256}, {11088, 34742}, {92605, 97746}, {68272, 68682}, {44286, 70033}, {88703, 92573}, {37394, 87075}, {47741, 73042}, {5603, 9454}, {88970, 96339}, {62904, 98525}, {42743, 69814}, {28999, 80490}, {76263, 90116}, {78042, 90721}, {27856, 69492}, {20067, 54704}, {72177, 81840}, {34951, 76201}, {59089, 65862}, {61102, 76554}, {32726, 48272}, {57683, 99972}, {74537, 85162}, {88161, 90916}, {50114, 88989}, {5170, 11173}, {87698, 90284}, {78856, 84320}, {14517, 51015}, {30757, 54925}, {28234, 45768}, {73177, 89666}}, 3, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void smallestChair(
            // Given
            int[][] times, int targetFriend, int expected) {

        // When
        int result = subject.smallestChair(times, targetFriend);

        // Then
        assertThat(result)
                .isEqualTo(expected);
    }
}