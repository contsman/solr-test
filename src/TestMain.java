public class TestMain {
	private static String[] aa = { "aa1", "aa2" };
	private static String[] bb = { "bb1", "bb2", "bb3" };
	private static String[] cc = { "cc1", "cc2", "cc3", "cc4" };
	private static String[][] xyz = { aa, bb, cc };
	private static int counterIndex = xyz.length - 1;
	private static int[] counter = { 0, 0, 0 };

	public static void main(String[] args) throws Exception {
//		for (int i = 0; i < aa.length * bb.length * cc.length; i++) {
//			System.out.print(aa[counter[0]]);
//			System.out.print("\t");
//			System.out.print(bb[counter[1]]);
//			System.out.print("\t");
//			System.out.print(cc[counter[2]]);
//			System.out.println();
//			System.out.println(i + 1);
//			handle();
//
//		}
		System.out.println(uniduration("1:02:11"));
		System.out.println("1:02:11".split(":").length);
	}

	public static void handle() {
		counter[counterIndex]++;
		if (counter[counterIndex] >= xyz[counterIndex].length) {
			counter[counterIndex] = 0;
			counterIndex--;
			if (counterIndex >= 0) {
				handle();
			}
			counterIndex = xyz.length - 1;
		}
	}
	public static String uniduration(String dur) {
        if (dur == null) return "";
        if (dur.length() == 0) return dur;
        if (dur.indexOf(":") >= 0) {
            if(dur.split(":").length==2){
                StringBuffer buffer = new StringBuffer();
                String[] minSec = dur.split(":");
                String time = minSec[0];
                if (Integer.parseInt(time) < 10) time = "0"+Integer.parseInt(time);
                buffer.append(time);
                buffer.append(":");
                time = minSec[1];
                if (Integer.parseInt(time) < 10) time = "0"+Integer.parseInt(time);
                buffer.append(time);
                return buffer.toString();
            }else{
                return dur;
            }
        }
        try {
            int ts = Integer.parseInt(dur);
            //vulogger.debug("processing dur:" + dur + " ts:" + ts);
            StringBuffer sb = new StringBuffer();
            int h = ts / 3600;
            int m = (ts - h * 3600) / 60;
            int s = (ts - h * 3600 - m * 60);
            if (h > 0) {
                if (h < 10) sb.append("0");
                sb.append(h);
                sb.append(":");
            }
            if (m < 10) sb.append("0");
            sb.append(m);
            sb.append(":");
            if (s < 10) sb.append("0");
            sb.append(s);

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
