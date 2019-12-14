import { Injectable } from '@angular/core';
import { Person } from "./person";
import {Contact} from "./contact"; 
import {ContactService} from "./contact.service";


@Injectable({
  providedIn: 'root'
})
export class PersonService {

    private persons: Person[] = [
    {
      id: 1,
      name: 'Horváth Béla',
      departments: 'Accounting',
      contacts: this.cService.getContact(1),
    },
    {
      id: 2,
      name: 'Sebes Tibor',
      departments: 'Accounting',
      contacts: this.cService.getContact(2),
    },
    {
      id: 3,
      name: 'Varga Géza',
      departments: 'Accounting',
      contacts: this.cService.getContact(3),
    },
    {
      id: 4,
      name: 'Katona Csenge',
      departments: 'Accounting',
      contacts: this.cService.getContact(4),
    },
  ];
  
  constructor(private cService: ContactService) {
    
  }

  getPersons(): Person[] {
    return this.persons;
  }
  
  getPerson(id: number): Person {
    return this.persons.find(i => i.id == id);
  }
}
