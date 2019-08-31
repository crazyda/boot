package com.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.demo.entity.Person;

/**
 * 	 表名和实体的名字一定要一致  一定要注意大小写
 * @ClassName: PersonRepository
 * @Description: 
 * @Author Crazy
 * @DateTime 2019年8月31日 下午4:28:22
 */
//对映射进行修改得
@RepositoryRestResource(path="people")
public interface PersonRepository extends JpaRepository<Person,Long>{ // 使用jpa 必须继承该接口
	List<Person> findByAddress(String address);
	
	Person findByNameAndAddress(String name,String address);
	
	@Query("select p from Person p where p.name= :name and p.address= :address")
	Person withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);
	
	@Query("select p from Person p where p.name= :name and p.address= :address")
	Person withNameAndAddressNamedQuery(String name,String address);
	
	@Transactional
	@Modifying	// 组合使用更新查询 
	@Query("update Person p set p.name=?1")
	int setName(String name);
	
	// 作为rest 风格 暴露
	@RestResource(path="nameStartsWith",rel="nameStartsWith")
	List<Person> findByNameStartsWith(String name);
	
	
}
