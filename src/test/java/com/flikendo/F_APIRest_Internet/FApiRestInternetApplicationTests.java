/**
 * Date: 03-10-2022
 * Author: Flikendo
 *
 * APIWebConnectionTest class
 */

package com.flikendo.F_APIRest_Internet;

import com.flikendo.F_APIRest_Internet.Connection.APIWebConnection;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FApiRestInternetApplicationTests {

	@Test
	void contextLoads() {
	}

	/**
	 * Test to check if isWebUp() method works
	 */
	@Test
	public void isWebUp() {
		APIWebConnection webConnection = new APIWebConnection("https://www.dieselogasolina.com/");
		webConnection.isWebUp();
	}

}
