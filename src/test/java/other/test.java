package other;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.HttpclientUtil.HttpUtil;
import com.model.TerminalAddressModel3;
import com.tw.Model.CommentInfoDTO;
import org.junit.Test;

import java.util.*;

public class test {

    @Test
    public void test() {
        TerminalAddressModel3 terminalAddressModel = new TerminalAddressModel3();
        //terminalAddressModel.setTerminalAddressId();
        terminalAddressModel.setWorkerCode("156022");
        terminalAddressModel.setProvince("陕西");
        terminalAddressModel.setCity("太原市");
        terminalAddressModel.setArea("小店区");
        terminalAddressModel.setDetailAddress("山西省太原市小店区发财路8号");
        terminalAddressModel.setLatitude("666.123");
        terminalAddressModel.setLongitude("888.123");
        terminalAddressModel.setIsdefault(1);
        terminalAddressModel.setIsdel(0);
        terminalAddressModel.setLabelId(3L);
        terminalAddressModel.setLabelName("宿舍");

        String params = JSON.toJSONString(terminalAddressModel);

        System.out.println(params);
    }

    @Test
    public void test2() {

        String params = "{\"labelId\":\"10\",\"type\":\"qwer\"}";
        JSONObject jsonObject = JSON.parseObject(params);
        Long labelId = Long.valueOf(JSON.parseObject(params).getString("labelId"));
        String type = JSON.parseObject(params).getString("type");
        System.out.println("==========================");
        System.out.println(labelId);
        System.out.println(type);
        System.out.println("==========================");

//        Map map = new HashMap();
//        Set set = new HashSet();
//        JSON
    }

    @Test
    public void test3() {
        String params = "{\"labelId\":10}";
        JSONObject jsonObject = JSON.parseObject(params);
        //Long labelId = Long.valueOf(JSON.parseObject(params).get("labelId"));
        Object labelId = JSON.parseObject(params).get("labelId");
        Integer id = (Integer) labelId;

        TerminalAddressModel3 terminalAddressModel = new TerminalAddressModel3();
        terminalAddressModel.setCity("上海市");
        int i = 10;
        int ii = i;
        String a = "key";
        String b = a;

        Map map = new HashMap();
        Set set = new HashSet();


        System.out.println("==========================");
        System.out.println(labelId);
        System.out.println("==========================");
    }

//    @Test
//    public void test4(){
//        String addressStr = "http://restapi.amap.com/v3/geocode/geo?key=xxxxxxxxxxxxxxxx&s=rsv3&city=028&address=";
//        String getAddress = HttpUtils.get(addressStr + UrlEncoded.encodeString(address));
//        JSONObject object = JSONObject.parseObject(getAddress);
//        JSONArray geocodes = object.getJSONArray("geocodes");
//        ExcelDetails details = ExcelDetails.dao.findById(id);
//        if (geocodes.size() == 0) {
//            details.set("status", 0);
//        } else if (geocodes.size() == 1) {
//            JSONObject trueAddress = geocodes.getJSONObject(0);
//            String location = trueAddress.getString("location");
//            String lngX = location.split(",")[0];
//            String latY = location.split(",")[1];
//        } else {
//        }
//    }

    @Test
    public void test4() {
        String addressStr = "http://restapi.amap.com/v3/geocode/geo?address=山西省太原市体育场&output=JSON&key=891f8b10fda5ce1bd2974144200771d1\t";
        String s = HttpUtil.doGet(addressStr);
        System.out.println("===========》" + s.toString());
    }

    @Test
    public void test5() {

        System.out.println("==========>" + Thread.currentThread().getStackTrace()[0].getMethodName());
        System.out.println("==========>" + Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("==========>" + Thread.currentThread().getStackTrace()[2].getMethodName());
        System.out.println("==========>" + Thread.currentThread().getStackTrace()[3].getMethodName());


        System.out.println("========================================");

        Exception e = new Exception();
        Exception e2 = new NullPointerException();

        e.printStackTrace();
        e2.printStackTrace();
        e2.printStackTrace();
        e.printStackTrace();

    }

    @Test
    public void test6() {
        List<TerminalAddressModel3> list = new ArrayList<>();
        TerminalAddressModel3 terminalAddressModel = new TerminalAddressModel3();
        terminalAddressModel.setCity("shanxi");
        list.add(terminalAddressModel);
        System.out.println("返回结果数据个数" + list.size());
        System.out.println("返回结果数据个数" + JSON.toJSONString(list));
    }

    @Test
    public void test7() {

        CommentInfoDTO commentInfoDTO = new CommentInfoDTO();

        System.out.println("===1===>"+commentInfoDTO.getCreator());

        CommentInfoDTO commentInfoDTO2 = null;

        System.out.println("===2===>"+commentInfoDTO2.getCreator());

    }
}
