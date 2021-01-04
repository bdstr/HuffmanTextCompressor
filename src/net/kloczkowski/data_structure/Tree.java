package net.kloczkowski.data_structure;

import java.util.Arrays;

public class Tree {
    private final Node root;

    public Tree(Heap heap) {
        while (heap.getSize() > 1) {
            Node leftSon = heap.extractMin();
            Node rightSon = heap.extractMin();
            Node newNode = new Node(leftSon, rightSon);
            heap.insert(newNode);
        }
        this.root = heap.extractMin();
    }

    public Node getRoot() {
        return root;
    }

    public LetterWithCode[] getNodesLettersWithCodes() {
        LetterWithCode[] lettersWithCodes = new LetterWithCode[0];

        Node leftSon = root.getLeftSon();
        Node rightSon = root.getRightSon();

        lettersWithCodes = checkSon(leftSon, new boolean[0], false, lettersWithCodes);
        lettersWithCodes = checkSon(rightSon, new boolean[0], true, lettersWithCodes);
        return lettersWithCodes;
    }

    private LetterWithCode[] checkSon(Node node, boolean[] code, boolean nextBit, LetterWithCode[] lettersWithCodes) {
        if (node != null) {
            code = Arrays.copyOf(code, code.length + 1);
            code[code.length - 1] = nextBit;
            if (node.getValue().length() == 1) {
                lettersWithCodes = Arrays.copyOf(lettersWithCodes, lettersWithCodes.length + 1);
                lettersWithCodes[lettersWithCodes.length - 1] = new LetterWithCode(node.getValue().charAt(0), code);
            } else {
                Node leftSon = node.getLeftSon();
                Node rightSon = node.getRightSon();

                lettersWithCodes = checkSon(leftSon, code, false, lettersWithCodes);
                lettersWithCodes = checkSon(rightSon, code, true, lettersWithCodes);
            }
        }
        return lettersWithCodes;
    }
}
