package other;

import com.common.util.StringUtil;
import com.model.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author David Tian
 * @since 2019-02-13
 */
public class listdemo {

    @Test
    public void demo() {

        List<EsQueryObject> esQueryObjectList = new ArrayList<>();
        EsQueryObject esQueryObject = null;
//        esQueryObject = new EsQueryObject();
//        esQueryObject.setVin("1");
//        esQueryObjectList.add(esQueryObject);
        esQueryObject = new EsQueryObject();
        esQueryObject.setVin("2");
        esQueryObjectList.add(esQueryObject);
//        esQueryObject = new EsQueryObject();
//        esQueryObject.setVin("3");
//        esQueryObjectList.add(esQueryObject);
//        esQueryObject = new EsQueryObject();
//        esQueryObject.setVin("4");
//        esQueryObjectList.add(esQueryObject);
//        esQueryObject = new EsQueryObject();
//        esQueryObject.setVin("5");
//        esQueryObjectList.add(esQueryObject);
//        esQueryObject = new EsQueryObject();
//        esQueryObject.setVin("6");
//        esQueryObjectList.add(esQueryObject);
        esQueryObject = new EsQueryObject();
        esQueryObject.setVin("7");
        esQueryObjectList.add(esQueryObject);
//        esQueryObject = new EsQueryObject();
//        esQueryObject.setVin("8");
//        esQueryObjectList.add(esQueryObject);
//        esQueryObject = new EsQueryObject();
//        esQueryObject.setVin("9");
//        esQueryObjectList.add(esQueryObject);
        esQueryObject = new EsQueryObject();
        esQueryObject.setVin("10");
        esQueryObjectList.add(esQueryObject);


        List<CarMessage> carMessageList = new ArrayList<>();
        CarMessage carMessage = null;
        carMessage = new CarMessage();
        carMessage.setVin("1");
        carMessageList.add(carMessage);
        carMessage = new CarMessage();
        carMessage.setVin("2");
        carMessageList.add(carMessage);
        carMessage = new CarMessage();
        carMessage.setVin("3");
        carMessageList.add(carMessage);
        carMessage = new CarMessage();
        carMessage.setVin("4");
        carMessageList.add(carMessage);
        carMessage = new CarMessage();
        carMessage.setVin("5");
        carMessageList.add(carMessage);
        carMessage = new CarMessage();
        carMessage.setVin("6");
        carMessageList.add(carMessage);
        carMessage = new CarMessage();
        carMessage.setVin("7");
        carMessageList.add(carMessage);
        carMessage = new CarMessage();
        carMessage.setVin("8");
        carMessageList.add(carMessage);
        carMessage = new CarMessage();
        carMessage.setVin("9");
        carMessageList.add(carMessage);
        carMessage = new CarMessage();
        carMessage.setVin("10");
        carMessageList.add(carMessage);


        for (CarMessage car : carMessageList) {
            boolean bool = false;
            //System.out.println("=======***1***=======>"+bool);
            for (EsQueryObject esQueryObject2 : esQueryObjectList) {
                if (car.getVin().equals(esQueryObject2.getVin())) {
                    car.setFitStatus("FIT");
                    bool = true;
                    break;
                }
            }
            System.out.println("=======***2***=======>" + bool);
            if (bool == false) {
                car.setFitStatus("NOT-FIT");
            }
        }

        System.out.println("========================");
        System.out.println("=========>" + carMessageList.toString());
        System.out.println("========================");
    }

    @Test
    public void demo2() {
        List<CarMessage> carMessageList = new ArrayList<>();
        CarMessage carMessage = new CarMessage();
        carMessage.setVin("1");
        carMessageList.add(carMessage);

        List<Object> list = new ArrayList<>();
        list.add(carMessage);

        System.out.println("=======>" + list.toString());
    }

    @Test
    public void demo3() {
        String s = "tian";
        try {
            s = "wei";
        } catch (Exception e) {

        } finally {

        }
        System.out.println("=======>" + s);
    }

