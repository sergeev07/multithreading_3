package ru.netology.utils;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TextChecker {
    public static AtomicInteger count3 = new AtomicInteger();
    public static AtomicInteger count4 = new AtomicInteger();
    public static AtomicInteger count5 = new AtomicInteger();

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static boolean isPalindrome(String text) {
        return text.equals(new StringBuilder(text).reverse().toString());
    }

    public static boolean isSingleChar(String text) {
        return text != null && text.chars().allMatch(c -> text.charAt(0) == c);
    }

    public static boolean isAlphabet(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) < text.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void countByLength(int length) {
        switch (length) {
            case 3:
                count3.getAndAdd(1);
                break;
            case 4:
                count4.getAndAdd(1);
                break;
            case 5:
                count5.getAndAdd(1);
                break;
            default:
                break;
        }
    }
}
