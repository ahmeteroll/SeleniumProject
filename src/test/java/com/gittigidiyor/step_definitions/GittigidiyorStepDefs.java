package com.gittigidiyor.step_definitions;
import com.gittigidiyor.pages.GittigitiyorPage;
import com.gittigidiyor.utilities.BrowserUtility;
import com.gittigidiyor.utilities.ConfigurationReader;
import com.gittigidiyor.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import java.io.FileWriter;
import java.io.IOException;
import org.apache.log4j.Logger;

public class GittigidiyorStepDefs {

    private static Logger logger = Logger.getLogger(GittigidiyorStepDefs.class);
    String searchItem = "bilgisayar";
    String price;
    GittigitiyorPage gg = new GittigitiyorPage();


    @Given("user navigates to gittigidiyor website")
    public void user_navigates_to_gittigidiyor_website() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtility.waitForClickElement(gg.closeCookies);
        gg.closeCookies.click();
    }

    @When("user searchs for {string}")
    public void user_searchs_for(String string) throws InterruptedException{
        BrowserUtility.waitForClickElement(gg.searchBox);
        gg.searchBox.click();
        gg.searchBox.sendKeys(searchItem);
        Thread.sleep(1000);
        gg.searchSubmit.click();
        Thread.sleep(2000);
    }

    @When("user navitages to second page")
    public void user_navitages_to_second_page() throws InterruptedException{
        BrowserUtility.waitForClickElement(gg.secondPage);
        gg.secondPage.click();
        Thread.sleep(2000);
    }

    @Then("user is on the second page")
    public void user_is_on_the_second_page() {
        String currentUrl = "https://www.gittigidiyor.com/arama?k=bilgisayar&sf=2";
        Assert.assertEquals(Driver.get().getCurrentUrl(), currentUrl);
        logger.info("User is on the second page.");

    }

    @When("user adds random item to basket")
    public void user_adds_random_item_to_basket() throws InterruptedException, IOException {
        BrowserUtility.waitForClickElement(gg.item);
        gg.item.click();
        Thread.sleep(2000);
        price = gg.priceOnItemPage.getText();

        FileWriter file = new FileWriter("D:\\Ahmet\\Projects\\TestiniumTask\\SeleniumProject\\item.txt", true);
        file.write(gg.itemInfo.getText());
        file.write("\n");
        file.write(price);
        file.close();
        gg.addToBasket.click();
        Thread.sleep(2000);
        gg.goToBasket.click();
        Thread.sleep(1000);
    }

    @Then("user validates item price")
    public void user_validates_item_price() {
        System.out.println(price);
        System.out.println(gg.priceOnBasket.getText());
        Assert.assertEquals(gg.priceOnBasket.getText(), price);
        logger.info("Prices are equal.");
    }

    @When("user increases the count")
    public void user_increases_the_count() throws InterruptedException{
        BrowserUtility.waitForClickElement(gg.amount);
        gg.amount.click();
        BrowserUtility.waitForClickElement(gg.count);
        gg.count.click();
        Thread.sleep(1000);
    }

    @Then("user checks item count")
    public void user_checks_item_count() {
        String count = "2";
        String updatedCount = gg.updatedCount.getAttribute("value");
        Assert.assertEquals(updatedCount, count);
        logger.info("Item count is 2.");

    }

    @When("user deleted the item")
    public void user_deleted_the_item() throws InterruptedException{
        Thread.sleep(1000);
        gg.deleteItem.click();
        Thread.sleep(1000);
    }

    @Then("user validates empty basket")
    public void user_validates_empty_basket() throws InterruptedException{
        String emptyBasket = "Sepetinizde ürün bulunmamaktadır.";
        Assert.assertEquals(gg.emptyBasket.getText(), emptyBasket);
        logger.info("Shopping cart is empty.");
        Driver.get().quit();
    }


}
