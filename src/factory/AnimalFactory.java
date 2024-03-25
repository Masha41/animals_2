package factory;
import animals.Animal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalData;
import exceptions.AnimalNotSupported;


import java.util.Scanner;

public class AnimalFactory {

private Scanner scanner = null;


public  AnimalFactory(Scanner scanner) {
    this.scanner = scanner;
}

    public Animal create(AnimalData animalData) throws AnimalNotSupported {
      switch (animalData) {
          case DUCK: {
              return new Duck(scanner);
          }
          case DOG: {
              return new Dog(scanner);
          }
          case CAT:  {
              return new Cat(scanner);
          }
      }
    throw new AnimalNotSupported(animalData);
    }
}


