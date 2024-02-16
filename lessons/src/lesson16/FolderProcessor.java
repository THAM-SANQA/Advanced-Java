package lesson16;

/**
 * @author thamsanqa 2024
 **/

//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.RecursiveTask;
//
//public class FolderProcessor extends RecursiveTask<List<String>> {
//
//    private static final long serialVersionUID = 1L;
//    //This attribute will store the full path of the folder this task is going to process.
//    private final String path;
//    //This attribute will store the name of the extension of the files this
//    // task is going to look for.
//    private final String extension;
//
//    //Implement the constructor of the class to initialize its attributes
//    public FolderProcessor(String path, String extension) {
//        this.path = path;
//        this.extension = extension;
//    }
//
//    //Implement the compute() method. As you parameterized the RecursiveTask class with the List<String> type,
//    //this method has to return an object of that type.
//    @Override
//    protected List<String> compute() {
//
//        //List to store the names of the files stored in the folder.
//        List<String> list = new ArrayList<String>();
//
//        //FolderProcessor tasks to store the subtasks that are going to process the subfolders stored in the folder
//        List<FolderProcessor> tasks = new ArrayList<FolderProcessor>();
//
//        //Get the content of the folder.
//        File file = new File(path);
//
//        File content[] = file.listFiles();
//        //For each element in the folder, if there is a subfolder, create a new FolderProcessor object
//        //and execute it asynchronously using the fork() method.
//        if (content != null) {
//
//            for (int i = 0; i < content.length; i++) {
//                if (content[i].isDirectory()) {
//                    FolderProcessor task =  new FolderProcessor(content[i].getAbsolutePath(), extension);
//                    task.fork();
//                    tasks.add(task);
//                }
//
//                //Otherwise, compare the extension of the file with the extension you are looking for using the checkFile() method
//                //and, if they are equal, store the full path of the file in the list of strings declared earlier.
//                else {
//                    if (checkFile(content[i].getName())) {
//                        list.add(content[i].getAbsolutePath());
//                    }
//                }
//            }
//        }
//
//        //If the list of the FolderProcessor subtasks has more than 50 elements,
//        //write a message to the console to indicate this circumstance.
//        if (tasks.size() > 50) {
//            System.out.printf("%s: %d tasks ran.\n", file.getAbsolutePath(),
//                    tasks.size());
//        }
//
//        //add to the list of files the results returned by the subtasks launched by this task.
//        addResultsFromTasks(list, tasks);
//        return list;
//    }
//
//    //For each task stored in the list of tasks, call the join() method that
//    // will wait for its finalization and then will return the result of the task.
//    //Add that result to the list of strings using the addAll() method.
//    private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks) {
//
//        for (FolderProcessor item : tasks) {
//            list.addAll(item.join());
//        }
//    }
//
//    //This method compares if the name of a file passed as a parameter ends with the extension you are looking for.
//    private boolean checkFile(String name) {
//
//        return name.endsWith(extension);
//    }
//}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> {

    private static final long serialVersionUID = 1L;

    private String path; // Folder path
    private String extension; // File extension to search for

    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    protected List<String> compute() {
        List<String> list = new ArrayList<>();
        List<FolderProcessor> tasks = new ArrayList<>();

        // Get all files and folders in the current path
        File file = new File(path);
        File[] content = file.listFiles();

        if (content != null) {
            // Process each file or folder
            for (File element : content) {
                if (element.isDirectory()) {
                    // If it's a directory, create a new FolderProcessor task and fork it
                    FolderProcessor task = new FolderProcessor(element.getAbsolutePath(), extension);
                    task.fork();
                    tasks.add(task);
                } else {
                    // If it's a file and has the desired extension, read and print its contents
                    if (checkFileExtension(element.getName())) {
                        list.add(readFileContents(element));
                    }
                }
            }
        }

        // Wait for all ForkJoinTasks to complete and merge their results
        for (FolderProcessor task : tasks) {
            list.addAll(task.join());
        }

        return list;
    }

    // Method to check if a file has the desired extension
    private boolean checkFileExtension(String fileName) {
        return fileName.endsWith(extension);
    }

    // Method to read and print the contents of a file
    private String readFileContents(File file) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n"); // Append each line to the StringBuilder
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Print the contents of the file
        System.out.printf("File: %s\n%s\n", file.getAbsolutePath(), content.toString());
        return content.toString(); // Return the contents as a String
    }
}
