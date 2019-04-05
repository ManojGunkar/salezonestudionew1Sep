package com.salesfunnel.apiconnector.presenter;

/**
 * Created by Manoj Kumar on 04-11-2018.
 * Copyright (C) 2018. Global Delight Technologies Pvt. Ltd. All rights reserved.
 */
public class Result<T> {
    private Error mError = null;
    private T mValue;

    public static <T> Result<T> error(int code, String reason) {
        return new Result<>(new Error(code, reason));
    }

    public static <T> Result<T> success(T value) {
        return new Result<>(value);
    }

    public Result(Error e) {
        mError = e;
    }

    public Result(T value) {
        mValue = value;
    }

    public boolean isSuccess() {
        return mError == null;
    }

    public Error getError() {
        return mError;
    }

    public T get() {
        return mValue;
    }

    public static class Error {
        private int code;
        private String reason;

        public Error(int code, String message) {
            this.code = code;
            this.reason = message;
        }

        public int getCode() {
            return code;
        }

        public String getReason() {
            return reason;
        }

    }
}
