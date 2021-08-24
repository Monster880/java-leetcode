Collections.sort(people, new Comparator<Person>() {
    public int compare(Person a, Person b) {
         return a.age < b.age ? -1 : a.age == b.age ? 0 : 1;
    }
});

Collections.sort(people, new Comparator<Person>(){
    public int compare(Person a, Person b){
        return a.age < b.age ? -1 : a.age == b.age ? 0 : 1;
    }
})