package org.example.CustomDataGenerator;

import java.nio.file.Paths;
import java.util.List;

import static org.example.CustomDataGenerator.CustomDataGeneratorService.generateIdsJsonData;
import static org.example.CustomDataGenerator.CustomDataGeneratorService.writeToJsonFile;
import static org.example.GlobalConstants.*;

public class CustomDataGeneratorMain {
    public static void main(String[] args) {
        System.out.println("Custom data generator started!");
        List<String> idsLines = CustomDataGeneratorService.getFileLinesFromPath(Paths.get(publicIdsFilePath));
        List<String> jundaLines = CustomDataGeneratorService.getFileLinesFromPath(Paths.get(publicJundaFilePath));
        List<String> tzaiLines = CustomDataGeneratorService.getFileLinesFromPath(Paths.get(publicTzaiFilePath));

        String jsonOutput = generateIdsJsonData(idsLines, jundaLines, tzaiLines);

        writeToJsonFile(customIdsJsonMapPath, jsonOutput);
        System.out.println("Custom data generator ended!");
    }


}
