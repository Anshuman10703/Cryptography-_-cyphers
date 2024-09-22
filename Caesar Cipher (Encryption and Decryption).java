public class CaesarCipher {

    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            
            if (idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                if (Character.isLowerCase(currChar)) {
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
    
    public String decrypt(String input, int key) {
        return encrypt(input, 26 - key);
    }
}
