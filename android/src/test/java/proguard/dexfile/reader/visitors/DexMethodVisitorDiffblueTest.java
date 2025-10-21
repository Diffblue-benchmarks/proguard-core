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
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.node.DexAnnotationNode;
import proguard.dexfile.reader.node.DexMethodNode;

public class DexMethodVisitorDiffblueTest {
  /**
   * Test {@link DexMethodVisitor#DexMethodVisitor()}.
   *
   * <ul>
   *   <li>Then return {@link DexMethodVisitor#visitor} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodVisitor#DexMethodVisitor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexMethodVisitor.<init>()",
    "void DexMethodVisitor.<init>(DexMethodVisitor)"
  })
  public void testNewDexMethodVisitor_thenReturnVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexMethodVisitor()).visitor);
  }

  /**
   * Test {@link DexMethodVisitor#DexMethodVisitor(DexMethodVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexMethodVisitor#DexMethodVisitor()}.
   *   <li>Then return {@link DexMethodVisitor#visitor} {@link DexMethodVisitor#visitor} is {@code
   *       null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexMethodVisitor#DexMethodVisitor(DexMethodVisitor)}
   *   <li>{@link DexMethodVisitor#DexMethodVisitor()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexMethodVisitor.<init>()",
    "void DexMethodVisitor.<init>(DexMethodVisitor)"
  })
  public void testNewDexMethodVisitor_whenDexMethodVisitor_thenReturnVisitorVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexMethodVisitor(new DexMethodVisitor())).visitor.visitor);
  }

  /**
   * Test {@link DexMethodVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Given {@link DexMethodVisitor#DexMethodVisitor(DexMethodVisitor)} with mv is {@link
   *       DexMethodVisitor#DexMethodVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexMethodVisitor.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation_givenDexMethodVisitorWithMvIsDexMethodVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new DexMethodVisitor(new DexMethodVisitor())).visitAnnotation("Name", Visibility.BUILD));
  }

  /**
   * Test {@link DexMethodVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Given {@link DexMethodVisitor#DexMethodVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexMethodVisitor.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation_givenDexMethodVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DexMethodVisitor()).visitAnnotation("Name", Visibility.BUILD));
  }

  /**
   * Test {@link DexMethodVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Then return {@link DexAnnotationNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexMethodVisitor.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation_thenReturnDexAnnotationNode() {
    // Arrange
    DexMethodNode mv =
        new DexMethodNode(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    DexMethodVisitor dexMethodVisitor = new DexMethodVisitor(mv);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexMethodVisitor.visitAnnotation("Name", Visibility.BUILD);

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
   * Test {@link DexMethodVisitor#visitCode()}.
   *
   * <ul>
   *   <li>Given {@link DexMethodVisitor#DexMethodVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodVisitor#visitCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexCodeVisitor DexMethodVisitor.visitCode()"
  })
  public void testVisitCode_givenDexMethodVisitor() {
    // Arrange, Act and Assert
    assertNull((new DexMethodVisitor()).visitCode());
  }

  /**
   * Test {@link DexMethodVisitor#visitCode()}.
   *
   * <ul>
   *   <li>Given {@link DexMethodVisitor#DexMethodVisitor(DexMethodVisitor)} with mv is {@link
   *       DexMethodVisitor#DexMethodVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexMethodVisitor#visitCode()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexCodeVisitor DexMethodVisitor.visitCode()"
  })
  public void testVisitCode_givenDexMethodVisitorWithMvIsDexMethodVisitor() {
    // Arrange, Act and Assert
    assertNull((new DexMethodVisitor(new DexMethodVisitor())).visitCode());
  }
}
