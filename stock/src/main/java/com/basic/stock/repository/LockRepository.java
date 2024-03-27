package com.basic.stock.repository;

import com.basic.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LockRepository extends JpaRepository<Stock, Long> {
    // 락를 가져오는거
    @Query(value ="select get_lock(:key, 3000)")
    void getLock(String key);

    // 락 해제 => 점유시간이 끝났을때 , 서비스 사용완료했을때
    @Query(value = "select release_lock(:key)")
    void releaseLock(String key);
}
