package com.max.service;

import com.max.bean.Cloth;
import com.max.utils.BusinessException;

import java.util.List;

public interface ClothService {
    public List<Cloth> list() throws BusinessException;
    public Cloth findById(String cid) throws BusinessException;
    public void update() throws BusinessException;
}
