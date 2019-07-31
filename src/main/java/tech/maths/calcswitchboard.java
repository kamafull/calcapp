package tech.maths;

import tech.equipment.asmbls.apartAsmbl3;

import java.sql.SQLException;

public class calcswitchboard {

    pricing pr = new pricing();

    public int price(apartAsmbl3 asmbl) throws SQLException{
        int price = 0;
        price = pr.price(asmbl.getListEq_1(),3 ) + pr.price(asmbl.getListEq_2(), 3) + 1100;
        return price;
    }


}
