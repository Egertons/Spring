package com.zhang.pojo;

public class jojo {
    String joko;
    int jj;
    boolean ll;

    public jojo() {
    }

    public jojo(String joko, int jj, boolean ll) {
        this.joko = joko;
        this.jj = jj;
        this.ll = ll;
    }

    @Override
    public String toString() {
        return "jojo{" +
                "joko='" + joko + '\'' +
                ", jj=" + jj +
                ", ll=" + ll +
                '}';
    }
}
