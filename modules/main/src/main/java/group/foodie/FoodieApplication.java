package group.foodie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * main boot
 *
 * @author renmingyuan
 * @date 2022/11/23
 */
@SpringBootApplication
@EnableTransactionManagement
public class FoodieApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodieApplication.class, args);
    }
}
