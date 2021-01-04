package net.kloczkowski;

import net.kloczkowski.data_structure.LetterWithCode;
import net.kloczkowski.data_structure.Node;
import net.kloczkowski.data_structure.Heap;
import net.kloczkowski.data_structure.Tree;
import net.kloczkowski.util.TextToNodesConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class HuffmanCompressedText {
    private final LetterWithCode[] lettersWithCodes;
    private final Boolean[] bits;

    public HuffmanCompressedText(String text) {
        Node[] nodes = TextToNodesConverter.convert(text);
        Heap heap = new Heap(nodes);
        Tree tree = new Tree(heap);
        lettersWithCodes = tree.getNodesLettersWithCodes();

        bits = compress(text);
    }

    public LetterWithCode[] getCodesOfLetters() {
        return lettersWithCodes;
    }

    public Boolean[] getBits() {
        return bits;
    }

    public int getSizeInBytes() {
        int charSize = 2 * 8;
        int lettersWithCodesSize = Arrays.stream(lettersWithCodes)
                .mapToInt(value -> value.getCode().length + charSize)
                .reduce(0, Integer::sum);
        return (bits.length / 8) + lettersWithCodesSize;
    }

    private Boolean[] compress(String text) {
        List<Boolean> compressedArray = new ArrayList<>();
        for (char character : text.toCharArray()) {
            LetterWithCode lettersWithCode = Arrays.stream(lettersWithCodes)
                    .filter(letterWithCode -> letterWithCode.getLetter() == character)
                    .findAny().orElseThrow(() -> new RuntimeException("Invalid character!"));

            for (boolean bit : lettersWithCode.getCode()) {
                compressedArray.add(bit);
            }
        }
        return compressedArray.toArray(Boolean[]::new);
    }

    public String decompress() {
        List<Boolean> code = new ArrayList<>();
        Map<List<Boolean>, Character> lettersWithCodesMap = Arrays.stream(lettersWithCodes)
                .collect(Collectors.toMap(
                        letterWithCode -> IntStream.range(0, letterWithCode.getCode().length).mapToObj(i -> letterWithCode.getCode()[i]).collect(Collectors.toList()),
                        LetterWithCode::getLetter));
        StringBuilder stringBuilder = new StringBuilder();

        for (boolean bit : bits) {
            code.add(bit);
            if (lettersWithCodesMap.containsKey(code)) {
                stringBuilder.append(lettersWithCodesMap.get(code));
                code.clear();
            }
        }
        return stringBuilder.toString();
    }
}
