import java.util.Random;

import static ru.netology.utils.TextChecker.*;

public class Main {


    public static void main(String[] args) {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        Thread palindrom = new Thread(() -> {
            for (String text : texts) {
                if (isPalindrome(text) && !isSingleChar(text))
                    countByLength(text.length());
            }
        });
        palindrom.start();

        Thread singlechar = new Thread(() -> {
            for (String text : texts) {
                if(isSingleChar(text))
                    countByLength(text.length());
            }
        });
        singlechar.start();

        Thread alpha = new Thread(() -> {
            for (String text : texts) {
                if(isAlphabet(text) && !isSingleChar(text))
                    countByLength(text.length());
            }
        });
        alpha.start();

        try {
            alpha.join();
            singlechar.join();
            palindrom.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Красивых слов с длиной 3: " + count3 + "шт");
        System.out.println("Красивых слов с длиной 4: " + count4 + "шт");
        System.out.println("Красивых слов с длиной 5: " + count5 + "шт");
    }
}
