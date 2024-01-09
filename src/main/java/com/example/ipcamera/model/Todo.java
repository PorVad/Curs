package com.example.ipcamera.model;

import com.example.ipcamera.entity.TodoEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean chose;

    public static Todo toModel(TodoEntity entity) {
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setChose(entity.getChose());
        model.setTitle(entity.getTitle());

        return model;
    }

    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getChose() {
        return chose;
    }

    public void setChose(Boolean chose) {
        this.chose = chose;
    }
}
