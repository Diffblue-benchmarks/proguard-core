package proguard.dexfile.reader.visitors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.reader.node.DexClassNode;
import proguard.dexfile.reader.node.DexFileNode;

public class DexFileVisitorDiffblueTest {
  /**
   * Test {@link DexFileVisitor#DexFileVisitor()}.
   *
   * <ul>
   *   <li>Then return {@link DexFileVisitor#visitor} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileVisitor#DexFileVisitor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileVisitor.<init>()", "void DexFileVisitor.<init>(DexFileVisitor)"})
  public void testNewDexFileVisitor_thenReturnVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexFileVisitor()).visitor);
  }

  /**
   * Test {@link DexFileVisitor#DexFileVisitor(DexFileVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexFileVisitor#DexFileVisitor()}.
   *   <li>Then return {@link DexFileVisitor#visitor} {@link DexFileVisitor#visitor} is {@code
   *       null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexFileVisitor#DexFileVisitor(DexFileVisitor)}
   *   <li>{@link DexFileVisitor#DexFileVisitor()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileVisitor.<init>()", "void DexFileVisitor.<init>(DexFileVisitor)"})
  public void testNewDexFileVisitor_whenDexFileVisitor_thenReturnVisitorVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexFileVisitor(new DexFileVisitor())).visitor.visitor);
  }

  /**
   * Test {@link DexFileVisitor#visit(int, String, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link DexFileVisitor#DexFileVisitor(DexFileVisitor)} with visitor is {@link
   *       DexFileNode} (default constructor).
   *   <li>Then return {@link DexClassNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileVisitor#visit(int, String, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexClassVisitor DexFileVisitor.visit(int, String, String, String[])"})
  public void testVisit_givenDexFileVisitorWithVisitorIsDexFileNode_thenReturnDexClassNode() {
    // Arrange and Act
    DexClassVisitor actualVisitResult =
        (new DexFileVisitor(new DexFileNode()))
            .visit(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Assert
    assertTrue(actualVisitResult instanceof DexClassNode);
    assertEquals("Class Name", ((DexClassNode) actualVisitResult).className);
    assertEquals("Super Class", ((DexClassNode) actualVisitResult).superClass);
    assertNull(((DexClassNode) actualVisitResult).source);
    assertNull(((DexClassNode) actualVisitResult).anns);
    assertNull(((DexClassNode) actualVisitResult).fields);
    assertNull(((DexClassNode) actualVisitResult).methods);
    assertNull(((DexClassNode) actualVisitResult).visitor);
    assertEquals(1, ((DexClassNode) actualVisitResult).interfaceNames.length);
    assertEquals(1, ((DexClassNode) actualVisitResult).access);
  }

  /**
   * Test {@link DexFileVisitor#visit(int, String, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link DexFileVisitor#DexFileVisitor(DexFileVisitor)} with visitor is {@link
   *       DexFileVisitor#DexFileVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileVisitor#visit(int, String, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexClassVisitor DexFileVisitor.visit(int, String, String, String[])"})
  public void testVisit_givenDexFileVisitorWithVisitorIsDexFileVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new DexFileVisitor(new DexFileVisitor()))
            .visit(1, "Class Name", "Super Class", new String[] {"Interface Names"}));
  }

  /**
   * Test {@link DexFileVisitor#visit(int, String, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link DexFileVisitor#DexFileVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileVisitor#visit(int, String, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexClassVisitor DexFileVisitor.visit(int, String, String, String[])"})
  public void testVisit_givenDexFileVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new DexFileVisitor())
            .visit(1, "Class Name", "Super Class", new String[] {"Interface Names"}));
  }
}
