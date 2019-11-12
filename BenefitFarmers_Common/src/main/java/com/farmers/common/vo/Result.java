package com.farmers.common.vo;

import lombok.Data;


@Data
public class Result {
    private int code;
    private String msg;
    private Object data;

    public static Result setOK(Object data){
        Result r=new Result();
        r.setCode(200);
        r.setMsg("OK");
        r.setData(data);
        return r;
    }


    public static Result setERROR(){
        Result r=new Result();
        r.setCode(400);
        r.setMsg("ERROR");
        r.setData(null);
        return r;
    }

    public static Result setResult(boolean isSuccess,Object object){
        if (isSuccess){
            return setOK(object);
        }else {
            return setERROR();
        }

    }
}

