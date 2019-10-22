/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.WorkplaceContactsBackend.repositories;

import hu.elte.WorkplaceContactsBackend.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author emsgem
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
