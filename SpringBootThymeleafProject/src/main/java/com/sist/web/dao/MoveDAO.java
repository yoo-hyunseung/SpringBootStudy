package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.MoveEntity;

@Repository
public interface MoveDAO extends JpaRepository<MoveEntity, Integer>{
	@Query(value = "select * from MOVE_DETAIL where address like concat('%',:address,'%')"
			+ " order by mno asc limit :start ,8",nativeQuery=true)
	public List<MoveEntity> moveFindListData(@Param("address") String address,@Param("start") Integer start);
	
	@Query(value="select ceil(count(*)/8.0) from MOVE_DETAIL where address like concat('%',:address,'%')",
			nativeQuery=true)
	public int moveFindTotalPage(@Param("address") String address);
	
}
