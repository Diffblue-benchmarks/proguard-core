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
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.node.DexAnnotationNode;
import proguard.dexfile.reader.node.DexClassNode;
import proguard.dexfile.reader.node.DexFieldNode;
import proguard.dexfile.reader.node.DexMethodNode;

public class DexClassVisitorDiffblueTest {
  /**
   * Test {@link DexClassVisitor#DexClassVisitor()}.
   *
   * <ul>
   *   <li>Then return {@link DexClassVisitor#visitor} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassVisitor#DexClassVisitor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexClassVisitor.<init>()",
    "void DexClassVisitor.<init>(DexClassVisitor)"
  })
  public void testNewDexClassVisitor_thenReturnVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexClassVisitor()).visitor);
  }

  /**
   * Test {@link DexClassVisitor#DexClassVisitor(DexClassVisitor)}.
   *
   * <ul>
   *   <li>When {@link DexClassVisitor#DexClassVisitor()}.
   *   <li>Then return {@link DexClassVisitor#visitor} {@link DexClassVisitor#visitor} is {@code
   *       null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexClassVisitor#DexClassVisitor(DexClassVisitor)}
   *   <li>{@link DexClassVisitor#DexClassVisitor()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexClassVisitor.<init>()",
    "void DexClassVisitor.<init>(DexClassVisitor)"
  })
  public void testNewDexClassVisitor_whenDexClassVisitor_thenReturnVisitorVisitorIsNull() {
    // Arrange, Act and Assert
    assertNull((new DexClassVisitor(new DexClassVisitor())).visitor.visitor);
  }

  /**
   * Test {@link DexClassVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Given {@link DexClassVisitor#DexClassVisitor(DexClassVisitor)} with dcv is {@link
   *       DexClassVisitor#DexClassVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexClassVisitor.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation_givenDexClassVisitorWithDcvIsDexClassVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new DexClassVisitor(new DexClassVisitor())).visitAnnotation("Name", Visibility.BUILD));
  }

  /**
   * Test {@link DexClassVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Given {@link DexClassVisitor#DexClassVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexClassVisitor.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation_givenDexClassVisitor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new DexClassVisitor()).visitAnnotation("Name", Visibility.BUILD));
  }

  /**
   * Test {@link DexClassVisitor#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Then return {@link DexAnnotationNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassVisitor#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexClassVisitor.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation_thenReturnDexAnnotationNode() {
    // Arrange
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    DexClassVisitor dexClassVisitor = new DexClassVisitor(dcv);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexClassVisitor.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    DexClassVisitor dexClassVisitor2 = dexClassVisitor.visitor;
    assertTrue(dexClassVisitor2 instanceof DexClassNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertNull(((DexAnnotationNode) actualVisitAnnotationResult).visitor);
    List<DexAnnotationNode> dexAnnotationNodeList = ((DexClassNode) dexClassVisitor2).anns;
    assertEquals(1, dexAnnotationNodeList.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
    assertSame(dcv.anns, dexAnnotationNodeList);
  }

  /**
   * Test {@link DexClassVisitor#visitField(int, Field, Object)}.
   *
   * <ul>
   *   <li>Given {@link DexClassVisitor#DexClassVisitor(DexClassVisitor)} with dcv is {@link
   *       DexClassVisitor#DexClassVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassVisitor#visitField(int, Field, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexFieldVisitor DexClassVisitor.visitField(int, Field, Object)"})
  public void testVisitField_givenDexClassVisitorWithDcvIsDexClassVisitor_thenReturnNull() {
    // Arrange
    DexClassVisitor dexClassVisitor = new DexClassVisitor(new DexClassVisitor());

    // Act and Assert
    assertNull(dexClassVisitor.visitField(1, new Field("Owner", "Name", "Type"), Constant.Null));
  }

  /**
   * Test {@link DexClassVisitor#visitField(int, Field, Object)}.
   *
   * <ul>
   *   <li>Given {@link DexClassVisitor#DexClassVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassVisitor#visitField(int, Field, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexFieldVisitor DexClassVisitor.visitField(int, Field, Object)"})
  public void testVisitField_givenDexClassVisitor_thenReturnNull() {
    // Arrange
    DexClassVisitor dexClassVisitor = new DexClassVisitor();

    // Act and Assert
    assertNull(dexClassVisitor.visitField(1, new Field("Owner", "Name", "Type"), Constant.Null));
  }

  /**
   * Test {@link DexClassVisitor#visitField(int, Field, Object)}.
   *
   * <ul>
   *   <li>Then {@link DexClassVisitor#DexClassVisitor(DexClassVisitor)} with dcv is {@link
   *       DexClassNode#DexClassNode(int, String, String, String[])} {@link DexClassVisitor#visitor}
   *       {@link DexClassNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassVisitor#visitField(int, Field, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexFieldVisitor DexClassVisitor.visitField(int, Field, Object)"})
  public void testVisitField_thenDexClassVisitorWithDcvIsDexClassNodeVisitorDexClassNode() {
    // Arrange
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    DexClassVisitor dexClassVisitor = new DexClassVisitor(dcv);

    // Act
    DexFieldVisitor actualVisitFieldResult =
        dexClassVisitor.visitField(1, new Field("Owner", "Name", "Type"), Constant.Null);

    // Assert
    DexClassVisitor dexClassVisitor2 = dexClassVisitor.visitor;
    assertTrue(dexClassVisitor2 instanceof DexClassNode);
    assertTrue(actualVisitFieldResult instanceof DexFieldNode);
    Field field = ((DexFieldNode) actualVisitFieldResult).field;
    assertEquals("Name", field.getName());
    assertEquals("Owner", field.getOwner());
    assertEquals("Type", field.getType());
    assertNull(((DexFieldNode) actualVisitFieldResult).anns);
    assertNull(((DexFieldNode) actualVisitFieldResult).visitor);
    List<DexFieldNode> dexFieldNodeList = ((DexClassNode) dexClassVisitor2).fields;
    assertEquals(1, dexFieldNodeList.size());
    assertEquals(1, ((DexFieldNode) actualVisitFieldResult).access);
    assertSame(dcv.fields, dexFieldNodeList);
  }

  /**
   * Test {@link DexClassVisitor#visitMethod(int, Method)}.
   *
   * <ul>
   *   <li>Given {@link DexClassVisitor#DexClassVisitor(DexClassVisitor)} with dcv is {@link
   *       DexClassVisitor#DexClassVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassVisitor#visitMethod(int, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexMethodVisitor DexClassVisitor.visitMethod(int, Method)"})
  public void testVisitMethod_givenDexClassVisitorWithDcvIsDexClassVisitor_thenReturnNull() {
    // Arrange
    DexClassVisitor dexClassVisitor = new DexClassVisitor(new DexClassVisitor());

    // Act and Assert
    assertNull(
        dexClassVisitor.visitMethod(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"))));
  }

  /**
   * Test {@link DexClassVisitor#visitMethod(int, Method)}.
   *
   * <ul>
   *   <li>Given {@link DexClassVisitor#DexClassVisitor()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassVisitor#visitMethod(int, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexMethodVisitor DexClassVisitor.visitMethod(int, Method)"})
  public void testVisitMethod_givenDexClassVisitor_thenReturnNull() {
    // Arrange
    DexClassVisitor dexClassVisitor = new DexClassVisitor();

    // Act and Assert
    assertNull(
        dexClassVisitor.visitMethod(
            1,
            new Method(
                "Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"))));
  }

  /**
   * Test {@link DexClassVisitor#visitMethod(int, Method)}.
   *
   * <ul>
   *   <li>Then {@link DexClassVisitor#DexClassVisitor(DexClassVisitor)} with dcv is {@link
   *       DexClassNode#DexClassNode(int, String, String, String[])} {@link DexClassVisitor#visitor}
   *       {@link DexClassNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassVisitor#visitMethod(int, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexMethodVisitor DexClassVisitor.visitMethod(int, Method)"})
  public void testVisitMethod_thenDexClassVisitorWithDcvIsDexClassNodeVisitorDexClassNode() {
    // Arrange
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    DexClassVisitor dexClassVisitor = new DexClassVisitor(dcv);
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act
    DexMethodVisitor actualVisitMethodResult =
        dexClassVisitor.visitMethod(1, new Method("Owner", "Name", proto));

    // Assert
    DexClassVisitor dexClassVisitor2 = dexClassVisitor.visitor;
    assertTrue(dexClassVisitor2 instanceof DexClassNode);
    assertTrue(actualVisitMethodResult instanceof DexMethodNode);
    Method method = ((DexMethodNode) actualVisitMethodResult).method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", method.getName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", method.getReturnType());
    assertNull(((DexMethodNode) actualVisitMethodResult).parameterAnns);
    assertNull(((DexMethodNode) actualVisitMethodResult).anns);
    assertNull(((DexMethodNode) actualVisitMethodResult).codeNode);
    assertNull(((DexMethodNode) actualVisitMethodResult).visitor);
    List<DexMethodNode> dexMethodNodeList = ((DexClassNode) dexClassVisitor2).methods;
    assertEquals(1, dexMethodNodeList.size());
    assertEquals(1, method.getParameterTypes().length);
    assertEquals(1, ((DexMethodNode) actualVisitMethodResult).access);
    assertSame(proto, method.getProto());
    assertSame(dcv.methods, dexMethodNodeList);
  }

  /**
   * Test {@link DexClassVisitor#visitSource(String)}.
   *
   * <ul>
   *   <li>Then {@link DexClassVisitor#DexClassVisitor(DexClassVisitor)} with dcv is {@link
   *       DexClassNode#DexClassNode(int, String, String, String[])} {@link DexClassVisitor#visitor}
   *       {@link DexClassNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassVisitor#visitSource(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassVisitor.visitSource(String)"})
  public void testVisitSource_thenDexClassVisitorWithDcvIsDexClassNodeVisitorDexClassNode() {
    // Arrange
    DexClassVisitor dexClassVisitor =
        new DexClassVisitor(
            new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"}));

    // Act
    dexClassVisitor.visitSource("File");

    // Assert
    DexClassVisitor dexClassVisitor2 = dexClassVisitor.visitor;
    assertTrue(dexClassVisitor2 instanceof DexClassNode);
    assertEquals("File", ((DexClassNode) dexClassVisitor2).source);
  }
}
