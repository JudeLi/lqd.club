package com.way.rapid.myapplication;

        import java.util.ArrayList;
        import java.util.List;

public class StaticList {
    public static List<Bean> list1;
    static {
        list1 = new ArrayList<Bean>();
        list1.add(new Bean(R.drawable.ic_oo_, "莫倾城", "今天是晴天，待会一起去爬山，又是愉快的一天"));
        list1.add(new Bean(R.drawable.ic_qq, "李白", "十步杀一人，千里不留行"));
        list1.add(new Bean(R.drawable.ic_vv_, "杜甫", " 是时候学习一波了"));
    }
}