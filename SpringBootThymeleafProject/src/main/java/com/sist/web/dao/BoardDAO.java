package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.BoardEntity;
@Repository
public interface BoardDAO extends JpaRepository<BoardEntity, Integer>{
	@Query(value="select * from board order by no desc limit :start ,10", nativeQuery=true)
	public List<BoardEntity> boardListData(int start);
	
	@Query(value="select ceil(count(*)/10) from board", nativeQuery=true)
	public int boardTotalPage();
	
	public BoardEntity findByNo(int no);
}
