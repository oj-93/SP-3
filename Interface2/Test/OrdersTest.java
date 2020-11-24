import com.company.Orders;
import com.company.Pizza;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrdersTest {

    @Test
    public void getPrice() {
        Orders order = new Orders("tim",456273812);
        Pizza pizza = new Pizza(2,"Amerikaner","Tomatsauce, ost, oksefars og oregano",53);
        Pizza pizza1 = new Pizza(3,"Caccitore","Tomatsauce, ost, pepperoni og oregano",57);
        order.addPizzaToOrder(pizza);
        order.addPizzaToOrder(pizza1);
        int actual = order.getPrice();
        int expected = 110;
        assertEquals(expected,actual);

    }

}