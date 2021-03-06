package org.survey.service.poll;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.survey.config.ServiceTestConfig;

import javax.xml.ws.soap.SOAPFaultException;

/**
 * Test PersonManagement using WebService. Spring injects userService with
 * WebService. Must use SpringJUnit4ClassRunner to enable spring injection.
 * Loaded Spring configuration is defined by ContextConfiguration.
 */
//@Ignore("re-write the service tests so that they do not use repositories")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy(@ContextConfiguration(classes = ServiceTestConfig.class))
public class PollServiceIT extends PollServiceTestBase {
    /**
     * Override method because expected exception is wrapped in
     * SOAPFaultException in WebService.
     */
    @Test
    @Override
    public void existsWithNull() {
        super.existsWithNull();
    }

    /**
     * Override method because expected exception is wrapped in
     * SOAPFaultException in WebService.
     */
    @Test
    @Override
    public void createWithError() {
        try {
            create();
            entityService.create(orginalEntities.get(0));
        } catch (SOAPFaultException e) {
            Assert.assertTrue(e.getMessage()
                    .startsWith("Poll already exists: "));
        }
    }
}
