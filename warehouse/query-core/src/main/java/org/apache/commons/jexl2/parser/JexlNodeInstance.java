package org.apache.commons.jexl2.parser;

import java.util.function.Supplier;

public class JexlNodeInstance<T extends JexlNode> {
    
    public static final JexlNodeInstance<ASTJexlScript> ASTJexlScript = new JexlNodeInstance<>(() -> new ASTJexlScript(ParserTreeConstants.JJTJEXLSCRIPT));
    public static final JexlNodeInstance<ASTBlock> ASTBlock = new JexlNodeInstance<>(() -> new ASTBlock(ParserTreeConstants.JJTBLOCK));
    public static final JexlNodeInstance<ASTAmbiguous> ASTAmbiguous = new JexlNodeInstance<>(() -> new ASTAmbiguous(ParserTreeConstants.JJTAMBIGUOUS));
    public static final JexlNodeInstance<ASTIfStatement> ASTIfStatement = new JexlNodeInstance<>(() -> new ASTIfStatement(ParserTreeConstants.JJTIFSTATEMENT));
    public static final JexlNodeInstance<ASTWhileStatement> ASTWhileStatement = new JexlNodeInstance<>(() -> new ASTWhileStatement(ParserTreeConstants.JJTWHILESTATEMENT));
    public static final JexlNodeInstance<ASTForeachStatement> ASTForeachStatement = new JexlNodeInstance<>(() -> new ASTForeachStatement(ParserTreeConstants.JJTFOREACHSTATEMENT));
    public static final JexlNodeInstance<ASTReturnStatement> ASTReturnStatement = new JexlNodeInstance<>(() -> new ASTReturnStatement(ParserTreeConstants.JJTRETURNSTATEMENT));
    public static final JexlNodeInstance<ASTAssignment> ASTAssignment = new JexlNodeInstance<>(() -> new ASTAssignment(ParserTreeConstants.JJTASSIGNMENT));
    public static final JexlNodeInstance<ASTVar> ASTVar = new JexlNodeInstance<>(() -> new ASTVar(ParserTreeConstants.JJTVAR));
    public static final JexlNodeInstance<ASTReference> ASTReference = new JexlNodeInstance<>(() -> new ASTReference(ParserTreeConstants.JJTREFERENCE));
    public static final JexlNodeInstance<ASTTernaryNode> ASTTernaryNode = new JexlNodeInstance<>(() -> new ASTTernaryNode(ParserTreeConstants.JJTTERNARYNODE));
    public static final JexlNodeInstance<ASTOrNode> ASTOrNode = new JexlNodeInstance<>(() -> new ASTOrNode(ParserTreeConstants.JJTORNODE));
    public static final JexlNodeInstance<ASTAndNode> ASTAndNode = new JexlNodeInstance<>(() -> new ASTAndNode(ParserTreeConstants.JJTANDNODE));
    public static final JexlNodeInstance<ASTBitwiseOrNode> ASTBitwiseOrNode = new JexlNodeInstance<>(() -> new ASTBitwiseOrNode(ParserTreeConstants.JJTBITWISEORNODE));
    public static final JexlNodeInstance<ASTBitwiseXorNode> ASTBitwiseXorNode = new JexlNodeInstance<>(() -> new ASTBitwiseXorNode(ParserTreeConstants.JJTBITWISEXORNODE));
    public static final JexlNodeInstance<ASTBitwiseAndNode> ASTBitwiseAndNode = new JexlNodeInstance<>(() -> new ASTBitwiseAndNode(ParserTreeConstants.JJTBITWISEANDNODE));
    public static final JexlNodeInstance<ASTEQNode> ASTEQNode = new JexlNodeInstance<>(() -> new ASTEQNode(ParserTreeConstants.JJTEQNODE));
    public static final JexlNodeInstance<ASTNENode> ASTNENode = new JexlNodeInstance<>(() -> new ASTNENode(ParserTreeConstants.JJTNENODE));
    public static final JexlNodeInstance<ASTLTNode> ASTLTNode = new JexlNodeInstance<>(() -> new ASTLTNode(ParserTreeConstants.JJTLTNODE));
    public static final JexlNodeInstance<ASTGTNode> ASTGTNode = new JexlNodeInstance<>(() -> new ASTGTNode(ParserTreeConstants.JJTGTNODE));
    public static final JexlNodeInstance<ASTLENode> ASTLENode = new JexlNodeInstance<>(() -> new ASTLENode(ParserTreeConstants.JJTLENODE));
    public static final JexlNodeInstance<ASTGENode> ASTGENode = new JexlNodeInstance<>(() -> new ASTGENode(ParserTreeConstants.JJTGENODE));
    public static final JexlNodeInstance<ASTERNode> ASTERNode = new JexlNodeInstance<>(() -> new ASTERNode(ParserTreeConstants.JJTERNODE));
    public static final JexlNodeInstance<ASTNRNode> ASTNRNode = new JexlNodeInstance<>(() -> new ASTNRNode(ParserTreeConstants.JJTNRNODE));
    public static final JexlNodeInstance<ASTAdditiveNode> ASTAdditiveNode = new JexlNodeInstance<>(() -> new ASTAdditiveNode(ParserTreeConstants.JJTADDITIVENODE));
    public static final JexlNodeInstance<ASTAdditiveOperator> ASTAdditiveOperator = new JexlNodeInstance<>(() -> new ASTAdditiveOperator(ParserTreeConstants.JJTADDITIVEOPERATOR));
    public static final JexlNodeInstance<ASTMulNode> ASTMulNode = new JexlNodeInstance<>(() -> new ASTMulNode(ParserTreeConstants.JJTMULNODE));
    public static final JexlNodeInstance<ASTDivNode> ASTDivNode = new JexlNodeInstance<>(() -> new ASTDivNode(ParserTreeConstants.JJTDIVNODE));
    public static final JexlNodeInstance<ASTModNode> ASTModNode = new JexlNodeInstance<>(() -> new ASTModNode(ParserTreeConstants.JJTMODNODE));
    public static final JexlNodeInstance<ASTUnaryMinusNode> ASTUnaryMinusNode = new JexlNodeInstance<>(() -> new ASTUnaryMinusNode(ParserTreeConstants.JJTUNARYMINUSNODE));
    public static final JexlNodeInstance<ASTBitwiseComplNode> ASTBitwiseComplNode = new JexlNodeInstance<>(() -> new ASTBitwiseComplNode(ParserTreeConstants.JJTBITWISECOMPLNODE));
    public static final JexlNodeInstance<ASTNotNode> ASTNotNode = new JexlNodeInstance<>(() -> new ASTNotNode(ParserTreeConstants.JJTNOTNODE));
    public static final JexlNodeInstance<ASTIdentifier> ASTIdentifier = new JexlNodeInstance<>(() -> new ASTIdentifier(ParserTreeConstants.JJTIDENTIFIER));
    public static final JexlNodeInstance<ASTNullLiteral> ASTNullLiteral = new JexlNodeInstance<>(() -> new ASTNullLiteral(ParserTreeConstants.JJTNULLLITERAL));
    public static final JexlNodeInstance<ASTTrueNode> ASTTrueNode = new JexlNodeInstance<>(() -> new ASTTrueNode(ParserTreeConstants.JJTTRUENODE));
    public static final JexlNodeInstance<ASTFalseNode> ASTFalseNode = new JexlNodeInstance<>(() -> new ASTFalseNode(ParserTreeConstants.JJTFALSENODE));
    public static final JexlNodeInstance<ASTNumberLiteral> ASTNumberLiteral = new JexlNodeInstance<>(() -> new ASTNumberLiteral(ParserTreeConstants.JJTNUMBERLITERAL));
    public static final JexlNodeInstance<ASTStringLiteral> ASTStringLiteral = new JexlNodeInstance<>(() -> new ASTStringLiteral(ParserTreeConstants.JJTSTRINGLITERAL));
    public static final JexlNodeInstance<ASTArrayLiteral> ASTArrayLiteral = new JexlNodeInstance<>(() -> new ASTArrayLiteral(ParserTreeConstants.JJTARRAYLITERAL));
    public static final JexlNodeInstance<ASTMapLiteral> ASTMapLiteral = new JexlNodeInstance<>(() -> new ASTMapLiteral(ParserTreeConstants.JJTMAPLITERAL));
    public static final JexlNodeInstance<ASTMapEntry> ASTMapEntry = new JexlNodeInstance<>(() -> new ASTMapEntry(ParserTreeConstants.JJTMAPENTRY));
    public static final JexlNodeInstance<ASTEmptyFunction> ASTEmptyFunction = new JexlNodeInstance<>(() -> new ASTEmptyFunction(ParserTreeConstants.JJTEMPTYFUNCTION));
    public static final JexlNodeInstance<ASTSizeFunction> ASTSizeFunction = new JexlNodeInstance<>(() -> new ASTSizeFunction(ParserTreeConstants.JJTSIZEFUNCTION));
    public static final JexlNodeInstance<ASTFunctionNode> ASTFunctionNode = new JexlNodeInstance<>(() -> new ASTFunctionNode(ParserTreeConstants.JJTFUNCTIONNODE));
    public static final JexlNodeInstance<ASTMethodNode> ASTMethodNode = new JexlNodeInstance<>(() -> new ASTMethodNode(ParserTreeConstants.JJTFUNCTIONNODE));
    public static final JexlNodeInstance<ASTSizeMethod> ASTSizeMethod = new JexlNodeInstance<>(() -> new ASTSizeMethod(ParserTreeConstants.JJTSIZEMETHOD));
    public static final JexlNodeInstance<ASTConstructorNode> ASTConstructorNode = new JexlNodeInstance<>(() -> new ASTConstructorNode(ParserTreeConstants.JJTCONSTRUCTORNODE));
    public static final JexlNodeInstance<ASTArrayAccess> ASTArrayAccess = new JexlNodeInstance<>(() -> new ASTArrayAccess(ParserTreeConstants.JJTARRAYACCESS));
    public static final JexlNodeInstance<ASTReferenceExpression> ASTReferenceExpression = new JexlNodeInstance<>(() -> new ASTReferenceExpression(ParserTreeConstants.JJTREFERENCEEXPRESSION));
    
    private final Supplier<T> constructor;
    
    private JexlNodeInstance(Supplier<T> constructor) {
        this.constructor = constructor;
    }
    
    public Supplier<T> getConstructor() {
        return constructor;
    }
    
    public T getInstance() {
        return constructor.get();
    }
    
    public JexlNodeBuilder<T> builder() {
        return JexlNodeBuilder.of(this);
    }
}
