package com.dongbawen.common.enums;

/**
 * @author snh
 * @version 1.0
 * @className DrugRuleTypeCategoryEnum
 * @description TODO
 * @date 2019/11/18 19:30
 **/
public enum DrugRuleTypeCategoryEnum {

    INTERACTION("相互作用","1"),
    ALLERGY("过敏","2");

    private String value;

    private String code;

    DrugRuleTypeCategoryEnum(String value, String code){
        this.value=value;
        this.code=code;
    }


    public static final class FieldValidation{

        public static String getValue(String code){
            DrugRuleTypeCategoryEnum[] categoryEnums=DrugRuleTypeCategoryEnum.values();
            for (DrugRuleTypeCategoryEnum categoryEnum : categoryEnums) {
                if(categoryEnum.code.equals(code)){
                    return categoryEnum.value;
                }
            }
            return null;
        }

        public static String getCode(String value){
            DrugRuleTypeCategoryEnum[] categoryEnums=DrugRuleTypeCategoryEnum.values();
            for (DrugRuleTypeCategoryEnum categoryEnum : categoryEnums) {
                if(categoryEnum.value.equals(value)){
                    return categoryEnum.code;
                }
            }
            return null;
        }
    }
}
