package com.mnt.library.controller;

import com.mnt.library.entity.Category;
import com.mnt.library.entity.Publisher;
import com.mnt.library.service.PublisherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public void savePublisher(Publisher publisher)
    {
        publisherService.save(publisher);
    }

    @GetMapping("/{id}")
    public Publisher getPublisherById( @PathVariable Integer id)
    {
        return publisherService.getPublisherById(id);
    }

    @GetMapping
    public List<Publisher> getAllPublishers()
    {
        return publisherService.findAll();
    }

    @PutMapping("/{id}")
    public void updatePublisher(Publisher publisher,@PathVariable Integer id)
    {
        publisherService.updatePublisher(publisher);
    }

    @DeleteMapping("/{id}")
    public void deletePublisherById(@PathVariable Integer id)
    {
        publisherService.deleteById(id);
    }
}
