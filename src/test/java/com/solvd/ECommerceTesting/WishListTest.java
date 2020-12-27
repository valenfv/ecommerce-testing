package com.solvd.ECommerceTesting;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.solvd.ECommerceTesting.pages.ECHomePage;
import com.solvd.ECommerceTesting.pages.account.ECMyAccountPage;
import com.solvd.ECommerceTesting.pages.account.ECWishListPage;
import com.solvd.ECommerceTesting.services.LoginService;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest extends AbstractTest implements LoginService {

    /*
    * For this test, the UNEXPECTED_ALERT_BEHAVIOUR capability needs to be set to IGNORE
    * You can check the capability on _config.properties
    *
    * You can find credentials on _testdata.properties
    *
    * ALL sensitive data is being encrypted (passwords)
    * Key for decryption is under ./src/main/resources/crypto.key
    * */

    @Test
    @MethodOwner(owner = "fvazquez")
    @TestPriority(Priority.P3)
    public void createAndDeleteWishList() {
        ECMyAccountPage map = loginDefault(getDriver(), R.TESTDATA.get("credentials"), R.TESTDATA.get("password"));
        ECWishListPage wlp = map.goToWishListPage();
        String wlName = RandomStringUtils.random(10, true, true);
        wlp.createWishList(wlName);
        Assert.assertTrue(wlp.deleteWLByName(wlName), "Wishlist wasnt created");
        Assert.assertFalse(wlp.isWishListPresent(wlName), "Wishlist wasnt deleted");
    }
}
