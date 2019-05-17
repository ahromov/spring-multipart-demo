package ua.lviv.lgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.lgs.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
