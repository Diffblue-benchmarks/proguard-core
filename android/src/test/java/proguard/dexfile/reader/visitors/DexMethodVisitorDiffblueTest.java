package proguard.dexfile.reader.visitors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.node.DexAnnotationNode;
import proguard.dexfile.reader.node.DexMethodNode;

public class DexMethodVisitorDiffblueTest {
  /**
   * Method under test: {@link DexMethodVisitor#DexMethodVisitor()}
   */
  @Test
  public void testNewDexMethodVisitor() {
    // Arrange, Act and Assert
    assertNull((new DexMethodVisitor()).visitor);
    assertNull((new DexMethodVisitor(new DexMethodVisitor())).visitor.visitor);
  }

  /**
   * Method under test:
   * {@link DexMethodVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  public void testVisitAnnotation() {
    // Arrange, Act and Assert
    assertNull((new DexMethodVisitor()).visitAnnotation("Name", Visibility.BUILD));
    assertNull((new DexMethodVisitor(new DexMethodVisitor())).visitAnnotation("Name", Visibility.BUILD));
  }

  /**
   * Method under test:
   * {@link DexMethodVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  public void testVisitAnnotation2() {
    // Arrange
    DexMethodNode mv = new DexMethodNode(1,
        new Method("Owner", "Name", new Proto(new String[]{"Parameter Types"}, "Return Type")));

    DexMethodVisitor dexMethodVisitor = new DexMethodVisitor(mv);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult = dexMethodVisitor.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    DexMethodVisitor dexMethodVisitor2 = dexMethodVisitor.visitor;
    assertTrue(dexMethodVisitor2 instanceof DexMethodNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertNull(((DexAnnotationNode) actualVisitAnnotationResult).visitor);
    List<DexAnnotationNode> dexAnnotationNodeList = ((DexMethodNode) dexMethodVisitor2).anns;
    assertEquals(1, dexAnnotationNodeList.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
    assertSame(mv.anns, dexAnnotationNodeList);
  }

  /**
   * Method under test: {@link DexMethodVisitor#visitCode()}
   */
  @Test
  public void testVisitCode() {
    // Arrange, Act and Assert
    assertNull((new DexMethodVisitor()).visitCode());
    assertNull((new DexMethodVisitor(new DexMethodVisitor())).visitCode());
  }
}
