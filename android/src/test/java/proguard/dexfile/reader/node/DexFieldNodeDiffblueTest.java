package proguard.dexfile.reader.node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.visitors.DexAnnotationVisitor;
import proguard.dexfile.reader.visitors.DexClassVisitor;
import proguard.dexfile.reader.visitors.DexFieldVisitor;

public class DexFieldNodeDiffblueTest {
  /**
   * Test {@link DexFieldNode#DexFieldNode(DexFieldVisitor, int, Field, Object)}.
   *
   * <ul>
   *   <li>When {@link DexFieldVisitor#DexFieldVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldNode#DexFieldNode(DexFieldVisitor, int, Field, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexFieldNode.<init>(int, Field, Object)",
    "void DexFieldNode.<init>(DexFieldVisitor, int, Field, Object)"
  })
  public void testNewDexFieldNode_whenDexFieldVisitor() {
    // Arrange
    DexFieldVisitor visitor = new DexFieldVisitor();

    // Act and Assert
    Field field =
        (new DexFieldNode(visitor, 1, new Field("Owner", "Name", "Type"), Constant.Null)).field;
    assertEquals("Name", field.getName());
    assertEquals("Owner", field.getOwner());
    assertEquals("Type", field.getType());
  }

  /**
   * Test {@link DexFieldNode#DexFieldNode(int, Field, Object)}.
   *
   * <ul>
   *   <li>When {@link Field#Field(String, String, String)} with {@code Owner} and {@code Name} and
   *       {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldNode#DexFieldNode(int, Field, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexFieldNode.<init>(int, Field, Object)",
    "void DexFieldNode.<init>(DexFieldVisitor, int, Field, Object)"
  })
  public void testNewDexFieldNode_whenFieldWithOwnerAndNameAndType() {
    // Arrange, Act and Assert
    Field field = (new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null)).field;
    assertEquals("Name", field.getName());
    assertEquals("Owner", field.getOwner());
    assertEquals("Type", field.getType());
  }

  /**
   * Test {@link DexFieldNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFieldNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFieldNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv() {
    // Arrange
    DexFieldNode dexFieldNode =
        new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    dexFieldNode.accept(dcv);

    // Assert
    List<DexFieldNode> dexFieldNodeList = dcv.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertNull(getResult.anns);
    assertEquals(1, getResult.access);
    assertSame(dexFieldNode.cst, getResult.cst);
    assertSame(dexFieldNode.field, getResult.field);
  }

  /**
   * Test {@link DexFieldNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFieldNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFieldNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv2() {
    // Arrange
    DexFieldNode dexFieldNode =
        new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);
    dexFieldNode.visitAnnotation("Name", Visibility.BUILD);
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    dexFieldNode.accept(dcv);

    // Assert
    List<DexFieldNode> dexFieldNodeList = dcv.fields;
    assertEquals(1, dexFieldNodeList.size());
    List<DexAnnotationNode> dexAnnotationNodeList = dexFieldNodeList.get(0).anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexFieldNode#visitAnnotation(String, Visibility)}.
   *
   * <p>Method under test: {@link DexFieldNode#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexFieldNode.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation() {
    // Arrange
    DexFieldNode dexFieldNode =
        new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);
    dexFieldNode.anns = new ArrayList<>();

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexFieldNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexFieldNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Test {@link DexFieldNode#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Given {@link DexFieldNode#DexFieldNode(int, Field, Object)} with access is one and field
   *       is {@link Field#Field(String, String, String)} and cst is {@link Constant#Null}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldNode#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexFieldNode.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation_givenDexFieldNodeWithAccessIsOneAndFieldIsFieldAndCstIsNull() {
    // Arrange
    DexFieldNode dexFieldNode =
        new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexFieldNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexFieldNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }
}
