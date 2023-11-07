package org.example.service;

import org.example.entity.Palindrome;

import java.util.Optional;

public interface PalindromeService {
    Optional<Palindrome> isPalindrome(String str);
}
