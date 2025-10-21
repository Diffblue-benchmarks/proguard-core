package proguard.dexfile.reader.node;

import static org.junit.Assert.assertArrayEquals;
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
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.visitors.DexAnnotationVisitor;
import proguard.dexfile.reader.visitors.DexClassVisitor;
import proguard.dexfile.reader.visitors.DexFieldVisitor;
import proguard.dexfile.reader.visitors.DexFileVisitor;
import proguard.dexfile.reader.visitors.DexMethodVisitor;

public class DexClassNodeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Interface Names}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexClassNode#DexClassNode(int, String, String, String[])}
   *   <li>{@link DexClassNode#visitSource(String)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexClassNode.<init>(int, String, String, String[])",
    "void DexClassNode.<init>(DexClassVisitor, int, String, String, String[])",
    "void DexClassNode.visitSource(String)"
  })
  public void testGettersAndSetters_whenArrayOfStringWithInterfaceNames() {
    // Arrange and Act
    DexClassNode actualDexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    actualDexClassNode.visitSource("File");

    // Assert
    assertEquals("Class Name", actualDexClassNode.className);
    assertEquals("File", actualDexClassNode.source);
    assertEquals("Super Class", actualDexClassNode.superClass);
    assertNull(actualDexClassNode.anns);
    assertNull(actualDexClassNode.fields);
    assertNull(actualDexClassNode.methods);
    assertEquals(1, actualDexClassNode.access);
    assertArrayEquals(new String[] {"Interface Names"}, actualDexClassNode.interfaceNames);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link DexClassVisitor#DexClassVisitor()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DexClassNode#DexClassNode(DexClassVisitor, int, String, String, String[])}
   *   <li>{@link DexClassNode#visitSource(String)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexClassNode.<init>(int, String, String, String[])",
    "void DexClassNode.<init>(DexClassVisitor, int, String, String, String[])",
    "void DexClassNode.visitSource(String)"
  })
  public void testGettersAndSetters_whenDexClassVisitor() {
    // Arrange and Act
    DexClassNode actualDexClassNode =
        new DexClassNode(
            new DexClassVisitor(),
            1,
            "Class Name",
            "Super Class",
            new String[] {"Interface Names"});
    actualDexClassNode.visitSource("File");

    // Assert
    assertEquals("Class Name", actualDexClassNode.className);
    assertEquals("File", actualDexClassNode.source);
    assertEquals("Super Class", actualDexClassNode.superClass);
    assertNull(actualDexClassNode.anns);
    assertNull(actualDexClassNode.fields);
    assertNull(actualDexClassNode.methods);
    assertEquals(1, actualDexClassNode.access);
    assertArrayEquals(new String[] {"Interface Names"}, actualDexClassNode.interfaceNames);
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    dexClassNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    assertNull(dexClassNode.source);
    assertNull(dexClassNode.anns);
    assertNull(dexClassNode.fields);
    assertNull(dexClassNode.methods);
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv2() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    // Act
    dexClassNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    assertEquals(1, dexClassNode.anns.size());
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv3() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitField(1, new Field("Owner", "Name", "Type"), Constant.Null);

    // Act
    dexClassNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    assertEquals(1, dexClassNode.fields.size());
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv4() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitMethod(
        1, new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    dexClassNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    assertEquals(1, dexClassNode.methods.size());
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv5() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    // Act
    dexClassNode.accept(new DexClassVisitor(new DexClassVisitor()));

    // Assert that nothing has changed
    assertEquals(1, dexClassNode.anns.size());
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv6() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitField(1, new Field("Owner", "Name", "Type"), Constant.Null);

    // Act
    dexClassNode.accept(new DexClassVisitor(new DexClassVisitor()));

    // Assert that nothing has changed
    assertEquals(1, dexClassNode.fields.size());
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv7() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitMethod(
        1, new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));

    // Act
    dexClassNode.accept(new DexClassVisitor(new DexClassVisitor()));

    // Assert that nothing has changed
    assertEquals(1, dexClassNode.methods.size());
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv8() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitSource("File");
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    dexClassNode.accept(dcv);

    // Assert
    assertEquals("File", dcv.source);
    assertNull(dcv.anns);
    assertNull(dcv.fields);
    assertNull(dcv.methods);
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv9() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);
    dexClassNode.visitSource("File");
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    dexClassNode.accept(dcv);

    // Assert
    List<DexAnnotationNode> dexAnnotationNodeList = dcv.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv10() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    Field field = new Field("Owner", "Name", "Type");

    dexClassNode.visitField(1, field, Constant.Null);
    dexClassNode.visitSource("File");
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    dexClassNode.accept(dcv);

    // Assert
    List<DexFieldNode> dexFieldNodeList = dcv.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertNull(getResult.anns);
    assertEquals(1, getResult.access);
    assertSame(field, getResult.field);
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv11() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    Method method =
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    dexClassNode.visitMethod(1, method);
    dexClassNode.visitSource("File");
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    dexClassNode.accept(dcv);

    // Assert
    List<DexMethodNode> dexMethodNodeList = dcv.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.parameterAnns);
    assertNull(getResult.anns);
    assertNull(getResult.codeNode);
    assertEquals(1, getResult.access);
    assertSame(method, getResult.method);
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv12() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);
    dexClassNode.visitSource("File");

    // Act
    dexClassNode.accept(
        new DexClassVisitor(
            new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"})));

    // Assert that nothing has changed
    assertEquals("File", dexClassNode.source);
    assertEquals(1, dexClassNode.anns.size());
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv13() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitField(1, new Field("Owner", "Name", "Type"), Constant.Null);
    dexClassNode.visitSource("File");

    // Act
    dexClassNode.accept(
        new DexClassVisitor(
            new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"})));

    // Assert that nothing has changed
    assertEquals("File", dexClassNode.source);
    assertEquals(1, dexClassNode.fields.size());
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv14() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitMethod(
        1, new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type")));
    dexClassNode.visitSource("File");

    // Act
    dexClassNode.accept(
        new DexClassVisitor(
            new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"})));

    // Assert that nothing has changed
    assertEquals("File", dexClassNode.source);
    assertEquals(1, dexClassNode.methods.size());
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>When {@link DexClassVisitor#DexClassVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv_whenDexClassVisitor() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitSource("File");

    // Act
    dexClassNode.accept(new DexClassVisitor());

    // Assert that nothing has changed
    assertEquals("File", dexClassNode.source);
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>When {@link DexClassVisitor#DexClassVisitor(DexClassVisitor)} with dcv is {@link
   *       DexClassNode#DexClassNode(int, String, String, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv_whenDexClassVisitorWithDcvIsDexClassNode() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitSource("File");

    // Act
    dexClassNode.accept(
        new DexClassVisitor(
            new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"})));

    // Assert that nothing has changed
    assertEquals("File", dexClassNode.source);
  }

  /**
   * Test {@link DexClassNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <ul>
   *   <li>When {@link DexClassVisitor#DexClassVisitor(DexClassVisitor)} with dcv is {@link
   *       DexClassVisitor#DexClassVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassNode#accept(DexClassVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexClassVisitor)"})
  public void testAcceptWithDcv_whenDexClassVisitorWithDcvIsDexClassVisitor() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitSource("File");

    // Act
    dexClassNode.accept(new DexClassVisitor(new DexClassVisitor()));

    // Assert that nothing has changed
    assertEquals("File", dexClassNode.source);
  }

  /**
   * Test {@link DexClassNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#anns} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexFileVisitor)"})
  public void testAcceptWithDfv_thenDexFileNodeClzsFirstAnnsSizeIsOne() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    List<DexAnnotationNode> dexAnnotationNodeList = dexClassNodeList.get(0).anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexClassNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#fields} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexFileVisitor)"})
  public void testAcceptWithDfv_thenDexFileNodeClzsFirstFieldsSizeIsOne() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    Field field = new Field("Owner", "Name", "Type");

    dexClassNode.visitField(1, field, Constant.Null);
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    List<DexFieldNode> dexFieldNodeList = dexClassNodeList.get(0).fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertNull(getResult.anns);
    List<DexFieldNode> dexFieldNodeList2 = dexClassNode.fields;
    assertEquals(1, dexFieldNodeList2.size());
    assertEquals(1, getResult.access);
    assertSame(field, dexFieldNodeList2.get(0).field);
    assertSame(field, getResult.field);
  }

  /**
   * Test {@link DexClassNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#methods} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexFileVisitor)"})
  public void testAcceptWithDfv_thenDexFileNodeClzsFirstMethodsSizeIsOne() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    Method method =
        new Method("Owner", "Name", new Proto(new String[] {"Parameter Types"}, "Return Type"));

    dexClassNode.visitMethod(1, method);
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    List<DexMethodNode> dexMethodNodeList = dexClassNodeList.get(0).methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.parameterAnns);
    assertNull(getResult.anns);
    assertNull(getResult.codeNode);
    List<DexMethodNode> dexMethodNodeList2 = dexClassNode.methods;
    assertEquals(1, dexMethodNodeList2.size());
    assertEquals(1, getResult.access);
    assertSame(method, dexMethodNodeList2.get(0).method);
    assertSame(method, getResult.method);
  }

  /**
   * Test {@link DexClassNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#source} is {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexFileVisitor)"})
  public void testAcceptWithDfv_thenDexFileNodeClzsFirstSourceIsFile() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.visitSource("File");
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    DexClassNode getResult = dexClassNodeList.get(0);
    assertEquals("File", getResult.source);
    assertNull(getResult.anns);
    assertNull(getResult.fields);
    assertNull(getResult.methods);
  }

  /**
   * Test {@link DexClassNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>When {@link DexFileNode} (default constructor).
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#source} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexClassNode#accept(DexFileVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexClassNode.accept(DexFileVisitor)"})
  public void testAcceptWithDfv_whenDexFileNode_thenDexFileNodeClzsFirstSourceIsNull() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    DexFileNode dfv = new DexFileNode();

    // Act
    dexClassNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList = dfv.clzs;
    assertEquals(1, dexClassNodeList.size());
    DexClassNode getResult = dexClassNodeList.get(0);
    assertNull(getResult.source);
    assertNull(getResult.anns);
    assertNull(getResult.fields);
    assertNull(getResult.methods);
  }

  /**
   * Test {@link DexClassNode#visitAnnotation(String, Visibility)}.
   *
   * <p>Method under test: {@link DexClassNode#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexClassNode.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexClassNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Test {@link DexClassNode#visitAnnotation(String, Visibility)}.
   *
   * <p>Method under test: {@link DexClassNode#visitAnnotation(String, Visibility)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexAnnotationVisitor DexClassNode.visitAnnotation(String, Visibility)"})
  public void testVisitAnnotation2() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.anns = new ArrayList<>();

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexClassNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Test {@link DexClassNode#visitField(int, Field, Object)}.
   *
   * <p>Method under test: {@link DexClassNode#visitField(int, Field, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexFieldVisitor DexClassNode.visitField(int, Field, Object)"})
  public void testVisitField() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Act
    DexFieldVisitor actualVisitFieldResult =
        dexClassNode.visitField(1, new Field("Owner", "Name", "Type"), Constant.Null);

    // Assert
    assertTrue(actualVisitFieldResult instanceof DexFieldNode);
    Field field = ((DexFieldNode) actualVisitFieldResult).field;
    assertEquals("Name", field.getName());
    assertEquals("Owner", field.getOwner());
    assertEquals("Type", field.getType());
    assertNull(((DexFieldNode) actualVisitFieldResult).anns);
    assertEquals(1, dexClassNode.fields.size());
    assertEquals(1, ((DexFieldNode) actualVisitFieldResult).access);
  }

  /**
   * Test {@link DexClassNode#visitField(int, Field, Object)}.
   *
   * <p>Method under test: {@link DexClassNode#visitField(int, Field, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexFieldVisitor DexClassNode.visitField(int, Field, Object)"})
  public void testVisitField2() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.fields = new ArrayList<>();

    // Act
    DexFieldVisitor actualVisitFieldResult =
        dexClassNode.visitField(1, new Field("Owner", "Name", "Type"), Constant.Null);

    // Assert
    assertTrue(actualVisitFieldResult instanceof DexFieldNode);
    Field field = ((DexFieldNode) actualVisitFieldResult).field;
    assertEquals("Name", field.getName());
    assertEquals("Owner", field.getOwner());
    assertEquals("Type", field.getType());
    assertNull(((DexFieldNode) actualVisitFieldResult).anns);
    assertEquals(1, dexClassNode.fields.size());
    assertEquals(1, ((DexFieldNode) actualVisitFieldResult).access);
  }

  /**
   * Test {@link DexClassNode#visitMethod(int, Method)}.
   *
   * <p>Method under test: {@link DexClassNode#visitMethod(int, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexMethodVisitor DexClassNode.visitMethod(int, Method)"})
  public void testVisitMethod() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act
    DexMethodVisitor actualVisitMethodResult =
        dexClassNode.visitMethod(1, new Method("Owner", "Name", proto));

    // Assert
    assertTrue(actualVisitMethodResult instanceof DexMethodNode);
    Method method = ((DexMethodNode) actualVisitMethodResult).method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", method.getName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", method.getReturnType());
    assertNull(((DexMethodNode) actualVisitMethodResult).parameterAnns);
    assertNull(((DexMethodNode) actualVisitMethodResult).anns);
    assertNull(((DexMethodNode) actualVisitMethodResult).codeNode);
    assertEquals(1, dexClassNode.methods.size());
    assertEquals(1, method.getParameterTypes().length);
    assertEquals(1, ((DexMethodNode) actualVisitMethodResult).access);
    assertSame(proto, method.getProto());
  }

  /**
   * Test {@link DexClassNode#visitMethod(int, Method)}.
   *
   * <p>Method under test: {@link DexClassNode#visitMethod(int, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DexMethodVisitor DexClassNode.visitMethod(int, Method)"})
  public void testVisitMethod2() {
    // Arrange
    DexClassNode dexClassNode =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});
    dexClassNode.methods = new ArrayList<>();
    Proto proto = new Proto(new String[] {"Parameter Types"}, "Return Type");

    // Act
    DexMethodVisitor actualVisitMethodResult =
        dexClassNode.visitMethod(1, new Method("Owner", "Name", proto));

    // Assert
    assertTrue(actualVisitMethodResult instanceof DexMethodNode);
    Method method = ((DexMethodNode) actualVisitMethodResult).method;
    assertEquals("(Parameter Types)Return Type", method.getDesc());
    assertEquals("Name", method.getName());
    assertEquals("Owner", method.getOwner());
    assertEquals("Return Type", method.getReturnType());
    assertNull(((DexMethodNode) actualVisitMethodResult).parameterAnns);
    assertNull(((DexMethodNode) actualVisitMethodResult).anns);
    assertNull(((DexMethodNode) actualVisitMethodResult).codeNode);
    assertEquals(1, dexClassNode.methods.size());
    assertEquals(1, method.getParameterTypes().length);
    assertEquals(1, ((DexMethodNode) actualVisitMethodResult).access);
    assertSame(proto, method.getProto());
  }
}
