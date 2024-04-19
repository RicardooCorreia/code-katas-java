package haker.rank.acm_icpc_team;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {


    public static List<Integer> acmTeam(List<String> participantsWithTopicKnowledge, int numberOfTopics) {

        final List<List<Integer>> participantsWithTopics = participantsWithTopicKnowledge.stream()
                .map(String::chars)
                .map(intStream -> intStream.map(operand -> operand - 48))
                .map(IntStream::boxed)
                .map(Stream::toList)
                .toList();

        int maximumKnowledge = 0;
        int teamsWithMaximumKnowledge = 0;

        for (int participant1Index = 0;
             participant1Index < participantsWithTopics.size();
             participant1Index++) {

            for (int participant2Index = participant1Index + 1;
                 participant2Index < participantsWithTopics.size();
                 participant2Index++) {

                int teamKnowledge = calculateTeamKnowledge(
                        numberOfTopics,
                        participantsWithTopics.get(participant1Index),
                        participantsWithTopics.get(participant2Index));

                if (teamKnowledge == maximumKnowledge) {
                    teamsWithMaximumKnowledge++;
                } else if (teamKnowledge > maximumKnowledge) {
                    maximumKnowledge = teamKnowledge;
                    teamsWithMaximumKnowledge = 1;
                }
            }
        }

        return List.of(maximumKnowledge, teamsWithMaximumKnowledge);
    }

    private static int calculateTeamKnowledge(int numberOfTopics,
                                              List<Integer> participant1,
                                              List<Integer> participant2) {

        int teamKnowledge = 0;
        for (int topicIndex = 0; topicIndex < numberOfTopics; topicIndex++) {
            teamKnowledge += Math.min(participant1.get(topicIndex) + participant2.get(topicIndex), 1);
        }
        return teamKnowledge;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<Integer> result = Result.acmTeam(topic, m);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

