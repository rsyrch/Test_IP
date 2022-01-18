package com.example.test_ip.util;

import com.example.test_ip.util.status.Status;

public class ResultUtil {

    public static Result success(){
        Result result = new Result();
        result.setStatus(Status.SUCCESS.getDesc());
        result.setCode(Status.SUCCESS.getCode());
        result.setMessage("");
        result.setData(null);
        return result;
    }

    public static Result success(Object object){
        Result result = new Result();
        result.setStatus(Status.SUCCESS.getDesc());
        result.setCode(Status.SUCCESS.getCode());
        result.setMessage("");
        result.setData(object);
        return result;
    }

    public static Result error(Integer code, String message){
        Result result = new Result();
        result.setStatus(Status.ERROR.getDesc());
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static Result error(String message){
        Result result = new Result();
        result.setStatus(Status.ERROR.getDesc());
        result.setCode(Status.ERROR.getCode());
        result.setMessage(message);
        return result;
    }
}
