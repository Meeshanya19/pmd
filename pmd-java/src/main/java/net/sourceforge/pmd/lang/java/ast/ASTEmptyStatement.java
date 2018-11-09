/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTEmptyStatement.java */

package net.sourceforge.pmd.lang.java.ast;

public class ASTEmptyStatement extends AbstractJavaNode {
    public ASTEmptyStatement(int id) {
        super(id);
    }

    public ASTEmptyStatement(JavaParser p, int id) {
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
}
