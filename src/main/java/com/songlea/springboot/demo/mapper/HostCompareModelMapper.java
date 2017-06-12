package com.songlea.springboot.demo.mapper;

import com.songlea.springboot.demo.model.HostCompareModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * HostCompareModelMapper
 *
 * @author Song Lea
 */
@Repository // @Repository注解非必须,@Mapper注解也会生成对应的bean,这里加上只是为了IDEA的代码检查
@Mapper
public interface HostCompareModelMapper {

    // 必须加@Param注解,否则配置文件中找不到这个参数
    List<HostCompareModel> selectHostCompareByCondition(@Param("name") String name, @Param("compareStatus") String compareStatus,
                                                        @Param("startTime") String startTime, @Param("endTime") String endTime,
                                                        @Param("sort") String sort, @Param("order") String order);
}
