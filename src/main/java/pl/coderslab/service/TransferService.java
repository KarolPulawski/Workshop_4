package pl.coderslab.service;

public class TransferService {

    private String text;

    public TransferService(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
