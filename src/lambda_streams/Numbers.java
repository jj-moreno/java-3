package lambda_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class Numbers {
    static List<Integer> nums = Arrays.asList(10, 100, 1000, 5, 50, 500, 3, 30, 300, 7, 70, 700, 1, 10, 100, 25, 250, 2500);

    public static void main(String[] args) {
        //Part I :complete the static class methods that have been set up in this Numbers class java file.  Use streams to compute the results wheever possible.
        System.out.println(nums);
        System.out.println("odds");
        for (int num : nums) {
            if (isOdd(num)) {
                System.out.print(num + ", ");
            }
        }
        System.out.println();
        System.out.println("evens");
        for (int num : nums) {
            if (isEven(num)) {
                System.out.print(num + ", ");
            }
        }
        System.out.println();
        System.out.println("primes");
        for (int num : nums) {
            if (isPrime(num)) {
                System.out.print(num + ", ");
            }
        }
        System.out.println();
        System.out.println("sum:");
        System.out.println(added());
        System.out.println("remainder:");
        System.out.println(subtracted());
        System.out.println("product:");
        System.out.println(multipled());
        System.out.println("quotient:");
        System.out.println(divided());
        System.out.println("max:");
        System.out.println(findMax());
        System.out.println("min:");
        System.out.println(findMin());
        System.out.println("comparing first num to second num");
        System.out.println(compare(nums.get(0), nums.get(1)) == 1 ?
                "first num greater than second num" : "first num smaller than second num");
        System.out.println("append:");
        System.out.println(append(1));
        System.out.println(nums);
        //Part II - refactor all of the class methods to accept lambda expressions. You can put the lambda functions directly inside the method calls, or defined them first, then pass them into the methods. give them the same names as the static methods, but add the word 'lambda' in front of every lambda function:
        System.out.println("lambda odds");
        Predicate<Integer> lambdaIsOdd = (i) -> i % 2 != 0;

        for (int num : nums) {
            if (lambdaIsOdd.test(num)) {
                System.out.print(num + ", ");
            }
        }
        System.out.println();

        System.out.println("lambda evens");
        Predicate<Integer> lambdaIsEven = (i) -> i % 2 == 0;

        for (int num : nums) {
            if (lambdaIsEven.test(num)) {
                System.out.print(num + ", ");
            }
        }
        System.out.println();

        System.out.println("lambda primes");
        Predicate<Integer> lambdaIsPrime = (i) -> {
            for (int n = 2; n <= i / 2; n++) {
                if (i % n == 0) {
                    return false;
                }
            }
            return i != 1;
        };

        for (int num : nums) {
            if (lambdaIsPrime.test(num)) {
                System.out.print(num + ", ");
            }
        }
        System.out.println();

        System.out.println("lambda sum:");
        IntSupplier lambdaAdded = () -> {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        };
        System.out.println(lambdaGetInt(lambdaAdded));

        System.out.println("remainder:");
        IntSupplier lambdaSubtracted = () -> {
            int subtract = nums.get(0);
            int size = nums.size();
            for (int i = 1; i < size; i++) {
                subtract -= nums.get(i);
            }
            return subtract;
        };
        System.out.println(lambdaGetInt(lambdaSubtracted));

        System.out.println("product:");
        LongSupplier lambdaMultiplied = () -> {
            long multiply = nums.get(0);
            int size = nums.size();
            for (int i = 1; i < size; i++) {
                multiply *= nums.get(i);
            }
            return multiply;
        };
        System.out.println(lambdaGetLong(lambdaMultiplied));

        System.out.println("quotient:");
        DoubleSupplier lambdaDivided = () -> {
            double divide = nums.get(0);
            int size = nums.size();
            for (int i = 1; i < size; i++) {
                divide /= nums.get(i);
            }
            return divide;
        };
        System.out.println(lambdaGetDouble(lambdaDivided));

        System.out.println("lambda max:");
        IntSupplier lambdaFindMax = () -> {
            int max = nums.get(0);
            int size = nums.size();
            int num;
            for (int i = 1; i < size; i++) {
                num = nums.get(i);
                if (max < num) {
                    max = num;
                }
            }
            return max;
        };
        System.out.println(lambdaGetInt(lambdaFindMax));

        System.out.println("lambda min:");
        IntSupplier lambdaFindMin = () -> {
            int min = nums.get(0);
            int size = nums.size();
            int num;
            for (int i = 1; i < size; i++) {
                num = nums.get(i);
                if (min > num) {
                    min = num;
                }
            }
            return min;
        };
        System.out.println(lambdaGetInt(lambdaFindMin));

        System.out.println("lambda comparing first num to second num");
        BiFunction<Integer, Integer, Integer> lambdaCompare = (i, j) -> {
            if (i > j) {
                return 1;
            } else if (i < j) {
                return -1;
            }
            return 0;
        };
        System.out.println(lambdaGetInt(() -> lambdaCompare.apply(nums.get(0), nums.get(1))) == 1 ?
                "first num greater than second num" : "first num smaller than second num");

        System.out.println("lambda append:");
        IntFunction<Integer> lambdaAppend = (n) -> {
            ArrayList<Integer> copyNumsArr = new ArrayList<>(nums);
            copyNumsArr.add(n);
            nums = List.copyOf(copyNumsArr);
            return n;
        };
        System.out.println(lambdaGetInt(() -> lambdaAppend.apply(2)));
        System.out.println(nums);
    }

    static boolean isOdd(int i) {
        //determine if the value at the index i is odd.  return true if yes, return false if  no.
        return i % 2 != 0;
    }

    static boolean isEven(int i) {
        //determine if the value at the index i is even.  return true if yes, return false if  no.
        return i % 2 == 0;
    }

    static boolean isPrime(int i) {
        //determine if the value at the index i is a prime number.  return true if yes, return false if no.
        for (int n = 2; n <= i / 2; n++) {
            if (i % n == 0) {
                return false;
            }
        }

        return i != 1;
    }

    static int added() {
        //add all the elements in the list.  return the sum.  
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    static int subtracted() {
        //subtract all the elements in the list. return the remainder.
        int subtract = nums.get(0);
        int size = nums.size();
        for (int i = 1; i < size; i++) {
            subtract -= nums.get(i);
        }
        return subtract;
    }

    static long multipled() {
        //multiply all the elements in the list. and return the product.
        long multiply = nums.get(0);
        int size = nums.size();
        for (int i = 1; i < size; i++) {
            multiply *= nums.get(i);
        }
        return multiply;
    }

    static double divided() {
        //divide all the elements in the list. and return the product.
        double divide = nums.get(0);
        int size = nums.size();
        for (int i = 1; i < size; i++) {
            divide /= nums.get(i);
        }
        return divide;
    }

    static int findMax() {
        //return the maximum value in the list.
        int max = nums.get(0);
        int size = nums.size();
        int num;
        for (int i = 1; i < size; i++) {
            num = nums.get(i);
            if (max < num) {
                max = num;
            }
        }
        return max;
    }

    static int findMin() {
        //return the minimum value in the list.
        int min = nums.get(0);
        int size = nums.size();
        int num;
        for (int i = 1; i < size; i++) {
            num = nums.get(i);
            if (min > num) {
                min = num;
            }
        }
        return min;
    }

    static int compare(int i, int j) {
        //compare the values stored in the array at index position i and j.
        //if the value at i is greater, return 1.  if the value at j is greater, return -1.  if the two values are equal, return 0.
        if (i > j) {
            return 1;
        } else if (i < j) {
            return -1;
        }
        return 0;
    }

    static int append(int n) {
        //add a new value to the values list. return that value after adding it to the list.
        ArrayList<Integer> copyNumsArr = new ArrayList<>(nums);
        copyNumsArr.add(n);
        nums = List.copyOf(copyNumsArr);
        return n;
    }

    static int lambdaGetInt(IntSupplier intSupplier) {
        return intSupplier.getAsInt();
    }

    static long lambdaGetLong(LongSupplier longSupplier) {
        return longSupplier.getAsLong();
    }

    static double lambdaGetDouble(DoubleSupplier doubleSupplier) {
        return doubleSupplier.getAsDouble();
    }

}
