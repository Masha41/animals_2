package animals;

import data.ColorData;
import utils.EnumConverter;
import utils.Validators;

import java.util.Scanner;



public abstract class Animal {

    private final Scanner scanner;

    public Animal (Scanner scanner) {
    this.scanner = scanner;
  }
   // private  scanner = null;

    private String name;
    private float weight;

    private int age;
    private ColorData colorData;
    private Validators validators = new Validators();
    private EnumConverter enumConverter= new EnumConverter();

    //public Animal(Scanner scanner) {
   // }


    public String getName() {
        
        return this.name;
    }

    public float getWeight() {
        return this.weight;

    }

    public int getAge() {

        return this.age;
    }

    public ColorData getColorData() {
        return this.colorData;

    }

    public void setName() {
String name = "";
       while (true) {
    System.out.println("Введите имя животного");
    name = scanner.next().trim();
    if (validators.isStringChars(name)) {
        break;
    }
    System.out.println("Вы ввели неверное имя животного");
}
        this.name = name;
    }

    public void setWeight() {
String weightStr = "";
        while (true){
            System.out.println("Введите вес животного");
            weightStr = scanner.next().trim();
            if(validators.isStringNumber(weightStr) && Float.parseFloat(weightStr) >0){
                break;
            }
            System.out.println("Введен неверный вес животного");
        }

        this.weight = Float.parseFloat(weightStr);

    }

    public void setAge() {
        String ageStr = "";
        while (true) {
            System.out.println("Введите возраст животного");
            ageStr = scanner.next().trim();
           if (validators.isStringNumber(ageStr) && Integer.parseInt(ageStr) > 0) {
                break;
            }
            System.out.println("Введен неверный возраст");
        }
       this.age = Integer.parseInt(ageStr);

    }

    public void setColorData() {
       String colorDataStr = "";
        while (true){
            System.out.printf("Введите цвет животного один из %s\n", enumConverter.getNamesFromEnum(ColorData.class, ","));
            colorDataStr = scanner.next().toUpperCase().trim();
            if(validators.checkValueInEnum(ColorData.class, colorDataStr)){
                break;
            }
            System.out.printf("Цвет животного %s не существует\n",colorDataStr);
        }

        this.colorData = ColorData.valueOf(colorDataStr);
    }


    public void say() {
       System.out.println("Я говорю");
    }

    public void go() {

        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        return String.format("Привет! меня зовут %s, мне %d %s, я вешу - %.2f кг, мой цвет - %s", name, age, getPadej(), weight, colorData.getName());


    }

    private String getPadej() {
        int ostatok = age % 10;
        if (age >= 11 && age <= 14) {
            return "лет";
        }
        if (ostatok == 1) {
            return "год";
        }
        if (ostatok >= 5) {
            return "лет";
        }
        if (ostatok >= 2) {
            return "года";

        }
         return "лет";
    }
}
