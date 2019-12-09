import { Injectable } from '@angular/core';
import { Person } from "./person";
import {ContactService} from "./contact.service";
import {Contact} from "./contact" 

@Injectable({
  providedIn: 'root'
})
export class PersonService {

    private issues: Contact[] = [];
    private contactService : ContactService;  
  private persons: Person[] = [
    {
      id: 1,
      name: 'Horváth Béla',
      departments: 'Accounting',
      contacts: this.contactService.getContact(1),
    },
    {
      id: 2,
      name: 'Sebes Tibor',
      departments: 'Accounting',
      contacts: this.contactService.getContact(2),
    },
    {
      id: 3,
      name: 'Varga Géza',
      departments: 'Accounting',
      contacts: this.contactService.getContact(3),
    },
    {
      id: 4,
      name: 'Katona Csenge',
      departments: 'Accounting',
      contacts: this.contactService.getContact(4),
    },
  ];
  
  constructor(private contServ : ContactService) {
    this.contactService = contServ;
   }
  
  getPersons(): Person[] {
    return this.persons;
  }
  
  getPerson(id: number): Person {
    return this.persons.find(i => i.id == id);
  }

}