package other;

import com.tw.CheckParam.CheckParamUtil;
import com.tw.Enum_test.TagTypeEnum;
import com.tw.Model.CommentInfoDTO;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author David Tian
 * @since 2019-03-16
 */
public class test2 {

    @Test
    public void test() {

        boolean i = true;

        Boolean ii = i;

        System.out.println("===============>" + ii);

    }

    @Test
    public void test2() {

        CommentInfoDTO commentInfoDTO = new CommentInfoDTO();
        commentInfoDTO.setType(2);
        commentInfoDTO.setTargetId("x1");
        commentInfoDTO.setFromId("g5");
        commentInfoDTO.setFromName("guest5");
        commentInfoDTO.setFromAvatar("www5");
        commentInfoDTO.setContent("评论5");
        commentInfoDTO.setScore(5);
        commentInfoDTO.setCreator("system");
        commentInfoDTO.setDateCreate(new Date());

        //List<CommentTagDTO> commentTagDTOList = new ArrayList<>();
        //commentInfoDTO.setCommentTagDTOList(commentTagDTOList);


        //<CommentSubScoreDTO> commentSubScoreDTOList = new ArrayList<>();
        //commentInfoDTO.setCommentSubScoreDTOList(commentSubScoreDTOList);

        String s = "";
        List<String> excludeNames = new ArrayList<>();
        excludeNames.add("id");
        excludeNames.add("typeName");
        excludeNames.add("commentTagDTOList");
        excludeNames.add("commentSubScoreDTOList");
        try {
            s = CheckParamUtil.checkParamExistNull(commentInfoDTO, excludeNames);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("===============>" + s);


    }


    @Test
    public void test3() {

        Object string = CheckParamUtil.checkParam(1, "String", "", null);

        System.out.println("===============>" + string);

    }

    @Test
    public void test4() {

        Long code = 1L;

        if (!StringUtils.isEmpty(code)) {
            System.out.println("=========>" + "XXXXX");
        }
    }


    @Test
    public void test5() {


        TagTypeEnum tagTypeEnum = TagTypeEnum.getByName("GOOD_COMMENT");
        System.out.println("===============>" + tagTypeEnum +"      "+tagTypeEnum.name());

        TagTypeEnum tagTypeEnum2 = TagTypeEnum.getByName("BAD_COMMENT");
        System.out.println("===============>" + tagTypeEnum2+"      "+tagTypeEnum2.name());


        System.out.println("==============================");

        String typeName = TagTypeEnum.getByCode(1);
        System.out.println("===============>" + typeName);

        String typeName2 = TagTypeEnum.getByCode(2);
        System.out.println("===============>" + typeName2);

        String typeName3 = TagTypeEnum.getByCode(3);
        System.out.println("===============>" + typeName3);

    }

    @Test
    public void test6() {

        String str1="2.30";
        BigDecimal bd=new BigDecimal(str1);
        System.out.println("===============>" + bd);


        System.out.println("=============================================" );

        String result = "";
        float num =(float)10/3;

        DecimalFormat df = new DecimalFormat("0.0");

        result = df.format(num);

        System.out.println("===============>" + result);

        BigDecimal bd2=new BigDecimal(result);
        System.out.println("===============>" + bd2);


    }

    @Test
    public void test7(){

        List list = new ArrayList();

        int batchCount = 100;

        if (list!=null){
            int recCount=list.size();
            if (recCount>0 && recCount<=batchCount){

                //operate
            }
            if (recCount>batchCount){

                int times = recCount / batchCount;
                int residue = recCount % batchCount;
                if (residue > 0) {
                    times = times + 1;
                }
                for (int i=0;i<times;i++){
                    if (i==times-1){
                        //operate
                    }else{
                        //operate
                    }
                }
            }
        }else {

            //
        }

    }

    

}
