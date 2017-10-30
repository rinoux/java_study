package com.fr.decision.staticres.monitor;

import com.fr.decision.staticres.FileEntity;

/**
 * 文件变化监听者，具体由调用者实现
 */
public interface FileModificationListener {
    void onStart(final FileModificationObserver observer);
    void onDirectoryCreate(final FileEntity directory);
    void onDirectoryChange(final FileEntity directory);
    void onDirectoryDelete(final FileEntity directory);
    void onFileCreate(final FileEntity file);
    void onFileChange(final FileEntity file);
    void onFileDelete(final FileEntity file);
    void onStop(final FileModificationObserver observer);
}
