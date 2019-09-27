
/**
 *
 * @author Carlos Ponciano & Vinicius Luis
 */
public class CodingAlgorithm {

    private static CodingAlgorithm obj;
    private final char INITIAL_LETTER;
    private final char LAST_LETTER;

    private CodingAlgorithm() {
        INITIAL_LETTER = 'A';
        LAST_LETTER = 'Z';
    }

    public static CodingAlgorithm getInstance() {
        if (obj == null) {
            obj = new CodingAlgorithm();
        }

        return obj;
    }

    public String encryption(String text, String key) {
        String out = "";
        char aux;
        int currentIndexKey = 0;

        for (int i = 0; i < text.toCharArray().length; i++) {
            aux = text.charAt(i);

            if (Character.isLetter(aux)) {
                aux = (char) ((Character.toUpperCase(key.charAt(currentIndexKey)) + (Character.toUpperCase(aux) - INITIAL_LETTER)) % (LAST_LETTER + 1));

                if (aux < INITIAL_LETTER) {
                    aux += INITIAL_LETTER;
                }

                currentIndexKey++;

                if (currentIndexKey == key.length()) {
                    currentIndexKey = 0;
                }
            }

            out += String.valueOf(aux);
        }

        return out;
    }

    public String deciphering(String encryption, String key) {
        String out = "";
        char aux;
        int currentIndexKey = 0;

        for (int i = 0; i < encryption.toCharArray().length; i++) {
            aux = encryption.charAt(i);

            if (Character.isLetter(aux)) {
                aux = (char) ((Character.toUpperCase(aux) - (Character.toUpperCase(key.charAt(currentIndexKey)) - INITIAL_LETTER)) % (LAST_LETTER + 1));

                if (aux < INITIAL_LETTER) {
                    aux = (char) (LAST_LETTER - (INITIAL_LETTER - aux - 1));
                }

                currentIndexKey++;

                if (currentIndexKey == key.length()) {
                    currentIndexKey = 0;
                }
            }

            out += String.valueOf(aux);
        }

        return out;
    }
}
