package com.zagradio.me.zagradio_me_back.repository;

import com.zagradio.me.zagradio_me_back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User findUserById(@Param("id") long id);

    @Query("DELETE FROM User r WHERE r.id = :id")
    User deleteUserById(@Param("id") long id);
}
