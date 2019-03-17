package com.example.sensi.uploader.service;

import com.example.sensi.uploader.model.DataStorageModel;

public interface DataStorageService {
    void storeData(String storageName, String data);
    String formatText(DataStorageModel dataStorageModel);
}
