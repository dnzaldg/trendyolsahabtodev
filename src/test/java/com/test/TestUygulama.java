package com.test;
import com.test.Page.TestPage;
import com.test.pages.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.test.pages.BaseTest.getDriver;
import java.util.Random;


public class TestUygulama {
    public TestPage tp;
    public BaseTest bt;

    @Test
    public void openPage() //driver ayağa kalkıyor
    {
        tp=new TestPage(getDriver());
        loginPageControl();
    }

    public void loginPageControl() {
        Assert.assertTrue(tp.getTitle().equals("En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da"));
        System.out.println("Web Sitesi Açıldı.");
        tp.clickElement(By.cssSelector("div.fancybox-overlay.fancybox-overlay-fixed > div > div > a"));
        tp.clickElement(By.id("accountBtn"));
        tp.sendKeys(By.id("email"),"dnz.testapplication@gmail.com");
        tp.sendKeys(By.id("password"),"1234dnz.");
        tp.clickElement(By.id("loginSubmit"));
        System.out.println("Giriş yapıldı.");
        search();
    }
    public void search(){
        try {

            Thread.sleep(3000);
        }
        catch (InterruptedException e) {

            e.printStackTrace();
        }
        tp.sendKeys(By.cssSelector("div > div > input"),"Bilgisayar");
        tp.clickElement(By.cssSelector("#auto-complete-app > div > div.search-box-container > i"));
        System.out.println("Bilgisayar kelimesi aratıldı.");
        randomProduct();
    }
    public void randomProduct(){
        Random rnd=new Random();
        int result = rnd.nextInt(20) + 1;
        System.out.println(result);
        tp.clickElement(By.cssSelector("div.srch-prdcts-cntnr > div:nth-child(2) > div > div:nth-child("+result+")"));
       System.out.println("Ürün seçildi");
        String productDetailPrice=tp.findElement(By.cssSelector("#product-detail-app > div > div.pr-cn > div.pr-cn-in > div.pr-in-w > div:nth-child(1) > div.pr-in-cn > div:nth-child(3) > div > div > span.prc-slg")).getText();
        tp.clickElement(By.className("add-to-bs-tx"));
        tp.clickElement(By.className("goBasket"));
        System.out.println("Ürün sepete eklendi.");

        String resultBasket=tp.findElement(By.cssSelector("#basketAside > div > div.col-lg-12.col-md-12.col-xs-12.shoppingReview.grid-pad-20 > dl > dd.total-price")).getText();
        Assert.assertEquals(productDetailPrice, resultBasket);
        System.out.println("Ürün fiyat ile sepet fiyat karşılaştırıldı.");
        try{
            tp.clickElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[1]/div/button[2]"));
            System.out.println("Ürün adedi 1 adet arttırıldı");
            tp.clickElement(By.xpath("//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/button"));
            tp.clickElement(By.xpath("//*[@id=\"ngdialog1\"]/div[2]/form/div/div[2]/div/div[1]/button[2]"));

        }
        catch (Exception e){
            try{
                tp.clickElement(By.className("removeitem"));
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());

            }

        }
        System.out.println("Ürün sepetten silindi.");
    }
}
