package tech.maths.asmbl3;

import tech.equipment.asmbls.apartAsmbl3;
import tech.utils.other.pricingListEq;

import java.sql.SQLException;

public class calcAsmbl3 {

    pricingListEq pr = new pricingListEq();

    public int price(apartAsmbl3 asmbl) throws SQLException{
        int price = 0;
        price = pr.price(asmbl.getListEq_1()) + pr.price(asmbl.getListEq_2()) + 1600;
        return price;
    }


}
