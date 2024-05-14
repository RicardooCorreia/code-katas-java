package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormSmallestNumberFromTwoDigitArraysTest {

    private final FormSmallestNumberFromTwoDigitArrays.Solution subject = new FormSmallestNumberFromTwoDigitArrays.Solution();

    @Test
    void minNumber_whenHaveDifferentNumbers_returnSmallestPossibleNumber() {

        // Given
        int[] nums1 = {4, 1, 3};
        int[] nums2 = {5, 7};

        // When
        int result = subject.minNumber(nums1, nums2);

        // Then
        assertEquals(15, result);
    }

    @Test
    void minNumber_whenShareSameNumber_returnSmallestPossibleSingleNumber() {

        // Given
        int[] nums1 = {3, 5, 2, 6};
        int[] nums2 = {3, 1, 7};

        // When
        int result = subject.minNumber(nums1, nums2);

        // Then
        assertEquals(3, result);
    }
}