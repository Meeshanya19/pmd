/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTAssignmentOperator.java */

package net.sourceforge.pmd.lang.java.ast;

/**
 * Represents an assignment operator in an {@linkplain ASTExpression assignment expression}.
 *
 * <pre>
 *
 *  AssignmentOperator ::= "=" | "*=" | "/=" | "%=" | "+=" | "-=" | "<<=" | ">>=" | ">>>=" | "&=" | "^=" | "|="
 *
 * </pre>
 */
public class ASTAssignmentOperator extends AbstractJavaNode {
    private boolean isCompound;

    public ASTAssignmentOperator(int id) {
        super(id);
    }

    public ASTAssignmentOperator(JavaParser p, int id) {
        super(p, id);
    }

    // TODO this could be determined from the image of the operator, no need to set it in the parser...
    public void setCompound() {
        isCompound = true;
    }

    public boolean isCompound() {
        return this.isCompound;
    }

    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }


    @Override
    public <T> void jjtAccept(SideEffectingVisitor<T> visitor, T data) {
        visitor.visit(this, data);
    }
}
