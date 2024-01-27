package com.weirddev.testme.intellij.utils

import org.junit.Test

/**
 * Date: 03/03/2017
 * @author Yaron Yamin
 */
class ClassNameUtilsTest {

    @Test
    void testIsArray() {
        assert !ClassNameUtils.isArray("canonicalName")
    }
    @Test
    void testVarargsFalse() {
        assert !ClassNameUtils.isVarargs("canonicalName..")
    }
    @Test
    void testVarargsTrue() {
        assert ClassNameUtils.isVarargs("com.median.canonicalName...")
    }

    @Test
    void testExtractClassName() {
        assert "Set" ==  new ClassNameUtils().extractClassName("java.util.Set")
    }

    @Test
    void testExtractPackageName() {
        assert ClassNameUtils.extractPackageName("java.util.Set") == "java.util"
    }
    @Test
    void testExtractPackageNameWhenNull() {
        assert ClassNameUtils.extractPackageName(null) == null
    }

    @Test
    void testStripArrayVarargsDesignator() {
        String result = ClassNameUtils.stripArrayVarargsDesignator("typeName")
        assert result == "typeName"
    }
    @Test
    void testStripArrayVarargsDesignatorRemoveArray() {
        String result = ClassNameUtils.stripArrayVarargsDesignator("typeName[]")
        assert result == "typeName"
    }
    @Test
    void testStripArrayVarargsDesignatorRemoveVarargs() {
        String result = ClassNameUtils.stripArrayVarargsDesignator("typeName...")
        assert result == "typeName"
    }

    @Test
    void testExtractContainerType() {
        String result = ClassNameUtils.extractContainerType("Set<Something>")
        assert result == "Set"
    }

    @Test
    void testExtractTargetPropertyNameForSetter() {
        String result = ClassNameUtils.extractTargetPropertyName("setMyName", true, false)
        assert result == "myName"
    }
    @Test
    void testExtractTargetPropertyNameForGetter() {
        String result = ClassNameUtils.extractTargetPropertyName("getMyName", false, true)
        assert result == "myName"
    }
    @Test
    void testExtractTargetPropertyNameForIsGetter() {
        String result = ClassNameUtils.extractTargetPropertyName("isMyName", false, true)
        assert result == "myName"
    }

    @Test
    void testRemoveFromCamelCaseName() {
        String result = ClassNameUtils.removeFromCamelCaseName("setMyName", "set")
        assert result == "myName"
    }
    @Test
    void testRemoveFromCamelCaseNameReturnNullWhenInvalid() {
        String result = ClassNameUtils.removeFromCamelCaseName("set", "set")
        assert result == null
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme