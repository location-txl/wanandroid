package design.factory.method;

import design.factory.statics.MeizuPhone;
import design.factory.statics.Phone;

public class MeizuPhoneFactory implements IPhoneFactory{
    @Override
    public Phone createPhone() {
        return new MeizuPhone();
    }
}
