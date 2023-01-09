package com.smartcommerce.dnc;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.project.Project;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DncApplicationTests {

	@Test
	void contextLoads() {
		ProjectApiRoot apiRoot = Client.createApiClient();

		Project myProject = apiRoot
				.get()
				.executeBlocking()
				.getBody();

		System.out.println(myProject.getName());
	}

}
