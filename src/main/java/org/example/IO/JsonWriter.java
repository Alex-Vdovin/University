package org.example.IO;

import org.example.Model.FullInfo;
import org.example.UtilityClasses.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {
    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    private JsonWriter() {

    }

    public static void writeJsonReq(FullInfo fullInfo) {
        logger.log(Level.INFO, "JSON writing started");
        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.log(Level.INFO, "Папка успешно создана");
        } catch (IOException ioEx) {
            logger.log(Level.FINE, "Папка уже существует", ioEx);
        }
        writeStudents(fullInfo);
        writeUniversities(fullInfo);
        writeStatistics(fullInfo);
        logger.log(Level.INFO, "JSON writing finished successfully");
    }

    private static void writeStudents(FullInfo fullInfo) {
        String studentsJson = JsonUtil.writeListToJson(fullInfo.getStudentList());
        try (FileOutputStream fos = new FileOutputStream("jsonReqs/students" + fullInfo.getProcessDate().getTime() + ".json");) {
            fos.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ioEx) {
            logger.log(Level.SEVERE, "Student to JSON writing failed", ioEx);
        }

    }

    private static void writeUniversities(FullInfo fullInfo) {
        String universitiesToJson = JsonUtil.writeListToJson(fullInfo.getUniversityList());
        try (FileOutputStream fos = new FileOutputStream("jsonReqs/universities" + fullInfo.getProcessDate().getTime() + ".json");) {
            fos.write(universitiesToJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ioEx) {
            logger.log(Level.SEVERE, "Universities to JSON writing failed");
        }
    }

    private static void writeStatistics(FullInfo fullInfo) {
        String statisticsToJson = JsonUtil.writeListToJson(fullInfo.getStatisticsList());
        try (FileOutputStream fos = new FileOutputStream("jsonReqs/statistics" + fullInfo.getProcessDate().getTime() + ".json")) {
            fos.write(statisticsToJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ioEx) {
            logger.log(Level.SEVERE, "Statistics to JSON writing failed");
        }
    }
}
