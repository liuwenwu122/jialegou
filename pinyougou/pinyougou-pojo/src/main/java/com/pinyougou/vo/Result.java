package com.pinyougou.vo;

public class Result {

    private boolean success;
    private String messages;

    public Result() {
    }

    public Result(boolean success, String messages) {
        this.success = success;
        this.messages = messages;
    }

    public static Result ok(String messages){
        return new Result(true,messages);
    }

    public static Result fail(String messages){
        return new Result(false,messages);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
