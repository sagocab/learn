package com.example.learn.action;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExamples5ParallelPerformancePractical {
    private static final String[] priceStrings = {"1.0", "100.99", "35.75", "21.30", "88.00"};
    private static final BigDecimal[] targetPrices = {new BigDecimal("30"), new BigDecimal("20"), new BigDecimal("31")};
    private static final Random random = new Random(123);
    private static final Random targetPriceRandom = new Random(111);

    private static final List<Product2> products;

    static {
        final int length = 8_000_000;
        final Product2[] list = new Product2[length];

        for(int i = 1 ; i <= length ; i++){
            list[i - 1] = new Product2((long) i, "Producet" + i, new BigDecimal(priceStrings[random.nextInt(5)]));
        }
        products= Collections.unmodifiableList(Arrays.asList(list));
    }

    private static BigDecimal imperativeSum(final List<Product2> products, Predicate<Product2> predicate){
        BigDecimal sum = BigDecimal.ZERO;
        for(final Product2 product2 : products){
            if(predicate.test(product2)){
                sum = sum.add(product2.getPrice());
            }
        }
        return sum;
    }

    private static BigDecimal streamSum(final Stream<Product2> stream, final Predicate<Product2> predicate){
        /*
        Stream은 재사용할 수 없기 때문에, Stream을 직접 파라미터로 넘기는건 위험. 순수하게 테스트용임.
         */
        return stream.filter(predicate).map(Product2::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static void imperativeTest(final BigDecimal targetPrice, final boolean printResult) {
        /**
         * Benchmark 코드라서 결코 일반 앱 개발등에 쓰기 좋은 코딩 스타일로 작성된것이 아닙니다.
         * (Stream사용 이외의) 이런 코드 작성을 절대 권장하지 않습니다.
         */
        if (printResult) {
            System.out.println("============================================");
            System.out.println("\nImperative Sum\n--------------------------------------------");
        }
        final long start = System.currentTimeMillis();
        final BigDecimal result = imperativeSum(products, product -> product.getPrice().compareTo(targetPrice) >= 0);
        final long howLong = System.currentTimeMillis() - start;
        if (printResult) {
            System.out.println("Sum: " + result);
            System.out.println("It took " + howLong + " ms.");
            System.out.println("============================================");
        }
    }

    private static void streamTest(final BigDecimal targetPrice, final boolean printResult){
        if (printResult) {
            System.out.println("============================================");
            System.out.println("\nStream Sum\n--------------------------------------------");
        }
        final long start = System.currentTimeMillis();
        BigDecimal result = streamSum(products.stream(), product2 -> product2.getPrice().compareTo(targetPrice) >= 0);
        final long howLong = System.currentTimeMillis() - start;
        if (printResult) {
            System.out.println("Sum: " + result);
            System.out.println("It took " + howLong + " ms.");
            System.out.println("============================================");
        }
    }

    private static void parallelStreamTest(final BigDecimal targetPrice, final boolean printResult){
        /**
         * Benchmark 코드라서 결코 일반 앱 개발등에 쓰기 좋은 코딩 스타일로 작성된것이 아닙니다.
         * (Stream사용 이외의) 이런 코드 작성을 절대 권장하지 않습니다.
         */
        if (printResult) {
            System.out.println("============================================");
            System.out.println("\nParallel Stream Sum\n--------------------------------------------");
        }
        final long start = System.currentTimeMillis();
        BigDecimal result = streamSum(products.parallelStream(), product2 -> product2.getPrice().compareTo(targetPrice) >= 0);
        final long howLong = System.currentTimeMillis() - start;
        if (printResult) {
            System.out.println("Sum: " + result);
            System.out.println("It took " + howLong + " ms.");
            System.out.println("============================================");
        }
    }
    public static void main(String[] args) {
        final BigDecimal targetPrice = new BigDecimal("40");
        imperativeTest(targetPrice, true);
        streamTest(targetPrice, true);
        parallelStreamTest(targetPrice, true);

        System.out.println("Ignore Tests Above=======================\n");
        System.out.println("Start");
        for (int i = 0 ; i <5 ; i++){
            BigDecimal price = targetPrices[targetPriceRandom.nextInt(3)];
            imperativeTest(price, true);
            streamTest(price, true);
            parallelStreamTest(price, true);
        }
    }
}

@AllArgsConstructor
@Data
class Product2 {
    private Long id;
    private String name;
    private BigDecimal price;
}