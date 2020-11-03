package concurrency.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
//    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SS.SSS"); // NOT THREAD-SAFE!!!
    
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int userId = i;
            executorService.submit(() -> {
                String birthDate = new UserService().birthDate(userId);
                System.out.println(birthDate);
            });
        }
        executorService.shutdown();
    }

    private String birthDate(int userId) {
        Date birthDate = birthDateFromDb(userId);
//        return simpleDateFormat.format(birthDate); // NOT THREAD-SAFE!!!
        final SimpleDateFormat df = ThreadSafeFormatter.dateFormatter.get();
        return df.format(birthDate);
    }

    private Date birthDateFromDb(int userId) {
        return new Date();
    }

}
