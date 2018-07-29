import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;

public class Starter {


    public static void main(String[] args) {


        Long count = Stream.of(1,2,3,4,5,6,7,8).parallel().filter(i -> i > 4).peek(i -> System.out.println(i)).map(i -> i*i).count();
    }
}

