package design.factory.statics;

public class PhoneFactory {
    public static enum PhoneType{
        MEIZU,
        XIAOMI,
    }

    public static Phone createPhone(PhoneType phoneType) {
        switch (phoneType) {
            case MEIZU:
                return new MeizuPhone();
            case XIAOMI:
                return new XiaomiPhone();
        }
        throw new IllegalArgumentException("参数填写错误");
    }
}
