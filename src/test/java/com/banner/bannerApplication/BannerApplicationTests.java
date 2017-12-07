package com.banner.bannerApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BannerApplicationTests {
	String WEBSOCKET_URI = "http://localhost:8080";

	@Test
	public void contextLoads() {
	}

}
