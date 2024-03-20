package de.cbrachem.example.samesitecookiedemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SameSiteCookieTest {
	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void samesite_should_be_lax() {
		// make a http request to the server. check if the session cookie is set to SameSite=Lax
		var url = "http://localhost:" + port + "/";
		var response = restTemplate.getForEntity(url, String.class);

		var setCookieHeaders = response.getHeaders().get("Set-Cookie");
		var sessionCookie = setCookieHeaders
				.stream()
				.filter(cookie -> cookie.startsWith("JSESSIONID"))
				.findFirst()
				.orElseThrow();

		// if we use jetty then it's strict even though it's set to lax in the application properties
		assertThat(sessionCookie).contains("SameSite=Lax");
	}
}
