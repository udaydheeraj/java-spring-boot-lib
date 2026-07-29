package com.mnt.library.service;

import com.mnt.library.entity.Publisher;

import java.util.List;

public interface PublisherService {
    void save(Publisher publisher);
    public Publisher getPublisherById(Integer id);

    public List<Publisher> findAll();

    public void updatePublisher(Publisher publisher);

    public void deleteById(Integer id);

}
