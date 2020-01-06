package com.miaoshaproject.controller;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonRetunType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    public static final String CONTENT_TYPE_FORMED = "application/x-www-form-urlencoded";

    /**
     * 定义exceptionhandler解决未被controller层吸收的exception
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex) {
        Map<String,Object> responseData = new HashMap<>();

        if (ex instanceof BusinessException){
            BusinessException businessException = (BusinessException)ex;
            responseData.put("errCode",businessException.getErrCode());
            responseData.put("errMsg",businessException.getErrMsg());
        }else {
            System.out.println(ex.getLocalizedMessage()+ex.getMessage());
            responseData.put("errCode", EmBusinessError.SYSTEM_ERROR.getErrCode());
            responseData.put("errMsg",EmBusinessError.SYSTEM_ERROR.getErrMsg());
        }

        return CommonRetunType.create("fail",responseData);

    }
}
