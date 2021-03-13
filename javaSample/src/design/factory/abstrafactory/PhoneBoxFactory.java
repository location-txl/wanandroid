package design.factory.abstrafactory;

import design.factory.statics.Phone;

public interface PhoneBoxFactory {
    Charging createChrging();
    Phone  createPhone();
}
