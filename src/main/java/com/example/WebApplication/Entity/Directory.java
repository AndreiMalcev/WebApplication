package com.example.WebApplication.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EXPLORER")
public class Directory {

    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private String parent;
    private boolean children;

    public Directory() {
        super();
    }

    public Directory(String parent, String text, boolean children) {
        this.parent = parent;
        this.text = text;
        this.children = children;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public boolean isChildren() {
        return children;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }
}