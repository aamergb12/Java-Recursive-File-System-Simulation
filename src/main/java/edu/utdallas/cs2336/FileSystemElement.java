package edu.utdallas.cs2336;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FileSystemElement {
    public enum Type {FILE, DIRECTORY}

    ;

    private final Type type;
    private final String name;
    private final List<FileSystemElement> contentsList;

    public FileSystemElement(String name) {
        this.name = name;
        type = Type.FILE;
        contentsList = Collections.unmodifiableList(new ArrayList<FileSystemElement>());
    }

    public FileSystemElement(String name, List<FileSystemElement> contents) {
        this.name = name;
        type = Type.DIRECTORY;
        contentsList = Collections.unmodifiableList(contents);
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<FileSystemElement> getContentsList() {
        return contentsList;
    }
}
