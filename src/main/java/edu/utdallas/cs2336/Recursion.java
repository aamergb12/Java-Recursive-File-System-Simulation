package edu.utdallas.cs2336;

import java.util.Iterator;

public class Recursion {

    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    public static String primeFactorization(int number) {
        // TODO: use PRIMES above to find the smallest divisor.
        //  Consider your base cases:
        //    1) the number you have is prime
        //    2) you can't find a prime factor
        //  Your recursion will be to call the method again
        //  when you find a prime factor (after dividing by
        //  that factor)!
        //  RETURN FORMAT: each prime factor (smallest to
        //  largest), with " * " between them
        //  Example: 10 creates "2 * 5"
        for ( int prime : PRIMES) {
            if ( number == prime) {
                return Integer.toString(number);
            }
            if ( number % prime == 0) {
                return prime + " * " + primeFactorization(number / prime);
            }
        }
        // Nothing found
        return Integer.toString(number);
    }

    private static void printContents(FileSystemElement element, StringBuilder stringBuilder, String prepend) {
        // TODO: Your job is to print a "file list", with each directory
        //  you find causing it to be indented 3 spaces.
        //  ...
        //  Use element.getType() to tell file vs. directory
        //  ...
        //  Ex: a directory with a file named "file" and a subdirectory
        //  "something" with a file named "another" would produce:
        //  file
        //  something
        //     another
        //  (ending in a carriage return)
        //  ...
        //  Your recursion is when you discover a directory: print
        //  the name, and recurse, passing 3 additional spaces in the
        //  "prepend" argument.
        //  ...
        //  The final file/directory will have a \n at the end
        //  (that is, you don't need to detect the final entry)


        stringBuilder.append(prepend).append(element.getName()).append("\n");


        if (element.getType() == FileSystemElement.Type.DIRECTORY) {
            for (FileSystemElement child : element.getContentsList()) {  

                printContents(child, stringBuilder, prepend + "   ");
            }
        }


    }

    public static String printContents(FileSystemElement element) {
        StringBuilder builder = new StringBuilder();
        printContents(element, builder, "");
        return builder.toString();
    }
}