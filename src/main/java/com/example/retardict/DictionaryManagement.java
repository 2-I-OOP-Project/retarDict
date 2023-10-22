package com.example.retardict;

import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary dic = new Dictionary();

    public void insertFromCommandLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert number of words: ");
        int wordCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < wordCount; i++) {
            System.out.println("Insert word target: ");
            String target = scanner.nextLine();
            System.out.println("Insert word explain: ");
            String explain = scanner.nextLine();
            dic.insertWord(target, explain);
        }
    }

    public void showAllWords() {
        System.out.println("No | English | Vietnamese");
        dic.sortByWordTarget();
        for (int i = 0; i < dic.getWordCount(); i++) {
            System.out.println((i + 1) + " | " + dic.getWord(i).getWord_target() + " | " + dic.getWord(i).getWord_explain());
        }
    }
}
