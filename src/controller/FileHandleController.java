/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.FileData;
import repository.FileHandleRepository;
import view.Menu;

/**
 *
 * @author GoldCandy
 */
public class FileHandleController extends Menu {

    protected static String[] mc = {"Find person info",
        "Copy Text to new file", "Exit"};
    protected FileHandleRepository repo;
    protected FileData data;

    public FileHandleController() {
        super("========== File Processing =========", mc);
        repo = new FileHandleRepository();
        data = new FileData();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1: {
                System.out.println("--------- Person info ---------");
                repo.personInfo(data.getList());
                break;
            }
            case 2: {
                System.out.println("------------- Copy text --------------");
                repo.copyText();
                break;
            }
            case 3: {
                System.out.println("EXIT...");
                System.exit(0);
            }
            default: {
                System.out.println("No such choice");
            }
        }
    }
}
