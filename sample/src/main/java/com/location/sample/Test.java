package com.location.sample;

import android.view.View;

public class Test {

    static void setOnClicker(View.OnClickListener clickListener){

    }
void testFunc(){

}

      String name = "a";
     void main(){
        int a  = 10;
        setOnClicker(new View.OnClickListener() {
            void test(){
                String this_name = name;
                int b = a;
            }
            @Override
            public void onClick(View v) {
               int b = a;
               String this_name = name;
                testFunc();
            }
        });
    }


    public static void main(String[] args) {
        String str="name";
        int age = 12;
        new Thread(() -> {
            System.out.println(str);
            System.out.println(age);
        }).start();
    }
}


