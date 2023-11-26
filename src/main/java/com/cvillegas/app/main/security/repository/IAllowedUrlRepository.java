package com.cvillegas.app.main.security.repository;

import com.cvillegas.app.main.security.model.AllowedUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IAllowedUrlRepository extends JpaRepository<AllowedUrl, String> {
}
