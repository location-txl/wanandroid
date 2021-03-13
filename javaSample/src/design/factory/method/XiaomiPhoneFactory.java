package design.factory.method;

import design.factory.statics.MeizuPhone;
import design.factory.statics.Phone;
import design.factory.statics.XiaomiPhone;

public class XiaomiPhoneFactory implements IPhoneFactory{
    @Override
    public Phone createPhone() {
        return new XiaomiPhone();
    }
}
