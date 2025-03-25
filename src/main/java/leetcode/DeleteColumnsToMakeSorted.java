package leetcode;

public class DeleteColumnsToMakeSorted {

    static class Solution {
        public int minDeletionSize(String[] strs) {

            int deleteCount = 0;

            char[] firstLine = strs[0].toCharArray();

            for (int columnIndex = 0; columnIndex < firstLine.length; columnIndex++) {

                char previousChar = firstLine[columnIndex];
                for (int lineIndex = 1; lineIndex < strs.length; lineIndex++) {
                    char currentChar = strs[lineIndex].charAt(columnIndex);
                    if (currentChar < previousChar) {
                        deleteCount++;
                        break;
                    } else {
                        previousChar = currentChar;
                    }
                }
            }

            return deleteCount;
        }
    }
}
