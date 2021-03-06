package com.miaoshaproject.dao;

import com.miaoshaproject.dataobject.UserPasswordDO;

public interface UserPasswordDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table j_user_password
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table j_user_password
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    int insert(UserPasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table j_user_password
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    int insertSelective(UserPasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table j_user_password
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    UserPasswordDO selectByPrimaryKey(Integer id);

    UserPasswordDO selectByUserId(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table j_user_password
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    int updateByPrimaryKeySelective(UserPasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table j_user_password
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    int updateByPrimaryKey(UserPasswordDO record);
}