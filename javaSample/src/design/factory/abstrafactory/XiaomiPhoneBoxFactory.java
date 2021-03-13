package design.factory.abstrafactory;

import design.factory.statics.Phone;
import design.factory.statics.XiaomiPhone;

public class XiaomiPhoneBoxFactory implements  PhoneBoxFactory{
    @Override
    public Charging createChrging() {
        return new CommonCharging();
    }

    @Override
    public Phone createPhone() {
        return new XiaomiPhone();
    }
}
