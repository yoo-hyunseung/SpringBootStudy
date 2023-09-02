package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.EstateEntity;
import java.util.*;


@Repository
public interface EstateDAO extends JpaRepository<EstateEntity,Integer>{
	@Query(value="select * from estate_detail order by rand() limit 7",nativeQuery=true)
	public List<EstateEntity> estateHomeData();
	
	@Query(value="select * from estate_detail where type=:type order by rand() limit 5",nativeQuery=true)
	public List<EstateEntity> estateComData(@Param("type") String type);
	
	@Query(value="select * from estate_detail where etype=:etype order by no limit :start ,8",nativeQuery=true)
	public List<EstateEntity> estateTypeListData(@Param("etype")Integer etype,@Param("start")Integer start);
	
	@Query(value="select ceil(count(*)/8.0) from estate_detail where etype=:etype" ,nativeQuery=true)
	public int estateTypeTotalPage(int etype);
}
