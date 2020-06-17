package test;

import cyber.guru.Product;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void analyseString() {
String actual = Product.analyseString("Analyse this string");
        Assert.assertEquals("123",null);
    }


}