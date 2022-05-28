package edu.zju.se.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

  private int code; // 200是正常，非200表示异常
  private String msg;
  private Object data;

  public static Result success() {
    return success(200, "success", null);
  }

  public static Result success(Object data) {
    return success(200, "success", data);
  }

  public static Result success(String msg, Object data) {
    return success(200, msg, data);
  }

  public static Result success(int code, String msg, Object data) {
    Result r = new Result();
    r.setCode(code);
    r.setMsg(msg);
    r.setData(data);
    return r;
  }

  public static Result fail() {
    return fail(400, "failed", null);
  }

  public static Result fail(String msg) {
    return fail(400, msg, null);
  }

  public static Result fail(Object data) {
    return fail(400, "failed", data);
  }

  public static Result fail(String msg, Object data) {
    return fail(400, msg, data);
  }

  public static Result fail(int code, String msg, Object data) {
    Result r = new Result();
    r.setCode(code);
    r.setMsg(msg);
    r.setData(data);
    return r;
  }

}