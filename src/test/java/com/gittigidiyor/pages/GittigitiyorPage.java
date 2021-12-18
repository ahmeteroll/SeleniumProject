package com.gittigidiyor.pages;
import com.gittigidiyor.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GittigitiyorPage extends BasePage{



    @FindBy(xpath = "//input[@type=\"text\"]")
        public WebElement searchBox;
    @FindBy(xpath = "//button[@type=\"submit\"]")
        public WebElement searchSubmit;
    @FindBy(xpath = "(//li[@data-testid=\"pagination-list-item\"])[2]")
        public WebElement secondPage;
    @FindBy(xpath = "//*[contains(text(),'Kapat')]")
        public WebElement closeCookies;
    @FindBy(xpath = "//img[@data-testid=\"productImage\"]")
        public WebElement item;
    @FindBy(xpath = "//button[@id='add-to-basket']")
        public WebElement addToBasket;
    @FindBy(xpath = "//div[@id=\"sp-price-lowPrice\"]")
        public WebElement priceOnItemPage;
    @FindBy(xpath = "//h1[@id=\"sp-title\"]")
        public WebElement itemInfo;
    @FindBy(xpath = "//a[.=\"Sepete Git\"]")
        public WebElement goToBasket;
    @FindBy(xpath = "//div[@class=\"total-price\"]")
        public WebElement priceOnBasket;
    @FindBy(xpath = "//select[@class=\"amount\"]")
        public WebElement amount;
    @FindBy(xpath = "//option[@value=\"2\"]")
        public WebElement count;
    @FindBy(xpath = "//select[@value=\"2\"]")
        public WebElement updatedCount;
    @FindBy(xpath = "//a[@title=\"Sil\"]")
        public WebElement deleteItem;
    @FindBy(xpath = "//h2[.=\"Sepetinizde ürün bulunmamaktadır.\"]")
        public WebElement emptyBasket;

}
