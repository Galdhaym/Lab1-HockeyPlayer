package com.company;

import java.io.*;

public class ObjectSerializer implements AutoCloseable {
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    File file;

    ObjectSerializer(File file) throws IOException {
        if(!file.isFile()) {
            throw new IOException("Current file path must be a file!");
        }
        this.file = file;
    }

    public void save(Object object) throws IOException {
        if(outputStream == null){
            outputStream = new ObjectOutputStream(new FileOutputStream(file));
        }

        outputStream.writeObject(object);
    }

    public Object load() throws IOException, ClassNotFoundException {
        if(inputStream == null){
            inputStream = new ObjectInputStream(new FileInputStream(file));
        }

        return inputStream.readObject();
    }

    @Override
    public void close() throws IOException {
        if(outputStream != null){
            outputStream.close();
            outputStream = null;
        }

        if(inputStream != null){
            inputStream.close();
            inputStream = null;
        }
    }
}
