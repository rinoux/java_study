package com.fr.decision.staticres.storage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * 各种存储的抽象，包括一些基础的方法
 */
public interface Storage {

    /**
     * 获取配置
     *
     * @return 配置
     */
    StorageConfig getConfig();

    /**
     * 该路径的文件是否存在
     *
     * @param path 文件/路径
     * @return 是否存在
     */
    boolean exist(String path);

    /**
     * 根据路径获取该文件的数据
     *
     * @param path 路径
     * @return 数据字节数组
     */
    InputStream getData(String path) throws IOException;

    /**
     * 获得该路径下的子路径
     *
     * @param path 路径
     * @return 子路径集合
     */
    Set<String> getChildren(String path);

    /**
     * 获得该路径权限
     *
     * @param path 路径
     * @return 权限
     */
    int getACL(String path);

    /**
     * 删除该路径
     *
     * @param path 路径
     * @return 是否成功删除
     */
    boolean delete(String path) throws IOException;

    /**
     * 创建文件
     *
     * @param path 路径
     * @param data 数据
     * @param acl  权限
     * @return 创建的文件路径
     */
    String create(String path, byte[] data, Object acl) throws IOException;

}
