package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonRetunType;
import com.miaoshaproject.service.model.UserModel;
import com.miaoshaproject.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@Controller("user")
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    @ResponseBody
    @CrossOrigin(allowCredentials = "true",allowedHeaders = "true")
    public CommonRetunType register(@RequestParam(name = "telephone")String telephone,
                                    @RequestParam(name = "otpCode")String otpCode,
                                    @RequestParam(name = "name")String name,
                                    @RequestParam(name = "gender")Integer gender,
                                    @RequestParam(name = "age")Integer age,
                                    @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //验证手机号和对应的otpcode相符合
        String inSessionOtpCode = (String) this.httpServletRequest.getSession().getAttribute(telephone);

        if (!com.alibaba.druid.util.StringUtils.equals(otpCode,inSessionOtpCode)){
            throw new BusinessException(EmBusinessError.PARAMETER_VLIDATION_ERROR);
        }

        //用户注册流程
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setGender(new Byte(String.valueOf(gender.intValue())));
        userModel.setAge(age);
        userModel.setTelephone(telephone);
        userModel.setEncrptPassword(this.EncodeByMD5(password));
        userService.register(userModel);

        return CommonRetunType.create(null);
    }

    private String EncodeByMD5(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //确定加密方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64En = new BASE64Encoder();
        //加密字符串
        String newstr = base64En.encode(md5.digest(str.getBytes("utf-8")));
        return  newstr;
    }

    @RequestMapping(value = "/getotp", method = {RequestMethod.POST})
    @ResponseBody
    @CrossOrigin(allowCredentials = "true",allowedHeaders = "true")
    public CommonRetunType getOTP(@RequestParam(name="telephone")String telephone){
        //按照一定规则生成OTP验证码
        Random random = new Random();
        int randonInt = random.nextInt(99999);
        if (randonInt<10000){
            randonInt += 10000;
        }
        String otpCode = String.valueOf(randonInt);
        //将OTP验证码同用户的手机号关联,使用httpsession的方式绑定用户的手机号与OTPCode
        this.httpServletRequest.getSession().setAttribute(telephone,otpCode);

        //将OTP验证码通过短信通道发送给用户,省略
        System.out.println("telephone = " + telephone + "& OTPCode = " + otpCode);

        return CommonRetunType.create(null);
    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonRetunType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        //调用service服务获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);

        //若获取的对应用户信息不存在
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

        //将核心领域模型用户转化为可供UI使用的viewobject
        UserVO userVO = convertFromModel(userModel);
        return CommonRetunType.create(userVO);
    }

    private UserVO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);

        return userVO;
    }


}
