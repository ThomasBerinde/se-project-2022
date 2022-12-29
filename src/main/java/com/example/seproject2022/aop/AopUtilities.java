package com.example.seproject2022.aop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AopUtilities {

        private void logMessage(BufferedWriter bufferedWriter,
                                String loggingMessage) {
                try {
                        bufferedWriter.append(loggingMessage)
                                      .append("\n");
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

        public void writeToFile(String fileName,
                                String loggingMessage) {
                try {
                        File aopFolder = new File("src/main/resources/aop");
                        if (!aopFolder.exists()) {
                                if (!aopFolder.mkdir()) {
                                        throw new RuntimeException("Failed to create \"aop\" folder");
                                }
                        }
                        File loggingFile = new File("src/main/resources/aop/" + fileName);
                        if (!loggingFile.exists()) {
                                if (!loggingFile.createNewFile()) {
                                        throw new RuntimeException(
                                                String.format("Failed to create \"%s\" file", fileName));
                                }
                        }
                        BufferedWriter bufferedWriter = new BufferedWriter(
                                new FileWriter(loggingFile, true)); // "true" means you append to the file
                        logMessage(bufferedWriter, loggingMessage);
                        bufferedWriter.close();
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }
}