    @Test
    public void demo4() {
        float f = 0.156f;
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(3);
        String format = nf.format(f);
        System.out.println("=======>" + format);
    }

    @Test
    public void demo5() {
        String s1 = "index";
        String s2 = "INDEX";
        System.out.println("==========>" + s2.equals(s1));
    }

    @Test
    public void demo6() {

        Long i = 9L;

        List list = new ArrayList();
        list.add(26L);
        list.add(39L);
        list.add(5L);
        list.add(40L);
        list.add(39L);
        list.add(25L);
        System.out.println(list);

        List newList = (List) list.stream().distinct().collect(Collectors.toList());

        System.out.println("java8新特性stream去重:" + newList);

    }

    @Test
    public void demo7() {

        Map<Object, Object> map = new HashMap<>();

        map.put(1, 1);

        map.put(1, 2);

        System.out.println("=========XXXXX=========>" + map.toString());

    }


    @Test
    public void demo8() {

        List<Comment> commentList = new ArrayList<>();
        Comment comment = null;

        comment = new Comment();
        comment.setScore(2);
        commentList.add(comment);

        comment = new Comment();
        comment.setScore(4);
        commentList.add(comment);

        comment = new Comment();
        comment.setScore(6);
        commentList.add(comment);

        comment = new Comment();
        comment.setScore(8);
        commentList.add(comment);

        comment = new Comment();
        comment.setScore(10);
        commentList.add(comment);


        int goodNum = 0;
        int badNum = 0;
        int scoreTotal = 0;
        for (Comment commentt : commentList) {
            Integer score = commentt.getScore();
            if (score <= 6) {
                badNum++;
            } else if (score > 6) {
                goodNum++;
            }
            scoreTotal = scoreTotal + score;
        }
        float avg = scoreTotal / commentList.size();
        BigDecimal avgScore = BigDecimal.valueOf(avg);

        System.out.println("==================");
        System.out.println("=========>" + goodNum);
        System.out.println("=========>" + badNum);
        System.out.println("=========>" + avgScore);
        System.out.println("==================");

    }

    @Test
    public void demo9() {

        Map<Integer, Integer> tagMap = new HashMap<>();

        List<CommentTagVo> commentTagVoList = new ArrayList<>();
        CommentTagVo commentTag = null;

        commentTag = new CommentTagVo();
        String tagids1 = "1,2,3,4,6";
        commentTag.setCommenttagids(tagids1);
        commentTagVoList.add(commentTag);

        commentTag = new CommentTagVo();
        String tagids2 = "1,2,3,4,7";
        commentTag.setCommenttagids(tagids2);
        commentTagVoList.add(commentTag);

        commentTag = new CommentTagVo();
        String tagids3 = "1,2,3,4,5";
        commentTag.setCommenttagids(tagids3);
        commentTagVoList.add(commentTag);

        commentTag = new CommentTagVo();
        String tagids4 = "1,2,3,4,5";
        commentTag.setCommenttagids(tagids4);
        commentTagVoList.add(commentTag);

        commentTag = new CommentTagVo();
        String tagids5 = "8,2,3,4,5";
        commentTag.setCommenttagids(tagids5);
        commentTagVoList.add(commentTag);


        for (CommentTagVo commentTagVo : commentTagVoList) {

            String commenttagids = commentTagVo.getCommenttagids();
            String[] split = commenttagids.split(",");
            List<String> list = Arrays.asList(split);
            List<Integer> tagidList = StringUtil.stringConvertInteger(list);

            Map<Integer, Integer> map = countTag(tagidList);

            if (tagMap.size() == 0) {
                tagMap.putAll(map);
                continue;
            }

            for (Integer key : map.keySet()) {
                if (tagMap.containsKey(key)) {
                    Integer num = tagMap.get(key) + map.get(key);
                    tagMap.put(key, num);
                } else {
                    tagMap.put(key, map.get(key));
                }
            }
        }

        //根据评论类型查询相关所有标签信息
        List<TagInfoVo> tagInfoVoList = new ArrayList<>();
        TagInfoVo tagInfo = null;

        tagInfo = new TagInfoVo();
        tagInfo.setId(1L);
        tagInfoVoList.add(tagInfo);

        tagInfo = new TagInfoVo();
        tagInfo.setId(2L);
        tagInfoVoList.add(tagInfo);

        tagInfo = new TagInfoVo();
        tagInfo.setId(3L);
        tagInfoVoList.add(tagInfo);

        tagInfo = new TagInfoVo();
        tagInfo.setId(4L);
        tagInfoVoList.add(tagInfo);

        tagInfo = new TagInfoVo();
        tagInfo.setId(5L);
        tagInfoVoList.add(tagInfo);

        tagInfo = new TagInfoVo();
        tagInfo.setId(6L);
        tagInfoVoList.add(tagInfo);

        tagInfo = new TagInfoVo();
        tagInfo.setId(7L);
        tagInfoVoList.add(tagInfo);

        tagInfo = new TagInfoVo();
        tagInfo.setId(8L);
        tagInfoVoList.add(tagInfo);


        for (TagInfoVo tagInfoVo : tagInfoVoList) {
            int tagId = Integer.parseInt(String.valueOf(tagInfoVo.getId()));
            if (tagMap.containsKey(tagId)) {
                tagInfoVo.setCount(tagMap.get(tagId));
            } else {
                tagInfoVo.setCount(0);
            }
        }

        //todo 评论所对应的标签数量
        int size = tagMap.size();


        System.out.println("==================");
        System.out.println("=========>" + tagMap.toString());
        System.out.println("==================");
        System.out.println("=========>" + tagInfoVoList.toString());
        System.out.println("==================");

    }

