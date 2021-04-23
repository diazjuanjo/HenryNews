package com.henry.base.controller;

import com.henry.base.model.News;
import com.henry.base.model.PaginationResponse;
import com.henry.base.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping
    @Operation(summary = "add new")
    public String addNew(@RequestBody News objNew){
        News newNew = newsService.addNew(objNew);
        return ("New created: " + newNew);
    }

    @PutMapping("/{id}/writer/{writerID}")
    @Operation(summary = "add a writer to a new")
    private String addWriter(@PathVariable Integer id, @PathVariable Integer writerID){
        newsService.addWriter(id, writerID);
        return ("Added a writer by id: " + writerID);
    }

    @GetMapping
    @Operation(summary = "All news paginated")
    public PaginationResponse<News> getAll(@RequestParam(value = "size", defaultValue = "20") Integer size,
                                           @RequestParam(value = "page", defaultValue = "0") Integer page){
        return newsService.getAll(page,size);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a new by id")
    public String deleteNew(@PathVariable Integer id){
        newsService.deleteWriterById(id);
        return ("New deleted by id: " + id);
    }

}
