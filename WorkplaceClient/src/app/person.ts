import {Contact} from './contact';

export class Person {
    public id: number = 0;
    public name: string = '';
    public departments: string = '';
    //public contacts: string = '';
    public contacts: Contact[] = [];
}
