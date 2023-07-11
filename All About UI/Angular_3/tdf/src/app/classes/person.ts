export class Person {

    firstname = '';
    lastname = '';
    email ='';
    gender = '';
    country:country = new country(1,''); 

}
export class country
{
  id=0;
  name='';
  constructor(id:number,name:string)
  {
    this.id = id;
    this.name = name;
  }
}
