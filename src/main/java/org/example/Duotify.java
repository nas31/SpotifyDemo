package org.example;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Assert;





        public class Duotify {


            // private static BMPSet mainContentText;

            public static void main(String[]args) throws InterruptedException {

                // STEPS:

                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();

                driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php?");
                Assert.assertEquals(driver.getTitle(), "Welcome to Duotify!");
                driver.findElement(By.id("hideLogin")).click();


                Faker faker = new Faker();
                String userName = faker.name().username();
                String firstName = faker.name().firstName();
                String lastName = faker.name().lastName();
                String email = faker.internet().emailAddress();
                String confirmEmail = faker.internet().emailAddress();
                String password = faker.internet().password();
                String confirmPass = faker.internet().password();

                driver.findElement(By.name("username")).sendKeys(userName);

                driver.findElement(By.name("firstName")).sendKeys(firstName);

                driver.findElement(By.name("lastName")).sendKeys(lastName);

                driver.findElement(By.name("email")).sendKeys(email);
                driver.findElement(By.name("email2")).sendKeys(email);

                driver.findElement(By.name("password")).sendKeys(password);
                driver.findElement(By.name("password2")).sendKeys(password);

                driver.findElement(By.name("registerButton")).click();//sendKeys(Keys.ENTER);
//Assert.assertEquals(driver.getCurrentUrl(),"http://duotify.us-east-2.elasticbeanstalk.com/register.php");
                WebElement nameFirstAndLast = driver.findElement(By.id("nameFirstAndLast"));
                Thread.sleep(500);
                Assert.assertEquals(nameFirstAndLast.getText(),firstName+ " " + lastName);
                nameFirstAndLast.click();
                Thread.sleep(500);
                WebElement nameFirstAndLast2 = driver.findElement(By.className("userInfo"));
                //Thread.sleep(500);
                Assert.assertEquals(nameFirstAndLast.getText(),firstName+ " " + lastName);

                driver.findElement(By.id("rafael")).click();
                Thread.sleep(500);
                Assert.assertEquals(driver.getCurrentUrl(),"http://duotify.us-east-2.elasticbeanstalk.com/register.php");
                driver.findElement(By.id("loginUsername")).sendKeys(userName);
                driver.findElement(By.id("loginPassword")).sendKeys(password);
                Thread.sleep(500);
                driver.findElement(By.name("loginButton")).sendKeys(Keys.ENTER);
                //Thread.sleep(500);
                WebElement homePageText= driver.findElement(By.id("mainContent"));
                Thread.sleep(500);
                Assert.assertTrue(homePageText.getText().trim().contains("You Might Also Like"));
//Assert.assertTrue(Boolean.parseBoolean(homePageText.));
                Thread.sleep(1000);
                driver.findElement(By.id("nameFirstAndLast")).click();
                Thread.sleep(500);
                driver.findElement(By.id("rafael")).click();
                Thread.sleep(500);
                Assert.assertEquals(driver.getCurrentUrl(),"http://duotify.us-east-2.elasticbeanstalk.com/register.php");

                driver.quit();
            }
        }
