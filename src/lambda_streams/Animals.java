package lambda_streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

class Animals {
    //This class will be using streams.
    static List<String> animals = Arrays.asList("peacoCK", "rabbit", "chiwawa", "OranguTAN", "vipeR", "cobra", "paNDa", "bUffalo", "DeeR", "maLLard");

    public static void main(String[] args) {
        System.out.println("original animals : " + animals);

        //clean up the animals array by using the capsFirst() method. follow instructions in the method definition.
        System.out.println("capsFirst with mutate false:");
        List<String> cleaned = capsFirst(animals, false);
        System.out.println(cleaned);
        //do not modify these addAnimal() method invocations
        addAnimal("rEIndeeR");
        addAnimal("Platypus");
        addAnimal("frOg");
        addAnimal("lEOpArD");
        //---------------------------------------
        System.out.println("capsFirst with mutate true:");
        capsFirst(animals, true);
        System.out.println(animals);
        System.out.println("lowerFirst with mutate false");
        List<String> lowered = lowerFirst(animals, false);
        System.out.println(lowered);
        System.out.println("lowerFirst with mutate true:");
        lowerFirst(animals, true);
        System.out.println(animals);
        System.out.println("flipAnimals with mutate false");
        List<String> flipped = flipAnimals(false);
        System.out.println(flipped);
        System.out.println("sortAnimals with mutate false");
        List<String> sorted = sortAnimals(false);
        System.out.println(sorted);
        System.out.println(); // line separation for call to lambda functions and overridden methods taking in lambdas as args

        Function<List<String>, List<String>> lambdaCapsFirst = (animalList) -> animalList.stream()
                .map(animal -> animal.substring(0, 1).toUpperCase() + animal.substring(1).toLowerCase())
                .collect(Collectors.toList());
        System.out.println("lambda capsFirst with mutate false:");
        List<String> lambdaCleaned = capsFirst(lambdaCapsFirst, false);
        System.out.println(lambdaCleaned);

        System.out.println("lambda addAnimal");
        Function<String, String> lamdaAdded = (animal) -> {
            ArrayList<String> copyAnimals = new ArrayList<>(animals);
            copyAnimals.add(animal);
            animals = List.copyOf(copyAnimals);
            return animal;
        };
        System.out.println("added: " + addAnimal(lamdaAdded, "gOosE"));
        System.out.println("added: " + addAnimal(lamdaAdded, "FisH"));

        System.out.println("lambda capsFirst with mutate true:");
        capsFirst(lambdaCapsFirst, true);
        System.out.println(animals);

        Function<List<String>, List<String>> lambdaLowerFirst = (animalList) -> animalList.stream()
                .map(animal -> animal.substring(0, 1).toLowerCase() + animal.substring(1).toUpperCase())
                .collect(Collectors.toList());
        System.out.println("lambda lowerFirst with mutate false:");
        List<String> lambdaLowered = lowerFirst(lambdaLowerFirst, false);
        System.out.println(lambdaLowered);
        System.out.println("lambda lowerFirst with mutate true:");
        lowerFirst(lambdaLowerFirst, true);
        System.out.println(animals);

        Supplier<List<String>> lambdaFlipAnimals = () -> {
            Iterator<String> reversedStream = new LinkedList<>(animals).descendingIterator();
            return StreamSupport.stream(Spliterators.spliteratorUnknownSize(reversedStream, Spliterator.ORDERED), false)
                    .collect(Collectors.toList());
        };
        System.out.println("lambda flipAnimals with mutate false");
        List<String> lambdaFlipped = flipAnimals(lambdaFlipAnimals, false);
        System.out.println(lambdaFlipped);
        System.out.println("lambda flipAnimals with mutate true");
        flipAnimals(lambdaFlipAnimals, true);
        System.out.println(animals);

        Supplier<List<String>> lambdaSortAnimals = () -> animals.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("lambda sortAnimals with mutate false");
        List<String> lambdaSorted = sortAnimals(lambdaSortAnimals, false);
        System.out.println(lambdaSorted);
        System.out.println("lambda sortAnimals with mutate true");
        sortAnimals(lambdaSortAnimals, true);
        System.out.println(animals);

        Consumer<List<String>> addRandList = (randList) -> {
            List<String> subList = randList.subList(0, (int) (Math.random() * randList.size()) + 1);
            animals.addAll(subList);
        };
        System.out.println("Bonus: added to animals list from random subset of random animals list");
        addRandAnimals(addRandList);
        System.out.println(animals);
    }

