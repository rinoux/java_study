package com.fr.decision.staticres.storage.ftp;

import com.fr.decision.staticres.storage.Storage;
import com.fr.decision.staticres.storage.StorageConfig;
import sun.net.ftp.FtpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class FTPStorage implements Storage {
    private FtpConfig config;
    private FtpClient ftpClient;

    public FTPStorage(FtpConfig config) {
        this.config = config;
    }

    private void init() {
        //todo read Config
        ftpClient = ftpClient.create();
    }

    @Override
    public StorageConfig getConfig() {
        return config;
    }

    @Override
    public boolean exist(String path) {
        return false;
    }

    @Override
    public InputStream getData(String path) throws IOException {
        throw new IOException("file not exist");
    }

    @Override
    public Set<String> getChildren(String path) {
        return null;
    }

    @Override
    public int getACL(String path) {
        return 0;
    }

    @Override
    public boolean delete(String path) {
        return false;
    }

    @Override
    public String create(String path, byte[] data, Object acl) {
        return null;
    }


}
