package cn.kgc.service.impl;

import cn.kgc.dao.TakeoutMapper;
import cn.kgc.domain.Takeout;
import cn.kgc.service.TakeOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TakeOutImpl implements TakeOutService {
    @Autowired
    private TakeoutMapper takeoutMapper;

    @Override
    public int insertIntoTakeOut(Takeout takeout) {
        return takeoutMapper.insertSelective(takeout);
    }
}
