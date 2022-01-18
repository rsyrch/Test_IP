package com.example.test_ip.util.status;

public enum  Status {
    SUCCESS(0, "success"),
    ERROR(1, "error");

    private int code;
    private String desc;

    Status(int code, String desc) {
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
        return "Status{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
