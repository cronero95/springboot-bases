package com.springbootprojects.myfirstproject.heroesandvillains.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.springbootprojects.myfirstproject.Publisher;
import com.springbootprojects.myfirstproject.PublisherRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("publishers")
public class PublishersController {
    private final PublisherRepository publisherRepository;

    public PublishersController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @GetMapping()
    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }
    
    @GetMapping("id/{publisher-id}")
    public Publisher findPublisherById(
        @PathVariable("publisher-id") Integer id
    ) {
        return publisherRepository.findById(id)
            .orElse(null);
    }

    @PostMapping()
    public Publisher createPublisher(
        @RequestBody Publisher publisher
    ) {
        return publisherRepository.save(publisher);
    }
    
    @DeleteMapping("id/publisher-id")
    public String deletePublisher(
        @PathVariable("publisher-id") Integer id
    ) {
        publisherRepository.deleteById(id);
        return "The publisher with id "+id+" was deleted";
    }
}
