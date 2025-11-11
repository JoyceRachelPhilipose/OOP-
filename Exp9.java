import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("\n=== File Menu ===");
            System.out.println("1. Create a new file");
            System.out.println("2. Rename a file");
            System.out.println("3. Delete a file");
            System.out.println("4. Create a directory");
            System.out.println("5. Find absolute path of a file");
            System.out.println("6. Display all file names of a directory");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: createNewFile(); break;
                case 2: renameFile(); break;
                case 3: deleteFile(); break;
                case 4: createDirectory(); break;
                case 5: absolutePath(); break;
                case 6: listDirectoryFiles(); break;
                case 7: System.out.println("Exiting."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 7);

        sc.close();
    }

    private static void createNewFile() {
        System.out.print("Enter path/name of new file: ");
        String fname = sc.nextLine();
        File f = new File(fname);
        try {
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
            } else {
                System.out.println("File already exists: " + f.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    private static void renameFile() {
        System.out.print("Enter existing file path/name: ");
        String oldName = sc.nextLine();
        System.out.print("Enter new file path/name: ");
        String newName = sc.nextLine();
        File oldFile = new File(oldName);
        File newFile = new File(newName);
        if (!oldFile.exists()) {
            System.out.println("Original file does not exist.");
            return;
        }
        if (newFile.exists()) {
            System.out.println("Destination file already exists.");
            return;
        }
        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed to: " + newFile.getName());
        } else {
            System.out.println("Failed to rename file.");
        }
    }

    private static void deleteFile() {
        System.out.print("Enter file path/name to delete: ");
        String fname = sc.nextLine();
        File f = new File(fname);
        if (!f.exists()) {
            System.out.println("File does not exist.");
            return;
        }
        if (f.delete()) {
            System.out.println("Deleted file: " + fname);
        } else {
            System.out.println("Failed to delete file.");
        }
    }

    private static void createDirectory() {
        System.out.print("Enter directory path/name to create: ");
        String dname = sc.nextLine();
        File d = new File(dname);
        if (d.exists()) {
            System.out.println("Directory already exists: " + d.getAbsolutePath());
        } else {
            if (d.mkdirs()) {
                System.out.println("Directory created: " + d.getAbsolutePath());
            } else {
                System.out.println("Failed to create directory.");
            }
        }
    }

    private static void absolutePath() {
        System.out.print("Enter file (or dir) path/name: ");
        String fname = sc.nextLine();
        File f = new File(fname);
        System.out.println("Absolute path: " + f.getAbsolutePath());
    }

    private static void listDirectoryFiles() {
        System.out.print("Enter directory path: ");
        String dpath = sc.nextLine();
        File d = new File(dpath);
        if (!d.exists() || !d.isDirectory()) {
            System.out.println("Not a valid directory.");
            return;
        }
        String[] names = d.list();
        if (names == null || names.length == 0) {
            System.out.println("Directory is empty.");
        } else {
            System.out.println("Files/directories inside " + d.getAbsolutePath() + ":");
            for (String name : names) {
                System.out.println(name);
            }
        }
    }
}
