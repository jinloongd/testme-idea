package com.weirddev.testme.intellij;

import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.openapi.projectRoots.JavaSdk;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.testFramework.LightProjectDescriptor;
import com.intellij.testFramework.fixtures.DefaultLightProjectDescriptor;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * Date: 19/12/2016
 *
 * @author Yaron Yamin
 */
abstract public class BaseIJIntegrationTest extends LightCodeInsightFixtureTestCase {
    private static final String FILE_HEADER_TEMPLATE = "File Header.java";
    private static final String HEADER_TEMPLATE_REPLACEMENT_TEXT = "/** created by TestMe integration test on MMXVI */\n";
    public static final String TEST_ME_WITH_JUNIT4_MOCKITO_JAVA = "TestMe with JUnit4 & Mockito.java";
    public static final String TEST_ME_WITH_JUNIT5_MOCKITO_JAVA = "TestMe with JUnit5 & Mockito.java";
    private static boolean isHeaderTemplateReplaced=false;
    protected final String templateFilename;
    protected final String testDirectory;
    private String testDataRoot;

    public BaseIJIntegrationTest(String templateFilename, String testDirectory, String testDataRoot) {
        this.templateFilename = templateFilename;
        this.testDirectory = testDirectory;
        this.testDataRoot = testDataRoot;
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        System.out.println("TestDataPath:"+getTestDataPath());
        assertTrue(new File(getTestDataPath()).exists());
        System.out.println("temp dir path:"+myFixture.getTempDirPath());
        replacePatternTemplateText(FILE_HEADER_TEMPLATE, HEADER_TEMPLATE_REPLACEMENT_TEXT);
    }

    private void replacePatternTemplateText(String templateName, String templateText) {
        if(isHeaderTemplateReplaced){
            return;
        }
        FileTemplateManager fileTemplateManager = FileTemplateManager.getInstance(getProject());
        FileTemplate headerTemplate = fileTemplateManager.getPattern(templateName);
        System.out.println("headerTemplate:"+headerTemplate);
        System.out.println("Existing header Template text:\n"+headerTemplate.getText());
        System.out.println("Replacing header Template text with:\n"+ templateText);
        headerTemplate.setText(templateText);
        isHeaderTemplateReplaced = true;
    }

    @Override
    protected String getTestDataPath() {
        return testDataRoot +getTestName(true).replace('$', '/');
    }

    @NotNull
    @Override
    protected LightProjectDescriptor getProjectDescriptor() {
        return new DefaultLightProjectDescriptor() {
            @Override
            public Sdk getSdk() {
                return JavaSdk.getInstance().createJdk("java 1.7", new File(System.getProperty("java.home")).getParent(), false);
            }
        };
    }
}
