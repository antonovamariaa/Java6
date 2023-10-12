package hw6;

public class Computer {
    private String brand;
    private int ram;     //ОЗУ
    private int hdd;        //Объем ЖД
    private String os;      //Операционная система
    private String color;   //цвет


    public Computer(String brand, int ram, int hdd, String os, String color){
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }


    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam(){
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd(){
        return hdd;
    }
    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getOs(){
        return os;
    }
    public void setOs(String os) {
        this.os = os;
    }

    public String getColor(){
        return color;
    }
     public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Бренд: " + brand + ", ОЗУ: " + ram + ", Объем ЖД: " + hdd + ", Операционная система: " + os + ", Цвет: " + color;
    }

        
}
