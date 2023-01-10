package com.smartcommerce.dnc;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.project.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.smartcommerce.dnc.client.CommercetoolsClient;

@SpringBootTest
@Import(CommercetoolsClient.class)
class DncApplicationTests {

	@Autowired
	private CommercetoolsClient commercetoolsClient;


	@Test
	void staticContextLoads() {
		ProjectApiRoot apiRoot = CommercetoolsClient.createStaticApiClient();

		Project myProject = apiRoot
				.get()
				.executeBlocking()
				.getBody();

		System.out.println(myProject.getName());
	}

	@Test
	void contextLoads() {
		ProjectApiRoot apiRoot = commercetoolsClient.createApiClient();

		Project myProject = apiRoot
				.get()
				.executeBlocking()
				.getBody();

		System.out.println(myProject.getName());
	}

}
