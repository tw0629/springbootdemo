package com.service.tw.Enum_test;

/**
 * @author David Tian
 * @since 2019-07-08
 *
 *
 * https://www.cnblogs.com/liaokailin/p/3196253.html
 * 这个是我在看 枚举实现单例的  时候，看到的这种写法！！！
 *
 */
public enum TrafficLamp {

    RED(30){
        public  TrafficLamp nextLamp() {
            return GREEN ;
        }
    },
    GREEN(20){
        public  TrafficLamp nextLamp() {
            return YELLOW ;
        }
    },
    YELLOW(10){
        public  TrafficLamp nextLamp() {
            return RED ;
        }
    } ;

    public abstract TrafficLamp nextLamp() ;

    private int time ;

    private TrafficLamp(int time){
        this.time = time ;
        System.out.println(time);
    }

    public static void main(String[] args) {
        System.out.println(TrafficLamp.GREEN);
    }
}
