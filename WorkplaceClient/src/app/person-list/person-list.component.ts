import { Component, OnInit } from '@angular/core';
import {Person} from '../person';
import {PersonService} from '../person.service';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {

  public filteredIssues: Person[];
  public selectedStatus: string;
  public selectedIssue: Person;

  private persons: Person[] = [];

  constructor(private personService: PersonService) { 
    this.persons = personService.getPersons();
  }

  ngOnInit() {
    
  }

}
