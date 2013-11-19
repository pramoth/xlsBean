/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.lib.xlsbean;

import com.google.common.collect.Table;
import com.google.common.io.ByteStreams;
import java.io.*;
import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Teng
 */
public class MyCsvTest {

    public MyCsvTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void xlsSingleClassTest() throws Exception {
        System.out.println("singleClassTest----------------------------------------------");
        InputStream in = getClass().getResourceAsStream("/Import1.xls");
        List<SingTypeCsvModel> toBeans = XlsBean.toBeans(SingTypeCsvModel.class, in);
        assertEquals(toBeans.size(), 15);
        for (SingTypeCsvModel b : toBeans) {
            System.out.println(ToStringBuilder.reflectionToString(b));
        }

    }

    @Test
    public void xlsSubClassTest() throws Exception {
        System.out.println("subClassTest----------------------------------------------");
        InputStream in = getClass().getResourceAsStream("/Import1.xls");
        List<SubSingTypeCsvModel> toBeans = XlsBean.toBeans(SubSingTypeCsvModel.class, in);
        assertEquals(toBeans.size(), 15);
        for (SubSingTypeCsvModel b : toBeans) {
            System.out.println(ToStringBuilder.reflectionToString(b));
        }
    }

    @Test
    public void xlsxSingleClassTest() throws Exception {
        System.out.println("singleClassTest----------------------------------------------");
        InputStream in = getClass().getResourceAsStream("/Import1.xlsx");
        List<SingTypeCsvModel> toBeans = XlsBean.toBeans(SingTypeCsvModel.class, in);
        assertEquals(toBeans.size(), 15);
        for (SingTypeCsvModel b : toBeans) {
            System.out.println(ToStringBuilder.reflectionToString(b));
        }

    }

    @Test
    public void xlsxSubClassTest() throws Exception {
        System.out.println("subClassTest----------------------------------------------");
        InputStream in = getClass().getResourceAsStream("/Import1.xlsx");
        List<SubSingTypeCsvModel> toBeans = XlsBean.toBeans(SubSingTypeCsvModel.class, in);
        assertEquals(toBeans.size(), 15);
        for (SubSingTypeCsvModel b : toBeans) {
            System.out.println(ToStringBuilder.reflectionToString(b));
        }
    }

    @Test
    public void toXlsTest() throws Exception {
        System.out.println("toXlsTest----------------------------------------------");
        InputStream in = getClass().getResourceAsStream("/Import1.xls");
        List<SubSingTypeCsvModel> toBeans = XlsBean.toBeans(SubSingTypeCsvModel.class, in);
        assertEquals(toBeans.size(), 15);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XlsBean.toXls("my sheet", toBeans, out, Type.XLS);
        out.flush();
        ByteArrayInputStream in2 = new ByteArrayInputStream(out.toByteArray());
        List<SubSingTypeCsvModel> toBeans2 = XlsBean.toBeans(SubSingTypeCsvModel.class, in2);
        for (SubSingTypeCsvModel b : toBeans2) {
            System.out.println(ToStringBuilder.reflectionToString(b));
        }
        assertArrayEquals(toBeans.toArray(), toBeans2.toArray());
    }

    @Test
    public void toXlsxTest() throws Exception {
        System.out.println("toXlsTest----------------------------------------------");
        InputStream in = getClass().getResourceAsStream("/Import1.xlsx");
        List<SubSingTypeCsvModel> toBeans = XlsBean.toBeans(SubSingTypeCsvModel.class, in);
        assertEquals(toBeans.size(), 15);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XlsBean.toXls("my sheet", toBeans, out, Type.XLSX);
        out.flush();
        ByteArrayInputStream in2 = new ByteArrayInputStream(out.toByteArray());
        List<SubSingTypeCsvModel> toBeans2 = XlsBean.toBeans(SubSingTypeCsvModel.class, in2);
        for (SubSingTypeCsvModel b : toBeans2) {
            System.out.println(ToStringBuilder.reflectionToString(b));
        }
        assertArrayEquals(toBeans.toArray(), toBeans2.toArray());
    }
}
