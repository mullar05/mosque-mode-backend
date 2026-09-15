package com.malik.mosquemode.repository;

import com.malik.mosquemode.entity.Mosque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MosqueRepository
        extends JpaRepository<Mosque, Long> {
}