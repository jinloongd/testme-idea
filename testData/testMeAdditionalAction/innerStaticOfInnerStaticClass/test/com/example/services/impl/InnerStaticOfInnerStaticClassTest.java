package com.example.services.impl;

import org.junit.Test;

/**
 * created by TestMe integration test on MMXVI
 */
public class InnerStaticOfInnerStaticClassTest {
    Foo.InnerStaticClass.InnerStaticOfInnerStaticClass innerStaticOfInnerStaticClass = new Foo.InnerStaticClass.InnerStaticOfInnerStaticClass();

    @Test
    public void testMethodOfInnerOfInnerClass() throws Exception {
        innerStaticOfInnerStaticClass.methodOfInnerOfInnerClass();
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme