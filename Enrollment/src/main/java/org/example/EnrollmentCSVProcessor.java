package org.example;

import org.example.model.EnrolleeDetails;

import java.io.*;
import java.util.*;

public class EnrollmentCSVProcessor {
    public static void main(String[] args) {
        String inputFilePath = "enrollees_v2.csv";
        String outputFilePath = "sorted_enrollees.csv";

        List<EnrolleeDetails> enrolleeDetails = readEnrolleesFromCSV(inputFilePath);

        if (enrolleeDetails != null) {
            Collections.sort(enrolleeDetails, Comparator.comparing(EnrolleeDetails::getFullName));
            enrolleeDetails = removeDuplicateRecords(enrolleeDetails);
            if (writeEmployeesToCSV(outputFilePath, enrolleeDetails)) {
                System.out.println("Employees sorted by name and written to " + outputFilePath);
            } else {
                System.out.println("Error writing to CSV file.");
            }
        } else {
            System.out.println("Error reading CSV file.");
        }
    }

    public static List<EnrolleeDetails> readEnrolleesFromCSV(String filePath) {
        List<EnrolleeDetails> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(EnrollmentCSVProcessor.class.getClassLoader().getResourceAsStream(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String id = data[0];
                    String fullName = data[1];
                    int version = Integer.parseInt(data[2]);
                    String company = data[3];
                    employees.add(new EnrolleeDetails(id, fullName, version, company));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return null;
        }

        return employees;
    }

    public static boolean writeEmployeesToCSV(String filePath, List<EnrolleeDetails> enrolleeDetails) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (EnrolleeDetails enrolleeDetail : enrolleeDetails) {
                writer.write(enrolleeDetail.toCSVFormat() + "\n");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<EnrolleeDetails> removeDuplicateRecords(List<EnrolleeDetails> enrolleeDetails) {
        Map<String, EnrolleeDetails> idCompanyMap = new HashMap<>();

        for (EnrolleeDetails enrollee : enrolleeDetails) {
            String key = enrollee.getId() + "_" + enrollee.getCompany();
            if (!idCompanyMap.containsKey(key) || idCompanyMap.get(key).getVersion() < enrollee.getVersion()) {
                idCompanyMap.put(key, enrollee);
            }
        }
        return new ArrayList<>(idCompanyMap.values());
    }
}

