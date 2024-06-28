package com.service.tw.Runtime;

import org.junit.Test;

/**
 * @author David Tian
 * @since 2019-05-14
 */
public class runtime_demo {

    /**
     * 使用Runtime.availableProcessors() 获得可用的处理器个数。
     *
     * java.lang.Runtime.availableProcessors() 方法: 返回可用处理器的Java虚拟机的数量。
     * 这个值可以在虚拟机中的某个调用过程中改变。应用程序是可用的处理器数量敏感，因此应该偶尔查询该属性，并适当调整自己的资源使用情况。
     *
     * 我的双核1-2-1机器上，它返回的是2，这是对的。
     * 不过在我的1-4-2机器 上，也就是一个CPU插槽，4核，每个核2个超线程，这样的话会返回8
     *
     * 也不一定 https://blog.csdn.net/jiafu1115/article/details/40430709
     *
     */
    @Test
    public void test1(){

        Runtime runtime = Runtime.getRuntime();
        int i = runtime.availableProcessors();
        System.out.println("======"+i);

//        Runtime.getRuntime().availableProcessors()

        int processors = Runtime.getRuntime().availableProcessors();

        System.out.println("=========="+processors);
        System.out.println("Number of processors available to the Java Virtual Machine: " + processors);
    }
}
