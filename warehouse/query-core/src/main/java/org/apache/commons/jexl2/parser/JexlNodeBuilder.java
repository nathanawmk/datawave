package org.apache.commons.jexl2.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class JexlNodeBuilder<T extends JexlNode> {
    
    private final Supplier<T> constructor;
    private final List<Supplier<? extends JexlNode>> children = new ArrayList<>();
    private String image;
    private Object value;
    
    public static <T extends JexlNode> JexlNodeBuilder<T> of(JexlNodeInstance<T> instance) {
        return new JexlNodeBuilder<>(instance.getConstructor());
    }
    
    public static JexlNodeBuilder<ASTJexlScript> ASTJexlScript() {
        return of(JexlNodeInstance.ASTJexlScript);
    }
    
    public static JexlNodeBuilder<ASTBlock> ASTBlock() {
        return of(JexlNodeInstance.ASTBlock);
    }
    
    public static JexlNodeBuilder<ASTAmbiguous> ASTAmbiguous() {
        return of(JexlNodeInstance.ASTAmbiguous);
    }
    
    public static JexlNodeBuilder<ASTIfStatement> ASTIfStatement() {
        return of(JexlNodeInstance.ASTIfStatement);
    }
    
    public static JexlNodeBuilder<ASTWhileStatement> ASTWhileStatement() {
        return of(JexlNodeInstance.ASTWhileStatement);
    }
    
    public static JexlNodeBuilder<ASTForeachStatement> ASTForeachStatement() {
        return of(JexlNodeInstance.ASTForeachStatement);
    }
    
    public static JexlNodeBuilder<ASTReturnStatement> ASTReturnStatement() {
        return of(JexlNodeInstance.ASTReturnStatement);
    }
    
    public static JexlNodeBuilder<ASTAssignment> ASTAssignment() {
        return of(JexlNodeInstance.ASTAssignment);
    }
    
    public static JexlNodeBuilder<ASTVar> ASTVar() {
        return of(JexlNodeInstance.ASTVar);
    }
    
    public static JexlNodeBuilder<ASTReference> ASTReference() {
        return of(JexlNodeInstance.ASTReference);
    }
    
    public static JexlNodeBuilder<ASTTernaryNode> ASTTernaryNode() {
        return of(JexlNodeInstance.ASTTernaryNode);
    }
    
    public static JexlNodeBuilder<ASTOrNode> ASTOrNode() {
        return of(JexlNodeInstance.ASTOrNode);
    }
    
    public static JexlNodeBuilder<ASTAndNode> ASTAndNode() {
        return of(JexlNodeInstance.ASTAndNode);
    }
    
    public static JexlNodeBuilder<ASTBitwiseOrNode> ASTBitwiseOrNode() {
        return of(JexlNodeInstance.ASTBitwiseOrNode);
    }
    
    public static JexlNodeBuilder<ASTBitwiseXorNode> ASTBitwiseXorNode() {
        return of(JexlNodeInstance.ASTBitwiseXorNode);
    }
    
    public static JexlNodeBuilder<ASTBitwiseAndNode> ASTBitwiseAndNode() {
        return of(JexlNodeInstance.ASTBitwiseAndNode);
    }
    
    public static JexlNodeBuilder<ASTEQNode> ASTEQNode() {
        return of(JexlNodeInstance.ASTEQNode);
    }
    
    public static JexlNodeBuilder<ASTNENode> ASTNENode() {
        return of(JexlNodeInstance.ASTNENode);
    }
    
    public static JexlNodeBuilder<ASTLTNode> ASTLTNode() {
        return of(JexlNodeInstance.ASTLTNode);
    }
    
    public static JexlNodeBuilder<ASTGTNode> ASTGTNode() {
        return of(JexlNodeInstance.ASTGTNode);
    }
    
    public static JexlNodeBuilder<ASTLENode> ASTLENode() {
        return of(JexlNodeInstance.ASTLENode);
    }
    
    public static JexlNodeBuilder<ASTGENode> ASTGENode() {
        return of(JexlNodeInstance.ASTGENode);
    }
    
    public static JexlNodeBuilder<ASTERNode> ASTERNode() {
        return of(JexlNodeInstance.ASTERNode);
    }
    
    public static JexlNodeBuilder<ASTNRNode> ASTNRNode() {
        return of(JexlNodeInstance.ASTNRNode);
    }
    
    public static JexlNodeBuilder<ASTAdditiveNode> ASTAdditiveNode() {
        return of(JexlNodeInstance.ASTAdditiveNode);
    }
    
    public static JexlNodeBuilder<ASTAdditiveOperator> ASTAdditiveOperator() {
        return of(JexlNodeInstance.ASTAdditiveOperator);
    }
    
    public static JexlNodeBuilder<ASTMulNode> ASTMulNode() {
        return of(JexlNodeInstance.ASTMulNode);
    }
    
    public static JexlNodeBuilder<ASTDivNode> ASTDivNode() {
        return of(JexlNodeInstance.ASTDivNode);
    }
    
    public static JexlNodeBuilder<ASTModNode> ASTModNode() {
        return of(JexlNodeInstance.ASTModNode);
    }
    
    public static JexlNodeBuilder<ASTUnaryMinusNode> ASTUnaryMinusNode() {
        return of(JexlNodeInstance.ASTUnaryMinusNode);
    }
    
    public static JexlNodeBuilder<ASTBitwiseComplNode> ASTBitwiseComplNode() {
        return of(JexlNodeInstance.ASTBitwiseComplNode);
    }
    
    public static JexlNodeBuilder<ASTNotNode> ASTNotNode() {
        return of(JexlNodeInstance.ASTNotNode);
    }
    
    public static JexlNodeBuilder<ASTIdentifier> ASTIdentifier() {
        return of(JexlNodeInstance.ASTIdentifier);
    }
    
    public static JexlNodeBuilder<ASTNullLiteral> ASTNullLiteral() {
        return of(JexlNodeInstance.ASTNullLiteral);
    }
    
    public static JexlNodeBuilder<ASTTrueNode> ASTTrueNode() {
        return of(JexlNodeInstance.ASTTrueNode);
    }
    
    public static JexlNodeBuilder<ASTFalseNode> ASTFalseNode() {
        return of(JexlNodeInstance.ASTFalseNode);
    }
    
    public static JexlNodeBuilder<ASTNumberLiteral> ASTNumberLiteral() {
        return of(JexlNodeInstance.ASTNumberLiteral);
    }
    
    public static JexlNodeBuilder<ASTStringLiteral> ASTStringLiteral() {
        return of(JexlNodeInstance.ASTStringLiteral);
    }
    
    public static JexlNodeBuilder<ASTArrayLiteral> ASTArrayLiteral() {
        return of(JexlNodeInstance.ASTArrayLiteral);
    }
    
    public static JexlNodeBuilder<ASTMapLiteral> ASTMapLiteral() {
        return of(JexlNodeInstance.ASTMapLiteral);
    }
    
    public static JexlNodeBuilder<ASTMapEntry> ASTMapEntry() {
        return of(JexlNodeInstance.ASTMapEntry);
    }
    
    public static JexlNodeBuilder<ASTEmptyFunction> ASTEmptyFunction() {
        return of(JexlNodeInstance.ASTEmptyFunction);
    }
    
    public static JexlNodeBuilder<ASTSizeFunction> ASTSizeFunction() {
        return of(JexlNodeInstance.ASTSizeFunction);
    }
    
    public static JexlNodeBuilder<ASTFunctionNode> ASTFunctionNode() {
        return of(JexlNodeInstance.ASTFunctionNode);
    }
    
    public static JexlNodeBuilder<ASTMethodNode> ASTMethodNode() {
        return of(JexlNodeInstance.ASTMethodNode);
    }
    
    public static JexlNodeBuilder<ASTSizeMethod> ASTSizeMethod() {
        return of(JexlNodeInstance.ASTSizeMethod);
    }
    
    public static JexlNodeBuilder<ASTConstructorNode> ASTConstructorNode() {
        return of(JexlNodeInstance.ASTConstructorNode);
    }
    
    public static JexlNodeBuilder<ASTArrayAccess> ASTArrayAccess() {
        return of(JexlNodeInstance.ASTArrayAccess);
    }
    
    public static JexlNodeBuilder<ASTReferenceExpression> ASTReferenceExpression() {
        return of(JexlNodeInstance.ASTReferenceExpression);
    }
    
    public static JexlNodeBuilder<?> booleanEquivalent(boolean value) {
        return value ? ASTTrueNode() : ASTFalseNode();
    }
    
    private JexlNodeBuilder(Supplier<T> constructor) {
        this.constructor = constructor;
    }

    public JexlNodeBuilder<T> withImage(String image) {
        this.image = image;
        return this;
    }
    
    public JexlNodeBuilder<T> withValue(Object value) {
        this.value = value;
        return this;
    }
    
    public JexlNodeBuilder<T> withChild(JexlNodeBuilder<? extends JexlNode> builder) {
        children.add(builder::build);
        return this;
    }
    
    public T build() {
        T node = constructor.get();
        node.image = this.image;
        node.jjtSetValue(value);
        JexlNode[] childArray = children.stream().map(Supplier::get).toArray(JexlNode[]::new);
        for (JexlNode child : childArray) {
            child.jjtSetParent(node);
        }
        node.children = childArray;
        return node;
    }
}
