package codeadvent.boostprogram;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LargeList {

    private Map<String, String> map = new TreeMap<>();

    public LargeList(List<String> program) {
        for (int i = 0; i < program.size(); i++) {
            map.put(String.valueOf(i), String.valueOf(program.get(i)));
        }
    }

    public long get(long idx) {
        String num = map.get(String.valueOf(idx));
        if (num == null) {
            set(idx, 0L);
            num = "0";
        }
        return Long.parseLong(num);
    }

    public void set(long idx, long val) {
        map.put(String.valueOf(idx), String.valueOf(val));
    }

    public long size() {
        return map.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PROGRAM:").append('\n');
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("   K: ").append(entry.getKey())
                    .append(", V: ").append(entry.getValue()).append('\n');
        }
        return sb.toString();
    }

}
