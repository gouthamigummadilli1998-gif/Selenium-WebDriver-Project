package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adactinhotelapp.utilities.DataProviders;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LoginPage;
import com.tutorialsninja.pages.MyAccountPage;

import testbase.BaseClass;

public class TC003_LoginDDT extends BaseClass {

    @Test(
        dataProvider = "loginData",
        dataProviderClass = DataProviders.class
    )
    public void verify_login(String email, String password, String exp) {

        logger.info("****** Starting TC003_LoginDDT ******");

        try {

            // ==============================
            // HomePage
            // ==============================

            HomePage hp = new HomePage(driver);

            hp.clickMyaccount();
            hp.clicklogin();

            // ==============================
            // LoginPage
            // ==============================

            LoginPage lp = new LoginPage(driver);

            lp.setEmail(email);
            lp.setpassword(password);
            lp.btnLogin();

            // ==============================
            // MyAccountPage
            // ==============================

            MyAccountPage ap = new MyAccountPage(driver);

            boolean targetPage = ap.isAccountPageExists();

            // ==========================================
            // VALID DATA
            // Login Success  -> PASS + Logout
            // Login Failed   -> FAIL
            // ==========================================

            if (exp.equalsIgnoreCase("Valid")) {

                if (targetPage) {

                    System.out.println(
                        "PASS: Valid data + Login successful"
                    );

                    ap.clickLogout();

                } else {

                    Assert.fail(
                        "Valid data but login failed for: " + email
                    );
                }
            }

            // ==========================================
            // INVALID DATA
            // Login Success  -> FAIL + Logout
            // Login Failed   -> PASS
            // ==========================================

            else if (exp.equalsIgnoreCase("InValid")) {

                if (targetPage) {

                    ap.clickLogout();

                    Assert.fail(
                        "Invalid data but login was successful for: "
                        + email
                    );

                } else {

                    System.out.println(
                        "PASS: Invalid data + Login failed"
                    );
                }
            }

            // ==========================================
            // Unexpected Excel value
            // ==========================================

            else {

                Assert.fail(
                    "Unexpected value in Excel: " + exp
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            Assert.fail(
                "Exception occurred: " + e.getMessage()
            );
        }

        logger.info("****** Finished TC003_LoginDDT ******");
    }
}