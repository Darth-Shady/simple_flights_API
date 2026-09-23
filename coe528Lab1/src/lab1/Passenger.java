
package lab1;

/**
 *
 * @author stabeeb
 */
public abstract class Passenger { //it has to be abstract class to have abstract method but idk about this, recheck l8r
    //instance
    private String name;
    private int age;
    
    public Passenger(String name, int age) {
    this.name = name;
    this.age = age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getAge() {
        return this.age ;
    }
    
    abstract double applyDiscount(double p) ;
}
