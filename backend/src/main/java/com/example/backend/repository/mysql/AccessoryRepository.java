package com.example.backend.repository.mysql;

import com.example.backend.pojo.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface AccessoryRepository extends JpaRepository<Accessory, String> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE ACCESSORY SET ANAME=?1 WHERE ID=?2", nativeQuery = true)
    void changeAccessoryById(String name, int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM ACCESSORY WHERE ID=?1", nativeQuery = true)
    void deleteByAccessoryId(int id);
}
