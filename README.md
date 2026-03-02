Basic LoginPage Understanding:

                          Test Layer
                              ↓
                       Page Layer (POM)
                              ↓
                   BasePage (Reusable Actions)
                              ↓
               DriverFactory (Driver Management)
                              ↓
                      WebDriver (Browser)
Login scenario flow :

                TestNG
                   │
                   ▼
             BaseTest.setup()
                   │
                   ▼
          DriverFactory.initDriver()
                   │
                   ▼
              ChromeDriver
                   │
                   ▼
              Open Login URL
                   │
                   ▼
              LoginTest
                   │
                   ▼
            LoginPage.login()
                   │
         ┌─────────┴─────────┐
         ▼                   ▼
     BasePage.type()     BasePage.click()
         │                   │
         ▼                   ▼
      WaitUtils           WaitUtils
         │                   │
         ▼                   ▼
      WebDriver ---------> Browser
                   │
                   ▼
         return SecureAreaPage
                   │
                   ▼
        SecureAreaPage methods
                   │
                   ▼
               Assertions
                   │
                   ▼
         SecureAreaPage.logout()
                   │
                   ▼
             return LoginPage


