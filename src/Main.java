import animals.Animal;
import data.AnimalData;

import data.CommandData;
import exceptions.AnimalNotSupported;

import factory.AnimalFactory;
import utils.EnumConverter;
import utils.Validators;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AnimalNotSupported {

        Scanner scanner = new Scanner(System.in);


        Validators validators = new Validators();
        EnumConverter enumConverter = new EnumConverter();


        List<Animal> animals = new ArrayList<>();


        while (true) {
            System.out.printf("Введите одну из комманд: %s\n", enumConverter.<CommandData>getNamesFromEnum(CommandData.class, "/"));


            String commandStr = scanner.next().toUpperCase().trim();

            if (!validators.checkValueInEnum(CommandData.class, commandStr)) {
                System.out.printf("Команды %s не существует\n", commandStr);
                continue;
            }

            CommandData commandData = CommandData.valueOf(commandStr);

            switch (commandData) {


                case ADD: {
                    String animalTypeStr = "";

                    while (true) {
                        System.out.printf("Введите тип животного %s\n", enumConverter.getNamesFromEnum(AnimalData.class, "/"));
                        animalTypeStr = scanner.next().toUpperCase().trim();

                        if (validators.checkValueInEnum(AnimalData.class, animalTypeStr)) {
                            break;
                        }
                        System.out.printf("Тип животного %s не существует\n", animalTypeStr);

                    }


                    Animal animal = new AnimalFactory(scanner).create(AnimalData.valueOf(animalTypeStr));
                    animal.setName();
                    animal.setAge();
                    animal.setWeight();
                    animal.setColorData();
                    animal.say();

                    animals.add(animal);

                    break;
                }
                case LIST: {
                    if (animals.isEmpty()) {
                        System.out.println("Список животных пустой");

                        break;
                    }
                    animals.forEach((Animal animal) -> System.out.println(animal.toString()));
                    break;
                }


                case EXIT:
                    System.exit(0);


            }
        }
    }
}

















