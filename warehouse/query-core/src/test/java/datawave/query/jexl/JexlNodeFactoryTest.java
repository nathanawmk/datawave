package datawave.query.jexl;

import datawave.query.jexl.visitors.JexlStringBuildingVisitor;
import org.apache.commons.jexl2.parser.ASTAssignment;
import org.apache.commons.jexl2.parser.ASTFalseNode;
import org.apache.commons.jexl2.parser.ASTIdentifier;
import org.apache.commons.jexl2.parser.ASTTrueNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class JexlNodeFactoryTest {
    
    @Test
    public void testShallowCopy() {
        assertThrows(IllegalArgumentException.class, () -> JexlNodeFactory.shallowCopy(null));
        
        assertEquals();
    }
    
    @Test
    public void testBuildIdentifier() {
        ASTIdentifier node = JexlNodeFactory.buildIdentifier("FOO");
        assertEquals(node.image, "FOO");
        JexlASTHelper.validateLineage(node, true);
    
        ASTIdentifier invalidIdentifierNode = JexlNodeFactory.buildIdentifier("%FOO");
        assertEquals(invalidIdentifierNode.image, "$%FOO");
        JexlASTHelper.validateLineage(invalidIdentifierNode, true);
    }
    
    @Test
    public void testCreateAssignmentWithBooleanValue() {
        ASTAssignment trueNode = JexlNodeFactory.createAssignment("FOO", true);
        assertEquals("(FOO = true)", JexlStringBuildingVisitor.buildQuery(trueNode));
        assertTrue(trueNode.jjtGetChild(1) instanceof ASTTrueNode);
        JexlASTHelper.validateLineage(trueNode, true);
    
        ASTAssignment falseNode = JexlNodeFactory.createAssignment("FOO", false);
        assertEquals("(FOO = false)", JexlStringBuildingVisitor.buildQuery(falseNode));
        assertTrue(falseNode.jjtGetChild(1) instanceof ASTFalseNode);
        JexlASTHelper.validateLineage(falseNode, true);
    }
    
    @Test
    public void testCreateAssignmentWithStringValue() {
        ASTAssignment node = JexlNodeFactory.createAssignment("FOO", "a");
        assertEquals("(FOO = 'a')", JexlStringBuildingVisitor.buildQuery(node));
        JexlASTHelper.validateLineage(node, true);
    }
}
