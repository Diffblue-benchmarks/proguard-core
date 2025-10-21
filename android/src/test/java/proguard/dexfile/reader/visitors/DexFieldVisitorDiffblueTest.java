package proguard.dexfile.reader.visitors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.node.DexAnnotationNode;
import proguard.dexfile.reader.node.DexFieldNode;

public class DexFieldVisitorDiffblueTest {
  /**
   * Test {@link DexFieldVisitor#DexFieldVisitor()}.
   *
   * <ul>
   *   <li>Then return {@link DexFieldVisitor#visitor} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldVisitor#DexFieldVisitor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexFieldVisitor.<init>()",
    "void DexFieldVisitor.<init>(DexFieldVisitor)"
  })
  public void testNewDexFieldVisitor_thenReturnVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexFieldVisitor()).visitor);
  }

  /**
   * Test {@link DexFieldVisitor#DexFieldVisitor(DexFieldVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexFieldVisitor#DexFieldVisitor()}.
   *   <li>Then return {@link DexFieldVisitor#visitor} {@link DexFieldVisitor#visitor} is {@code
   *       null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexFieldVisitor#DexFieldVisitor(DexFieldVisitor)}
   *   <li>{@link DexFieldVisitor#DexFieldVisitor()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexFieldVisitor.<init>()",
    "void DexFieldVisitor.<init>(DexFieldVisitor)"
  })
  public void testNewDexFieldVisitor_whenDexFieldVisitor_thenReturnVisitorVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexFieldVisitor(new DexFieldVisitor())).visitor.visitor);
  }

  /**
   * Test {@link DexFieldVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Given {@link DexFieldVisitor#DexFieldVisitor(DexFieldVisitor)} with visitor is {@link
   *       DexFieldVisitor#DexFieldVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexFieldVisitor.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation_givenDexFieldVisitorWithVisitorIsDexFieldVisitor() {
    // Arrange, Act and Assert
    assertNull(
        (new DexFieldVisitor(new DexFieldVisitor())).visitAnnotation("Name", Visibility.BUILD));
  }

  /**
   * Test {@link DexFieldVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Given {@link DexFieldVisitor#DexFieldVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexFieldVisitor.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation_givenDexFieldVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DexFieldVisitor()).visitAnnotation("Name", Visibility.BUILD));
  }

  /**
   * Test {@link DexFieldVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Then return {@link DexAnnotationNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexFieldVisitor.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation_thenReturnDexAnnotationNode() {
    // Arrange
    DexFieldNode visitor = new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);

    DexFieldVisitor dexFieldVisitor = new DexFieldVisitor(visitor);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexFieldVisitor.visitAnnotation("Name", Visibility.BUILD);

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
