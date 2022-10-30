package com.quentin.bootdemo.repo;

import com.quentin.bootdemo.dto.MyMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @see CrudRepository
 * @see SimpleJpaRepository 支持事物
 * @author quentin
 * @create 2022-10-19 18:10
 */
public interface MyMsgRepository extends Repository<MyMessage, Long> {
    // TODO 学习lock
//    @Lock(LockModeType.READ)
//    @Query("SELECT msg FROM MyMessage msg WHERE msg.id = ?1")
    MyMessage findById(Long id);

    long count();

    boolean existsById(Long id);

    Page<MyMessage> findAll(Pageable pageable);

    void deleteById(Long id);

    List<MyMessage> findByMsgEndsWith(String subMsg);
}
