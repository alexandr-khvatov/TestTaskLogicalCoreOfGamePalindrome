package org.example.service;

import org.example.entity.Palindrome;

import java.util.Objects;
import java.util.Optional;

public class PalindromeServiceImpl implements PalindromeService {
    @Override
    public Optional<Palindrome> isPalindrome(String str) {
        if (checkPalindrome(str)) {
            return Optional.of(new Palindrome(str));
        } else {
            return Optional.empty();
        }
    }

    private boolean checkPalindrome(String str) {
        if (Objects.isNull(str)) {
            throw new IllegalArgumentException("Не должно быть null");
        }

        if (str.isBlank()) {
            return true;
        }

        var i = 0;
        var j = str.length() - 1;

        while (i < j) {

            while (str.charAt(i) == ' ') {
                i++;
            }
            while (str.charAt(j) == ' ') {
                j--;
            }

            if (Character.toLowerCase(str.charAt(i++)) != Character.toLowerCase(str.charAt(j--))) {
                return false;
            }
        }
        return true;
    }
}
