package com.example.WebApplication.ExplorerService;

import com.example.WebApplication.Entity.Directory;
import com.example.WebApplication.DAO.ExplorerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ExplorerService implements ExplorerServiceInterface{

    @Autowired
    private ExplorerRepository directories;

    @Override
    public void rename(Long id, String newName) {
        directories.rename(id, newName);
    }

    @Override
    public void deleteWithChildren(Long id) {
        LinkedList<Directory> directory = directories.children(id);
        directories.delete(id);
        while (!directory.isEmpty()) {
            Directory dir = directory.poll();
            directory.addAll(directories.children(dir.getId()));
            directories.delete(dir.getId());
        }
    }

    @Override
    public void updateParent(Long id, String parent) {
        directories.updateParent(id, parent);
    }

    @Override
    public List<Directory> children(String id) {
       return directories.children(id);
    }

    @Override
    public void create(String parent, String name){
        directories.create(parent, name);
    }

}