package com.lisa.gametest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.lisa.gametest.dao")
@ServletComponentScan
public class GametestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GametestApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  电竞测试系统启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.     闫志鹏  ____     __        \n" +
                " |  _ _   \\     张国梁  \\   \\   /  /    \n" +
                " | ( ' )  |       张嘉豪\\  _. /  '       \n" +
                " |(_ o _) /         李亚东_( )_ .'         \n" +
                " | (_,_).' __  ___(_  贾黎阳o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }

}
