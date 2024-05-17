package com.springbootprojects.myfirstproject.publisher;

import org.springframework.stereotype.Service;

@Service
public class PublisherMapper {

    public Publisher dtoToPublisher(PublisherDto publisherDto) {
        var publisher = new Publisher();

        publisher.setName(publisherDto.name());
        publisher.setFoundationYear(publisherDto.foundationYear());

        return publisher;
    }

    public PublisherResponseDto publisherToDtoResponse(Publisher publisher) {
        var publisherResponseDto = new PublisherResponseDto(
            publisher.getName()
        );
        return publisherResponseDto;
    }
}
