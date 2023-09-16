package mainpackage;

import mainpackage.files.interceptors.Audited;
import mainpackage.files.interceptors.AuditedInterceptor;
import mainpackage.files.service.AuditService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestInterceptor {
    Weld weld;
    WeldContainer container;

    @Before
    public void init() {
        weld = new Weld();
        container = weld.initialize();
    }

    @After
    public void shutdown() {
        weld.shutdown();
    }

    @Test
    public void givenTheService_whenMethodAndInterceptorExecuted_thenOK() {
        AuditService auditService = container.select(AuditService.class).get();
        String code = "123456";
        auditService.deliverService(code);

        Assert.assertTrue(AuditedInterceptor.calledBefore);
        Assert.assertTrue(AuditedInterceptor.calledAfter);
    }
}