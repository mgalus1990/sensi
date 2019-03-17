package com.example.sensi.uploader.model;

public enum FormatTag {

    BOLD("b"),
    UNDERSCORE("u"),
    ITALIC("i"),
    SUBSCRIPTED("sub"),
    SUPERSCRIPTED("sup");

    FormatTag(String tag) {
        this.tag = tag;
    }

    private String tag;

    public String getTag() {
        return tag;
    }
}