    static List<String> capsFirst(List<String> animalList, boolean mutate) {
        //clean up the animals list so that the first letter is capitalized, and all the other letters are lowercased. Use a stream to accomplish this task.  Also, the 2nd parameter of this function is a boolean.  use this boolean 'flag' to determine whether or not to 'mutate' the original animals array stored as a static class field.  if the flag is set to 'true', mutate the animals and return the animals out of the function.  if it is false, create a copy of the animals, perform your stream operations on the copy, and return the copy of animals out of the function, WITHOUT modifying the original animals array.  
        if (mutate) {
            return animals = animalList.stream()
                    .map(animal -> animal.substring(0, 1).toUpperCase() + animal.substring(1).toLowerCase())
                    .collect(Collectors.toList());
        } else {
            List<String> copyAnimals = new ArrayList<>(animalList);
            copyAnimals = copyAnimals.stream()
                    .map(animal -> animal.substring(0, 1).toUpperCase() + animal.substring(1).toLowerCase())
                    .collect(Collectors.toList());
            return copyAnimals;
        }
    }

    static String addAnimal(String animal) {
        //add an animal to the animal list.
        ArrayList<String> copyAnimals = new ArrayList<>(animals);
        copyAnimals.add(animal);
        animals = List.copyOf(copyAnimals);
        return animal;
    }

    static List<String> lowerFirst(List<String> animalList, boolean mutate) {
        //lowercase the first letter, and uppercase the rest of the letters, using streams.  Also, depending on the value of the boolean flag 'mutate', mutate the original animals list, or perform your stream operations on a 'copy' of the animals list.  return the list out of hte function in both cases.
        if (mutate) {
            return animals = animalList.stream()
                    .map(animal -> animal.substring(0, 1).toLowerCase() + animal.substring(1).toUpperCase())
                    .collect(Collectors.toList());
        } else {
            List<String> copyAnimals = new ArrayList<>(animalList);
            copyAnimals = copyAnimals.stream()
                    .map(animal -> animal.substring(0, 1).toLowerCase() + animal.substring(1).toUpperCase())
                    .collect(Collectors.toList());
            return copyAnimals;
        }
    }

    static List<String> flipAnimals(boolean mutate) {
        //reverse the order of the animals in the animal list.  If the booleaen parameter is true, reverse the static animals array list by mutating the array.  if the mutate boolean is false, flip a 'copy' of the animals list, then return that list of flipped animals, WITHOUT mutating the static animals array. return the flipped list in both cases.

        if (mutate) {
            Iterator<String> reversedStream = new LinkedList<>(animals).descendingIterator();
            return animals = StreamSupport.stream(Spliterators.spliteratorUnknownSize(reversedStream, Spliterator.ORDERED), false)
                    .collect(Collectors.toList());
        } else {
            List<String> copyAnimals = new ArrayList<>(animals);
            Iterator<String> reversedStream = new LinkedList<>(copyAnimals).descendingIterator();
            copyAnimals = StreamSupport.stream(Spliterators.spliteratorUnknownSize(reversedStream, Spliterator.ORDERED), false)
                    .collect(Collectors.toList());
            return copyAnimals;
        }
    }

    static List<String> sortAnimals(boolean mutate) {
        //sort the animals in alphabetical order.  If the booleaen parameter is true, mutating the animals list.  if the mutate boolean is false, sort a 'copy' of the animals list, then return that list of sorted animals, WITHOUT mutating the static animals array. return the sorted list in both cases.
        if (mutate) {
            return animals = animals.stream()
                    .sorted()
                    .collect(Collectors.toList());
        } else {
            List<String> copyAnimals = new ArrayList<>(animals);
            copyAnimals = copyAnimals.stream()
                    .sorted()
                    .collect(Collectors.toList());
            return copyAnimals;
        }
    }

    static List<String> capsFirst(Function<List<String>, List<String>> function, boolean mutate) {
        if (mutate) {
            return animals = function.apply(animals);
        } else {
            List<String> copyAnimals;
            copyAnimals = function.apply(animals);
            return copyAnimals;
        }
    }

    static String addAnimal(Function<String, String> function, String animal) {
        return function.apply(animal);
    }

    static List<String> lowerFirst(Function<List<String>, List<String>> function, boolean mutate) {
        if (mutate) {
            return animals = function.apply(animals);
        } else {
            List<String> copyAnimals;
            copyAnimals = function.apply(animals);
            return copyAnimals;
        }
    }

    static List<String> flipAnimals(Supplier<List<String>> supplier, boolean mutate) {
        if (mutate) {
            return animals = supplier.get();
        } else {
            List<String> copyAnimals;
            copyAnimals = supplier.get();
            return copyAnimals;
        }
    }

    static List<String> sortAnimals(Supplier<List<String>> supplier, boolean mutate) {
        if (mutate) {
            return animals = supplier.get();
        } else {
            List<String> copyAnimals;
            copyAnimals = supplier.get();
            return copyAnimals;
        }
    }

    static void addRandAnimals(Consumer<List<String>> consumer) {
        List<String> randAnimals = Arrays.asList("dUCk", "WoLf", "tiGEr", "sEalIoN", "haWK", "pYThON", "tURTle", "BeaR");
        consumer.accept(randAnimals);
    }
}
