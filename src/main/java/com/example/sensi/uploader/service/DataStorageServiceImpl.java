package com.example.sensi.uploader.service;

import com.example.sensi.uploader.constant.DataStorageConstant;
import com.example.sensi.uploader.model.DataStorageModel;
import com.example.sensi.uploader.model.FormatTag;
import com.example.sensi.uploader.repository.DataStorageRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class DataStorageServiceImpl implements DataStorageService {

    private DataStorageRepository dataStorageRepository;

    public DataStorageServiceImpl(DataStorageRepository dataStorageRepository) {
        this.dataStorageRepository = dataStorageRepository;
    }

    @Override
    public void storeData(String storageName, String data) {
        dataStorageRepository.storeData(storageName, data);
    }

    @Override
    public String formatText(DataStorageModel dataStorageModel) {
        StringBuilder formattedTextBuilder = new StringBuilder(dataStorageModel.getText());
        Optional.ofNullable(dataStorageModel.getTags())
                .orElse(Collections.emptyList())
                .forEach(formatTag -> appendTag(formattedTextBuilder, formatTag));
        return formattedTextBuilder.toString();
    }

    private void appendTag(StringBuilder formattedTextBuilder, FormatTag formatTag) {
        formattedTextBuilder.insert(0, buildStartTag(formatTag));
        formattedTextBuilder.append(buildEndTag(formatTag));
    }

    private String buildStartTag(FormatTag formatTag) {
        return new StringBuilder()
                .append(DataStorageConstant.HTML_TAG_PREFIX)
                .append(formatTag.getTag())
                .append(DataStorageConstant.HTML_TAG_SUFFIX)
                .toString();
    }

    private String buildEndTag(FormatTag formatTag) {
        return new StringBuilder()
                .append(DataStorageConstant.HTML_END_TAG_PREFX)
                .append(formatTag.getTag())
                .append(DataStorageConstant.HTML_TAG_SUFFIX)
                .toString();
    }
}
