package Data;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name = "validlogin")

	public Object[][] validLoginData() {

		return new Object[][] { { "student", "Password123" } };

	}

	@DataProvider(name = "InvalidLogin")

	public Object[][] InvalidLoginData() {
		return new Object[][] { { "student", "wrongpwd" }, { "wrongusername", "Password123" },
				{ "wrongUsername", "WrongPassword" }

		};

	}
}
