package com.zibo.utils;

import lombok.Data;

@Data
public class _Pair {
    private int begin;
    private int end;

    public _Pair() {}

    public _Pair(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
}