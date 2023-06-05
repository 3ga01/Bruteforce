public class BruteForce {
    // Glsa nx lvhsl abhwtlr
    // Uryyb jbeyq
    // public static void main(String[] args) {
    //     String ciphertext = "uladvyr zljbypaf";

    //     for (int shift = 0; shift < 26; shift++) {
    //         String plaintext = decrypt(ciphertext, shift);
    //         System.out.println("Shift: " + shift + ", Plaintext: " + plaintext);
    //     }
    // }

    public static String decrypt(String ciphertext, int shift) {
        StringBuilder plaintext = new StringBuilder();
        int length = ciphertext.length();

        for (int i = 0; i < length; i++) {
            char c = ciphertext.charAt(i);

            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base - shift + 26) % 26 + base);
            }

            plaintext.append(c);
        }

        return plaintext.toString();
    }
}