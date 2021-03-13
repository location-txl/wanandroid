package design.factory.statics;

public class XiaomiPhone  implements Phone{
    @Override
    public void open() {
        System.out.println("小米手机已开机");
    }
}
