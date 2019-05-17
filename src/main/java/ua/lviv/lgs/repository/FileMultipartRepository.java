package ua.lviv.lgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.model.Photo;

@Repository
public interface FileMultipartRepository extends JpaRepository<Photo, String> {
}
