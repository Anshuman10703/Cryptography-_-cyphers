public class CaesarBreaker {

    public String breakCaesarCipher(String encrypted) {
        int[] letterFrequencies = countLetterFrequencies(encrypted);
        int maxIndex = maxIndex(letterFrequencies);
        int key = maxIndex - 4;  // Assuming 'E' is the most common letter (index 4)
        if (maxIndex < 4) {
            key = 26 - (4 - maxIndex);
        }
        return new CaesarCipher().decrypt(encrypted, key);
    }

    private int[] countLetterFrequencies(String message) {
        int[] counts = new int[26];
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for (char ch : message.toUpperCase().toCharArray()) {
            int idx = alphabet.indexOf(ch);
            if (idx != -1) {
                counts[idx]++;
            }
        }
        return counts;
    }

    private int maxIndex(int[] values) {
        int maxIdx = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[i] > values[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
