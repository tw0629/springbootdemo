package other;

import com.sun.beans.decoder.ValueObject;
import org.junit.Test;

/**
 * @author David Tian
 * @desc
 * @since 2020-08-21 14:45
 */
public class test3 {

    @Test
    public void test() {

        boolean i = true;

        Boolean ii = i;

        System.out.println("===============>" + ii);

    }

    @Test
    public void test2() {

        new Thread(() -> {
            while (true) {
                System.out.println(String.format("B(mod 3) consume : %d", ""));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

    }

    @Test
    public void test3() {
        Integer i = 5;

        System.out.println(i==0);
        System.out.println("    ");
        System.out.println(i.equals(0));


    }

}
