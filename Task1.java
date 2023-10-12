package hw6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Task1 {
    // вместо MAP для хранения дальнейших характеристик
    public static Computer compFiltr = new Computer("any", 0, 0, "any", "any");

    public static void main(String[] args) {
        Set<Computer> computers = new HashSet<>();

        setCompList(computers);
        filter(computers);

    }

    // задаем лист компьютеров (пока вручную)
    static Set<Computer> setCompList(Set<Computer> computers) {
        computers.add(new Computer("HP", 16, 2, "windows", "black"));
        computers.add(new Computer("Asus", 8, 2, "linux", "silver"));
        computers.add(new Computer("HP", 8, 1, "windows", "black"));
        computers.add(new Computer("Lenovo", 64, 2, "windows", "red"));
        computers.add(new Computer("Asus", 32, 2, "linux", "black"));
        computers.add(new Computer("Lenovo", 8, 3, "windows", "white"));
        computers.add(new Computer("HP", 8, 1, "linux", "black"));
        computers.add(new Computer("Lenovo", 32, 2, "windows", "black"));
        computers.add(new Computer("HP", 8, 1, "windows", "black"));
        computers.add(new Computer("Asus", 16, 1, "linux", "silver"));
        computers.add(new Computer("HP", 8, 2, "windows", "white"));
        computers.add(new Computer("Lenovo", 8, 1, "linux", "black"));
        computers.add(new Computer("Lenovo", 32, 3, "windows", "black"));
        computers.add(new Computer("HP", 16, 1, "linux", "silver"));
        computers.add(new Computer("Asus", 64, 1, "linux", "black"));
        return computers;
    }

    static void filter(Set<Computer> computers) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Бренд");
        System.out.println("2 - ОЗУ");
        System.out.println("3 - Объем ЖД");
        System.out.println("4 - Опреационная система");
        System.out.println("5 - Цвет");
        System.out.println("Введите цифру или цифры через пробел, соответствующую необходимому критерию:");
        String[] input = (scanner.nextLine()).split(" ");

        boolean compExist = true;
        boolean correctInput = true;

        for (int i = 0; i < input.length; i++) {
            System.out.println();

            switch (input[i]) {
                case "1":
                    System.out.println("Введите бренд: (HP, Asus, Lenovo)");
                    String temp1 = scanner.nextLine();
                    if (Arrays.asList("HP", "Asus", "Lenovo").contains(temp1)) {
                        compFiltr.setBrand(temp1);
                    } else {
                        compFiltr.setBrand(temp1);
                        compExist = false;
                    }
                    break;

                case "2":
                    System.out.println("Введите минимальное ОЗУ: (8, 16, 32, 64)");
                    int temp2 = Integer.parseInt(scanner.nextLine());
                    if (Arrays.asList(8, 16, 32, 64).contains(temp2)) {
                        compFiltr.setRam(temp2);
                    } else {
                        compFiltr.setRam(temp2);
                        compExist = false;
                    }
                    break;

                case "3":
                    System.out.println("Введите минимальный объем ЖД: (1, 2, 3)");
                    int temp3 = Integer.parseInt(scanner.nextLine());
                    if (Arrays.asList(1, 2, 3).contains(temp3)) {
                        compFiltr.setHdd(temp3);
                    } else {
                        compFiltr.setHdd(temp3);
                        compExist = false;
                    }
                    break;

                case "4":
                    System.out.println("Введите опреационную систему: (windows, linux)");
                    String temp4 = scanner.nextLine();
                    if (Arrays.asList("windows", "linux").contains(temp4)) {
                        compFiltr.setOs(temp4);
                    } else {
                        compFiltr.setOs(temp4);
                        compExist = false;
                    }
                    break;

                case "5":
                    System.out.println("Введите цвет: (black, silver, red, white)");
                    String temp5 = scanner.nextLine();
                    if (Arrays.asList("black", "silver", "red", "white").contains(temp5)) {
                        compFiltr.setColor(temp5);
                    } else {
                        compFiltr.setColor(temp5);
                        compExist = false;
                    }
                    break;

                default:
                    System.out.println("Вы ввели неверные цифры");
                    compExist = false;
                    correctInput = false;

            }
        }

        if (correctInput) {
            System.out.println();
            System.out.println("Выбранные характеристики: ");
            System.out.println(compFiltr.toString()); // вывести характеристики поиска
            System.out.println();

            if (compExist == false) {
                System.out.println("В нашей вселенной таких компьютеров не существует...");
            } else {
                System.out.println("Найдено.");
                System.out.println("Отображение доступного каталога: ");
                compPrint(computers, compFiltr);

            }
        }
    }

    // выводит то, что надо
    static void compPrint(Set<Computer> computers, Computer compFiltr) {
        boolean found = false;
        for (Computer computer : computers) {
            if ((Objects.equals(computer.getBrand(), compFiltr.getBrand()) | compFiltr.getBrand() == "any")) {
                if ((computer.getRam() >= compFiltr.getRam()) | (compFiltr.getRam() == 0)) {
                    if ((computer.getHdd() >= compFiltr.getHdd()) | (compFiltr.getHdd() == 0)) {
                        if ((Objects.equals(computer.getOs(), compFiltr.getOs())) | (compFiltr.getOs() == "any")) {
                            if ((Objects.equals(computer.getColor(), compFiltr.getColor())) | (compFiltr.getColor() == "any")) {
                                System.out.println(computer.toString());
                                found = true;
                            }
                        }
                    }
                }
            }
        }
        if (!found) {
            System.out.println("Компьютеров с таким набором характеристик нет.");
        }
    }
}