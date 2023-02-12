package com.max.service.impl;

import com.max.bean.Cloth;
import com.max.service.ClothService;
import com.max.utils.BusinessException;
import com.max.utils.ProductXMLUtils;

import java.util.List;

public class ClothServiceImpl implements ClothService {
    @Override
    public List<Cloth> list() throws BusinessException {
        List <Cloth> clothes = ProductXMLUtils.parserProductFormXml();
        return clothes;
    }

}
