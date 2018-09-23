package com.yxysoft.common.base;

/**
 * @ClassName: BaseEnum
 * @Description: 用于枚举需要实现的接口
 * @author yangsy
 * @param <K> 枚举类型的值的类型
 */
public interface BaseEnum<K> {

    /**
     * @Title: getValue
     * @Description: 得到枚举对应的值,一般保存这个值至数据库
     * @return 该枚举的值
     */
    K getValue();

    /**
     * @Title: getLabel
     * @Description: 得到枚举描述，一般用来展示给用户看
     * @return 该枚举值的描述
     */
    String getLabel();

}
