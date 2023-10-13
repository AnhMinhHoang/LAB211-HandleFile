/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.Validation;
import data_access.FileHandleDao;
import java.util.List;
import model.FileData;

/**
 *
 * @author GoldCandy
 */
public class FileHandleRepository implements IFileHandleRepository {

    protected Validation valid = new Validation();

    @Override
    public void personInfo(List<FileData> data) {
        String path = valid.inputString("Enter path");
        FileHandleDao.Instance().personInfo(path, data);
    }

    @Override
    public void copyText() {
        FileHandleDao.Instance().copyText();
    }
}
