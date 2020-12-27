package com.solvd.ECommerceTesting;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.solvd.ECommerceTesting.components.ECProductResult;
import com.solvd.ECommerceTesting.pages.ECHomePage;
import com.solvd.ECommerceTesting.pages.search.ECSearchPage;
import com.solvd.ECommerceTesting.services.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class SearchTest extends AbstractTest implements SearchService {

    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "fvazquez")
    @XlsDataSourceParameters(path = "xls/ECData.xlsx", sheet = "search", dsUid = "TUID")
    public void searchResultsShouldContainSearchQuery(HashMap<String, String> args){
        String query = args.get("query");
        ECSearchPage sp = search(getDriver(), query);
        List<ECProductResult> results = sp.getResults();
        Assert.assertTrue(results.size() != 0, "No results found!");
        Assert.assertTrue(results.stream().allMatch(s -> StringUtils.containsIgnoreCase(s.getName(), query)), "All items must contain the query string");
    }
}
