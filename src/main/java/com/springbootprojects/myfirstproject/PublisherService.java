package com.springbootprojects.myfirstproject;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public PublisherService(PublisherRepository publisherRepository, PublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    public List<PublisherResponseDto> findAllPublishers() {
        return publisherRepository.findAll()
            .stream()
            .map(publisherMapper::publisherToDtoResponse)
            .collect(Collectors.toList());
    }

    public PublisherResponseDto findPublisherById(Integer id) {
        var publisher = publisherRepository.findById(id)
            .orElse(null);

        if (publisher == null) {
            return new PublisherResponseDto(null);
        }

        return publisherMapper.publisherToDtoResponse(publisher);
    }

    public PublisherResponseDto createPublisher(PublisherDto publisherDto) {
        var publisher = publisherMapper.dtoToPublisher(publisherDto);
        publisherRepository.save(publisher);
        return publisherMapper.publisherToDtoResponse(publisher);
    }

    public String deletePublisher(Integer id) {
        publisherRepository.deleteById(id);
        return "The publisher with id "+id+" was deleted";
    }
}
