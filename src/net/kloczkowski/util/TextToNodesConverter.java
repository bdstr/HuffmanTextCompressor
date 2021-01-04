package net.kloczkowski.util;

import net.kloczkowski.data_structure.Node;

import java.util.HashMap;
import java.util.Map;

public class TextToNodesConverter {
    public static Node[] convert(String text) {
        Map<Character, Integer> lettersOccurrences = new HashMap<>();
        for (char character : text.toCharArray()) {
            lettersOccurrences.put(character,
                    lettersOccurrences.containsKey(character) ? lettersOccurrences.get(character) + 1 : 1);
        }
        return lettersOccurrences.entrySet().stream()
                .map(entry -> new Node(entry.getKey().toString(), entry.getValue()))
                .toArray(Node[]::new);
    }
}
