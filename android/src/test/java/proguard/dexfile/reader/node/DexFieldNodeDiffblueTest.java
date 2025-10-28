package proguard.dexfile.reader.node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.visitors.DexAnnotationVisitor;
import proguard.dexfile.reader.visitors.DexClassVisitor;
import proguard.dexfile.reader.visitors.DexFieldVisitor;

public class DexFieldNodeDiffblueTest {
  /**
   * Method under test: {@link DexFieldNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept() {
    // Arrange
    DexFieldNode dexFieldNode = new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);

    // Act
    dexFieldNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    assertNull(dexFieldNode.anns);
  }

  /**
   * Method under test: {@link DexFieldNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept2() {
    // Arrange
    DexFieldNode dexFieldNode = new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);

    // Act
    dexFieldNode.accept(new DexClassVisitor(new DexClassVisitor()));

    // Assert that nothing has changed
    assertNull(dexFieldNode.anns);
  }

  /**
   * Method under test: {@link DexFieldNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept3() {
    // Arrange
    DexFieldNode dexFieldNode = new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexFieldNode.accept(dcv);

    // Assert
    assertNull(dexFieldNode.anns);
    List<DexFieldNode> dexFieldNodeList = dcv.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertNull(getResult.anns);
    assertEquals(1, getResult.access);
    assertSame(dexFieldNode.cst, getResult.cst);
    assertSame(dexFieldNode.field, getResult.field);
  }

  /**
   * Method under test: {@link DexFieldNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept4() {
    // Arrange
    DexFieldNode dexFieldNode = new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);

    // Act
    dexFieldNode
        .accept(new DexClassVisitor(new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"})));

    // Assert
    assertNull(dexFieldNode.anns);
  }

  /**
   * Method under test: {@link DexFieldNode#accept(DexClassVisitor)}
   */
  @Test
  public void testAccept5() {
    // Arrange
    DexFieldNode dexFieldNode = new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);
    dexFieldNode.visitAnnotation("Name", Visibility.BUILD);
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", new String[]{"Interface Names"});

    // Act
    dexFieldNode.accept(dcv);

    // Assert
    List<DexFieldNode> dexFieldNodeList = dcv.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    List<DexAnnotationNode> dexAnnotationNodeList = getResult.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult2 = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult2.type);
    List<DexAnnotationNode> dexAnnotationNodeList2 = dexFieldNode.anns;
    assertEquals(1, dexAnnotationNodeList2.size());
    assertEquals(1, getResult.access);
    assertEquals(Visibility.BUILD, getResult2.visibility);
    assertTrue(dexAnnotationNodeList2.get(0).items.isEmpty());
    assertTrue(getResult2.items.isEmpty());
    assertSame(dexFieldNode.cst, getResult.cst);
    assertSame(dexFieldNode.field, getResult.field);
  }

  /**
   * Method under test: {@link DexFieldNode#visitAnnotation(String, Visibility)}
   */
  @Test
  public void testVisitAnnotation() {
    // Arrange
    DexFieldNode dexFieldNode = new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult = dexFieldNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexFieldNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Method under test: {@link DexFieldNode#visitAnnotation(String, Visibility)}
   */
  @Test
  public void testVisitAnnotation2() {
    // Arrange
    DexFieldNode dexFieldNode = new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);
    dexFieldNode.anns = new ArrayList<>();

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult = dexFieldNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexFieldNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Method under test: {@link DexFieldNode#DexFieldNode(int, Field, Object)}
   */
  @Test
  public void testNewDexFieldNode() {
    // Arrange, Act and Assert
    Field field = (new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null)).field;
    assertEquals("Name", field.getName());
    assertEquals("Owner", field.getOwner());
    assertEquals("Type", field.getType());
  }

  /**
   * Method under test:
   * {@link DexFieldNode#DexFieldNode(DexFieldVisitor, int, Field, Object)}
   */
  @Test
  public void testNewDexFieldNode2() {
    // Arrange
    DexFieldVisitor visitor = new DexFieldVisitor();

    // Act and Assert
    Field field = (new DexFieldNode(visitor, 1, new Field("Owner", "Name", "Type"), Constant.Null)).field;
    assertEquals("Name", field.getName());
    assertEquals("Owner", field.getOwner());
    assertEquals("Type", field.getType());
  }
}
