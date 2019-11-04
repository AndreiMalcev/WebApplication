package com.example.WebApplication.DAO;


import com.example.WebApplication.Entity.Directory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Repository
public interface ExplorerRepository extends JpaRepository<Directory, Long> {

    @Query(value = "SELECT * FROM EXPLORER WHERE parent = :parent", nativeQuery = true)
    List<Directory> children(@Param("parent") String parent);


    @Query(value = "SELECT * FROM EXPLORER WHERE parent =TO_CHAR(:id)", nativeQuery = true)
    LinkedList<Directory> children(@Param("id") Long id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO EXPLORER(parent, text, children) values(:parent, :name, TRUE)", nativeQuery = true)
    void create( @Param("parent") String parent, @Param("name") String name);


    @Modifying
    @Transactional
    @Query(value = "UPDATE EXPLORER SET parent = :parent WHERE id = :id", nativeQuery = true)
    void updateParent(@Param("id")Long id,@Param("parent") String parent);


    @Modifying
    @Transactional
    @Query(value = "UPDATE EXPLORER SET EXPLORER.text = :name WHERE id = :id", nativeQuery = true)
    void rename(@Param("id")Long id,@Param("name") String name);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM EXPLORER WHERE id = :id", nativeQuery = true)
    void delete(@Param("id") Long id);
}