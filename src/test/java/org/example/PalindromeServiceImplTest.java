package org.example;

import org.example.service.PalindromeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PalindromeServiceImplTest {
    private PalindromeServiceImpl palindromeService;

    @BeforeEach
    void setUp() {
        palindromeService = new PalindromeServiceImpl();
    }


    @Test
    void isPalindrome_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> palindromeService.isPalindrome(null));
    }


    @ParameterizedTest(name = "#{index} - isPalindrome({0}):{1} ")
    @MethodSource("getArgumentsForIsPalindrome")
    void isPalindrome(String maybePalindromeValue, boolean expected) {
        var actual = palindromeService.isPalindrome(maybePalindromeValue).isPresent();
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> getArgumentsForIsPalindrome() {
        return Stream.of(
                Arguments.of("", true),
                Arguments.of("      ", true),
                Arguments.of("топот", true),
                Arguments.of("1111", true),
                Arguments.of("11211", true),
                Arguments.of("а роза упала на лапу Азора", true),
                Arguments.of("а роза упала на лапу Азора ", true),
                Arguments.of("топот1", false),
                Arguments.of("12", false),
                Arguments.of("Арбуз", false)
        );
    }
}