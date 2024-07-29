package com.brady;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Map<String, String> arguments = ArgumentParser.parse(args);

        BigInteger min = new BigInteger(arguments.get("min") == null ? String.valueOf(Integer.MAX_VALUE / 2) : arguments.get("min"));
        BigInteger max = new BigInteger(arguments.get("max") == null ? String.valueOf(Integer.MAX_VALUE) : arguments.get("max"));
        int count = Integer.parseInt(arguments.get("count") == null ? "10" : arguments.get("count"));

        Long start = System.currentTimeMillis();

        List<BigInteger> primes = generateRandomPrimes(min, max, count);

        Long end = System.currentTimeMillis();

        System.out.println("Generated " + primes.size() + " primes in " + (end - start) + "ms");

        for (BigInteger prime : primes) {
            System.out.println(prime);
        }
    }

    static List<BigInteger> generateRandomPrimes(BigInteger min, BigInteger max, int count) {
        List<BigInteger> primes = new ArrayList<>();

        while (primes.size() < count) {
            BigInteger random = generateRandomNumber(min, max);
            if (isPrime(random)) {
                primes.add(random);
            }
        }
        return primes;
    }

    static BigInteger generateRandomNumber(BigInteger min, BigInteger max) {
        Random rnd = new Random();

        BigInteger result = new BigInteger(max.bitLength(), rnd);

        while (result.compareTo(min) < 0 || result.compareTo(max) > 0) {
            result = new BigInteger(max.bitLength(), rnd);
        }
        return result;
    }

    static boolean isPrime(BigInteger number) {
        return number.isProbablePrime(10);
    }
}
