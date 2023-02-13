package com.max.service.impl;

import com.max.bean.Cloth;
import com.max.service.ClothService;
import com.max.utils.BusinessException;
import com.max.utils.ClothIO;

import java.util.List;

public class ClothServiceImpl implements ClothService {
    private ClothIO clothIO = new ClothIO();
    @Override
    public List<Cloth> list() throws BusinessException {
        return clothIO.list();

    }

    @Override
    public Cloth findById(String cid) throws BusinessException {
        return clothIO.findClothById(cid);
    }

    public void update() throws BusinessException{
        clothIO.update();
    }

}
