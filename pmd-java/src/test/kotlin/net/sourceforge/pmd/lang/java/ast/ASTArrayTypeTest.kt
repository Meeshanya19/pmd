package net.sourceforge.pmd.lang.java.ast

import net.sourceforge.pmd.lang.ast.test.shouldBe


/**
 * @author Clément Fournier
 * @since 7.0.0
 */
class ASTArrayTypeTest : ParserTestSpec({

    parserTest("Multi-Dim Array") {
        "ArrayTypes[][][]" should matchType<ASTArrayType> {

            it::getElementType shouldBe child<ASTClassOrInterfaceType> {
                it::getTypeImage shouldBe "ArrayTypes"
                it::getImage shouldBe "ArrayTypes"
            }

            it::getDimensions shouldBe child<ASTArrayTypeDims> {

                child<ASTArrayTypeDim> {}
                child<ASTArrayTypeDim> {}
                child<ASTArrayTypeDim> {}
            }
        }
    }

    parserTest("Annotated array type") {
        "ArrayTypes[][] @A []" should matchType<ASTArrayType> {

            it::getElementType shouldBe child<ASTClassOrInterfaceType> {
                it::getTypeImage shouldBe "ArrayTypes"
                it::getImage shouldBe "ArrayTypes"
            }

            it::getDeclaredAnnotations shouldBe fromChild<ASTArrayTypeDims, List<ASTAnnotation>> {

                child<ASTArrayTypeDim> {}
                child<ASTArrayTypeDim> {}
                fromChild<ASTArrayTypeDim, List<ASTAnnotation>> {

                    val lst = listOf(annotation("A"))

                    it::getDeclaredAnnotations shouldBe lst

                    lst
                }
            }
        }
    }

    parserTest("Multi-Dim Array allocation") {
        "new ArrayTypes[][][] { }" should matchExpr<ASTArrayAllocation> {

            // not an array type
            child<ASTClassOrInterfaceType> {
                it::getTypeImage shouldBe "ArrayTypes"
                it::getImage shouldBe "ArrayTypes"
            }

            child<ASTArrayAllocationDims> {
                unspecifiedChildren(3)
            }
            child<ASTArrayInitializer> { }
        }
    }

})