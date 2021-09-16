package org.apache.commons.jexl2.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class JexlNodeInstance<T extends JexlNode> {
    
    private static final Map<Class<? extends JexlNode>,JexlNodeInstance<?>> classInstances = new HashMap<>();
    private static final Map<Class<? extends JexlNode>,JexlNodeInstance<?>> assignableClassInstances = new HashMap<>();
    
    private static <T extends JexlNode> JexlNodeInstance<T> createInstance(Supplier<T> constructor) {
        JexlNodeInstance<T> instance = new JexlNodeInstance<>(constructor);
        Class<? extends JexlNode> clazz = constructor.get().getClass();
        classInstances.put(clazz, instance);
        assignableClassInstances.put(clazz, instance);
        return instance;
    }
    
    public static final JexlNodeInstance<ASTJexlScript> ASTJexlScript = createInstance(() -> new ASTJexlScript(ParserTreeConstants.JJTJEXLSCRIPT));
    public static final JexlNodeInstance<ASTBlock> ASTBlock = createInstance(() -> new ASTBlock(ParserTreeConstants.JJTBLOCK));
    public static final JexlNodeInstance<ASTAmbiguous> ASTAmbiguous = createInstance(() -> new ASTAmbiguous(ParserTreeConstants.JJTAMBIGUOUS));
    public static final JexlNodeInstance<ASTIfStatement> ASTIfStatement = createInstance(() -> new ASTIfStatement(ParserTreeConstants.JJTIFSTATEMENT));
    public static final JexlNodeInstance<ASTWhileStatement> ASTWhileStatement = createInstance(() -> new ASTWhileStatement(ParserTreeConstants.JJTWHILESTATEMENT));
    public static final JexlNodeInstance<ASTForeachStatement> ASTForeachStatement = createInstance(() -> new ASTForeachStatement(ParserTreeConstants.JJTFOREACHSTATEMENT));
    public static final JexlNodeInstance<ASTReturnStatement> ASTReturnStatement = createInstance(() -> new ASTReturnStatement(ParserTreeConstants.JJTRETURNSTATEMENT));
    public static final JexlNodeInstance<ASTAssignment> ASTAssignment = createInstance(() -> new ASTAssignment(ParserTreeConstants.JJTASSIGNMENT));
    public static final JexlNodeInstance<ASTVar> ASTVar = createInstance(() -> new ASTVar(ParserTreeConstants.JJTVAR));
    public static final JexlNodeInstance<ASTReference> ASTReference = createInstance(() -> new ASTReference(ParserTreeConstants.JJTREFERENCE));
    public static final JexlNodeInstance<ASTTernaryNode> ASTTernaryNode = createInstance(() -> new ASTTernaryNode(ParserTreeConstants.JJTTERNARYNODE));
    public static final JexlNodeInstance<ASTOrNode> ASTOrNode = createInstance(() -> new ASTOrNode(ParserTreeConstants.JJTORNODE));
    public static final JexlNodeInstance<ASTAndNode> ASTAndNode = createInstance(() -> new ASTAndNode(ParserTreeConstants.JJTANDNODE));
    public static final JexlNodeInstance<ASTBitwiseOrNode> ASTBitwiseOrNode = createInstance(() -> new ASTBitwiseOrNode(ParserTreeConstants.JJTBITWISEORNODE));
    public static final JexlNodeInstance<ASTBitwiseXorNode> ASTBitwiseXorNode = createInstance(() -> new ASTBitwiseXorNode(ParserTreeConstants.JJTBITWISEXORNODE));
    public static final JexlNodeInstance<ASTBitwiseAndNode> ASTBitwiseAndNode = createInstance(() -> new ASTBitwiseAndNode(ParserTreeConstants.JJTBITWISEANDNODE));
    public static final JexlNodeInstance<ASTEQNode> ASTEQNode = createInstance(() -> new ASTEQNode(ParserTreeConstants.JJTEQNODE));
    public static final JexlNodeInstance<ASTNENode> ASTNENode = createInstance(() -> new ASTNENode(ParserTreeConstants.JJTNENODE));
    public static final JexlNodeInstance<ASTLTNode> ASTLTNode = createInstance(() -> new ASTLTNode(ParserTreeConstants.JJTLTNODE));
    public static final JexlNodeInstance<ASTGTNode> ASTGTNode = createInstance(() -> new ASTGTNode(ParserTreeConstants.JJTGTNODE));
    public static final JexlNodeInstance<ASTLENode> ASTLENode = createInstance(() -> new ASTLENode(ParserTreeConstants.JJTLENODE));
    public static final JexlNodeInstance<ASTGENode> ASTGENode = createInstance(() -> new ASTGENode(ParserTreeConstants.JJTGENODE));
    public static final JexlNodeInstance<ASTERNode> ASTERNode = createInstance(() -> new ASTERNode(ParserTreeConstants.JJTERNODE));
    public static final JexlNodeInstance<ASTNRNode> ASTNRNode = createInstance(() -> new ASTNRNode(ParserTreeConstants.JJTNRNODE));
    public static final JexlNodeInstance<ASTAdditiveNode> ASTAdditiveNode = createInstance(() -> new ASTAdditiveNode(ParserTreeConstants.JJTADDITIVENODE));
    public static final JexlNodeInstance<ASTAdditiveOperator> ASTAdditiveOperator = createInstance(() -> new ASTAdditiveOperator(ParserTreeConstants.JJTADDITIVEOPERATOR));
    public static final JexlNodeInstance<ASTMulNode> ASTMulNode = createInstance(() -> new ASTMulNode(ParserTreeConstants.JJTMULNODE));
    public static final JexlNodeInstance<ASTDivNode> ASTDivNode = createInstance(() -> new ASTDivNode(ParserTreeConstants.JJTDIVNODE));
    public static final JexlNodeInstance<ASTModNode> ASTModNode = createInstance(() -> new ASTModNode(ParserTreeConstants.JJTMODNODE));
    public static final JexlNodeInstance<ASTUnaryMinusNode> ASTUnaryMinusNode = createInstance(() -> new ASTUnaryMinusNode(ParserTreeConstants.JJTUNARYMINUSNODE));
    public static final JexlNodeInstance<ASTBitwiseComplNode> ASTBitwiseComplNode = createInstance(() -> new ASTBitwiseComplNode(ParserTreeConstants.JJTBITWISECOMPLNODE));
    public static final JexlNodeInstance<ASTNotNode> ASTNotNode = createInstance(() -> new ASTNotNode(ParserTreeConstants.JJTNOTNODE));
    public static final JexlNodeInstance<ASTIdentifier> ASTIdentifier = createInstance(() -> new ASTIdentifier(ParserTreeConstants.JJTIDENTIFIER));
    public static final JexlNodeInstance<ASTNullLiteral> ASTNullLiteral = createInstance(() -> new ASTNullLiteral(ParserTreeConstants.JJTNULLLITERAL));
    public static final JexlNodeInstance<ASTTrueNode> ASTTrueNode = createInstance(() -> new ASTTrueNode(ParserTreeConstants.JJTTRUENODE));
    public static final JexlNodeInstance<ASTFalseNode> ASTFalseNode = createInstance(() -> new ASTFalseNode(ParserTreeConstants.JJTFALSENODE));
    public static final JexlNodeInstance<ASTNumberLiteral> ASTNumberLiteral = createInstance(() -> new ASTNumberLiteral(ParserTreeConstants.JJTNUMBERLITERAL));
    public static final JexlNodeInstance<ASTStringLiteral> ASTStringLiteral = createInstance(() -> new ASTStringLiteral(ParserTreeConstants.JJTSTRINGLITERAL));
    public static final JexlNodeInstance<ASTArrayLiteral> ASTArrayLiteral = createInstance(() -> new ASTArrayLiteral(ParserTreeConstants.JJTARRAYLITERAL));
    public static final JexlNodeInstance<ASTMapLiteral> ASTMapLiteral = createInstance(() -> new ASTMapLiteral(ParserTreeConstants.JJTMAPLITERAL));
    public static final JexlNodeInstance<ASTMapEntry> ASTMapEntry = createInstance(() -> new ASTMapEntry(ParserTreeConstants.JJTMAPENTRY));
    public static final JexlNodeInstance<ASTEmptyFunction> ASTEmptyFunction = createInstance(() -> new ASTEmptyFunction(ParserTreeConstants.JJTEMPTYFUNCTION));
    public static final JexlNodeInstance<ASTSizeFunction> ASTSizeFunction = createInstance(() -> new ASTSizeFunction(ParserTreeConstants.JJTSIZEFUNCTION));
    public static final JexlNodeInstance<ASTFunctionNode> ASTFunctionNode = createInstance(() -> new ASTFunctionNode(ParserTreeConstants.JJTFUNCTIONNODE));
    public static final JexlNodeInstance<ASTMethodNode> ASTMethodNode = createInstance(() -> new ASTMethodNode(ParserTreeConstants.JJTFUNCTIONNODE));
    public static final JexlNodeInstance<ASTSizeMethod> ASTSizeMethod = createInstance(() -> new ASTSizeMethod(ParserTreeConstants.JJTSIZEMETHOD));
    public static final JexlNodeInstance<ASTConstructorNode> ASTConstructorNode = createInstance(() -> new ASTConstructorNode(ParserTreeConstants.JJTCONSTRUCTORNODE));
    public static final JexlNodeInstance<ASTArrayAccess> ASTArrayAccess = createInstance(() -> new ASTArrayAccess(ParserTreeConstants.JJTARRAYACCESS));
    public static final JexlNodeInstance<ASTReferenceExpression> ASTReferenceExpression = createInstance(() -> new ASTReferenceExpression(ParserTreeConstants.JJTREFERENCEEXPRESSION));
    
    public static JexlNodeInstance<?> ofType(Class<? extends JexlNode> clazz) {
        JexlNodeInstance<?> instance = classInstances.get(clazz);
        if (instance == null) {
            throw new IllegalArgumentException("No " + JexlNodeInstance.class.getName() + " registered for type " + clazz.getName());
        }
        return instance;
    }
    
    public static JexlNodeInstance<?> ofType(JexlNode node) {
        return ofType(node.getClass());
    }
    
    public static JexlNodeInstance<?> ofAssignableType(Class<? extends JexlNode> nodeClass) {
        JexlNodeInstance<?> instance = assignableClassInstances.get(nodeClass);
        if (instance == null) {
            for (Class<? extends JexlNode> clazz : classInstances.keySet()) {
                if (nodeClass.isAssignableFrom(clazz)) {
                    instance = classInstances.get(clazz);
                    assignableClassInstances.put(nodeClass, instance);
                    return instance;
                }
            }
            throw new IllegalArgumentException("No " + JexlNodeInstance.class.getName() + " registered with type that " + nodeClass.getName() + " is assignable from");
        }
        return instance;
    }
    
    public static JexlNodeInstance<?> ofAssignableType(JexlNode node) {
        return ofAssignableType(node.getClass());
    }
    
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
