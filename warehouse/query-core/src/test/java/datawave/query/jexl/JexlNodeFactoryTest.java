package datawave.query.jexl;

import datawave.query.jexl.visitors.JexlStringBuildingVisitor;
import datawave.query.jexl.visitors.TreeEqualityVisitor;
import org.apache.commons.jexl2.parser.ASTAssignment;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JexlNodeFactoryTest {
    
    @Test
    public void testCreateAssignment() {
        ASTAssignment node = JexlNodeFactory.createAssignment("FOO", "a");
        assertEquals("(FOO = 'a')", JexlStringBuildingVisitor.buildQuery(node));
        JexlASTHelper.validateLineage(node, true);
    
        ASTAssignment node2 = JexlNodeFactory.createAssignmentAlternative("FOO", "a");
        assertEquals("(FOO = 'a')", JexlStringBuildingVisitor.buildQuery(node2));
        JexlASTHelper.validateLineage(node2, true);
    
        TreeEqualityVisitor.Comparison comparison = TreeEqualityVisitor.checkEquality(node, node2);
        assertTrue(comparison.getReason(), comparison.isEqual());
    }
    
}
