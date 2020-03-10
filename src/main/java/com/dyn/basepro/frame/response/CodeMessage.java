package com.dyn.basepro.frame.response;

import lombok.Data;

@Data
public class CodeMessage {

    private String code;

    private String message;

    private CodeMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CodeMessage of(String code, String message) {
        return new CodeMessage(code, message);
    }

}
