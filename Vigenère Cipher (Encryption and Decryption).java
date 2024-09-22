public class VigenereCipher {

    public String encrypt(String input, String key) {
        StringBuilder encrypted = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        key = key.toUpperCase();
        
        int keyIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            
            if (idx != -1) {
                int shift = alphabet.indexOf(key.charAt(keyIndex));
                int newIdx = (idx + shift) % 26;
                char newChar = alphabet.charAt(newIdx);
                
                if (Character.isLowerCase(currChar)) {
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.append(newChar);
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                encrypted.append(currChar);
            }
        }
        return encrypted.toString();
    }

    public String decrypt(String input, String key) {
        StringBuilder decrypted = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        key = key.toUpperCase();
        
        int keyIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            
            if (idx != -1) {
                int shift = alphabet.indexOf(key.charAt(keyIndex));
                int newIdx = (idx - shift + 26) % 26;
                char newChar = alphabet.charAt(newIdx);
                
                if (Character.isLowerCase(currChar)) {
                    newChar
