package com.owen.mapper;

import com.owen.model.BlogEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by huang_b on 2017/9/4.
 */
@CacheConfig(cacheNames = "blogdata")
public interface BlogMapper {
    @Select("SELECT * FROM Blogs")
    @Results({
            @Result(property = "Title", column = "Title"),
            @Result(property = "Content", column = "Content")
    })
    List<BlogEntity> getAll();

    @Cacheable(key = "#p0")
    @Select("SELECT * FROM Blogs WHERE id = #{id}")
    @Results({
            @Result(property = "Title", column = "Title"),
            @Result(property = "Content", column = "Content")
    })
    BlogEntity getOne(String id);

    @CachePut(key = "#p0.id")
    @Insert("INSERT INTO Blogs(id,Title,Content) VALUES(#{id},#{Title}, #{Content})")
    void insert(BlogEntity entity);

    @Update("UPDATE Blogs SET Title=#{Title},Content=#{Content} WHERE id =#{id}")
    void update(BlogEntity entity);

    @Delete("DELETE FROM Blogs WHERE id =#{id}")
    void delete(String id);
}
