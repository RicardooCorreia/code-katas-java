package haker.rank.designer_pdf_viewer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here

        final int charCount = word.length();
        final int tallestChar = findTallestChar(h, word);

        return tallestChar * charCount;
    }

    private static int findTallestChar(List<Integer> h, String word) {

        return word.chars()
                .distinct()
                .map(Result::getCharAlphabeticIndex)
                .map(operand -> operand - 1) // index for list
                .map(h::get)
                .max()
                .orElseThrow(RuntimeException::new);
    }

    private static int getCharAlphabeticIndex(int character) {

        return character - 'a' + 1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

