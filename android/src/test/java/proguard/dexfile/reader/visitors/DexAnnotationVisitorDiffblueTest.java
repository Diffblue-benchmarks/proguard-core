package proguard.dexfile.reader.visitors;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.node.DexAnnotationNode;

public class DexAnnotationVisitorDiffblueTest {
  /**
   * Method under test: {@link DexAnnotationVisitor#DexAnnotationVisitor()}
   */
  @Test
  public void testNewDexAnnotationVisitor() {
    // Arrange, Act and Assert
    assertNull((new DexAnnotationVisitor()).visitor);
    assertNull((new DexAnnotationVisitor(new DexAnnotationVisitor())).visitor.visitor);
  }

  /**
   * Method under test: {@link DexAnnotationVisitor#visit(String, Object)}
   */
  @Test
  public void testVisit() {
    // Arrange
    DexAnnotationNode visitor = new DexAnnotationNode("Type", Visibility.BUILD);

    DexAnnotationVisitor dexAnnotationVisitor = new DexAnnotationVisitor(visitor);

    // Act
    dexAnnotationVisitor.visit("Name", Constant.Null);

    // Assert
    DexAnnotationVisitor dexAnnotationVisitor2 = dexAnnotationVisitor.visitor;
    assertTrue(dexAnnotationVisitor2 instanceof DexAnnotationNode);
    assertSame(visitor.items, ((DexAnnotationNode) dexAnnotationVisitor2).items);
  }

  /**
   * Method under test:
   * {@link DexAnnotationVisitor#visitEnum(String, String, String)}
   */
  @Test
  public void testVisitEnum() {
    // Arrange
    DexAnnotationNode visitor = new DexAnnotationNode("Type", Visibility.BUILD);

    DexAnnotationVisitor dexAnnotationVisitor = new DexAnnotationVisitor(visitor);

    // Act
    dexAnnotationVisitor.visitEnum("Name", "The characteristics of someone or something", "42");

    // Assert
    DexAnnotationVisitor dexAnnotationVisitor2 = dexAnnotationVisitor.visitor;
    assertTrue(dexAnnotationVisitor2 instanceof DexAnnotationNode);
    assertSame(visitor.items, ((DexAnnotationNode) dexAnnotationVisitor2).items);
  }
}
