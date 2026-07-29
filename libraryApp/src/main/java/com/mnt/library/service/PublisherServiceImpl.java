package com.mnt.library.service;

import com.mnt.library.entity.Publisher;
import com.mnt.library.repository.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService{

    PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    @Transactional
    public void save(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public Publisher getPublisherById(Integer id) {
        return publisherRepository.findById(id);
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    @Transactional
    public void updatePublisher(Publisher publisher) {
       //Publisher publisher =  publisherRepository.findById(id);
       // publisher.setPublisherId(id);
        //publisher.setEmail(
        publisherRepository.update(publisher);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Publisher publisher = publisherRepository.findById(id);
        publisherRepository.deleteById(publisher);
    }
}
