package com.example.sensi.uploader.model;

import java.util.ArrayList;
import java.util.List;

public class DataStorageModel {

    private String storageName;
    private String text;
    List<FormatTag> tags = new ArrayList<>();

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<FormatTag> getTags() {
        return tags;
    }

    public void setTags(List<FormatTag> tags) {
        this.tags = tags;
    }
}