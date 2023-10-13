/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.Comparator;
import model.FileData;

/**
 *
 * @author GoldCandy
 */
public class Library implements Comparator<FileData> {

    @Override
    public int compare(FileData o1, FileData o2) {
        if (o1.getMoney() > o2.getMoney()) {
            return 1;
        }
        if (o1.getMoney() < o2.getMoney()) {
            return -1;
        }
        return 0;
    }
}
