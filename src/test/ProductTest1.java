package test;

import cyber.guru.Product;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest1 {

    @Test
    public void analyseString1() {
        String actual = Product.analyseString1("Analyse this string");
        Assert.assertEquals("123",actual);
    }
}