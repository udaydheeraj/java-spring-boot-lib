package com.mnt.library.repository;

import com.mnt.library.entity.Category;
import com.mnt.library.entity.Publisher;

import java.util.List;

public interface PublisherRepository {
    void save(Publisher publisher);

    Publisher findById(Integer id);

    List<Publisher> findAll();

    void update(Publisher publisher);

    void deleteById(Publisher publisher);
}
