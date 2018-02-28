package com.sample.springboot.repo;

import com.sample.springboot.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by PRGA on 2/28/2018.
 */
public interface IUserRepo extends ElasticsearchRepository<User, String>{

    List<User> findByName(String name);

}
