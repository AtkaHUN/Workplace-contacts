import { Injectable } from '@angular/core';
import { Contact } from "./contact";

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  public contacts: Contact[] = [
    {
        id: 1,
        contactType: 0,
        contact: '0612751698',
    },
    {
        id: 1,
        contactType: 1,
        contact: '0612751698',
    },
    {
        id: 2,
        contactType: 2,
        contact: 'horba@melonmail.com',
    },
    {
        id: 3,
        contactType: 1,
        contact: '0612751698',
    },
    {
        id: 4,
        contactType: 0,
        contact: '0612751698',
    }
  ];
  
  constructor() { }
  
  getContacts(): Contact[] {
    return this.contacts;
  }
  
  getContact(id: number): Contact[] {
    return this.contacts.filter(i => i.id == id);
  }

}