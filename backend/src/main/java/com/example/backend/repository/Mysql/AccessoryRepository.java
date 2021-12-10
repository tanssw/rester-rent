package com.example.backend.repository.Mysql;

import com.example.backend.pojo.Mysql.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface AccessoryRepository extends JpaRepository<Accessory, String> {

    @Query(value = "SELECT * FROM ACCESSORY WHERE ANAME=?1", nativeQuery = true)
    Accessory findByAccessoryName(String name);

    @Query(value = "SELECT * FROM ACCESSORY WHERE ID=?1", nativeQuery = true)
    Accessory findByAccessoryId(int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ACCESSORY SET ANAME=?1, QUANTITY=?2 WHERE ID=?3", nativeQuery = true)
    void changeAccessoryById(String name, int quantity, int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM ACCESSORY WHERE ID=?1", nativeQuery = true)
    void deleteByAccessoryId(int id);
}
