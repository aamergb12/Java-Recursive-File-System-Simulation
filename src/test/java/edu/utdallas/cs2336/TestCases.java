package edu.utdallas.cs2336;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TestCases {

    @Test
    public void testPrimeFactorization() {
        assert "13".equals(Recursion.primeFactorization(13));
        assert "2 * 3 * 5".equals(Recursion.primeFactorization(2*3*5));
        assert "13 * 13".equals(Recursion.primeFactorization(13*13));
        assert "2 * 2 * 3 * 5 * 7".equals(Recursion.primeFactorization(2*2*3*5*7));
    }

    @Test
    public void testDirectoryTraversal() {
        // Simple
        FileSystemElement file = new FileSystemElement("Hello.txt");
        assert ( Recursion.printContents(file).equals("Hello.txt\n"));

        // With subdirectory
        FileSystemElement secondFile = new FileSystemElement("There.txt");
        FileSystemElement thirdFile = new FileSystemElement("Student.txt");

        List<FileSystemElement> subDirectoryContents = new ArrayList<>();
        subDirectoryContents.add(secondFile);
        subDirectoryContents.add(thirdFile);
        FileSystemElement subDirectory = new FileSystemElement("subdir", subDirectoryContents);
        assert(Recursion.printContents(subDirectory).equals("subdir\n   There.txt\n   Student.txt\n"));

        List<FileSystemElement> mainDirectoryContents = new ArrayList<>();
        mainDirectoryContents.add(file);
        mainDirectoryContents.add(subDirectory);
        FileSystemElement mainDirectory = new FileSystemElement("main", mainDirectoryContents);
        assert(Recursion.printContents(mainDirectory).equals("main\n   Hello.txt\n   subdir\n      There.txt\n      Student.txt\n"));
    }
}
