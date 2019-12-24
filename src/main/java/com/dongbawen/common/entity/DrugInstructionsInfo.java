package com.dongbawen.common.entity;

import com.dongbawen.common.annotation.Excel;
import com.dongbawen.common.annotation.ExcelTarget;
import lombok.Data;

/**
 * @author snh
 * @version 1.0
 * @className DrugInstructionsInfo
 * @description TODO 药品信息，包含说明书厂商等。
 * @date 2019/10/15 8:39
 **/
@Data
@ExcelTarget(sheetName = "药品信息")
public class DrugInstructionsInfo {

    /**
     * 药品编码 同种药品不同厂商 药品编码不同
     */
    @Excel(name = "药品编码",index = 0)
    private String drugCode;

    /**
     * 药品通用名
     */
    @Excel(name = "药品通用名",index = 1)
    private String drugName;

    /**
     * 是否医保
     */
    @Excel(name = "医保药",index = 2)
    private String flagMedicalInsurance;
    /**
     * 是否国产
     */
    @Excel(name = "国产药",index = 3)
    private String flagDomestic;
    /**
     * 成份说明
     */
    @Excel(name = "药品成份",index = 4)
    private String ingredientsDesc;
    /**
     * 性状说明
     */
    @Excel(name = "性状",index = 5)
    private String charactersDesc;

    /**
     * 接种对象
     */
    @Excel(name = "接种对象",index = 6)
    private String inoculumObject;

    /**
     * 质量标准
     */
    @Excel(name = "质量标准",index = 7)
    private String qualityStandard;

    /**
     * 作用与用途
     */
    @Excel(name = "作用与用途",index = 8)
    private String effectionPurpose;
    /**
     * 适应症说明
     */
    @Excel(name = "适应症",index = 9)
    private String indicationDesc;

    /**
     * 超说明书适应症
     */
    @Excel(name = "超说明书适应症",index = 10)
    private String offlabelIndications;
    /**
     * 用法用量说明
     */
    @Excel(name = "用法用量",index = 11)
    private String dosageAdministrationDesc;
    /**
     * 副反应及处理
     */
    @Excel(name = "副反应及处理",index = 12)
    private String sideEffectsTreatment;
    /**
     * 不良反应说明
     */
    @Excel(name = "不良反应",index = 13)
    private String adverseReactionsDesc;
    /**
     * 禁忌说明
     */
    @Excel(name = "禁忌",index = 14)
    private String contraindicationsDesc;
    /**
     * 注意事项说明
     */
    @Excel(name = "注意事项",index = 15)
    private String cautionsDesc;
    /**
     * 药物相互作用说明
     */
    @Excel(name = "药物相互作用",index = 16)
    private String interactionsDesc;
    /**
     * 药理作用
     */
    @Excel(name = "药理作用",index = 17)
    private String pharmacologicalAction;
    /**
     * 药代动力学说明
     */
    @Excel(name = "药代动力学",index = 18)
    private String pharmacokineticsDesc;
    /**
     * 药理毒理说明
     */
    @Excel(name = "药理毒理",index = 19)
    private String pharmacologicalAndToxicologicalDesc;
    /**
     * 药物过量说明
     */
    @Excel(name = "药物过量",index = 20)
    private String overdosageDesc;
    /**
     * 临床试验说明
     */
    @Excel(name = "临床试验",index = 21)
    private String clinicalTrialsDesc;
    /**
     * 儿童用药说明
     */
    @Excel(name = "儿童用药",index = 22)
    private String pediatricUseDesc;
    /**
     * 孕妇及哺乳期妇女用药说明
     */
    @Excel(name = "孕妇及哺乳期妇女用药",index = 23)
    private String pregnancyAndNursingMothersDesc;
    /**
     * 老年用药说明
     */
    @Excel(name = "老年用药",index = 24)
    private String geriatricUseDesc;
    /**
     * 使用指导
     */
    @Excel(name = "使用指导",index = 25)
    private String useGuide;
    /**
     * 药物分类
     */
    @Excel(name = "药物分类",index = 26)
    private String drugClass;
    /**
     * 说明书标题
     */
    @Excel(name = "说明书标题",index = 27)
    private String instructionsTitle;
    /**
     * 注册证号
     */
    @Excel(name = "注册证号",index = 28)
    private String regApprovalNo;
    /**
     * 药品本位码
     */
    @Excel(name = "药品本位码",index = 29)
    private String drugStandCode;
    /**
     * 别名
     */
    @Excel(name = "别名",index = 30)
    private String drugAlias;
    /**
     * 商品名
     */
    @Excel(name = "商品名称",index = 31)
    private String tradeName;
    /**
     * 汉语拼音名称
     */
    @Excel(name = "汉语拼音名称",index = 32)
    private String pinyinName;
    /**
     * 英文名称
     */
    @Excel(name = "英文名称",index = 33)
    private String englishName;
    /**
     * 化学名
     */
    @Excel(name = "化学名",index = 34)
    private String chemicalName;
    /**
     * 作用类别
     */
    @Excel(name = "作用类别",index = 35)
    private String actionCategory;
    /**
     * 剂型
     */
    @Excel(name = "剂型",index = 36)
    private String drugSpec;
    /**
     * 规格
     */
    @Excel(name = "规格",index = 37)
    private String drugForm;
    /**
     * 包装说明
     */
    @Excel(name = "包装",index = 38)
    private String packageDesc;
    /**
     * 贮藏说明
     */
    @Excel(name = "贮藏",index = 39)
    private String storageDesc;
    /**
     * 有效期说明
     */
    @Excel(name = "有效期",index = 40)
    private String usefulLifeDesc;
    /**
     * 保存、运输与使用期限
     */
    @Excel(name = "保存、运输与使用期限",index = 41)
    private String storageTransportationDeadline;
    /**
     * 执行标准
     */
    @Excel(name = "执行标准",index = 42)
    private String implementStandard;
    /**
     * 批准文号/国家准字号
     */
    @Excel(name = "批准文号/国家准字号",index = 43)
    private String approvalNo;
    /**
     * 说明书修订日期
     */
    @Excel(name = "说明书修订日期",index = 44)
    private String revisionDate;
    /**
     * 生产企业/厂商（中文）
     */
    @Excel(name = "生产企业/厂商（中文）",index = 45)
    private String dcName;
    /**
     * 生产企业/厂商（英文）
     */
    @Excel(name = "生产企业/厂商（英文）",index = 46)
    private String dcEnName;
    /**
     * 生产地址
     */
    @Excel(name = "生产地址",index = 47)
    private String dcAddress;
    /**
     * 国家/地区（中文）
     */
    @Excel(name = "国家/地区（中文）",index = 48)
    private String dcProvince;
    /**
     * 国家/地区（英文）
     */
    @Excel(name = "国家/地区（英文）",index = 49)
    private String dcEnProvince;
    /**
     * 邮政编码
     */
    @Excel(name = "邮政编码",index = 50)
    private String dcPostcode;
    /**
     * 电话号码
     */
    @Excel(name = "电话号码",index = 51)
    private String dcTel;
    /**
     * 传真
     */
    @Excel(name = "传真号码",index = 52)
    private String dcFax;
    /**
     * 网址
     */
    @Excel(name = "网址",index = 53)
    private String dcUrl;
}
