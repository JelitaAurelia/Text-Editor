package semester3;

import java.util.ArrayList;
import java.util.Scanner;

public class TextEditor {
    private ArrayList<String> history;
    private int currentVersion;

    public TextEditor() {
        history = new ArrayList<>();
        currentVersion = -1;
    }

    public void show() {
        if (currentVersion == -1) {
            System.out.println("Teks kosong.");
        } else {
            System.out.println("Isi Teks Editor:");
            System.out.println(history.get(currentVersion));
        }
    }

    public void write(String text) {
        if (currentVersion < history.size() - 1) {
            history.subList(currentVersion + 1, history.size()).clear();
        }
        history.add(text);
        currentVersion++;
        System.out.println("Teks ditambahkan: " + text);
    }

    public void undo() {
        if (currentVersion <= 0) {
            System.out.println("Tidak ada versi sebelumnya untuk dikembalikan.");
        } else {
            currentVersion--;
            System.out.println("Undo berhasil. Kembali ke versi sebelumnya.");
        }
    }

    public void redo() {
        if (currentVersion >= history.size() - 1) {
            System.out.println("Tidak ada versi yang lebih baru untuk dipulihkan.");
        } else {
            currentVersion++; 
            System.out.println("Redo berhasil. Kembali ke versi yang lebih baru.");
        }
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Selamat datang di simulasi Text Editor.");
        do {
            System.out.println("\nMasukkan perintah (show/write/undo/redo/exit): ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "show":
                    textEditor.show();
                    break;
                case "write":
                    System.out.print("Masukkan teks: ");
                    String text = scanner.nextLine();
                    textEditor.write(text);
                    break;
                case "undo":
                    textEditor.undo();
                    break;
                case "redo":
                    textEditor.redo();
                    break;
                case "exit":
                    System.out.println("Keluar dari aplikasi.");
                    break;
                default:
                    System.out.println("Perintah tidak dikenali. Silakan coba lagi.");
                    break;
            }
        } while (!command.equalsIgnoreCase("exit"));

        scanner.close();
    }
}
