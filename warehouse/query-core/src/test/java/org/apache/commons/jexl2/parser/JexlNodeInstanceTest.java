package org.apache.commons.jexl2.parser;

import org.junit.Assert;
import org.junit.Test;

public class JexlNodeInstanceTest {
    
    @Test
    public void testInstanceConstants() {
        assertInstanceNode();
    }
    
    private void assertInstanceNode(JexlNodeInstance instance, Class<? extends JexlNodeInstance> type, int id) {
        JexlNode node = instance.getInstance();
        type.isInstance()
        Assert.assertTrue(node instanceof ty);
    }
}
