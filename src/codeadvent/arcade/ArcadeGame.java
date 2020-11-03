package codeadvent.arcade;

import java.util.Arrays;

public class ArcadeGame {

    private int joy;

    public static void main(String[] args) {

        Program program = new Program(Arrays.asList("2","380","379","385","1008","2571","639943","381","1005","381","12","99","109","2572","1102","0","1","383","1102","1","0","382","20101","0","382","1","20102","1","383","2","21102","37","1","0","1105","1","578","4","382","4","383","204","1","1001","382","1","382","1007","382","42","381","1005","381","22","1001","383","1","383","1007","383","23","381","1005","381","18","1006","385","69","99","104","-1","104","0","4","386","3","384","1007","384","0","381","1005","381","94","107","0","384","381","1005","381","108","1105","1","161","107","1","392","381","1006","381","161","1102","-1","1","384","1106","0","119","1007","392","40","381","1006","381","161","1101","0","1","384","21002","392","1","1","21102","21","1","2","21101","0","0","3","21102","138","1","0","1105","1","549","1","392","384","392","21002","392","1","1","21102","21","1","2","21101","3","0","3","21101","161","0","0","1105","1","549","1102","1","0","384","20001","388","390","1","20102","1","389","2","21102","180","1","0","1106","0","578","1206","1","213","1208","1","2","381","1006","381","205","20001","388","390","1","21002","389","1","2","21101","205","0","0","1105","1","393","1002","390","-1","390","1102","1","1","384","20101","0","388","1","20001","389","391","2","21101","0","228","0","1105","1","578","1206","1","261","1208","1","2","381","1006","381","253","21002","388","1","1","20001","389","391","2","21101","253","0","0","1105","1","393","1002","391","-1","391","1101","0","1","384","1005","384","161","20001","388","390","1","20001","389","391","2","21101","0","279","0","1106","0","578","1206","1","316","1208","1","2","381","1006","381","304","20001","388","390","1","20001","389","391","2","21102","304","1","0","1106","0","393","1002","390","-1","390","1002","391","-1","391","1101","1","0","384","1005","384","161","20102","1","388","1","20102","1","389","2","21102","1","0","3","21101","338","0","0","1106","0","549","1","388","390","388","1","389","391","389","21002","388","1","1","21001","389","0","2","21101","0","4","3","21101","0","365","0","1105","1","549","1007","389","22","381","1005","381","75","104","-1","104","0","104","0","99","0","1","0","0","0","0","0","0","233","19","18","1","1","21","109","3","21202","-2","1","1","22102","1","-1","2","21101","0","0","3","21101","414","0","0","1106","0","549","21202","-2","1","1","21201","-1","0","2","21101","0","429","0","1106","0","601","2101","0","1","435","1","386","0","386","104","-1","104","0","4","386","1001","387","-1","387","1005","387","451","99","109","-3","2106","0","0","109","8","22202","-7","-6","-3","22201","-3","-5","-3","21202","-4","64","-2","2207","-3","-2","381","1005","381","492","21202","-2","-1","-1","22201","-3","-1","-3","2207","-3","-2","381","1006","381","481","21202","-4","8","-2","2207","-3","-2","381","1005","381","518","21202","-2","-1","-1","22201","-3","-1","-3","2207","-3","-2","381","1006","381","507","2207","-3","-4","381","1005","381","540","21202","-4","-1","-1","22201","-3","-1","-3","2207","-3","-4","381","1006","381","529","21201","-3","0","-7","109","-8","2105","1","0","109","4","1202","-2","42","566","201","-3","566","566","101","639","566","566","2101","0","-1","0","204","-3","204","-2","204","-1","109","-4","2105","1","0","109","3","1202","-1","42","593","201","-2","593","593","101","639","593","593","21001","0","0","-2","109","-3","2105","1","0","109","3","22102","23","-2","1","22201","1","-1","1","21102","487","1","2","21101","326","0","3","21102","1","966","4","21101","630","0","0","1106","0","456","21201","1","1605","-2","109","-3","2106","0","0","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","1","1","0","0","0","0","2","2","2","0","0","0","2","2","0","0","0","0","2","0","0","0","0","0","0","0","0","0","0","2","0","2","0","2","0","0","0","0","2","2","2","0","1","1","0","2","0","2","0","2","0","0","2","2","0","2","2","2","2","0","0","0","2","0","0","2","2","2","0","2","2","0","2","0","0","0","0","2","0","0","0","0","0","0","1","1","0","0","0","0","2","0","0","0","2","0","0","2","0","0","0","0","2","0","0","0","2","2","0","2","0","2","2","0","2","2","0","2","0","2","2","2","0","0","2","0","1","1","0","0","2","2","2","2","2","2","2","0","0","2","0","2","0","0","0","2","0","2","0","0","2","0","0","0","0","2","0","0","2","2","0","2","0","0","2","2","0","0","1","1","0","2","2","0","0","0","0","0","2","2","0","0","0","0","0","0","0","0","2","2","0","0","0","0","0","0","0","0","0","0","0","0","2","0","2","0","0","2","0","0","1","1","0","0","0","2","0","0","2","0","0","0","0","0","2","0","0","2","2","0","0","2","0","2","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","1","1","0","0","0","0","0","2","0","2","2","2","0","2","2","0","0","0","0","0","0","2","0","2","0","0","2","2","0","0","0","2","0","2","2","0","2","0","0","0","2","0","1","1","0","0","0","0","2","0","2","2","2","2","2","0","2","0","2","2","0","0","2","2","0","2","2","2","0","2","0","2","2","0","2","2","0","2","2","2","2","2","0","0","1","1","0","0","2","0","0","0","2","0","2","2","2","2","2","0","2","0","0","2","2","0","0","2","0","2","2","0","0","2","0","2","0","2","2","2","0","2","2","2","2","0","1","1","0","2","0","0","0","2","0","0","2","0","0","0","2","0","2","0","2","2","0","0","0","0","2","2","2","2","2","2","0","0","2","2","0","0","2","2","0","2","0","0","1","1","0","2","0","0","0","2","0","0","0","0","2","2","0","0","2","2","2","0","0","0","0","0","2","0","0","0","2","0","2","0","0","2","0","2","2","2","2","0","0","0","1","1","0","0","0","0","0","0","2","2","0","2","0","2","2","0","2","0","2","2","0","2","0","0","0","0","2","0","0","0","2","2","0","2","2","0","0","0","2","2","0","0","1","1","0","0","2","0","2","2","0","2","2","2","0","0","2","2","0","0","2","2","2","2","0","0","0","0","0","0","0","0","0","0","0","2","0","2","0","0","0","2","0","0","1","1","0","0","2","0","0","2","0","2","0","2","0","0","2","2","2","2","2","0","2","0","0","2","2","0","0","0","2","0","0","0","2","2","0","2","0","0","2","0","0","0","1","1","0","2","2","0","0","2","0","0","0","0","0","0","2","0","2","0","0","2","0","0","0","2","0","2","0","2","2","0","0","2","0","0","0","0","0","2","0","0","0","0","1","1","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","1","1","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","4","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","1","1","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","1","1","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","1","1","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","3","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","1","1","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","1","85","93","24","97","81","73","90","65","8","89","80","17","22","56","24","44","93","59","34","85","16","26","8","85","58","86","32","75","36","78","65","80","67","83","36","22","47","30","4","17","49","44","80","79","66","53","32","98","63","63","38","69","39","8","74","77","35","93","58","2","40","74","19","95","85","34","13","26","46","94","7","77","1","80","44","80","57","25","40","36","5","66","24","4","26","69","28","34","96","28","14","47","60","2","76","36","90","20","84","9","72","34","80","30","81","91","19","50","38","65","78","80","91","43","52","59","32","98","13","11","74","84","5","64","4","92","11","51","11","36","12","94","80","7","36","15","19","78","76","81","21","88","8","31","50","23","22","80","54","72","6","6","12","81","79","80","85","33","60","67","53","8","98","35","34","11","10","34","18","42","65","14","30","89","21","85","32","50","73","4","28","81","10","94","65","65","5","14","25","47","62","4","35","62","70","66","71","88","94","83","13","28","92","93","75","86","4","7","94","15","43","74","47","3","46","82","71","56","37","95","45","29","90","48","51","19","16","65","10","7","81","98","13","96","49","90","64","94","14","68","73","35","19","34","75","37","7","5","87","44","71","52","12","27","92","27","81","63","95","38","49","61","7","92","65","37","47","63","13","2","62","70","65","24","17","59","31","7","1","15","9","48","52","74","38","27","8","53","80","66","6","72","35","39","79","11","89","80","90","53","84","7","84","64","75","15","40","48","82","30","28","98","23","90","88","92","5","34","7","23","41","87","93","65","46","90","29","24","38","56","15","62","6","89","68","81","93","43","31","60","51","45","25","15","88","25","11","88","93","60","87","4","3","93","8","50","62","27","54","7","6","18","44","65","33","69","23","45","44","69","49","11","73","81","64","18","6","74","7","77","53","18","6","98","62","35","81","48","33","64","26","16","55","17","71","75","72","39","6","54","67","97","68","59","65","3","70","75","91","98","87","41","94","16","1","14","27","11","19","52","53","18","47","27","29","59","6","37","86","71","12","62","84","26","36","22","74","95","77","59","66","70","95","91","2","59","39","50","81","51","75","87","30","22","30","64","54","53","64","33","37","88","24","90","24","32","36","95","39","54","6","85","10","15","53","82","13","41","50","10","67","87","51","87","15","80","27","10","32","97","77","90","41","34","45","14","11","95","79","58","31","49","59","86","50","89","22","92","68","51","74","28","38","16","68","29","6","23","37","19","55","71","5","73","38","66","12","21","45","51","69","89","51","2","9","61","62","97","92","74","23","8","23","82","56","74","9","9","73","69","3","25","81","18","67","64","5","86","96","49","22","86","93","36","15","28","31","55","62","81","78","66","65","55","68","71","92","66","65","48","64","75","16","42","26","12","49","27","33","40","66","43","37","51","90","32","96","63","96","42","61","70","97","96","79","67","59","12","17","81","12","39","64","80","1","28","2","83","35","20","54","69","97","11","96","96","22","60","92","79","28","35","32","24","19","96","85","26","20","38","72","60","41","62","14","51","54","60","45","35","37","17","85","53","27","1","87","55","25","48","46","10","70","16","13","16","77","10","73","70","65","58","57","62","16","59","51","70","93","55","42","79","46","12","88","28","96","53","82","61","75","67","58","13","42","11","64","3","76","15","60","40","6","57","71","68","26","48","57","80","61","28","88","44","92","49","49","38","46","37","40","34","1","18","97","72","49","53","49","35","88","44","5","29","81","6","21","87","77","25","36","91","33","22","74","22","85","55","39","98","21","6","43","26","2","60","36","34","72","39","25","40","51","37","65","69","48","4","18","42","49","13","52","80","39","65","94","92","27","34","58","83","93","5","34","2","11","90","37","73","77","84","68","63","78","63","34","32","47","26","90","72","61","89","5","78","26","80","92","29","36","76","48","53","61","53","14","42","1","2","34","37","36","16","70","27","1","50","26","29","92","53","58","19","90","47","27","35","30","72","76","54","85","33","26","65","77","39","7","3","8","67","87","25","12","43","74","95","97","12","23","47","62","70","62","22","98","76","17","14","77","50","91","20","15","42","34","20","65","79","87","27","44","12","95","2","97","97","43","62","76","65","48","71","83","72","33","44","17","65","40","86","12","89","97","54","36","62","78","65","15","7","37","25","31","3","16","33","91","56","67","66","29","61","40","91","32","27","13","8","55","89","54","69","76","16","67","66","54","7","75","84","6","64","15","29","56","88","57","49","26","57","70","19","3","62","79","61","62","55","49","16","94","94","53","79","639943"));

        int counter = 0;

        long x = 0;
        long y = 0;
        long id = 0;
        while ((x != 99) && (y != 99) && (id != 99)) {
            x = program.callProgram(Program.IGNORED_INPUT);
            if (x == 99) { continue; }
            System.out.println("x=" + x);
            y = program.callProgram(Program.IGNORED_INPUT);
            if (y == 99) { continue; }
            System.out.println("y=" + y);
            id = program.callProgram(Program.IGNORED_INPUT);
            if (id == 99) { continue; }
            System.out.println("id=" + id);
            if (id == 2) {
                counter++;
            }
            if (x == -1 && y == 0) {
                System.out.println("SCORE: " + id);
            }
        }
        System.out.println(">>>>>>> RESULT: " + counter);

    }

}
