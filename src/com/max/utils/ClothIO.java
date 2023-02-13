package com.max.utils;

import com.max.bean.Cloth;

import java.util.ArrayList;
import java.util.List;

public class ClothIO {
    private static List<Cloth> list = new ArrayList<>();
    public Cloth findClothById(String cid) throws BusinessException{
        if(list.size() == 0){
            list = ProductXMLUtils.parserProductFormXml();
        }
        String id;
        for(Cloth c:list){
            System.out.println(c.getId());
            id = c.getId();
            if(id.equals(cid)){
                return c;
            }
        }
        return null;
    }
    public List<Cloth> list() throws BusinessException{
        if(list.size() == 0){
            list = ProductXMLUtils.parserProductFormXml();
        }
        return list;
    }

    public void update() throws BusinessException{
        ProductXMLUtils.writeProductToXML(list);
    }
}
