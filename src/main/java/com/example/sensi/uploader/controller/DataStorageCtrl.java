package com.example.sensi.uploader.controller;

import com.example.sensi.uploader.constant.DataStorageConstant;
import com.example.sensi.uploader.model.DataStorageModel;
import com.example.sensi.uploader.service.DataStorageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataStorageCtrl {

    private DataStorageService dataStorageService;

    public DataStorageCtrl(DataStorageService dataStorageService) {
        this.dataStorageService = dataStorageService;
    }

    @GetMapping({"/store"})
    public ModelAndView getFileUploadPage() {
        return new ModelAndView(DataStorageConstant.DATA_STORAGE_TEMPLATE, DataStorageConstant.DATA_STORAGE_MODEL_NAME, new DataStorageModel());
    }

    @PostMapping({"/store"})
    public ModelAndView uploadFile(DataStorageModel dataStorageModel) {
        String formattedText = dataStorageService.formatText(dataStorageModel);
        dataStorageService.storeData(dataStorageModel.getStorageName(), formattedText);
        return new ModelAndView(DataStorageConstant.DATA_STORAGE_TEMPLATE)
                .addObject(DataStorageConstant.MESSAGE_PARAM, buildConfirmMessage(dataStorageModel));
    }

    private String buildConfirmMessage(DataStorageModel dataStorageModel) {
        return String.format("Text data has been stored in %s", dataStorageModel.getStorageName());
    }

}