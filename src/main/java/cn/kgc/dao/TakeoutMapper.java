package cn.kgc.dao;

import cn.kgc.domain.Takeout;
import cn.kgc.domain.TakeoutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TakeoutMapper {
    int countByExample(TakeoutExample example);

    int deleteByExample(TakeoutExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Takeout record);

    int insertSelective(Takeout record);

    List<Takeout> selectByExample(TakeoutExample example);

    Takeout selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Takeout record, @Param("example") TakeoutExample example);

    int updateByExample(@Param("record") Takeout record, @Param("example") TakeoutExample example);

    int updateByPrimaryKeySelective(Takeout record);

    int updateByPrimaryKey(Takeout record);
}