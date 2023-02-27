import java.util.HashMap;
import java.util.Scanner;

class MapSystem{
public static void main(String[] args) {

    HashMap<Integer, String> infomap = new HashMap<>();
    Scanner inputinfo = new Scanner(System.in);
    while (true){
        String[] getInfo = inputinfo.next().split(",");
        if (getInfo[0].equals("Put") || getInfo[0].equals("Update")) {
            int idx = Integer.parseInt(getInfo[1]);
            infomap.put(idx, getInfo[2]);
        }else if (getInfo[0].equals("Delete")) {
            int idx = Integer.parseInt(getInfo[1]);
            infomap.remove(idx);
        }else if (getInfo[0].equals("Get")) {
            System.out.println(infomap);
        }
    }
    }
}