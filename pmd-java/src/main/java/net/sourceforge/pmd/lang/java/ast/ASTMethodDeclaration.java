/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTMethodDeclaration.java */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.dfa.DFAGraphMethod;


/**
 * Method declaration node.
 *
 * <pre>
 * MethodDeclaration := [ TypeParameters() ] (TypeAnnotation())* ResultType() MethodDeclarator() [ "throws" NameList() ] ( Block() | ";" )
 * </pre>
 *
 */
public class ASTMethodDeclaration extends AbstractMethodOrConstructorDeclaration implements DFAGraphMethod {


    public ASTMethodDeclaration(int id) {
        super(id);
    }

    public ASTMethodDeclaration(JavaParser p, int id) {
        super(p, id);
    }

    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }


    @Override
    public <T> void jjtAccept(SideEffectingVisitor<T> visitor, T data) {
        visitor.visit(this, data);
    }


    /**
     * Returns the simple name of the method.
     */
    public String getMethodName() {
        return getFirstChildOfType(ASTMethodDeclarator.class).getImage();
    }


    @Override
    public String getName() {
        return getMethodName();
    }


    /**
     * Returns true if this method is explicitly modified by
     * the {@code public} modifier.
     */
    public boolean isSyntacticallyPublic() {
        return super.isPublic();
    }


    /**
     * Returns true if this method is explicitly modified by
     * the {@code abstract} modifier.
     */
    public boolean isSyntacticallyAbstract() {
        return super.isAbstract();
    }


    /**
     * Returns true if this method has public visibility.
     * Non-private interface members are implicitly public,
     * whether they declare the {@code public} modifier or
     * not.
     */
    @Override
    public boolean isPublic() {
        // interface methods are public by default, but could be private since java9
        return isInterfaceMember() && !isPrivate() || super.isPublic();
    }


    /**
     * Returns true if this method is abstract, so doesn't
     * declare a body. Interface members are
     * implicitly abstract, whether they declare the
     * {@code abstract} modifier or not.
     */
    @Override
    public boolean isAbstract() {
        return isInterfaceMember() || super.isAbstract();
    }


    /**
     * Returns true if this method declaration is a member of an interface type.
     */
    public boolean isInterfaceMember() {
        // for a real class/interface the 3rd parent is a ClassOrInterfaceDeclaration,
        // for anonymous classes, the parent is e.g. a AllocationExpression
        Node potentialTypeDeclaration = getNthParent(3);

        return potentialTypeDeclaration instanceof ASTClassOrInterfaceDeclaration
                && ((ASTClassOrInterfaceDeclaration) potentialTypeDeclaration).isInterface();
    }


    /**
     * Returns true if the result type of this method is {@code void}.
     */
    public boolean isVoid() {
        return getResultType().isVoid();
    }


    /**
     * Returns the result type node of the method.
     */
    public ASTResultType getResultType() {
        return getFirstChildOfType(ASTResultType.class);
    }


    /**
     * Returns the block defined by this method, or
     * null if the method is abstract.
     */
    public ASTBlock getBlock() {
        return getFirstChildOfType(ASTBlock.class);
    }


    /**
     * Returns the exception names listed in the {@code throws} clause
     * of this method declaration, or null if there are none.
     */
    public ASTNameList getThrows() {
        return getFirstChildOfType(ASTNameList.class);
    }


    @Override
    public MethodLikeKind getKind() {
        return MethodLikeKind.METHOD;
    }

    //@Override // enable this with PMD 7.0.0 - see interface ASTMethodOrConstructorDeclaration
    public ASTFormalParameters getFormalParameters() {
        return getFirstChildOfType(ASTMethodDeclarator.class).getFirstChildOfType(ASTFormalParameters.class);
    }


    /**
     * Returns the method declarator. Never null.
     */
    public ASTMethodDeclarator getMethodDeclarator() {
        return getFirstChildOfType(ASTMethodDeclarator.class);
    }
}
