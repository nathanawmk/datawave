package datawave.webservice.query.metric;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import datawave.marking.MarkingFunctions;
import datawave.webservice.query.exception.BadRequestQueryException;
import datawave.webservice.query.exception.DatawaveErrorCode;
import datawave.webservice.query.metric.BaseQueryMetric.Lifecycle;
import datawave.webservice.query.metric.BaseQueryMetric.PageMetric;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class QueryMetricTest {
    
    private static QueryMetric queryMetric = null;
    private static Map<String,String> markings = null;
    private static List<String> negativeSelectors = null;
    private static ArrayList<PageMetric> pageTimes = null;
    private static List<String> positiveSelectors = null;
    private static List<String> proxyServers = null;
    
    @BeforeClass
    public static void setup() {
        
        queryMetric = new QueryMetric();
        markings = new HashMap<String,String>();
        markings.put(MarkingFunctions.Default.COLUMN_VISIBILITY, "PUBLIC");
        queryMetric.setMarkings(markings);
        negativeSelectors = new ArrayList<String>();
        negativeSelectors.add("negativeSelector1");
        positiveSelectors = new ArrayList<String>();
        positiveSelectors.add("positiveSelector1");
        pageTimes = new ArrayList<PageMetric>();
        PageMetric pageMetric = new PageMetric();
        pageMetric.setCallTime(0);
        pageTimes.add(pageMetric);
        proxyServers = new ArrayList<String>();
        proxyServers.add("proxyServer1");
    }
    
    @Test
    public void testSetError() {
        BadRequestQueryException qe = new BadRequestQueryException(DatawaveErrorCode.FIELDS_NOT_IN_DATA_DICTIONARY, "test");
        Exception e = new Exception(qe);
        
        queryMetric.setError(e);
        assertEquals("The query contained fields which do not exist in the data dictionary for any specified datatype. test", queryMetric.getErrorMessage());
        assertEquals("400-16", queryMetric.getErrorCode());
        
        queryMetric.setErrorCode("");
        Throwable t = new Throwable("non-datawave error");
        queryMetric.setError(t);
        assertEquals("non-datawave error", queryMetric.getErrorMessage());
        assertEquals("", queryMetric.getErrorCode());
    }
    
    @Test
    public void testMetricVersion() {
        QueryMetric metric = new QueryMetric();
        Date d = new Date();
        metric.setBeginDate(d);
        metric.setCreateCallTime(0);
        metric.setCreateDate(d);
        metric.setEndDate(d);
        metric.setErrorCode("error");
        metric.setErrorMessage("errorMessage");
        metric.setHost("host");
        metric.setLastUpdated(d);
        metric.setLastWrittenHash(0);
        metric.setLifecycle(Lifecycle.INITIALIZED);
        metric.setMarkings(markings);
        metric.setNegativeSelectors(negativeSelectors);
        metric.setNumUpdates(0);
        metric.setPageTimes(pageTimes);
        metric.setPositiveSelectors(positiveSelectors);
        metric.setProxyServers(proxyServers);
        metric.setQuery("query");
        metric.setQueryAuthorizations("auths");
        metric.setQueryId("queryId");
        metric.setQueryLogic("queryLogic");
        metric.setQueryType(this.getClass());
        metric.setQueryType("queryType");
        metric.setSetupTime(0);
        metric.setUser("user");
        metric.setUserDN("userDN");
        
        try {
            final Properties props = new Properties();
            String inputPath = QueryMetricTest.class.getClassLoader().getResource("version.properties").getPath();
            props.load(new FileInputStream(inputPath));
            String propStr = props.getProperty("currentVersion");
            metric.setVersion(propStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        assertEquals(d, metric.getBeginDate());
        assertEquals("PUBLIC", metric.getColumnVisibility());
        assertEquals(0, metric.getCreateCallTime());
        assertEquals(d, metric.getCreateDate());
        assertEquals(0, metric.getElapsedTime());
        assertEquals(d, metric.getEndDate());
        assertEquals("error", metric.getErrorCode());
        assertEquals("errorMessage", metric.getErrorMessage());
        assertEquals("host", metric.getHost());
        assertEquals(d, metric.getLastUpdated());
        assertEquals(0, metric.getLastWrittenHash());
        assertEquals(Lifecycle.INITIALIZED, metric.getLifecycle());
        assertEquals("PUBLIC", metric.getMarkings().get(MarkingFunctions.Default.COLUMN_VISIBILITY));
        assertEquals("negativeSelector1", metric.getNegativeSelectors().get(0));
        assertEquals(0, metric.getNumPages());
        assertEquals(0, metric.getNumResults());
        assertEquals(0, metric.getNumUpdates());
        assertEquals(0, metric.getPageTimes().get(0).getCallTime());
        assertEquals("positiveSelector1", metric.getPositiveSelectors().get(0));
        assertEquals("proxyServer1", metric.getProxyServers().iterator().next());
        assertEquals("query", metric.getQuery());
        assertEquals("auths", metric.getQueryAuthorizations());
        assertEquals("queryId", metric.getQueryId());
        assertEquals("queryLogic", metric.getQueryLogic());
        assertEquals("queryType", metric.getQueryType());
        assertEquals(0, metric.getSetupTime());
        assertEquals("user", metric.getUser());
        assertEquals("userDN", metric.getUserDN());
        assertEquals("3.5.1-TEST", metric.getVersion());
    }
    
    @Test
    public void testSettersGetters() {
        Date d = new Date();
        queryMetric.setBeginDate(d);
        queryMetric.setCreateCallTime(0);
        queryMetric.setCreateDate(d);
        queryMetric.setEndDate(d);
        queryMetric.setErrorCode("error");
        queryMetric.setErrorMessage("errorMessage");
        queryMetric.setHost("host");
        queryMetric.setLastUpdated(d);
        queryMetric.setLastWrittenHash(0);
        queryMetric.setLifecycle(Lifecycle.INITIALIZED);
        queryMetric.setMarkings(markings);
        queryMetric.setNegativeSelectors(negativeSelectors);
        queryMetric.setNumUpdates(0);
        queryMetric.setPageTimes(pageTimes);
        queryMetric.setPositiveSelectors(positiveSelectors);
        queryMetric.setProxyServers(proxyServers);
        queryMetric.setQuery("query");
        queryMetric.setQueryAuthorizations("auths");
        queryMetric.setQueryId("queryId");
        queryMetric.setQueryLogic("queryLogic");
        queryMetric.setQueryType(this.getClass());
        queryMetric.setQueryType("queryType");
        queryMetric.setSetupTime(0);
        queryMetric.setUser("user");
        queryMetric.setUserDN("userDN");
        
        assertEquals(d, queryMetric.getBeginDate());
        assertEquals("PUBLIC", queryMetric.getColumnVisibility());
        assertEquals(0, queryMetric.getCreateCallTime());
        assertEquals(d, queryMetric.getCreateDate());
        assertEquals(0, queryMetric.getElapsedTime());
        assertEquals(d, queryMetric.getEndDate());
        assertEquals("error", queryMetric.getErrorCode());
        assertEquals("errorMessage", queryMetric.getErrorMessage());
        assertEquals("host", queryMetric.getHost());
        assertEquals(d, queryMetric.getLastUpdated());
        assertEquals(0, queryMetric.getLastWrittenHash());
        assertEquals(Lifecycle.INITIALIZED, queryMetric.getLifecycle());
        assertEquals("PUBLIC", queryMetric.getMarkings().get(MarkingFunctions.Default.COLUMN_VISIBILITY));
        assertEquals("negativeSelector1", queryMetric.getNegativeSelectors().get(0));
        assertEquals(0, queryMetric.getNumPages());
        assertEquals(0, queryMetric.getNumResults());
        assertEquals(0, queryMetric.getNumUpdates());
        assertEquals(0, queryMetric.getPageTimes().get(0).getCallTime());
        assertEquals("positiveSelector1", queryMetric.getPositiveSelectors().get(0));
        assertEquals("proxyServer1", queryMetric.getProxyServers().iterator().next());
        assertEquals("query", queryMetric.getQuery());
        assertEquals("auths", queryMetric.getQueryAuthorizations());
        assertEquals("queryId", queryMetric.getQueryId());
        assertEquals("queryLogic", queryMetric.getQueryLogic());
        assertEquals("queryType", queryMetric.getQueryType());
        assertEquals(0, queryMetric.getSetupTime());
        assertEquals("user", queryMetric.getUser());
        assertEquals("userDN", queryMetric.getUserDN());
    }
    
    @Test
    public void testJsonSerialization() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JaxbAnnotationModule());
        String metricAsBytes = objectMapper.writeValueAsString(queryMetric);
        QueryMetric deserializedMetric = objectMapper.readValue(metricAsBytes, QueryMetric.class);
        assertEquals(queryMetric, deserializedMetric);
    }
    
    @Test
    public void testXmlSerialization() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(QueryMetric.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        marshaller.marshal(queryMetric, baos);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        QueryMetric deserializedMetric = (QueryMetric) unmarshaller.unmarshal(new ByteArrayInputStream(baos.toByteArray()));
        assertEquals(queryMetric, deserializedMetric);
    }
    
    @Test
    public void testProtobufSerialization() throws Exception {
        Schema<QueryMetric> schema = (Schema<QueryMetric>) queryMetric.getSchemaInstance();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ProtostuffIOUtil.writeTo(baos, queryMetric, schema, LinkedBuffer.allocate());
        QueryMetric deserializedMetric = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(baos.toByteArray(), deserializedMetric, schema);
        assertEquals(queryMetric, deserializedMetric);
    }
}
