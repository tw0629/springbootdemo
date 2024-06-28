package com.common.util.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author David Tian
 * @desc
 * @since 2024/6/28 11:30
 *
 * 随机
 *  1 Random
 *  2 Math.random()
 *  3 ThreadLocalRandom.current().nextXXX() 多线程
 *
 */
public class RandomUtils {

    // 生成指定范围内的整数随机数（左合右合[]）
    public static int generateInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    // 生成指定范围内的浮点数随机数
    public static float generateFloat(float min, float max) {
        return new Random().nextFloat() * (max - min) + min;
    }

    // 生成指定长度的随机字符串
    public static String generateString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = new Random().nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }
        return sb.toString();
    }

    // 生成指定范围内的布尔随机数
    public static boolean generateBoolean() {
        return new Random().nextBoolean();
    }
}
