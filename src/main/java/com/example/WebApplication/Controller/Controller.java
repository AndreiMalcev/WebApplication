package com.example.WebApplication.Controller;

import com.example.WebApplication.ExplorerService.ExplorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class Controller {

    @Autowired
    private ExplorerService explorerService;

    @GetMapping("/get")
    @ResponseBody
    public List get(@RequestParam("id") String parent) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return explorerService.children(parent);
    }

    @PostMapping("/rename")
    public void rename(@RequestParam("id") Long id, @RequestParam("text") String text) {
        explorerService.rename(id, text);
    }

    @PostMapping("/create")
    public void create(@RequestParam("id") String parent, @RequestParam("text") String text) {
        System.out.println(parent + " " + text);
        explorerService.create(parent, text);
    }

    @PostMapping("/delete")
    public void delete (@RequestParam("id") Long id) {
        explorerService.deleteWithChildren(id);
    }

    @PostMapping("/change")
    public void change(@RequestParam("id") Long id, @RequestParam("newParent") String newParent) {
       explorerService.updateParent(id, newParent);
    }

}
