package com.example.webflux;

import java.util.Arrays;
import java.util.List;

public class ImperativeDeclarativeCodeExample {
    public static void main(String[] args) {
        // 6개의 인자를 가진 리스트 생성
        List<Integer> numbers = Arrays.asList(1, 3, 21, 10, 8, 11);


        // 명령형 프로그래밍
        int imperativeSum = 0;
        for (int number : numbers) {
            // 6보다 크거나 짝수가 아니면
            if (number > 6 && (number % 2 != 0)) {
                imperativeSum += number;
            }
        }
        System.out.println("imperativeSum = " + imperativeSum);

        // 선언형 프로그래밍
        int declarativeSum = numbers.stream()
                .filter(number -> number > 6 && (number % 2 != 0))
                .mapToInt(number -> number)
                .sum();
        System.out.println("declarativeSum = " + declarativeSum);
    }
}
