package spittr;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Vinayak More
 *
 * @date 28-Jul-2017
 */
public class MainClass {

    public static void main(String[] args) {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        String encode = b.encode("welcome");
        System.out.println(encode);
        encode = b.encode("welcome");
        System.out.println(b.matches("welcome", encode));

    }

}

