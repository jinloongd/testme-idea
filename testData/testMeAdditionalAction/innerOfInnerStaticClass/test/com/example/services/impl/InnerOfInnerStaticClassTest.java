package com.example.services.impl;

import org.junit.Test;

/**
 * created by TestMe integration test on MMXVI
 */
public class InnerOfInnerStaticClassTest {
    Foo.InnerStaticClass.InnerOfInnerStaticClass innerOfInnerStaticClass = new Foo.InnerStaticClass().new InnerOfInnerStaticClass();

    @Test
    public void testMethodOfInnerOfInnerClass() throws Exception {
        innerOfInnerStaticClass.methodOfInnerOfInnerClass();
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme