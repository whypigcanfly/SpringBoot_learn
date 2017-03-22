package com.server.v1.model.mapper.dao;

import com.server.v1.model.table.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by wanghaoyang on 17-3-21.
 */
public interface UserInfoDao extends JpaRepository<UserInfo, Long> {

   List<UserInfo> findByUsername(String name);
}
