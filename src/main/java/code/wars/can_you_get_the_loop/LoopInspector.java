package code.wars.can_you_get_the_loop;

import java.util.HashMap;
import java.util.Map;

public class LoopInspector {

    public int loopSize(Node node) {

        Map<Node, Integer> nodeIndexes = new HashMap<>();
        Node current = node;
        int index = 0;
        while (current != null) {
            if (nodeIndexes.containsKey(current)) {
                return index - nodeIndexes.get(current);
            } else {
                nodeIndexes.put(current, index);
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }
}
