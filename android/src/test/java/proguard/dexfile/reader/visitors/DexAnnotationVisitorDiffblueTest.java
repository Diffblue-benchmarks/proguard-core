package proguard.dexfile.reader.visitors;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.node.DexAnnotationNode;

public class DexAnnotationVisitorDiffblueTest {
  /**
   * Test {@link DexAnnotationVisitor#DexAnnotationVisitor()}.
   *
   * <ul>
   *   <li>Then return {@link DexAnnotationVisitor#visitor} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationVisitor#DexAnnotationVisitor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexAnnotationVisitor.<init>()",
    "void DexAnnotationVisitor.<init>(DexAnnotationVisitor)"
  })
  public void testNewDexAnnotationVisitor_thenReturnVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexAnnotationVisitor()).visitor);
  }

  /**
   * Test {@link DexAnnotationVisitor#DexAnnotationVisitor(DexAnnotationVisitor)}.
   *
   * <ul>
   *   <li>Then return {@link DexAnnotationVisitor#visitor} {@link DexAnnotationVisitor#visitor} is
   *       {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexAnnotationVisitor#DexAnnotationVisitor(DexAnnotationVisitor)}
   *   <li>{@link DexAnnotationVisitor#DexAnnotationVisitor()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexAnnotationVisitor.<init>()",
    "void DexAnnotationVisitor.<init>(DexAnnotationVisitor)"
  })
  public void testNewDexAnnotationVisitor_thenReturnVisitorVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexAnnotationVisitor(new DexAnnotationVisitor())).visitor.visitor);
  }

  /**
   * Test {@link DexAnnotationVisitor#visit(String, Object)}.
   *
   * <p>Method under test: {@link DexAnnotationVisitor#visit(String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexAnnotationVisitor.visit(String, Object)"})
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
   * Test {@link DexAnnotationVisitor#visitEnum(String, String, String)}.
   *
   * <p>Method under test: {@link DexAnnotationVisitor#visitEnum(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexAnnotationVisitor.visitEnum(String, String, String)"})
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
