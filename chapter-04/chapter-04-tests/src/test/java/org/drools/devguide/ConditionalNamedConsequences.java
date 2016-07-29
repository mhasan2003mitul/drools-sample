package org.drools.devguide;

import org.junit.Test;
import org.kie.api.runtime.KieSession;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 19-Jul-16.
 */
public class ConditionalNamedConsequences extends  BaseTest{

    protected final String ksessionName = "ruleConditionalNamedConsequencesKsession";

    @Test
    public void testConditionalNamedConsequences()

    {
        KieSession ksession = createSession(ksessionName);

        ksession.insert(new String("A"));
        //so the rule should fire for only one of the orders
        int firedRules = ksession.fireAllRules();
        assertThat(1, equalTo(firedRules));

        ksession.insert(new Integer(3));
        firedRules = ksession.fireAllRules();
        assertThat(1, equalTo(firedRules));

    }
}
