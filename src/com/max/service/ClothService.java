package com.max.service;

import com.max.bean.Cloth;
import com.max.utils.BusinessException;

import java.util.List;

public interface ClothService {
    public List<Cloth> list() throws BusinessException;
}
