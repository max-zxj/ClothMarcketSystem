package com.max.test;

import com.max.bean.Cloth;
import com.max.utils.ProductXMLUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ProductsXMLTest {
    @Test
    public void test(){
        List<Cloth> products = ProductXMLUtils.parserProductFormXml();
        System.out.println(Arrays.toString(products.toArray()));
    }
}
