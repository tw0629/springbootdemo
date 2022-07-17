package com.tw2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author suhaotian
 * @version 1.0.0
 * @createTime 2022/4/8
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FetchConfigurationBO {

    /**
     *  文件别名
     */
    @JsonProperty("file_alias")
    private String fileAlias;

    /**
     *  商户编码mcc/mid列表（逗号分隔）
     */
    @JsonProperty("file_merchant_code_list")
    private String fileMerchantCodeList;

    /**
     *  文件下载url变量取值Freemarker表达式
     */
    @JsonProperty("file_url_var_fm_exp")
    private String fileUrlVarFmExp;

    /**
     *  batchNo取值Freemarker表达式
     */
    @JsonProperty("batch_no_fm_exp")
    private String batchNoFmExp;

    /**
     *  是否考虑节假日
     */
    @JsonProperty("skip_holiday")
    private String skipHoliday;

    /**
     *  文件名日期偏移天数
     */
    @JsonProperty("file_name_date_offset")
    private String fileNameDateOffset;

    /**
     *  文件Url模板(Freemarker表达式)
     */
    @JsonProperty("download_url_template")
    private String downloadUrlTemplate;


}
