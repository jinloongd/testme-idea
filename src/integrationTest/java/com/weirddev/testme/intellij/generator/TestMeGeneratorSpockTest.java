package com.weirddev.testme.intellij.generator;

import com.weirddev.testme.intellij.configuration.TestMeConfigPersistent;
import com.weirddev.testme.intellij.template.FileTemplateConfig;
import com.weirddev.testme.intellij.template.TemplateRegistry;
import com.weirddev.testme.intellij.template.context.Language;

/**
 * Date: 24/02/2017
 *
 * @author Yaron Yamin
 */
public class TestMeGeneratorSpockTest extends TestMeGeneratorTestBase {
    public TestMeGeneratorSpockTest() {
        super(TemplateRegistry.SPOCK_MOCKITO_GROOVY_TEMPLATE, "testSpock", Language.Groovy);
        expectedTestClassExtension = "groovy";
        skipTestIfGroovyPluginDisabled();
    }
    public void testBean() throws Exception{
        doTest();
    }
    public void testCtorOverProps() throws Exception{
        doTest(true,true,true);
    }

    public void testGenerics() throws Exception{
        doTest(true,true,true);
    }
    public void testMockReturned() throws Exception {
        doTest(new FileTemplateConfig(TestMeConfigPersistent.getInstance().getState()));
    }

    public void testMockFieldsInDependencyInjection() {
        doTest(new FileTemplateConfig(TestMeConfigPersistent.getInstance().getState()));
    }

    public void testMockFieldsInDiWithSetter() {
        doTest(new FileTemplateConfig(TestMeConfigPersistent.getInstance().getState()));
    }

    public void testMockFieldsInDiWithCtor() {
        doTest(new FileTemplateConfig(TestMeConfigPersistent.getInstance().getState()));
    }
}
