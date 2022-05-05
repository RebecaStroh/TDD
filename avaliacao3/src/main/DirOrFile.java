package main;

import java.util.List;

public class DirOrFile {
    private String fileName;
    private String content;
    private List<DirOrFile> myFiles;
    public DirOrFile(String fileName, String content) {
        this.content = content;
        this.fileName = fileName;
        this.myFiles = null;
    }
    public DirOrFile(String fileName, List<DirOrFile> myFiles) {
        this.myFiles = myFiles;
        this.fileName = fileName;
        this.content = null;
    }

    public List<DirOrFile> getMyFiles() {
        return myFiles;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContent() {
        return content;
    }

    public void setMyFiles(List<DirOrFile> myFiles) {
        this.myFiles = myFiles;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
