package com.canaparro.hw.bedreport;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BedReportServiceTest {

    @Mock
    private ElasticsearchOperations elasticsearchOperations;

    private BedReportService bedReportService;

    @BeforeEach
    void initialization() {
        bedReportService = new BedReportService(elasticsearchOperations);
    }

    @Test
    public void buildQueryByParameters_withoutParameters_returnsEmptyQuery() {
        BoolQueryBuilder query = bedReportService.buildQueryByParameters(null, null, null);
        assertFalse(query.hasClauses());
    }

    @Test
    public void buildQueryByParameters_withEmptyParameters_returnsEmptyQuery() {
        BoolQueryBuilder query = bedReportService.buildQueryByParameters("", "", "");
        assertFalse(query.hasClauses());
    }

    @Test
    public void buildQueryByParameters_withStateParameter_returnsEmptyQuery() {
        BoolQueryBuilder query = bedReportService.buildQueryByParameters("state", null, null);
        assertTrue(query.hasClauses());
        assertEquals(1, query.must().size());
        assertEquals(0, query.mustNot().size());
        assertEquals(0, query.should().size());
        assertEquals(0, query.filter().size());
        MatchQueryBuilder stateQueryBuilder = (MatchQueryBuilder) query.must().get(0);
        assertEquals(BedReport.STATE, stateQueryBuilder.fieldName());
        assertEquals("state", stateQueryBuilder.value());
        assertEquals(Operator.AND, stateQueryBuilder.operator());
        assertEquals(Fuzziness.TWO, stateQueryBuilder.fuzziness());
    }

    @Test
    public void buildQueryByParameters_withStateAndCityParameters_returnsEmptyQuery() {
        BoolQueryBuilder query = bedReportService.buildQueryByParameters("state", "city", null);
        assertTrue(query.hasClauses());
        assertEquals(2, query.must().size());
        assertEquals(0, query.mustNot().size());
        assertEquals(0, query.should().size());
        assertEquals(0, query.filter().size());
        MatchQueryBuilder stateQueryBuilder = (MatchQueryBuilder) query.must().get(0);
        assertEquals(BedReport.STATE, stateQueryBuilder.fieldName());
        assertEquals("state", stateQueryBuilder.value());
        assertEquals(Operator.AND, stateQueryBuilder.operator());
        assertEquals(Fuzziness.TWO, stateQueryBuilder.fuzziness());
        MatchQueryBuilder cityQueryBuilder = (MatchQueryBuilder) query.must().get(1);
        assertEquals(BedReport.CITY, cityQueryBuilder.fieldName());
        assertEquals("city", cityQueryBuilder.value());
        assertEquals(Operator.AND, cityQueryBuilder.operator());
        assertEquals(Fuzziness.TWO, cityQueryBuilder.fuzziness());

    }

    @Test
    public void buildQueryByParameters_withStateAndCityAndHospitalParameter_returnsEmptyQuery() {
        BoolQueryBuilder query = bedReportService.buildQueryByParameters("state", "city", "hospital");
        assertTrue(query.hasClauses());
        assertEquals(3, query.must().size());
        assertEquals(0, query.mustNot().size());
        assertEquals(0, query.should().size());
        assertEquals(0, query.filter().size());
        MatchQueryBuilder stateQueryBuilder = (MatchQueryBuilder) query.must().get(0);
        assertEquals(BedReport.STATE, stateQueryBuilder.fieldName());
        assertEquals("state", stateQueryBuilder.value());
        assertEquals(Operator.AND, stateQueryBuilder.operator());
        assertEquals(Fuzziness.TWO, stateQueryBuilder.fuzziness());
        MatchQueryBuilder cityQueryBuilder = (MatchQueryBuilder) query.must().get(1);
        assertEquals(BedReport.CITY, cityQueryBuilder.fieldName());
        assertEquals("city", cityQueryBuilder.value());
        assertEquals(Operator.AND, cityQueryBuilder.operator());
        assertEquals(Fuzziness.TWO, cityQueryBuilder.fuzziness());
        MatchQueryBuilder hospitalQueryBuilder = (MatchQueryBuilder) query.must().get(2);
        assertEquals(BedReport.HOSPITAL, hospitalQueryBuilder.fieldName());
        assertEquals("hospital", hospitalQueryBuilder.value());
        assertEquals(Operator.AND, hospitalQueryBuilder.operator());
        assertEquals(Fuzziness.TWO, hospitalQueryBuilder.fuzziness());
    }
}
