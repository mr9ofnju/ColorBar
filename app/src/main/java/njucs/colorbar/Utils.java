package njucs.colorbar;

import java.io.File;
import java.util.*;

/**
 * Created by zhantong on 2016/9/29.
 */

public final class Utils {
    public static String combinePaths(String ... paths){
        if(paths.length==0){
            return "";
        }
        File combined=new File(paths[0]);
        int i=1;
        while(i<paths.length){
            combined=new File(combined,paths[i]);
            i++;
        }
        return combined.getPath();
    }
    public static int calculateMean(int[] array,int low,int high){
        int sum=0;
        for(int i=low;i<=high;i++){
            sum+=array[i];
        }
        return sum/(high-low+1);
    }
    public static int bitsToInt(BitSet bitSet, int length){//低位在前面
        return bitsToInt(bitSet, length, 0);
    }
    public static int bitsToInt(BitSet bitSet,int length,int offset){//低位在前面
        int value=0;
        for(int i=0;i<length;i++){
            value+=bitSet.get(offset+i)?(1 << i):0;
            //value = value << 1;
            //value+=bitSet.get(offset+i)?1:0;
            //value |= bitSet.get(offset+i) ? (length - 1 - i) : 0;
        }
        return value;
    }
}
