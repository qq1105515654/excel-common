package com.dongbawen.common.entity;

import com.dongbawen.common.annotation.Excel;
import com.dongbawen.common.annotation.ExcelTarget;
import lombok.Data;

/**
 * @author snh
 * @version 1.0
 * @className DrugBaseInfo
 * @description TODO 药品基础信息
 * @date 2019/10/15 8:31
 **/
@Data
@ExcelTarget(sheetName = "药品基础信息")
public class DrugBaseInfo {

    /**
     * 药品ID ,不从Excel表中来！在数据去重时查询数据库所得
     */
    private String drugId;
    /**
     * 药品通用名
     */
    @Excel(name = "药品通用名",index = 0)
    private String drugName;
    /**
     * 剂型
     */
    @Excel(name = "剂型",index = 1)
    private String drugForm;
    /**
     * 规格
     */
    @Excel(name = "规格",index = 2)
    private String drugSpec;

    /**
     * 是否处方
     */
    @Excel(name = "处方药",index = 3)
    private String flagPrescription;
    /**
     * 是否基药
     */
    @Excel(name = "基药",index = 4)
    private String flagBaseDrug;

    /**
     * ATC-解剖学主族代码      A
     */
    @Excel(name = "解剖学主族",index = 5)
    private String anatomicalMaingroupCode;
    /**
     * ATC-治疗学副族代码      A01
     */
    @Excel(name = "治疗学副族",index = 6)
    private String therapeuticsSubgroupCode;
    /**
     * ATC-药理学副族代码      A01A
     */
    @Excel(name = "药理学副族",index = 7)
    private String pharmacologySubgroupCode;
    /**
     * ATC-化学副族代码       A01AB
     */
    @Excel(name = "化学副族",index = 8)
    private String chemicalSubgroupCode;
    /**
     * ATC-化学物质代码       A01AB02
     */
    @Excel(name = "化学物质",index = 9)
    private String chemicalSubstancesCode;

    /**
     * 作用类别
     */
    @Excel(name = "作用类别",index = 10)
    private String actionCategory;
    /**
     * DDD值
     */
    @Excel(name = "DDD",index = 11)
    private String dddValue;
    /**
     * 是否高危药
     */
    @Excel(name = "高危药",index = 12)
    private String flagHighRisk;

    /**
     * 用药途径
     */
    @Excel(name = "用药途径",index = 13)
    private String routes;

}
