/*
 * Copyright (c) 2008-2016, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package am.ik.hazelcast.example;

import static am.ik.hazelcast.example.SomeRestServiceProperties.APPLICATION_SCOPE;
import static am.ik.hazelcast.example.SomeRestServiceProperties.DISCOVERY_URL;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.hazelcast.config.properties.PropertyDefinition;
import com.hazelcast.logging.ILogger;
import com.hazelcast.spi.discovery.DiscoveryNode;
import com.hazelcast.spi.discovery.DiscoveryStrategy;
import com.hazelcast.spi.discovery.DiscoveryStrategyFactory;

public class SomeRestServiceDiscoveryStrategyFactory implements DiscoveryStrategyFactory {

	private static final Collection<PropertyDefinition> PROPERTY_DEFINITIONS = //
			Collections.unmodifiableCollection(
					Arrays.asList(APPLICATION_SCOPE, DISCOVERY_URL));

	public SomeRestServiceDiscoveryStrategyFactory() {
		System.out.println("====> SomeRestServiceDiscoveryStrategyFactory");
	}

	@Override
	public Class<? extends DiscoveryStrategy> getDiscoveryStrategyType() {
		System.out.println("====> getDiscoveryStrategyType");
		System.out.println(this);
		System.out.println(SomeRestServiceDiscoveryStrategy.class);
		return SomeRestServiceDiscoveryStrategy.class;
	}

	@Override
	public DiscoveryStrategy newDiscoveryStrategy(DiscoveryNode discoveryNode,
			ILogger logger, Map<String, Comparable> properties) {
		System.out.println("====> newDiscoveryStrategy");
		System.out.println("discoveryNode: " + discoveryNode);
		System.out.println("logger: " + logger);
		System.out.println("properties: " + properties);
		return new SomeRestServiceDiscoveryStrategy(discoveryNode, logger, properties);
	}

	@Override
	public Collection<PropertyDefinition> getConfigurationProperties() {
		System.out.println("====> getConfigurationProperties");
		return PROPERTY_DEFINITIONS;
	}
}