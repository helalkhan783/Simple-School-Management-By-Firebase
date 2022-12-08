package com.example.collegeapp.ebook;

public class EbookPojo {
   private String title,pdfUrl;

    public EbookPojo() {
    }

    public EbookPojo(String title, String pdfUrl) {
        this.title = title;
        this.pdfUrl = pdfUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
