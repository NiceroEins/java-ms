package com.miaoshaproject.dataobject;

public class UserPasswordDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column j_user_password.id
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column j_user_password.user_id
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column j_user_password.encrpt_password
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    private String encrptPassword;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column j_user_password.id
     *
     * @return the value of j_user_password.id
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column j_user_password.id
     *
     * @param id the value for j_user_password.id
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column j_user_password.user_id
     *
     * @return the value of j_user_password.user_id
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column j_user_password.user_id
     *
     * @param userId the value for j_user_password.user_id
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column j_user_password.encrpt_password
     *
     * @return the value of j_user_password.encrpt_password
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    public String getEncrptPassword() {
        return encrptPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column j_user_password.encrpt_password
     *
     * @param encrptPassword the value for j_user_password.encrpt_password
     *
     * @mbg.generated Thu Dec 12 14:42:58 CST 2019
     */
    public void setEncrptPassword(String encrptPassword) {
        this.encrptPassword = encrptPassword == null ? null : encrptPassword.trim();
    }
}