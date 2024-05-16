package com.springbootprojects.myfirstproject.heroesandvillains.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.springbootprojects.myfirstproject.Publisher;
import com.springbootprojects.myfirstproject.PublisherDto;
import com.springbootprojects.myfirstproject.PublisherRepository;
import com.springbootprojects.myfirstproject.PublisherResponseDto;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<PublisherResponseDto> findAllPublishers() {
        return publisherRepository.findAll()
            .stream()
            .map(this::publisherToDto)
            .collect(Collectors.toList());
    }
    
    @GetMapping("id/{publisher-id}")
    public Publisher findPublisherById(
        @PathVariable("publisher-id") Integer id
    ) {
        return publisherRepository.findById(id)
            .orElse(null);
    }

    @PostMapping()
    public PublisherResponseDto createPublisher(
        @RequestBody PublisherDto publisherDto
    ) {
        var publisher = dtoToPublisher(publisherDto);
        publisherRepository.save(publisher);
        return publisherToDto(publisher);
    }

    private Publisher dtoToPublisher(PublisherDto publisherDto) {
        var publisher = new Publisher();

        publisher.setName(publisherDto.name());
        publisher.setFoundationYear(publisherDto.foundationYear());

        return publisher;
    }

    private PublisherResponseDto publisherToDto(Publisher publisher) {
        var publisherResponseDto = new PublisherResponseDto(
            publisher.getName()
        );
        return publisherResponseDto;
    }
    
    @DeleteMapping("id/publisher-id")
    public String deletePublisher(
        @PathVariable("publisher-id") Integer id
    ) {
        publisherRepository.deleteById(id);
        return "The publisher with id "+id+" was deleted";
    }
}
