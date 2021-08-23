Collections.sort(people, new Comparator<Person>() {
    @Override
    public int compare(Person a, Person b) {
        // TODO Auto-generated method stub
         return a.age < b.age ? -1 : a.age == b.age ? 0 : 1;
    }
});