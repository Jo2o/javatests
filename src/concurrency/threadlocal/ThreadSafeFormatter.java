package concurrency.threadlocal;

import java.text.SimpleDateFormat;

public class ThreadSafeFormatter {

    public static ThreadLocal<SimpleDateFormat> dateFormatter = ThreadLocal
            .withInitial(() -> new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SS.SSS"));

//    public static ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<>() {
//        @Override
//        protected SimpleDateFormat initialValue() {
//            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SS.SSS");
//        }
//        @Override
//        public SimpleDateFormat get() {
//            return super.get();
//        }
//    };

}
