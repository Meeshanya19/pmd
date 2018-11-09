/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTExplicitConstructorInvocation.java */

package net.sourceforge.pmd.lang.java.ast;

public class ASTExplicitConstructorInvocation extends AbstractJavaNode {

    private String thisOrSuper;

    public ASTExplicitConstructorInvocation(int id) {
        super(id);
    }

    public ASTExplicitConstructorInvocation(JavaParser p, int id) {
        super(p, id);
    }

    /**
     * Accept the visitor. *
     */
    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }


    @Override
    public <T> void jjtAccept(SideEffectingVisitor<T> visitor, T data) {
        visitor.visit(this, data);
    }


    public int getArgumentCount() {
        if (this.jjtGetNumChildren() == 1) {
            return ((ASTArguments) this.jjtGetChild(0)).getArgumentCount();
        } else {
            return ((ASTArguments) this.jjtGetChild(1)).getArgumentCount();
        }
    }

    public void setIsThis() {
        this.thisOrSuper = "this";
    }

    public void setIsSuper() {
        this.thisOrSuper = "super";
    }

    public boolean isThis() {
        return thisOrSuper != null && "this".equals(thisOrSuper);
    }

    public boolean isSuper() {
        return thisOrSuper != null && "super".equals(thisOrSuper);
    }
}
