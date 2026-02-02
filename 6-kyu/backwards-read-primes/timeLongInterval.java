// Description:
// In this Kata, you will be given a series of times at which an alarm sounds.
// Your task will be to determine the maximum time interval between alarms.
// Each alarm starts ringing at the beginning of the corresponding minute 
// and rings for exactly one minute. The times in the array are not in chronological order. 
// Ignore duplicate times, if any.

// For example:
// solve(["14:51"]) = "23:59". If the alarm sounds now, it will not sound for another 23 hours and 59 minutes.
// solve(["23:00","04:22","18:05","06:24"]) == "11:40". The max interval that the alarm will not sound is 11 hours and 40 minutes.

import java.util.Arrays;
import java.time.LocalTime;

class Solution {
    public static String solve(String[] arr) {
        int[] minutes = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            LocalTime t = LocalTime.parse(arr[i]);
            minutes[i] = t.getHour() * 60 + t.getMinute();
        }

        Arrays.sort(minutes);
      
        int maxGap = 0;
        for (int i = 0; i < minutes.length - 1; i++) {
            int gap = minutes[i+1] - minutes[i] - 1; 
            if (gap > maxGap) maxGap = gap;
        }

        int wrapGap = (1440 - minutes[minutes.length - 1]) + minutes[0] - 1;
        if (wrapGap > maxGap) maxGap = wrapGap;

        LocalTime result = LocalTime.MIDNIGHT.plusMinutes(maxGap);
        return String.format("%02d:%02d", result.getHour(), result.getMinute());
    }

}