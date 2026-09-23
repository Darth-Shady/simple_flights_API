package lab1;



/**
 *
 * @author stabeeb
 */
public class NonMember extends Passenger {
    
    
    public NonMember(String name, int age) {
        super(name, age);
    }
    
    
    @Override
    public double applyDiscount(double price) {
        if (this.getAge() > 65) {
            return price * 0.9;  // 10% discount
        }
        return price;  // No discount
    }
}