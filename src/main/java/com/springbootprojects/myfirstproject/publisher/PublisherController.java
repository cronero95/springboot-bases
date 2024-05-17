package com.springbootprojects.myfirstproject.publisher;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(
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
