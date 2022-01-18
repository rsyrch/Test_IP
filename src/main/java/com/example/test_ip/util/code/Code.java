package com.example.test_ip.util.code;

public enum Code {

    PROGRAM_ERROR(0000, "异常抛出"),
    DELETE_ERROR(1004, "删除失败"),
    MODIFY_ERROR(1003, "修改失败"),
    ADD_ERROR(1002, "添加失败"),
    GET_MSG_ERROR(1001, "获取消息异常");


    private int code;
    private String desc;

    Code(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Code{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
