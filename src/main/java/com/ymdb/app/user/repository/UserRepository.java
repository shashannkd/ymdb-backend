package com.ymdb.app.user.repository;


import com.ymdb.app.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Long removeUserByUserId(String userId);

}
