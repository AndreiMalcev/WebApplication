package com.example.WebApplication.ExplorerService;

import com.example.WebApplication.Entity.Directory;

import java.util.List;

public interface ExplorerServiceInterface {

    public void rename(Long id, String newName);
    public void deleteWithChildren(Long id);
    public void updateParent(Long id, String parent);
    public List<Directory> children(String parent);
    public void create(String parent, String name);
}
