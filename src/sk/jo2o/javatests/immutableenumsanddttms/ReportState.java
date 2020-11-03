package sk.jo2o.javatests.immutableenumsanddttms;

import java.util.*;

public enum ReportState {
    STARTED(1),
    CONFIG_TEMPORARY_DISABLED(2),
    REPORT_ID_SENT_TO_REPENG(3),
    REPORT_DATA_PIPELINE_STARTED(4),
    DB_DATA_ACQUIRED(5),
    DB_DATA_PROCESSED_SENDING_TO_REPENG(6),
    NO_TRANSACTION_DATA(7),
    REPORT_GENERATED(8),
    SFTP_UPLOAD_DISABLED(9),
    SFTP_UPLOAD_SUCCESS(10),
    SFTP_UPLOAD_FAILED(11);

    private int num;
    private static final Map<Integer, ReportState> map = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(e -> map.put(e.num, e));
    }

    ReportState(int num) {
        this.num = num;
    }

    public static ReportState valueOf(int num) {
        return map.get(num);
    }

    public int getNum() {
        return num;
    }
}
