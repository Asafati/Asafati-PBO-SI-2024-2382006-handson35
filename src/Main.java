import java.util.Scanner;

public class Main {
    public static String[] todos = new String[3];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("BEFORE EDIT");
        addTodoList("Mewarnai");
        addTodoList("Membaca");
        addTodoList("Bersepeda");
        addTodoList("Berkhotbah");
        showTodoList();
        removeTodoList(3); // Perbaikan di sini
        System.out.println("AFTER DELETE");
        showTodoList();
    }

    public static void showTodoList() {
        System.out.println("TODO LIST");
        for (int i = 0; i < todos.length; i++) {
            String todo = todos[i];
            if (todo != null) {
                System.out.println((i + 1) + ". " + todo);
            }
        }
    }

    public static void addTodoList(String todo) {
        resizeIfFull(); // Perbaikan di sini
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                todos[i] = todo;
                break;
            }
        }
    }

    public static void resizeIfFull() {
        // cek apakah todos penuh
        Boolean isFull;
        isFull = isArrayFull();

        // jika penuh, resize array
        if (isFull) {
            resizeArrayToTwoTimeBigger();
        }
    }

    public static Boolean isArrayFull() {
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                return false;
            }
        }
        return true;
    }

    public static void resizeArrayToTwoTimeBigger() {
        String[] temp = todos;
        todos = new String[todos.length * 2];
        for (int i = 0; i < temp.length; i++) { // Perbaikan di sini
            todos[i] = temp[i];
        }
    }

    public static boolean removeTodoList(Integer number) {
        if (isSelectedTodoNotValid(number)) {
            return false;
        }
        for (int i = number - 1; i < todos.length; i++) {
            if (i == (todos.length - 1)) {
                todos[i] = null;
            } else {
                // replace dengan elemen berikutnya
                todos[i] = todos[i + 1];
            }
        }
        return true;
    }

    public static boolean isSelectedTodoNotValid(Integer number) {
        // cek jika number kurang dari 1 atau lebih dari panjang array
        if (number < 1 || number > todos.length || todos[number - 1] == null) { // Perbaikan di sini
            return true;
        }
        return false;
    }

    public static boolean editTodoList(Integer number, String newTodo) {
        if (isSelectedTodoNotValid(number)) {
            return false;
        }
        todos[number - 1] = newTodo;
        return true;
    }
}