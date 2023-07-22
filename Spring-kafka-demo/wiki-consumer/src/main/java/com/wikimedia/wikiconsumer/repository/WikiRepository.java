package com.wikimedia.wikiconsumer.repository;

import com.wikimedia.wikiconsumer.entity.WikiDataEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiRepository extends JpaRepository<WikiDataEvent,Integer> {
}
