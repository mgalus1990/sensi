package com.example.sensi.uploader.repository;

import com.example.sensi.uploader.exception.DataStorageException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Repository
public class FileDataStorageRepository implements DataStorageRepository {

    private static final Logger logger = Logger.getLogger(DataStorageRepository.class);

    @Override
    public synchronized void storeData(String storageName, String data) {

        File storageFile = new File(storageName);
        ensureFileExists(storageName, storageFile);
        writeToFile(storageFile, data);

    }

    private void ensureFileExists(String storageName, File storageFile) {
        if (!storageFile.exists()) {
            try {
                storageFile.createNewFile();
            } catch (IOException exception) {
                logger.error("there was an error while trying to create file", exception);
                throw new DataStorageException(String.format("Could not save data to storage %s", storageName));
            }
        }
    }

    private void writeToFile(File storageFile, String data) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(storageFile));
            writer.write(data);
        } catch (IOException exception) {
            logger.error("there was an error while trying to create file writer", exception);
            throw new DataStorageException(String.format("Could not save data to storage %s", storageFile.getName()));
        } finally {
            try {
                writer.close();
            } catch (Exception e) {}
        }
    }

}
