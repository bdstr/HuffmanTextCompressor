package net.kloczkowski;

public class Main {

    public static void main(String[] args) {

//        String sampleText = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbccccccccccccddddddddddddddddeeeeeeeeefffff";
        String sampleText = """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vulputate in ante et vehicula. Etiam porttitor posuere velit eu aliquet. Vivamus libero odio, viverra eu purus id, dictum ultrices tellus. Mauris efficitur id elit vitae porta. Sed at nunc ultricies, porta velit non, euismod lorem. Nam vel diam tincidunt, facilisis nunc ut, dapibus purus. Sed blandit sagittis elit, eget tristique nulla. Sed a ultricies augue. Phasellus vestibulum leo sit amet ultrices auctor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque orci neque, commodo eu lectus eu, scelerisque ultrices tortor.
                Cras feugiat tortor et facilisis pellentesque. Proin dictum ex non arcu rutrum dapibus. Vestibulum ante augue, malesuada sit amet risus et, semper volutpat magna. Donec dolor mauris, gravida sed dui id, ultricies pretium ex. Vestibulum id molestie nisl. Nam mattis dictum tortor, id viverra ipsum condimentum quis. Etiam pellentesque ac lorem aliquam rhoncus. Aenean nisl quam, fermentum sit amet velit eget, scelerisque aliquam nibh. Aliquam maximus lectus iaculis tristique efficitur. Proin pretium arcu ut ex dictum, eget bibendum massa pharetra.
                Sed quis lacus blandit, blandit augue eget, congue sapien. Integer placerat mollis purus. Ut in convallis justo. Maecenas ullamcorper rutrum ligula, eget elementum urna interdum non. Mauris aliquam, est eu laoreet gravida, sem urna placerat erat, sit amet cursus risus dui eget turpis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ex metus, tincidunt ut ornare sit amet, imperdiet sed ante. Curabitur ante quam, laoreet nec posuere non, accumsan nec mauris. Mauris in ante iaculis, lobortis arcu vulputate, eleifend odio. Nunc sed purus auctor, cursus leo nec, finibus massa. Donec sollicitudin aliquet massa, blandit sodales nulla semper sit amet. Cras commodo nisl a turpis imperdiet laoreet. Aliquam bibendum iaculis mi, at accumsan arcu congue ut.
                Proin sollicitudin varius erat sit amet finibus. Mauris ultrices arcu quis urna bibendum cursus. Suspendisse sed aliquam metus, sit amet venenatis sem. Maecenas ullamcorper bibendum rhoncus. Mauris ac lectus feugiat, lacinia nulla id, volutpat ligula. Vivamus vel mi tortor. Duis massa lorem, efficitur at viverra nec, pharetra eget tortor. Vivamus vel pulvinar diam. Fusce sed nulla ultrices, lobortis nulla sodales, euismod erat. Vestibulum consectetur, sapien id lobortis luctus, lorem dui imperdiet mi, a condimentum est nunc in erat.
                Suspendisse leo mi, auctor aliquam urna ac, convallis pharetra velit. Proin iaculis dui sed erat volutpat cursus. Nunc auctor, lorem eget tempus dignissim, augue est porta nibh, ac iaculis lorem enim id elit. Nulla nec malesuada justo, a rutrum nunc. Nulla et tellus nulla. Donec elementum felis mi, sed porta mi dapibus sit amet. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque eu rhoncus arcu. Sed sit amet diam lectus. Nullam augue justo, gravida sed pellentesque quis, pharetra ac purus. Morbi ut quam sit amet lacus molestie elementum. Sed feugiat mattis justo. Aenean maximus arcu orci, vel mattis nunc suscipit vitae. In semper molestie ultrices.
                😂😍😀🎉👍
                """;

        HuffmanCompressedText compressedText = new HuffmanCompressedText(sampleText);

//        Arrays.stream(compressedText.getCodesOfLetters()).forEach(System.out::println);
        System.out.println(compressedText.decompress());
        System.out.println("Uncompressed string size: " + compressedText.decompress().getBytes().length + " bytes");
        System.out.println("Compressed string size: " + compressedText.getSizeInBytes() + " bytes");
        System.out.println("Memory saved approximately: " + String.format("%.2f", 100.0 - 100.0 / compressedText.decompress().getBytes().length * compressedText.getSizeInBytes()) + "%");
    }
}
