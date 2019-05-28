package com.infoshare.alpha.wwr.domain.facilities.command;

public class UploadCommand {

    private String uploadFilePath;

    public UploadCommand(String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }

    public String getUploadFilePath() {

        return this.uploadFilePath;
    }

}
