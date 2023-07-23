package com.delma.FileApp;


import jakarta.persistence.*;

@Entity
@Table(name = "filemodel")
public class FileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "content")
    @Lob
    private byte[] content;

    @Column(name = "name")
    private String name;

    @Column(name = "fileType")
    private String fileType;

    public FileModel() {
    }

    public FileModel(byte[] content, String name, String fileType) {

        this.content = content;
        this.name = name;
        this.fileType = fileType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
