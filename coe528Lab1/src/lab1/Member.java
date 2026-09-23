
package lab1;

/**
 *
 * @author stabeeb
 */
public class Member extends Passenger {
    //instance
    private int yearsOfMembership;
    
    public Member(String name, int age, int yearsOfMembership) {
        super(name,age);
        this.yearsOfMembership = yearsOfMembership;
    }
    
    public int getYearsOfMembership() {
        return yearsOfMembership;
    }
    
    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }
    
    @Override
    public double applyDiscount(double price) {
        if (yearsOfMembership > 5) {
            return price * 0.5;  // 50% discount
        } else if (yearsOfMembership > 1) {
            return price * 0.9;  // 10% discount
        }
        return price;  // No discount
    }
    
    
    
}
