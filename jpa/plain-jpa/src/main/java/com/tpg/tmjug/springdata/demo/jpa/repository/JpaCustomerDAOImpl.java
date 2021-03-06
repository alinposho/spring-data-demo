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
package com.tpg.tmjug.springdata.demo.jpa.repository;

import com.tpg.tmjug.springdata.demo.jpa.entities.Address;
import com.tpg.tmjug.springdata.demo.jpa.entities.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
class JpaCustomerDAOImpl implements JpaCustomerDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Customer findOne(Long id) {
        return em.find(Customer.class, id);
    }

    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            em.persist(customer);
            return customer;
        } else {
            return em.merge(customer);
        }
    }

    @Override
    public List<Customer> findByAddress(Address address) {

        TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.address = :address",
                Customer.class);
        query.setParameter("address", address);

        return query.getResultList();
    }

}
