package com.ugamsProj.core.models.Impl;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.ugamsProj.core.models.ServiceDemo;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junitx.util.PrivateAccessor;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class ServiceDemoImplTest {
    private final AemContext aemContext = new AemContext(ResourceResolverType.JCR_MOCK);

    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(ServiceDemo.class);
        aemContext.load().json("/UserNamesService.json","/home");
    }

    @Test
    void getUsersList() throws RepositoryException, NoSuchFieldException {
        ServiceDemo userNames = aemContext.request().adaptTo(ServiceDemo.class);
        final List<Hit> results = new ArrayList<>();
        Hit UserResult1 = mock(Hit.class);
        Mockito.when(UserResult1.getProperties()).thenReturn(aemContext.currentResource("/home/users/ugam").getValueMap());
        results.add(UserResult1);
        SearchResult SearchResult = mock(SearchResult.class);
        Query userQuery = mock(Query.class);
        QueryBuilder queryBuilder = mock(QueryBuilder.class);
        PrivateAccessor.setField(userNames, "queryBuilder", queryBuilder);
        Mockito.when(queryBuilder.createQuery(Mockito.any(PredicateGroup.class), Mockito.any(Session.class))).thenReturn(userQuery);
        Mockito.when(userQuery.getResult()).thenReturn(SearchResult);
        Mockito.when(SearchResult.getHits()).thenReturn(results);
        assertEquals(" "+"\r\nugamsProj",userNames.getUsersList());
    }
}