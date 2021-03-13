package design.factory.abstrafactory;

import design.factory.statics.MeizuPhone;
import design.factory.statics.Phone;
import design.factory.statics.XiaomiPhone;

public class MeizuPhoneBoxFactory implements  PhoneBoxFactory{
    @Override
    public Charging createChrging() {
        return new CommonCharging();
    }

    @Override
    public Phone createPhone() {
        return new MeizuPhone();
    }
}
