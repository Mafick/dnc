package com.smartcommerce.dnc.commercetools;

// Required imports

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.defaultconfig.ApiRootBuilder;
import com.commercetools.api.defaultconfig.ServiceRegion;
import io.vrap.rmf.base.client.oauth2.ClientCredentials;

public class Client {

	public static ProjectApiRoot createApiClient() {

		final ProjectApiRoot apiRoot = ApiRootBuilder.of()
				.defaultClient(ClientCredentials.of()
								.withClientId("Bp2ch5klNZyPckvrqELs2NR4")
								.withClientSecret("kA3hbmMQ8xGfqHJMvvfF5NhKcjB45IUB")
								.build(),
						ServiceRegion.GCP_EUROPE_WEST1)
				.build("dnc");

		return apiRoot;
	}

}