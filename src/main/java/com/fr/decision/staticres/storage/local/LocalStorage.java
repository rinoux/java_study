package com.fr.decision.staticres.storage.local;

import com.fr.decision.staticres.storage.Storage;
import com.fr.decision.staticres.storage.StorageConfig;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LocalStorage implements Storage {
    @Override
    public StorageConfig getConfig() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean exist(String path) {
        File file = new File(path);
        return file.exists();
    }

    @Override
    public InputStream getData(String path) throws IOException {
        File file = new File(path);
        if (file.exists() && !file.isDirectory()) {
            FileInputStream fis = new FileInputStream(file);
            fis.close();
            return fis;
        }
        return null;
    }

    @Override
    public Set<String> getChildren(String path) {
        Set<String> children = new HashSet<>();
        File file = new File(path);
        if (!file.isDirectory()) return null;
        String[] fileAndDirs = file.list();

        if (fileAndDirs != null) {
            Collections.addAll(children, fileAndDirs);
        }
        return children;
    }

    @Override
    public int getACL(String path) {
        File file = new File(path);
        int acl = 0;
        boolean readable = file.canRead();
        boolean writable = file.canWrite();
        boolean executable = file.canExecute();


        //TODO Rinoux:这个看需求实现
        return 0;
    }

    @Override
    public boolean delete(String path) throws IOException {
        File file = new File(path);
        boolean success;
        if (file.exists()) {
            success = file.delete();
        } else {
            throw new IOException("File not exist");
        }
        return success;
    }


    @Override
    public String create(String path, byte[] data, Object acl) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            throw new IOException("File already exist");
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data);
        fos.close();
        return path;
    }
}
