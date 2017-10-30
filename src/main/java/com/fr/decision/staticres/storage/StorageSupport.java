package com.fr.decision.staticres.storage;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 存储介质系统的工具
 * storage 可以做一些基本的查询，删除，创建等操作，更加复杂的操作，比如上传，更新，移动，复制等交给
 * StorageSupport来做
 */
public interface StorageSupport {
    boolean update(String path, OutputStream data);
    boolean move(String origPath, String destPath);
    boolean copy(String origPath, String destPath);
    String upload(String path, OutputStream data);
    InputStream download(String path);
    String rename(String path, String newPath);
    boolean remove(String path);
    String mkDir(String path);
    InputStream read(String path);
}
