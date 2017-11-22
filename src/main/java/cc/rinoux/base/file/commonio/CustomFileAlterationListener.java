package cc.rinoux.base.file.commonio;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

public class CustomFileAlterationListener implements FileAlterationListener {
    @Override
    public void onStart(FileAlterationObserver fileAlterationObserver) {
        //System.out.println("Start scanning file...");
    }

    @Override
    public void onDirectoryCreate(File file) {
        System.out.println("Directory: " + file.getAbsolutePath() + "' is created");
    }

    @Override
    public void onDirectoryChange(File file) {
        System.out.println("Directory: " + file.getAbsolutePath() + "' is changed");
    }

    @Override
    public void onDirectoryDelete(File file) {
        System.out.println("Directory: " + file.getAbsolutePath() + "' is deleted");
    }

    @Override
    public void onFileCreate(File file) {
        System.out.println("File: '" + file.getAbsolutePath() + "' is created");
    }

    @Override
    public void onFileChange(File file) {
        System.out.println("File: '" + file.getAbsolutePath() + "' is changed");
    }

    @Override
    public void onFileDelete(File file) {
        System.out.println("File: '" + file.getAbsolutePath() + "' is deleted");
    }

    @Override
    public void onStop(FileAlterationObserver fileAlterationObserver) {
        // System.out.println("Stop scanning file...");
    }
}