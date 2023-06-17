package org.example.CustomDataGenerator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.example.CustomDataGenerator.CustomDataGeneratorService.*;
import static org.example.GlobalConstants.customIdsJsonMapPath;
import static org.example.GlobalConstants.publicIdsFilePath;

public class CustomDataGeneratorMain {
    public static void main(String[] args) {
        System.out.println("Custom data generator started!");
        Path path = Paths.get(publicIdsFilePath);
        List<String> lines = getFileLinesFromPath(path);
        String jsonOutput = generateIdsJsonData(lines);

        writeToJsonFile(customIdsJsonMapPath, jsonOutput);
        System.out.println("Custom data generator ended!");
    }


}
