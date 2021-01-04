package net.kloczkowski.data_structure;

public class LetterWithCode {
    private final char letter;
    private final boolean[] code;

    public LetterWithCode(char letter, boolean[] code) {
        this.letter = letter;
        this.code = code;
    }

    public char getLetter() {
        return letter;
    }

    public boolean[] getCode() {
        return code;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(letter + ":");
        for (boolean bit : code) {
            stringBuilder.append(bit ? "1" : "0");
        }
        return stringBuilder.toString();
    }
}
