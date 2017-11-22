package com.owen.mapper;

import com.owen.model.BlogEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by huang_b on 2017/9/4.
 */
public interface BlogMapper {
    @Select("SELECT * FROM Blogs")
    @Results({
            @Result(property = "Title", column = "Title"),
            @Result(property = "Content", column = "Content")
    })
    List<BlogEntity> getAll();

    @Select("SELECT * FROM Blogs WHERE id = #{id}")
    @Results({
            @Result(property = "Title", column = "Title"),
            @Result(property = "Content", column = "Content")
    })
    BlogEntity getOne(String id);

    @Insert("INSERT INTO Blogs(id,Title,Content) VALUES(#{id},#{Title}, #{Content})")
    void insert(BlogEntity entity);

    @Update("UPDATE Blogs SET Title=#{Title},Content=#{Content} WHERE id =#{id}")
    void update(BlogEntity entity);

    @Delete("DELETE FROM Blogs WHERE id =#{id}")
    void delete(Long id);
}
