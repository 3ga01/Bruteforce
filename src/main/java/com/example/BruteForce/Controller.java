package com.example.BruteForce;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @PostMapping("/decrypt")
    public ModelAndView decrypt(@RequestParam("ciphertext") String ciphertext, Model model) {
        List<DecryptionResult> results = new ArrayList<>();

        for (int shift = 0; shift < 26; shift++) {
            String plaintext = decrypt(ciphertext, shift);
            results.add(new DecryptionResult(shift, plaintext));
        }

        model.addAttribute("results", results);
        return new ModelAndView("index");

    }

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

class DecryptionResult {
    private int shift;
    private String plaintext;

    public DecryptionResult(int shift, String plaintext) {
        this.shift = shift;
        this.plaintext = plaintext;
    }

    public int getShift() {
        return shift;
    }

    public String getPlaintext() {
        return plaintext;
    }
}
