package org.example.CustomDataGenerators;

import java.nio.file.Paths;
import java.util.List;

import static org.example.CustomDataGenerators.CustomIdsJsonMapGeneratorService.generateIdsJsonData;
import static org.example.CustomDataGenerators.CustomIdsJsonMapGeneratorService.writeToJsonFile;
import static org.example.GlobalConstants.*;

public class CustomIdsJsonMapGeneratorMain {
    public static void main(String[] args) {
        System.out.println("Custom data generator started!");
        List<String> idsLines = CustomIdsJsonMapGeneratorService.getFileLinesFromPath(Paths.get(publicIdsFilePath));
        List<String> jundaLines = CustomIdsJsonMapGeneratorService.getFileLinesFromPath(Paths.get(publicJundaFilePath));
        List<String> tzaiLines = CustomIdsJsonMapGeneratorService.getFileLinesFromPath(Paths.get(publicTzaiFilePath));

        String jsonOutput = generateIdsJsonData(idsLines, jundaLines, tzaiLines);

        writeToJsonFile(customIdsJsonMapPath, jsonOutput);
        System.out.println("Custom data generator ended!");
    }


}
