package com.dimon.xcrm.dao;

import com.dimon.xcrm.pojo.Xlogin;

public interface XloginMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table XLOGIN
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long xloginId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table XLOGIN
     *
     * @mbggenerated
     */
    int insert(Xlogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table XLOGIN
     *
     * @mbggenerated
     */
    int insertSelective(Xlogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table XLOGIN
     *
     * @mbggenerated
     */
    Xlogin selectByPrimaryKey(Long xloginId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table XLOGIN
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Xlogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table XLOGIN
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Xlogin record);
}