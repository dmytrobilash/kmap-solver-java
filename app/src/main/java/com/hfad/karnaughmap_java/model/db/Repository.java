package com.hfad.karnaughmap_java.model.db;


public interface Repository {
    String getButton();
    void setButton(String buttons, Runnable onSuccess);
}
