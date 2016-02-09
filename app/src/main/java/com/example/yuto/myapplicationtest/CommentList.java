package com.example.yuto.myapplicationtest;

/**
 * Created by yuto on 2016/02/06.
 */
public class CommentList {
    private String STRtaste;
    private String STRtopping;
    private String STRprice;
    private String STRcomment;

    public void setsTaste(String text) { STRtaste = text; }
    public String getsTaste() {
        return STRtaste;
    }

    public void setsTopping(String text) {
        STRtopping = text;
    }
    public String getsTopping() {
        return STRtopping;
    }

    public void setsPrice(String text) {
        STRprice = text;
    }
    public String getsPrice() {
        return STRprice;
    }

    public void setsComment(String text) {
        STRcomment = text;
    }
    public String getsComment() {
        return STRcomment;
    }
}
