package com.tom.db.repository;

import com.tom.db.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "userDataRepository")
public interface IUserDataRepository extends JpaRepository<UserData, Long> {
}