    public Map<Integer, Integer> countTag(List<Integer> tagidList) {

        Map<Integer, Integer> map = new ConcurrentHashMap<>();

        //计数器
        int count = 0;
        //假设有15种标签
        for (int i = 0; i <= 11; i++) {
            count = 0;
            for (int j = 0; j < tagidList.size(); j++) {
                if (tagidList.get(j).equals(i)) {
                    count++;
                }
            }
            if (count != 0) {
                map.put(i, count);
            }
        }

        return map;
    }


    @Test
    public void demo10() {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");

        Map<String, Integer> stringIntegerMap = calcCountsOfListElements(list);


        System.out.println("============>" + stringIntegerMap.toString());


    }

    public static Map<String, Integer> calcCountsOfListElements(List<String> items) {
        if (items != null && items.size() > 0) {
            Map<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < items.size(); i++) {
                if (!map.containsKey(items.get(i))) {
                    map.put(items.get(i), 1);
                } else {
                    map.put(items.get(i), (Integer) map.get(items.get(i)) + 1);
                }
            }
            return map;
        } else {
            return null;
        }
    }


    @Test
    public void demo11() {

        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("a");
        list.add("a");

        System.out.println("\n例子 1 -统计'a'出现的频率");
        System.out.println("a : " + Collections.frequency(list, "a"));

        System.out.println("\n例子 2 - 统计每一个元素出现的频率");
        //将List转换为Set
        Set<String> uniqueSet = new HashSet(list);
        for (String temp : uniqueSet) {
            System.out.println(temp + ": " + Collections.frequency(list, temp));
        }

        System.out.println("\n例子 3 - 用Map统计每个元素出现的频率");
        Map map = new HashMap();

        for (String temp : list) {
            Integer count = (Integer) map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
        printMap(map);

        System.out.println("\nSorted Map");
        Map treeMap = new TreeMap(map);
        printMap(treeMap);

    }

    public static void printMap(Map map) {

            /*for (Map.Entry entry : map.entrySet()) {
                System.out.println("Key : " + entry.getKey() + " Value : "
                        + entry.getValue());
            }*/

    }



    @Test
    private void demo12(){

        int s = 8;
        if(s==8){
            s=6;
        }
        if(s==6){
            System.out.println("=========666666");
        }


    }


}
