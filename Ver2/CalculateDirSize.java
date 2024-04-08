import java.io.File;

public class CalculateDirSize {
    public long calculateDirSize(File dir) {
        long size = 0;
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        size += f.length();
                    } else if (f.isDirectory()) {
                        size += calculateDirSize(f);
                    }
                }
            }
        }
        return size;
    }
}

