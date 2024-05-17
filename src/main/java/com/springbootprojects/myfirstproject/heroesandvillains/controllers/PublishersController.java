package com.springbootprojects.myfirstproject.heroesandvillains.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.springbootprojects.myfirstproject.PublisherDto;
import com.springbootprojects.myfirstproject.PublisherResponseDto;
import com.springbootprojects.myfirstproject.PublisherService;

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

    private final PublisherService publisherService;

    public PublishersController(
        PublisherService publisherService
    ) {
        this.publisherService = publisherService;
    }

    @GetMapping()
    public List<PublisherResponseDto> findAllPublishers() {
        return publisherService.findAllPublishers();
    }
    
    @GetMapping("id/{publisher-id}")
    public PublisherResponseDto findPublisherById(
        @PathVariable("publisher-id") Integer id
    ) {
        return publisherService.findPublisherById(id);
    }

    @PostMapping()
    public PublisherResponseDto createPublisher(
        @RequestBody PublisherDto publisherDto
    ) {
        return publisherService.createPublisher(publisherDto);
    }
    
    @DeleteMapping("id/publisher-id")
    public String deletePublisher(
        @PathVariable("publisher-id") Integer id
    ) {
        return publisherService.deletePublisher(id);
    }
}
