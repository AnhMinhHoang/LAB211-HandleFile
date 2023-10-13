/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access;

import common.Library;
import common.Validation;
import content.Prompt;
import java.util.Collections;
import java.util.List;
import model.FileData;

/**
 *
 * @author GoldCandy
 */
public class FileHandleDao {

    private static FileHandleDao instance = null;
    private static Validation valid = new Validation();

    public static FileHandleDao Instance() {
        if (instance == null) {
            synchronized (FileHandleDao.class) {
                if (instance == null) {
                    instance = new FileHandleDao();
                }
            }
        }
        return instance;
    }

    public String display(FileData data) {
        return String.format("%-20s%-20s%.1f", data.getName(),
                data.getAddress(), data.getMoney());
    }

    public void personInfo(String path, List<FileData> data) {
        data = new FileData().readFromFile(path);
        if (data.isEmpty()) {
            System.out.println(Prompt.fileNotFound);
            return;
        }
        Collections.sort(data, new Library());
        double salary = valid.inputDouble("Enter Money");
        String smax = "";
        String smin = "";
        double dmax = Double.MIN_VALUE;
        double dmin = Double.MAX_VALUE;
        int count = 0;
        System.out.printf("%-20s%-20s%s\n", "Name",
                "Address", "Money");
        for (FileData d : data) {
            if (d.getMoney() >= salary) {
                count++;
                System.out.println(display(d));
                if (dmax < d.getMoney()) {
                    dmax = d.getMoney();
                    smax = d.getName();
                }
                if (dmin > d.getMoney()) {
                    dmin = d.getMoney();
                    smin = d.getName();
                }
            }
        }
        if (count == 0) {
            System.out.println("Not found!");
            return;
        }
        if (!smax.isEmpty()) {
            System.out.println("Max: " + smax);
        }
        if (!smin.isEmpty()) {
            System.out.println("Min: " + smin);
        }
    }

    public void copyText() {
        List<FileData> new_data;
        FileData data = new FileData();
        String source = valid.inputString("Enter Source");
        new_data = data.readFromFile(source);
        if (new_data.isEmpty()) {
            System.out.println(Prompt.fileNotFound);
            return;
        }
        String filename = valid.inputString("Enter new file name");
        if (!data.writeToFile(filename, new_data)) {
            System.out.println(Prompt.pathNotFound);
            return;
        }
        System.out.println("Successful");
    }
}
