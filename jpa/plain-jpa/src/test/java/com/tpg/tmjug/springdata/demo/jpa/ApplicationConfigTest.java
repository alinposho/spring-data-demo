/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tpg.tmjug.springdata.demo.jpa;

import com.tpg.tmjug.springdata.demo.jpa.repository.CustomerDAO;
import com.tpg.tmjug.springdata.demo.jpa.repository.JpaCustomerDAO;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ApplicationConfigTest {

	@Test
	public void bootstrapPlainJpaAppFromXml() {

		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/plain-jpa-application-context.xml");
		assertThat(context, is(notNullValue()));
		assertThat(context.getBean(JpaCustomerDAO.class), is(notNullValue()));
	}

    @Test
    public void bootstrapSpringDataAppFromXml() {

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring-data-jpa-application-context.xml");
        assertThat(context, is(notNullValue()));
        assertThat(context.getBean(CustomerDAO.class), is(notNullValue()));
    }

}
