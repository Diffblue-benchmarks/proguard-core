package proguard.dexfile.reader.visitors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.node.DexAnnotationNode;
import proguard.dexfile.reader.node.DexFieldNode;

public class DexFieldVisitorDiffblueTest {
  /**
   * Method under test: {@link DexFieldVisitor#DexFieldVisitor()}
   */
  @Test
  public void testNewDexFieldVisitor() {
    // Arrange, Act and Assert
    assertNull((new DexFieldVisitor()).visitor);
    assertNull((new DexFieldVisitor(new DexFieldVisitor())).visitor.visitor);
  }

  /**
   * Method under test:
   * {@link DexFieldVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  public void testVisitAnnotation() {
    // Arrange, Act and Assert
    assertNull((new DexFieldVisitor()).visitAnnotation("Name", Visibility.BUILD));
    assertNull((new DexFieldVisitor(new DexFieldVisitor())).visitAnnotation("Name", Visibility.BUILD));
  }

  /**
   * Method under test:
   * {@link DexFieldVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  public void testVisitAnnotation2() {
    // Arrange
    DexFieldNode visitor = new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);

    DexFieldVisitor dexFieldVisitor = new DexFieldVisitor(visitor);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult = dexFieldVisitor.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    DexFieldVisitor dexFieldVisitor2 = dexFieldVisitor.visitor;
    assertTrue(dexFieldVisitor2 instanceof DexFieldNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertNull(((DexAnnotationNode) actualVisitAnnotationResult).visitor);
    List<DexAnnotationNode> dexAnnotationNodeList = ((DexFieldNode) dexFieldVisitor2).anns;
    assertEquals(1, dexAnnotationNodeList.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
    assertSame(visitor.anns, dexAnnotationNodeList);
  }
}
