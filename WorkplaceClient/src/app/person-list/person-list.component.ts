import { Component, OnInit } from '@angular/core';
import { PersonService } from '../person.service';
import { Person } from '../person';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css'],
  providers: [PersonService]
})
export class PersonListComponent implements OnInit {

  private persons: Person[] = [];

  constructor(private personService: PersonService) { 
    this.persons = personService.getPersons();
  }

  ngOnInit() {
  }

}
