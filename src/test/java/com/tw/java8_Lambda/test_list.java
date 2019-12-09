package com.tw.java8_Lambda;

import com.common.Model.CommentInfoDTO;
import com.model.TerminalAddressEntity;
import com.tw.Date_test.DateUtils3;
import org.junit.Test;

import java.util.*;

//遍历耗时测试
public class test_list {

    @Test
    public void test() {
        for (int t = 1; t < 5; t++) {
            for (int tt = 1; tt <= 4; tt++) {

                List<Integer> testList = Arrays.asList(new Integer[(int) Math.pow(100, (t))]);
                //System.out.println("========>  "+testList);

                System.out.println("===================================================");

                long t1 = System.currentTimeMillis();
                for (int i = 0; i < testList.size(); i++) {
                    Integer b = testList.get(i);
                }

                long t2 = System.currentTimeMillis();
                for (Integer i : testList) {
                    Integer b = i;
                }

                long t3 = System.currentTimeMillis();
                testList.forEach(integer -> {
                    Integer b = integer;
                });

                long t4 = System.currentTimeMillis();
                testList.stream().forEach(integer -> {
                    Integer b = integer;
                });

                long t5 = System.currentTimeMillis();
                testList.parallelStream().forEach(integer -> {
                    Integer b = integer;
                });

                long t6 = System.currentTimeMillis();
                Integer b;
                for (Iterator<Integer> iterator = testList.iterator(); iterator.hasNext(); b = iterator.next()) ;

                long t7 = System.currentTimeMillis();

                System.out.println("x" + tt + ": loop size:" + testList.size());
                System.out.println("y" + t + ": classical for loop waste millisecond:" + (t2 - t1));
                System.out.println("y" + t + ": classical forEach loop waste millisecond:" + (t3 - t2));
                System.out.println("y" + t + ": lambda forEach loop waste millisecond:" + (t4 - t3));
                System.out.println("y" + t + ": lambda not parallel stream forEach loop waste millisecond:" + (t5 - t4));
                System.out.println("y" + t + ": lambda parallel stream forEach loop waste millisecond:" + (t6 - t5));
                System.out.println("y" + t + ": classical iterator loop waste millisecond:" + (t7 - t6) + "\n");

            }
        }
    }

    @Test
    public void test2() {
        //  List<Integer> testList = Arrays.asList(new Integer[(int) Math.pow(100,(6))]);

        double pow = Math.pow(100, (6)); //pow() 方法可返回 x 的 y 次幂的值。
        System.out.println("========>" + pow);

        double pow2 = Math.pow(100, 6); //pow() 方法可返回 x 的 y 次幂的值。
        System.out.println("========>" + pow2);

        int pow3 = (int) Math.pow(100, 6); //pow() 方法可返回 x 的 y 次幂的值。
        System.out.println("========>" + pow3);

        Integer[] integers = new Integer[(int) Math.pow(100, 4)];
        System.out.println("========>" + integers);


        List<Integer> list = Arrays.asList(new Integer[(int) Math.pow(100, 4)]);
        System.out.println("========>" + list);
    }


    // list 去重
    @Test
    public void test3() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(4);


        System.out.println("去重之前： " + list.toString());

        removeDuplicate(list);

        System.out.println("去重之后： " + list.toString());


    }

    private static void removeDuplicate(List<TerminalAddressEntity> list) {
        LinkedHashSet<TerminalAddressEntity> set = new LinkedHashSet<TerminalAddressEntity>(list.size());
        set.addAll(list);
        list.clear();
        list.addAll(set);
    }

    private static ArrayList<TerminalAddressEntity> removeDuplicate2(List<TerminalAddressEntity> TerminalAddressEntitys) {
        Set<TerminalAddressEntity> set = new TreeSet<TerminalAddressEntity>(new Comparator<TerminalAddressEntity>() {
            @Override
            public int compare(TerminalAddressEntity o1, TerminalAddressEntity o2) {
                //字符串,则按照asicc码升序排列
                return o1.getWorkerCode().compareTo(o2.getWorkerCode());
            }
        });
        set.addAll(TerminalAddressEntitys);
        return new ArrayList<TerminalAddressEntity>(set);
    }

    @Test
    public void test4() {
        //初始化数据
        List<TerminalAddressEntity> dispatchList = new ArrayList<>();
        TerminalAddressEntity terminalAddressEntity = new TerminalAddressEntity();
        terminalAddressEntity.setTerminalAddressId(1L);
        terminalAddressEntity.setProvince("1");
        terminalAddressEntity.setWorkerCode("1");
        dispatchList.add(terminalAddressEntity);

        terminalAddressEntity = new TerminalAddressEntity();
        terminalAddressEntity.setTerminalAddressId(2L);
        terminalAddressEntity.setProvince("2");
        terminalAddressEntity.setWorkerCode("2");
        dispatchList.add(terminalAddressEntity);

        terminalAddressEntity = new TerminalAddressEntity();
        terminalAddressEntity.setTerminalAddressId(3L);
        terminalAddressEntity.setProvince("1");
        terminalAddressEntity.setWorkerCode("1");
        dispatchList.add(terminalAddressEntity);

        terminalAddressEntity = new TerminalAddressEntity();
        terminalAddressEntity.setTerminalAddressId(2L);
        terminalAddressEntity.setProvince("2");
        terminalAddressEntity.setWorkerCode("2");
        dispatchList.add(terminalAddressEntity);

        terminalAddressEntity = new TerminalAddressEntity();
        terminalAddressEntity.setTerminalAddressId(3L);
        terminalAddressEntity.setProvince("1");
        terminalAddressEntity.setWorkerCode("1");
        dispatchList.add(terminalAddressEntity);


        System.out.println("去重之前： " + dispatchList.toString());

        ArrayList<TerminalAddressEntity> tt = removeDuplicate2(dispatchList);

        System.out.println("去重之后： " + tt.toString());

    }

    @Test
    public void test5(){
        List<CommentInfoDTO> planEventVoList = new ArrayList<>();

        CommentInfoDTO commentInfoDTO = new CommentInfoDTO();
        commentInfoDTO.setId(1L);
        commentInfoDTO.setDateCreate(new Date());
        planEventVoList.add(commentInfoDTO);

        CommentInfoDTO commentInfoDTO2 = new CommentInfoDTO();
        commentInfoDTO2.setId(2L);
        commentInfoDTO2.setDateCreate(DateUtils3.addDateDay(new Date(),-1));
        planEventVoList.add(commentInfoDTO2);

        CommentInfoDTO commentInfoDTO3 = new CommentInfoDTO();
        commentInfoDTO3.setId(3L);
        commentInfoDTO3.setDateCreate(DateUtils3.addDateDay(new Date(),-2));
        planEventVoList.add(commentInfoDTO3);

        System.out.println("=======>" + planEventVoList.toString());

        //待处理按照待办计划跟进时间升序
        //升序:由小到大
        //planEventVoList.sort((CommentInfoDTO e1, CommentInfoDTO e2) -> e2.getDateCreate().compareTo(e1.getDateCreate()));


        planEventVoList.sort(Comparator.comparing((CommentInfoDTO e) -> e.getDateCreate()));



                System.out.println("=======>" + planEventVoList.toString());
        System.out.println("=======>" );

    }


}
