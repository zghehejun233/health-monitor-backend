package cn.sduonline.healthmonitorbackend.util;

import cn.sduonline.healthmonitorbackend.constants.ResultCode;

import java.util.List;

/**
 * Created By GuoChao on 2022/7/17 23:00
 */

public class Result<T> {

    //返回信息码
    private String code;
    //返回信息
    private String msg;
    //返回数据
    T data;
    List<T> datas;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }


    //成功，只返回成功码和信息
    public Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS.code);
        result.setMsg(ResultCode.SUCCESS.msg);
        return result;
    }

    //成功，返回成功码、信息和数据
    public Result<T> success(T data) {
        Result<T> result = new Result();
        result.setCode(ResultCode.SUCCESS.code);
        result.setMsg(ResultCode.SUCCESS.msg);
        result.setData(data);
        return result;
    }

    public Result<T> success(List<T> datas) {
        Result<T> result = new Result();
        result.setCode(ResultCode.SUCCESS.code);
        result.setMsg(ResultCode.SUCCESS.msg);
        result.setDatas(datas);
        return result;
    }

    //失败，返回自己定义的信息码和信息
    public Result<T> error() {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.ERROR.code);
        result.setMsg(ResultCode.ERROR.msg);
        return result;
    }

    //失败，返回controller层传过来信息码和信息
    public Result<T> error(String code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
