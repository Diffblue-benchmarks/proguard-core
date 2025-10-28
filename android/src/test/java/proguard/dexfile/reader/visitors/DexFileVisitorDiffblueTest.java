package proguard.dexfile.reader.visitors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.reader.node.DexClassNode;
import proguard.dexfile.reader.node.DexFileNode;

public class DexFileVisitorDiffblueTest {
  /**
   * Method under test: {@link DexFileVisitor#DexFileVisitor()}
   */
  @Test
  public void testNewDexFileVisitor() {
    // Arrange, Act and Assert
    assertNull((new DexFileVisitor()).visitor);
    assertNull((new DexFileVisitor(new DexFileVisitor())).visitor.visitor);
  }

  /**
   * Method under test:
   * {@link DexFileVisitor#visit(int, String, String, String[])}
   */
  @Test
  public void testVisit() {
    // Arrange, Act and Assert
    assertNull((new DexFileVisitor()).visit(1, "Class Name", "Super Class", new String[]{"Interface Names"}));
    assertNull((new DexFileVisitor(new DexFileVisitor())).visit(1, "Class Name", "Super Class",
        new String[]{"Interface Names"}));
  }

  /**
   * Method under test:
   * {@link DexFileVisitor#visit(int, String, String, String[])}
   */
  @Test
  public void testVisit2() {
    // Arrange
    DexFileNode visitor = new DexFileNode();
    DexFileVisitor dexFileVisitor = new DexFileVisitor(visitor);

    // Act
    DexClassVisitor actualVisitResult = dexFileVisitor.visit(1, "Class Name", "Super Class",
        new String[]{"Interface Names"});

    // Assert
    assertTrue(actualVisitResult instanceof DexClassNode);
    DexFileVisitor dexFileVisitor2 = dexFileVisitor.visitor;
    assertTrue(dexFileVisitor2 instanceof DexFileNode);
    assertEquals("Class Name", ((DexClassNode) actualVisitResult).className);
    assertEquals("Super Class", ((DexClassNode) actualVisitResult).superClass);
    assertNull(((DexClassNode) actualVisitResult).source);
    assertNull(((DexClassNode) actualVisitResult).anns);
    assertNull(((DexClassNode) actualVisitResult).fields);
    assertNull(((DexClassNode) actualVisitResult).methods);
    assertNull(((DexClassNode) actualVisitResult).visitor);
    List<DexClassNode> dexClassNodeList = ((DexFileNode) dexFileVisitor2).clzs;
    assertEquals(1, dexClassNodeList.size());
    assertEquals(1, ((DexClassNode) actualVisitResult).access);
    assertSame(visitor.clzs, dexClassNodeList);
    assertArrayEquals(new String[]{"Interface Names"}, ((DexClassNode) actualVisitResult).interfaceNames);
  }
}
